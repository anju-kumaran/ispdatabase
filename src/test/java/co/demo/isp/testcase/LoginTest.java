package co.demo.isp.testcase;

import co.demo.isp.config.FrameWorkConfig;
import co.demo.isp.data.LoginData;
import co.demo.isp.drivermanager.DriverManager;
import co.demo.isp.listeners.ScreenshotListener;
import co.demo.isp.pages.HomePage;
import co.demo.isp.pages.LoginPage;
import co.demo.isp.pages.UserDashboard;
import co.demo.isp.pages.student.DatasheetViewPage;
import co.demo.isp.reports.ExtentHtmlReport;
import co.demo.isp.util.FrameworkUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

@Listeners({ScreenshotListener.class})
public class LoginTest {
    WebDriver driver;
    WebDriverWait wait;
    ExtentReports reports;
    ExtentTest test;
    HomePage homePage;
    LoginPage loginPage;
    UserDashboard userDashboard;
    DatasheetViewPage datasheetViewPage;
    private final Logger logger = LogManager.getLogger(StudentTest.class);

    @BeforeSuite
    public void setup(){
        driver = DriverManager.getDriver();
        //wait = new WebDriverWait(driver,20);
        driver.get(FrameWorkConfig.getProperty("app.url"));
        logger.info("***Entering URL***");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
    }

    @BeforeTest
    public void getReports(){

        reports = ExtentHtmlReport.getReport();
    }

    @Test(dataProvider = "dataFromExcel", dataProviderClass = LoginData.class)
    public void testLogin(String email, String password) throws IOException {

        logger.info("******************************Login Data Provider Test Starting*********************************");
        homePage = new HomePage(driver);
        loginPage = homePage.clickBtnUserDashBoard();
        loginPage = new LoginPage(driver);
        userDashboard = loginPage.clickBtnLogin(email,password);
        datasheetViewPage = userDashboard.clickStudentsModule();
        logger.info("******************************Login Data Provider Test Ending*****************************************");
        test = reports.createTest("LoginTest");
        if(datasheetViewPage.getLiveText().getText().equals("Tips:")){
            test.log(Status.PASS, "Login Test Passed");

           // test.log(Status.PASS, "Login Test Passed. "+test.addScreenCaptureFromPath("target/screenshot/fail/testLogin_060320201828582.png"));

        }else {
            test.log(Status.FAIL, "Login Test Failed");
            //test.log(Status.FAIL, "Login Test Failed due to some reason "+test.addScreenCaptureFromPath("/target/screenshot/fail/testLogin_060320201828582.png"));
        }
    }

    @AfterTest
    public void endReport(){

        ExtentHtmlReport.getReport().flush();
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
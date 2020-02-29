package co.demo.isp.testcase;

import co.demo.isp.config.FrameWorkConfig;
import co.demo.isp.drivermanager.DriverManager;
import co.demo.isp.pages.HomePage;
import co.demo.isp.pages.LoginPage;
import co.demo.isp.pages.UserDashboard;
import co.demo.isp.pages.student.DatasheetViewPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class LoginTest {
    WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;
    LoginPage loginPage;
    UserDashboard userDashboard;
    DatasheetViewPage datasheetViewPage;
    private final Logger logger = LogManager.getLogger(StudentTest.class);

    @BeforeSuite
    public void setup(){
        driver = DriverManager.getDriver();
        driver.get(FrameWorkConfig.getProperty("app.url"));
        logger.info("Entering URL");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void testLogin(){
        logger.info("******************************Login Test Starting***********************************");
        homePage = new HomePage(driver);
        loginPage = homePage.clickBtnUserDashBoard();
        loginPage = new LoginPage(driver);
        String email = "training@pragra.co";
        String password = "Testing2019";
        userDashboard = loginPage.clickBtnLogin(email,password);
        datasheetViewPage = userDashboard.clickStudentsModule();
        logger.info("******************************Login Test End*****************************************");
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        sleep(2000);
        driver.quit();
    }
}
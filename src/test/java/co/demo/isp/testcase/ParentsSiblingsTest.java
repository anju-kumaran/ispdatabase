package co.demo.isp.testcase;

import co.demo.isp.config.FrameWorkConfig;
import co.demo.isp.data.LoginData;
import co.demo.isp.drivermanager.DriverManager;
import co.demo.isp.listeners.ScreenshotListener;
import co.demo.isp.pages.HomePage;
import co.demo.isp.pages.LoginPage;
import co.demo.isp.pages.UserDashboard;
import co.demo.isp.pages.student.DatasheetViewPage;
import co.demo.isp.pages.student.GeneralInformationPage;
import co.demo.isp.pages.student.ParentsSiblingsPage;
import co.demo.isp.pages.student.StudentTopNavBar;
import co.demo.isp.reports.ExtentHtmlReport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

@Listeners({ScreenshotListener.class})
public class ParentsSiblingsTest {
    WebDriver driver;
    WebDriverWait wait;
    ExtentReports reports;
    ExtentTest test;
    HomePage homePage;
    LoginPage loginPage;
    UserDashboard userDashboard;
    DatasheetViewPage datasheetViewPage;
    StudentTopNavBar studentTopNavBar;
    GeneralInformationPage generalInfoPage;
    ParentsSiblingsPage parentsSiblingsPage;
    private final Logger logger = LogManager.getLogger(ParentsSiblingsTest.class);

    @BeforeSuite
    public void setup(){
        driver = DriverManager.getDriver();
        driver.get(FrameWorkConfig.getProperty("app.url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
    }

    @BeforeTest
    public void getReports(){

        reports = ExtentHtmlReport.getReport();
    }

    @Test(dataProvider = "dataFromExcel", dataProviderClass = LoginData.class, priority = 1)
    public void testLogin(String email, String password) throws InterruptedException {
        logger.info("******************************In Home page***********************************");
        homePage = new HomePage(driver);
        logger.info("******************************In Login page***********************************");
        loginPage = homePage.clickBtnUserDashBoard();
        loginPage = new LoginPage(driver);
        logger.info("******************************In Student Menu ***********************************");
        userDashboard = loginPage.clickBtnLogin(email,password);
        sleep(5000);
        logger.info("******************************In datasheet page***********************************");
        datasheetViewPage = userDashboard.clickStudentsModule();
        //driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
        logger.info("******************************Login Test End*************************************");
        test = reports.createTest("LoginTest");
        if(datasheetViewPage.getLiveText().getText().equals("Tips:")){
            test.log(Status.PASS, "Login Test Passed");
        }else {
            test.log(Status.FAIL, "Login Test Failed");
        }
    }

    @Test(priority = 2)
    public void testParentsSiblingsPage(){
        logger.info("************************Parents Siblings Page Test Start********************************");
        studentTopNavBar = new StudentTopNavBar(driver);
        generalInfoPage = studentTopNavBar.clickAddNewStudent();
        parentsSiblingsPage = studentTopNavBar.clickParentsSiblings();
        logger.info("************************Parents Siblings Page Test End********************************");
        test = reports.createTest("ParentsSiblings Page Test");
        if(parentsSiblingsPage.getLiveText().getText().equals("Parent 1 Info")){
            test.log(Status.PASS, "ParentsSiblings Page Test Passed");
        }else {
            test.log(Status.FAIL, "ParentsSiblings Page Test Failed");
        }
    }

    @Test(dependsOnMethods = "testLogin", priority = 3)
    public void testParentSiblingsForm() throws InterruptedException {
        logger.info("************************Parents Siblings Form Test Start********************************");
        studentTopNavBar = new StudentTopNavBar(driver);
        sleep(5000);
        logger.info(".....Opening GeneralInfo page....");
        generalInfoPage = studentTopNavBar.clickAddNewStudent();
       // sleep(5000);
        logger.info(".....Entering Parents siblings page....");
        parentsSiblingsPage = studentTopNavBar.clickParentsSiblings();
        logger.info(".....Key in parent details....");
        parentsSiblingsPage
                .keyInParentOneFirstName("Steve")
                .keyInParentOneLastName("Smith")
                .keyInParentOneBday("27-Jan-1960")
                .keyInParentOneOccupation("Teacher")
                .keyInParentOneEmail("asd@qqq.com")
                .keyInParentOnePhone("657-345-9878")
                .selectParentOnePermitType("Visitor")
                .selectParentOneRelationship("Father")
                .keyInParentOnePermitNumber("W34690")
                .keyInParentOnePermitExpDate("23-Mar-2020")
                .checkParentOneDeceased()
                .checkParentOneResponsible()
                .keyInInstitution("ABC University")
                .keyInParentTwoFirstName("Emma")
                .keyInParentTwoLastName("Ray")
                .keyInParentTwoBday("19-May-1972")
                .keyInParentTwoOccupation("Doctor")
                .keyInParentTwoEmail("kacy@sdd.com")
                .keyInParentTwoPhone("2894568767")
                .selectParentTwoPermitType("Study Permit")
                .selectParentTwoRelationship("Mother")
                .keyInParentTwoPermitNumber("P676555")
                .keyInParentTwoPermitExpDate("14-Dec-2022")
                .checkParentTwoDeceased()
                .checkParentTwoResponsible()
                .selectEnglish("Both parents speak English")
                .selectAddressForParentOne("Father only")
                .keyInParentOneHomePhone("9056789876")
                .keyInParentOneHomeFax("43434")
                .keyInParentOneHomeCell("898988")
                .keyInParentOneWorkPhone("76574654")
                .keyInParentOneWorkFax("422445")
                .keyInParentOneAddress("456, Abc Street")
                .keyInParentOneCity("Copenhagen")
                .keyInParentOneProvince("Queensland")
                .selectParentOneCountry("Sweden")
                .keyInParentOnePostalCode("L4R7Y5")
                .keyInParentOneSecondaryEmail("john@test.com")
                .selectAddressForParentTwo("Mother only")
                .keyInParentTwoHomePhone("6489944346")
                .keyInParentTwoHomeFax("98775")
                .keyInParentTwoHomeCell("232322")
                .keyInParentTwoWorkPhone("676767676")
                .keyInParentTwoWorkFax("422445")
                .keyInParentTwoAddress("88, qweee Street")
                .keyInParentTwoCity("Toronto")
                .keyInParentTwoProvince("Ontario")
                .selectParentTwoCountry("Canada")
                .keyInParentTwoPostalCode("L4R7Y5")
                .keyInParentTwoSecondaryEmail("kac@qwer.com")
                .searchSiblingsInfo("Martha")
                .keyInNotes("This is a Test. parent siblings page.")
                .checkCommunicateMother()
                .checkCommunicateFather()
                .checkCommunicateAgent();

        // sleep(10000);
        // studentTopNavBar.clickSaveStudent();
        logger.info("************************Parents Siblings Form Test End********************************");
        test = reports.createTest("ParentsSiblings Form Test");
        if(parentsSiblingsPage.getLiveText().getText().equals("Parent 1 Info")){
            test.log(Status.PASS, "ParentsSiblings Form Test Passed");
        }else {
            test.log(Status.FAIL, "ParentsSiblings Form Test Failed");
        }

    }

    @AfterTest
    public void endReport(){
        ExtentHtmlReport.getReport().flush();
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        sleep(2000);
        driver.quit();
    }
}

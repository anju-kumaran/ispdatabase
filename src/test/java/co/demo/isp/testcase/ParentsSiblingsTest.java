package co.demo.isp.testcase;

import co.demo.isp.config.FrameWorkConfig;
import co.demo.isp.drivermanager.DriverManager;
import co.demo.isp.pages.HomePage;
import co.demo.isp.pages.LoginPage;
import co.demo.isp.pages.UserDashboard;
import co.demo.isp.pages.student.DatasheetViewPage;
import co.demo.isp.pages.student.GeneralInformationPage;
import co.demo.isp.pages.student.ParentsSiblingsPage;
import co.demo.isp.pages.student.StudentTopNavBar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class ParentsSiblingsTest {
    WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;
    LoginPage loginPage;
    UserDashboard userDashboard;
    DatasheetViewPage datasheetViewPage;
    StudentTopNavBar studentTopNavBar;
    GeneralInformationPage generalInfoPage;
    ParentsSiblingsPage parentsSiblingsPage;
   // private final Logger logger = LogManager.getLogger(ParentsSiblingsTest.class);

    @BeforeSuite
    public void setup(){
        driver = DriverManager.getDriver();
        driver.get(FrameWorkConfig.getProperty("app.url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void testLogin(){
        homePage = new HomePage(driver);
        loginPage = homePage.clickBtnUserDashBoard();
        loginPage = new LoginPage(driver);
        String email = "training@pragra.co";
        String password = "Testing2019";
        userDashboard = loginPage.clickBtnLogin(email,password);
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        datasheetViewPage = userDashboard.clickStudentsModule();
        driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
    }

    @Test(dependsOnMethods = "testLogin")
    public void testParentsSiblingsPage(){
        studentTopNavBar = new StudentTopNavBar(driver);
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        parentsSiblingsPage = studentTopNavBar.clickParentsSiblings();
        Assert.assertEquals("Parent 1 Info",parentsSiblingsPage.getLiveText().getText());
    }

    @Test(dependsOnMethods = "testLogin")
    public void testParentSiblingsForm() throws InterruptedException {
        studentTopNavBar = new StudentTopNavBar(driver);
        // sleep(2000);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        generalInfoPage = studentTopNavBar.clickAddNewStudent();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        parentsSiblingsPage = studentTopNavBar.clickParentsSiblings();
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

        //
        // sleep(10000);
        // studentTopNavBar.clickSaveStudent();

    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        sleep(2000);
        driver.quit();
    }
}

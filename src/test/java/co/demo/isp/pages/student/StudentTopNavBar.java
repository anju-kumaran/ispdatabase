package co.demo.isp.pages.student;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;

public class StudentTopNavBar {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "globalSearchStudent")
    private WebElement studentSearch;

    /*@FindBy(xpath = "//table[@class='table table-hover']//tr/td[2]")
    private WebElement studentName;

    @FindBy(xpath = "//table[@class='table table-hover']//tr/td[1]")
    private WebElement studentId;*/

    @FindBy(xpath = "//div[@class='col-md-4 col-sm-4 t-r f-r p-r-36']//a//i[@class='fa fa-history']")
    private  WebElement previousHistory;

    @FindBy(xpath = "//div[@class='col-md-4 col-sm-4 t-r f-r p-r-36']//a[contains(text(),'Datasheet')]")
    private  WebElement dataSheet;

    @FindBy(xpath = "//div[@class='col-md-4 col-sm-4 t-r f-r p-r-36']//a[@class='btn btn-dark2 m-l-7 ng-scope']")
    private WebElement addNewStudent;

    //@FindBy(xpath = "//div[@class='col-md-4 col-sm-4 t-r f-r p-r-36']//a//i[@class='fa fa-floppy-o fs-20']")
    @FindBy(xpath = "//a[@title='Update Student Information']")
    private  WebElement saveStudent;

    @FindBy(xpath = "//div[@class='wrapper-subtabs']//ul//li[3]")
    private WebElement generalInfo;

    @FindBy(xpath = "//div[@class='wrapper-subtabs']//ul//li[4]")
    private WebElement additionalInfo;

    @FindBy(xpath = "//div[@class='wrapper-subtabs']//ul//li[5]")
    private WebElement emergencyCust;

    //@FindBy(xpath = "//div[@class='wrapper-subtabs']//ul//li[6]")
    @FindBy(xpath = "//li[@role='presentation']//a[contains(text(),'Siblings')]")
    private WebElement parentsSiblings;

    @FindBy(xpath = "//div[@class='wrapper-subtabs']//ul//li[11]")
    private WebElement schoolHistory;

    @FindBy(xpath = "//div[@class='wrapper-subtabs']//ul//li[14]")
    private WebElement communicationLog;

    @FindBy(xpath = "//div[@class='wrapper-subtabs']//ul//li[15]")
    private WebElement immigrationMedical;

    @FindBy(xpath = "//div[@class='wrapper-subtabs']//ul//li[16]")
    private WebElement academics;

    @FindBy(xpath = "//div[@class='wrapper-subtabs']//ul//li[17]")
    private WebElement notes;

    @FindBy(xpath = "//div[@class='wrapper-subtabs']//ul//li[18]")
    private WebElement registrationCheckList;

    @FindBy(xpath = "//div[@class='wrapper-subtabs']//ul//li[19]")
    private WebElement preArrivalTravel;

    @FindBy(xpath = "//div[@class='wrapper-subtabs']//ul//li[20]")
    private WebElement activities;

    @FindBy(xpath = "//div[@class='wrapper-subtabs']//ul//li[21]")
    private WebElement documentRepository;

    @FindBy(xpath = "//div[@class='wrapper-subtabs']//ul//li[22]")
    private WebElement discipline;

    @FindBy(xpath = "//div[@class='wrapper-subtabs']//ul//li[24]")
    private WebElement homestayPayments;

    @FindBy(xpath = "//div[@class='wrapper-subtabs']//ul//li[25]")
    private WebElement scholarship;

    @FindBy(xpath = "//div[@class='wrapper-subtabs']//ul//li[26]")
    private WebElement payees;


    public StudentTopNavBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public DatasheetViewPage clickDatasheetView(){
        return new DatasheetViewPage(driver);
    }

    public GeneralInformationPage clickAddNewStudent(){
        //this.addNewStudent.click();
        addNewStudent = wait.until(ExpectedConditions.elementToBeClickable(addNewStudent));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addNewStudent);

        return new GeneralInformationPage(driver);
    }
    public GeneralInformationPage clickSaveStudent(){
        this.saveStudent.click();
        return new GeneralInformationPage(driver);
    }

    public GeneralInformationPage searchStudentByName(String studentName){
        this.studentSearch.sendKeys(studentName);
        try {
            Thread.sleep(8000);
            WebElement student = driver.findElement(By.xpath("//table[@class='table table-hover']//tr/td[2]"));
            if(student.getText().trim().equals(studentName)) {
                student.click();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*List<WebElement> studentList = driver.findElements(By.xpath("//table[@class='table table-hover']//tr/td[2]"));
        Iterator<WebElement> iterator = studentList.iterator();
        System.out.println("studentName:"+studentName);
        System.out.println("studentList:"+studentList);
        while (iterator.hasNext()) {
            WebElement elm  = iterator.next();
            System.out.println("elm:"+elm.getText());
            if(elm.getText().trim().equals(studentName)) {
                System.out.println("elm:"+elm);
                //elm.click();
                JavascriptExecutor executor = (JavascriptExecutor)driver;
                executor.executeScript("arguments[0].click();",elm);
                break;
            }
        }*/
        return new GeneralInformationPage(driver);
    }
    public GeneralInformationPage searchStudentById(String studentId){
        this.studentSearch.sendKeys(studentId);

        System.out.println("studentName:" + studentId);
        try {
            Thread.sleep(8000);
            WebElement student = driver.findElement(By.xpath("//table[@class='table table-hover']//tr/td[1]"));
            System.out.println("elm:" + student.getText());
            if(student.getText().equals(studentId)) {
                System.out.println("ifelm:" + student.getText());
                student.click();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new GeneralInformationPage(driver);
    }

    public ParentsSiblingsPage clickParentsSiblings(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", parentsSiblings);
        return new ParentsSiblingsPage(driver);
    }

    public ImmigrationMedicalPage clickImmigrationMedical(){
        this.immigrationMedical.click();
        return new ImmigrationMedicalPage(driver);
    }


}

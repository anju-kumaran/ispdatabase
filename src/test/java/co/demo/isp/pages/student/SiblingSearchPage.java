package co.demo.isp.pages.student;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SiblingSearchPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Parent 1 Last Name']")
    private WebElement parentOneLastname;

    @FindBy(xpath = "//button[@class='btn btn-dark' and text()='Search']")
    private WebElement btnSearchSibling;

    @FindBy(xpath = "//input[@placeholder='Relation']")
    private WebElement siblingRelation;

    @FindBy(xpath = "//button[text()='Add Siblings']")
    private WebElement btnAddSiblings;

    @FindBy(xpath = "//button[@class='btn btn-dark' and text()='Close']")
    private WebElement btnClose;

    public SiblingSearchPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void searchProbableSiblings(String lastname){
        this.parentOneLastname.sendKeys(lastname);
        this.btnSearchSibling.click();
    }
    public void addSiblings(String relation){
        this.siblingRelation.sendKeys(relation);
        this.btnAddSiblings.click();
    }
    public void closeSiblingSearchForm(){
        this.btnClose.click();
    }
}

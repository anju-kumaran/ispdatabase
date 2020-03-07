package co.demo.isp.pages;

import co.demo.isp.pages.student.DatasheetViewPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserDashboard {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@id='headingOne']//h3[@class='panel-title']")
    private WebElement studentTitle;

    public UserDashboard (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,20);
        PageFactory.initElements(driver,this);
    }
    public DatasheetViewPage clickStudentsModule(){
       // studentTitle = wait.until(ExpectedConditions.elementToBeClickable(studentTitle));
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].click();", studentTitle);
       return new DatasheetViewPage(driver);
    }
}

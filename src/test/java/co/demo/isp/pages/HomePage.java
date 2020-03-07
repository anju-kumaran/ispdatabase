package co.demo.isp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//a[@href='/user_login']")
    private WebElement btnUserDashBoard;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,20);
        PageFactory.initElements(driver,this);
    }
    public LoginPage clickBtnUserDashBoard(){
        btnUserDashBoard = wait.until(ExpectedConditions.elementToBeClickable(btnUserDashBoard));
        btnUserDashBoard.click();
        return new LoginPage(driver);
    }
}

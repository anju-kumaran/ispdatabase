package co.demo.isp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "email")
    private WebElement userEmail;

    @FindBy(id = "password")
    private WebElement userPassword;

    @FindBy(css = "a.forgot-password-btn")
    private WebElement forgotPassword;

    @FindBy(xpath = "//input[@type='submit' and @value='Login']")
    private WebElement btnLogin;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public UserDashboard clickBtnLogin(String email,String password){
       this.userEmail.sendKeys(email);
       this.userPassword.sendKeys(password);
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].click();", btnLogin);
       return new UserDashboard(driver);
    }

}

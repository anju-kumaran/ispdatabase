package co.demo.isp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//a[@href='/user_login']")
    private WebElement btnUserDashBoard;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public LoginPage clickBtnUserDashBoard(){
        btnUserDashBoard.click();
        return new LoginPage(driver);
    }
}

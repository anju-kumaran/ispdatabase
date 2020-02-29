package co.demo.isp.pages.student;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuickEmailPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Subject']")
    private WebElement emailSubject;

    @FindBy(xpath = "//input[@placeholder='E-mail address']")
    private WebElement emailAddress;

    @FindBy(xpath = "//textarea[@placeholder='Your message']")
    private WebElement emailMessage;

    @FindBy(xpath = "//button[@class='btn btn-dark' and text()='Send']")
    private WebElement btnSendEmail;

    @FindBy(xpath = "//button[@class='btn btn-dark' and text()='Close']")
    private WebElement btnCloseEmail;

    public QuickEmailPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void sendQuickEmail(String subject,String message){
        this.emailSubject.sendKeys(subject);
        this.emailMessage.sendKeys(message);
        this.btnSendEmail.click();
    }
    public void closeQuickEmailForm(){
        this.btnCloseEmail.click();
    }
}

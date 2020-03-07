package co.demo.isp.pages.student;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralInformationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//legend[@class='student-legend']")
    private WebElement liveText;

    public GeneralInformationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }
    public WebElement getLiveText() {
        return liveText;
    }
}

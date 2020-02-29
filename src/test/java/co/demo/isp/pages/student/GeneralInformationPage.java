package co.demo.isp.pages.student;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneralInformationPage {
    private WebDriver driver;

    @FindBy(xpath = "//legend[@class='student-legend']")
    private WebElement liveText;

    public GeneralInformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public WebElement getLiveText() {
        return liveText;
    }
}

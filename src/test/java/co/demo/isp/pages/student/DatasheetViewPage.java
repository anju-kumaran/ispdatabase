package co.demo.isp.pages.student;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatasheetViewPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@class='col-md-8 col-xs-12 p-l-5']//span//b[contains(text(),'Tips')]")
    private WebElement liveText;

    public DatasheetViewPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }
    public WebElement getLiveText() {

        return liveText;
    }
}

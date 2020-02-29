package co.demo.isp.pages.student;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ImmigrationMedicalPage {
    private WebDriver driver;

    public ImmigrationMedicalPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}

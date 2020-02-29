package co.demo.isp.drivermanager;

import co.demo.isp.config.FrameWorkConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private WebDriver driver;
    private static DriverManager instance;

    private DriverManager(){
        init();
    }

    private void init(){
        if(FrameWorkConfig.getProperty("browser").equals(BrowserType.CHROME.toString())){
            System.setProperty("webdriver.chrome.driver",FrameWorkConfig.getProperty("chrome.executable"));
            driver = new ChromeDriver();
        }else if (FrameWorkConfig.getProperty("browser").equals(BrowserType.FIREFOX.toString())){
            System.setProperty("webdriver.gecko.driver",FrameWorkConfig.getProperty("firefox.executable"));
            driver = new FirefoxDriver();
        }else{
            System.setProperty("webdriver.chrome.driver",FrameWorkConfig.getProperty("chrome.executable"));
            driver = new ChromeDriver();
        }
    }
    public static WebDriver getDriver(){
        if(instance==null){
            instance=new DriverManager();
        }
        return instance.driver;
    }
}

package co.demo.isp.listeners;

import co.demo.isp.drivermanager.DriverManager;
import co.demo.isp.util.FrameworkUtils;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
       //FrameworkUtils.captureScreenShot(DriverManager.getDriver(),iTestResult.getName(),true);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        FrameworkUtils.captureScreenShot(DriverManager.getDriver(),iTestResult.getName(),false);
    }

}

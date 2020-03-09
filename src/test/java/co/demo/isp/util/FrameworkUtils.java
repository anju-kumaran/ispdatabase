package co.demo.isp.util;

import co.demo.isp.config.FrameWorkConfig;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class FrameworkUtils {
    private static String dateFormat = "ddMMyyyyHHmm";
    private static HashMap<String,String> screenShotTestMap = new HashMap<>();
    public static String getScreenShotLocation(String testName){
        return screenShotTestMap.get(testName);
    }

    // Pass screenshots goes in dir
    // target/screenshot/pass
    // Fails
    // target/screenshot/fail

    private static void createScreenshotDirs(){
        try {
            if(FrameWorkConfig.getProperty("screenshotType").equals("pass")) {
                Files.createDirectories(
                        Paths.get(FrameWorkConfig.getProperty("screenshot.pass.dir")));
            }else  if(FrameWorkConfig.getProperty("screenshotType").equals("fail")){
                Files.createDirectories(
                        Paths.get(FrameWorkConfig.getProperty("screenshot.fail.dir")));
            }else{
                Files.createDirectories(
                        Paths.get(FrameWorkConfig.getProperty("screenshot.pass.dir")));
                Files.createDirectories(
                        Paths.get(FrameWorkConfig.getProperty("screenshot.fail.dir")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String formatDate(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        return simpleDateFormat.format(date);
    }


    public static String getScreenShotFile(String testName){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyyHHmmSS");
        return testName+"_"+simpleDateFormat.format(new Date())+".png";
    }

    public static void captureScreenShot(WebDriver driver, String testName, boolean pass ){
        createScreenshotDirs();
        File memoryScreenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileName = getScreenShotFile(testName);
        try {
            if(pass){
                Path passFilePath = Paths.get(FrameWorkConfig.getProperty("screenshot.pass.dir"),fileName);
                Files.copy(new FileInputStream(memoryScreenShot),passFilePath);
                screenShotTestMap.put(testName,passFilePath.toString());
            }else {
                Path passFilePath = Paths.get(FrameWorkConfig.getProperty("screenshot.fail.dir"),fileName);
                Files.copy(new FileInputStream(memoryScreenShot),passFilePath);
                //screenShotTestMap.put(testName,passFilePath.toAbsolutePath().toString());
                screenShotTestMap.put(testName,passFilePath.toString());
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File getReportFileName(){
        Path file = null;
        try {
            Files.createDirectories(Paths.get(FrameWorkConfig.getProperty("report.dir")));
            String fileName = FrameWorkConfig.getProperty("report.fileprefix")+"_"+formatDate(new Date())+".html";
            file = Paths.get(FrameWorkConfig.getProperty("report.dir"), fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file.toFile();
    }
}

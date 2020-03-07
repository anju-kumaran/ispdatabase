package co.demo.isp.reports;

import co.demo.isp.util.FrameworkUtils;
import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentHtmlReport {
     private static ExtentReports reports;

     private ExtentHtmlReport () {
         ExtentReporter extentReporter = new ExtentHtmlReporter(FrameworkUtils.getReportFileName());
         reports = new ExtentReports();
         reports.attachReporter(extentReporter);

         reports.setSystemInfo("Host name","localhost");
         reports.setSystemInfo("Environment","QA");
         reports.setSystemInfo("Automation Tester","Anju");
         reports.setSystemInfo("Organization","Pragra");

     }

     public static ExtentReports getReport(){
         if(reports==null){
            new ExtentHtmlReport();
        }
        return reports;
     }
}

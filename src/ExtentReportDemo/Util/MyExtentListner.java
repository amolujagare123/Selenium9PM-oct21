package ExtentReportDemo.Util;

import TestNGDemo.DemoSites.util.Init;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.event.ItemListener;
import java.io.IOException;

import static ExtentReportDemo.Util.Screenshot.getScreenshot;
import static ExtentReportDemo.Util.extentUtil.InitExtent.initExtentReport;

public class MyExtentListner extends Init implements ITestListener  {

    static ExtentReports extent;
    ExtentTest test;
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());
       // System.out.println("onTestStart");
    }

    public void onTestSuccess(ITestResult result) {
        test.pass("this test is passed");
      //  System.out.println("onTestSuccess");
    }

    public void onTestFailure(ITestResult result) {
        test.info("this test is fail");
        test.fail(result.getThrowable());
        try {
            test.addScreenCaptureFromPath("./screenshots/"+getScreenshot(driver));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //  System.out.println("onTestFailure");
    }

    public void onTestSkipped(ITestResult result) {

        test.info("this test is skipped");
        test.skip(result.getThrowable());
       /// System.out.println("onTestSkipped");
    }


    public void onStart(ITestContext context) {

       if (extent==null)
        extent =  initExtentReport();

        System.out.println("onStart");
    }

    public void onFinish(ITestContext context) {

       extent.flush();
    }
}

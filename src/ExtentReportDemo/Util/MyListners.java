package ExtentReportDemo.Util;

import com.aventstack.extentreports.ExtentReports;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static ExtentReportDemo.Util.extentUtil.InitExtent.initExtentReport;

public class MyListners implements ITestListener {

    // before test method @Test
    public void onTestStart(ITestResult result) {

        System.out.println("onTestStart");
    }

    public void onTestSuccess(ITestResult result) {

        System.out.println("onTestSuccess");
    }

    public void onTestFailure(ITestResult result) {

        System.out.println("onTestFailure");
    }

    public void onTestSkipped(ITestResult result) {

        System.out.println("onTestSkipped");
    }


    // before test tag <test>
    public void onStart(ITestContext context) {



        System.out.println("onStart");
    }

    // after test tag <test>
    public void onFinish(ITestContext context) {

        System.out.println("onFinish");
    }
}

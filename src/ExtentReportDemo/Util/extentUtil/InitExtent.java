package ExtentReportDemo.Util.extentUtil;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class InitExtent {

    public static ExtentReports initExtentReport()
    {
        ExtentSparkReporter reporter = new ExtentSparkReporter("reports/report.html");
        ExtentReports extent = new ExtentReports();

        reporter.config().setReportName("All regression tests");
        reporter.config().setDocumentTitle("All types of website");

        extent.attachReporter(reporter);

        extent.setSystemInfo("Developers name","Akshay");
        extent.setSystemInfo("Test Lead","Madhv");
        extent.setSystemInfo("Project Name","System management");
        extent.setSystemInfo("Start date","23 nov 21");

        return extent;
    }
}

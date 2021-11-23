package ExtentReportDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExtentReportDemo1 {


    ExtentReports extent;

    @BeforeClass
    public void initExtentReport()
    {
        ExtentSparkReporter reporter = new ExtentSparkReporter("reports/report.html");
        extent = new ExtentReports();

        reporter.config().setReportName("All regression tests");
        reporter.config().setDocumentTitle("All types of website");

        extent.attachReporter(reporter);

        extent.setSystemInfo("Developers name","Akshay");
        extent.setSystemInfo("Test Lead","Madhv");
        extent.setSystemInfo("Project Name","System management");
        extent.setSystemInfo("Start date","23 nov 21");
    }




    @Test
    public void myTest()
    {
        // --- Login page ------------

        ExtentTest test = extent.createTest("login test");


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        test.info("browser is opened");

        driver.manage().window().maximize();

        test.info("browser is maximized");

        driver.get("https://stock.scriptinglogic.net/");

        test.info("url is opened");

        WebElement txtUsername = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("admin");
        test.info("username is entered");

        WebElement txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("admin");

        test.info("password is entered");

        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();

        test.info("Login button is cliked");


        extent.flush();
    }


}

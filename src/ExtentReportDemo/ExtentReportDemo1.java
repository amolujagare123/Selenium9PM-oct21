package ExtentReportDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static ExtentReportDemo.Util.Screenshot.getScreenshot;

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


    @AfterClass
    public void writeToReport()
    {
        extent.flush();
    }


    @Test
    public void myTest1() throws IOException {
        // --- Login page ------------

            ExtentTest test = extent.createTest("valid login test");

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

        String expected = "https://stock.scriptinglogic.net/dashboard.php1";
        String actual = driver.getCurrentUrl();

        try {
            Assert.assertEquals(actual, expected, "this is not dashboard");

            test.pass("this test is passed");

        }
        catch (AssertionError e)
        {
            test.fail(e.getMessage());
            test.addScreenCaptureFromPath("./screenshots/"+getScreenshot(driver));
        }
    }


    @Test
    public void myTest2() throws IOException {
        // --- Login page ------------

        ExtentTest test = extent.createTest("invalid login test");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        test.info("browser is opened");

        driver.manage().window().maximize();

        test.info("browser is maximized");

        driver.get("https://stock.scriptinglogic.net/");

        test.info("url is opened");

        WebElement txtUsername = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("ffdfdf");
        test.info("wrong username is entered");

        WebElement txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("fdfdf");

        test.info("wrong password is entered");

        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();

        test.info("Login button is cliked");

        String expected = "https://stock.scriptinglogic.net/index.php?msg=Wrong%20Username%20or%20Password&type=error";

        String actual = driver.getCurrentUrl();


        try {
            Assert.assertEquals(actual,expected,"incorrect page");

            test.pass("this test is passed");

        }
        catch (AssertionError e)
        {
            test.fail(e.getMessage());
            test.addScreenCaptureFromPath("./screenshots/"+getScreenshot(driver));
        }

    }

    @Test
    public void myTest3() throws IOException {
        // --- Login page ------------

        ExtentTest test = extent.createTest("blank login test");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        test.info("browser is opened");

        driver.manage().window().maximize();

        test.info("browser is maximized");

        driver.get("https://stock.scriptinglogic.net/");

        test.info("url is opened");

        WebElement txtUsername = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("");
        test.info("username is not entered");

        WebElement txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("");

        test.info("password is not entered");

        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();

        test.info("Login button is cliked");

        String expected = "https://stock.scriptinglogic.net/";

        String actual = driver.getCurrentUrl();

        try {
            Assert.assertEquals(actual,expected,"incorrect page");

            test.pass("this test is passed");

        }
        catch (AssertionError e)
        {
            test.fail(e.getMessage());
            test.addScreenCaptureFromPath("./screenshots/"+getScreenshot(driver));
        }


    }


}

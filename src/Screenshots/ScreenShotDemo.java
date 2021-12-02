package Screenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotDemo {

    WebDriver driver;
    @BeforeClass// method below this annotation will run before every test method
    public void OpenBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterClass // method below this annotation will run before after test method
    public void closeBrowser() throws InterruptedException {
        //Thread.sleep(4000);
        driver.close();
    }

    @Test
    public void naukri() throws IOException {
        driver.get("http://drive.google.com");

        // 1. create the object reference of TakesScreenshot
        // assign current driver to it
        TakesScreenshot ts = (TakesScreenshot) driver;

        // 2. call getScreenshotAs method
        File scrFile = ts.getScreenshotAs(OutputType.FILE);

        // 3. copy this file object into a real image
        String timeStamp = new SimpleDateFormat("_yyyyMMdd_hhmmss").format(new Date());

        String fileName = "IMG"+timeStamp+".png";

        FileUtils.copyFile(scrFile,new File("D:\\screenshots\\"+fileName));


    }
}

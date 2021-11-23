package TestNGDemo.DemoSites;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SocialWebsites {
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
   //     Thread.sleep(4000);
        driver.close();
    }

    @Test
    public void facebook()
    {
        driver.get("http://facebook.com");
    }

    @Test
    public void instagram()
    {
        driver.get("http://instagram.com");
    }

    @Test
    public void twitter()
    {
        driver.get("http://twitter.com");
    }




}

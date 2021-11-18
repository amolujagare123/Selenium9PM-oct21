package TestNGDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SomeWebsites {
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
        Thread.sleep(4000);
        driver.close();
    }

    @Test (priority = 1)
    public void naukri()
    {
        driver.get("http://naukri.com");
    }

    @Test (priority = 2)
    public void shine()
    {
        driver.get("http://shine.com");
    }

    @Test (priority = 3)
    public void monster()
    {
        driver.get("http://monster.com");
    }


    /*
    monster
   naukri
shine

     */

}

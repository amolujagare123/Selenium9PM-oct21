package TestNGDemo.DemoSites;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class tutorialsWebsites {
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
     //   Thread.sleep(4000);
        driver.close();
    }

    @Test
    public void javatpoint()
    {
        driver.get("http://javatpoint.com");
    }

    @Test
    public void scriptinglogic()
    {
        driver.get("http://scriptinglogic.com");
    }

    @Test
    public void w3schools()
    {
        driver.get("http://w3schools.com");
    }



}

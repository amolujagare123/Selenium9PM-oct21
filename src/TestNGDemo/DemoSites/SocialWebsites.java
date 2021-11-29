package TestNGDemo.DemoSites;

import TestNGDemo.DemoSites.util.Init;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SocialWebsites  extends Init {


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

package TestNGDemo.DemoSites;

import TestNGDemo.DemoSites.util.Init;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JobWebsites  extends Init {


    @Test
    public void naukri()
    {
        driver.get("http://naukri.com");
        String expected ="Jobs - Recruitment";
        String actual = driver.getTitle();

        boolean result = actual.contains(expected);

 //       Assert.assertEquals(actual,expected,"");

        Assert.assertTrue(result,"the given txt is not present in the page title");
    }

    @Test//(enabled = false)
    public void shine()
    {
        driver.get("http://shine.com");
        Assert.assertEquals(true,false,"This test is failed");
    }

    @Test//(enabled = false)
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

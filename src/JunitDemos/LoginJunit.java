package JunitDemos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginJunit {


    WebDriver driver;

    @Before // method below this annotation will run before every test method
    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @After // method below this annotation will run after every test method
    public void closeBrowser()
    {
        driver.close();
    }

    @Test
    public void myTest1() {

        driver.get("http://stock.scriptinglogic.net");
        driver.findElement(By.cssSelector("#login-username")).sendKeys("admin"); // #login-username
        driver.findElement(By.cssSelector("#login-password")).sendKeys("admin"); // #login-password
        driver.findElement(By.cssSelector(".blue")).click(); // .blue

    }

    @Test
    public void myTest2() {

        driver.get("http://stock.scriptinglogic.net");
        driver.findElement(By.cssSelector("#login-username")).sendKeys("545"); // #login-username
        driver.findElement(By.cssSelector("#login-password")).sendKeys("dsds"); // #login-password
        driver.findElement(By.cssSelector(".blue")).click(); // .blue

    }

    @Test
    public void myTest3() {

        driver.get("http://stock.scriptinglogic.net");
        driver.findElement(By.cssSelector("#login-username")).sendKeys(""); // #login-username
        driver.findElement(By.cssSelector("#login-password")).sendKeys(""); // #login-password
        driver.findElement(By.cssSelector(".blue")).click(); // .blue

    }
}

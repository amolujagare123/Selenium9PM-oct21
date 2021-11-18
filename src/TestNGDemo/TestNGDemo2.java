package TestNGDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo2 {
    WebDriver driver;
    @BeforeMethod// method below this annotation will run before every test method
    public void OpenBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterMethod // method below this annotation will run before after test method
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(4000);
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
        driver.findElement(By.cssSelector("#login-username")).sendKeys("dsds"); // #login-username
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

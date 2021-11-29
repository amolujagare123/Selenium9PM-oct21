package DataProviderDemo;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDataProvider {

    @Test (dataProvider = "getData")
    public void myTest1(String username,String password) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://stock.scriptinglogic.net");
        driver.findElement(By.cssSelector("#login-username")).sendKeys(username); // #login-username
        driver.findElement(By.cssSelector("#login-password")).sendKeys(password); // #login-password
        driver.findElement(By.cssSelector(".blue")).click(); // .blue

    }

    @DataProvider
    public Object[][] getData()
    {

        Object[][] data = new Object[4][2];

        data[0][0] = "admin";
        data[0][1] = "admin";

        data[1][0] = "amol";
        data[1][1] = "amol123";

        data[2][0] = "deepa";
        data[2][1] = "deepa123";

        data[3][0] = "amar";
        data[3][1] = "amar123";

        return data;

    }

}

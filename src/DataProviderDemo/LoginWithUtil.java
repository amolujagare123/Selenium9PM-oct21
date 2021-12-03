package DataProviderDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static DataProviderDemo.util.DataProviderUtil.getMyData;

public class LoginWithUtil {

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
    public Object[][] getData() throws IOException {

        return getMyData("Data/myData.xls","Sheet2");

    }

}

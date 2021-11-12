package Basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LoginDemo2 {

    public static void main(String[] args) {

        // --- Login page ------------

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://stock.scriptinglogic.net/");

        List<WebElement> wbList = driver.findElements(By.tagName("input"));

        System.out.println("size="+wbList.size()); // 3

        wbList.get(0).sendKeys("admin"); // user - text
        wbList.get(1).sendKeys("admin"); // pass - text
        wbList.get(2).click(); // login btn

    }
}

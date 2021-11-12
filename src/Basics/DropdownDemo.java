package Basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownDemo {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("file:///C:/Users/amolu/Downloads/amol.html");

        // 1. find the webelement of select tag

        WebElement drpSel = driver.findElement(By.id("seltext"));

        // 2. create the object of Select class, pass
        // webelement into its constructor

        Select sel = new Select(drpSel);

        // 3. select the option using either
        // visible Text / index / value
        Thread.sleep(4000);
        //sel.selectByVisibleText("text 2");

       // sel.selectByIndex(3);
        sel.selectByValue("v13");

    }
}

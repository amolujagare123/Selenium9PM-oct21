package Basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioCheckBox {


        public static void main(String[] args) throws InterruptedException {

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("file:///C:/Users/amolu/Downloads/amol.html");

            driver.findElement(By.id("check1")).click(); // checkbox
            driver.findElement(By.id("rad1")).click(); // radio button




        }

}

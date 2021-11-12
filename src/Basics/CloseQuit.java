package Basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseQuit {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://naukri.com");

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    //    System.out.println(driver.getPageSource());

       // driver.close();
      driver.quit();

    }
}

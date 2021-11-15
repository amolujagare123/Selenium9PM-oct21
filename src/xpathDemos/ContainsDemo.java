package xpathDemos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContainsDemo {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.in/s?k=amarendra+chitale+book&ref=nb_sb_noss");

        //driver.findElement(By.xpath("//span[contains(text(),'NLP')]")).click();
        driver.findElement(By.xpath("//img[contains( @alt, 'Being' ) ]")).click();
    }
}

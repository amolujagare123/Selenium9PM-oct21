package xpathDemos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDatatable3 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://billing.scriptinglogic.net");

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("amolujagare@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//input[@name='btn_login']")).click();

        driver.findElement(By.xpath("//span[normalize-space()='Clients']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='View Clients']")).click();

        String name ="Ajay Mathur";

        driver.findElement(By.xpath("//tr[td/a[text()='"+name+ "']]//div")).click();

        driver.findElement(By.xpath("//tr[td/a[text()='"+name+"']]//a[normalize-space()='Edit']")).click();
    }
}

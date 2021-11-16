package CssSelectors;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginDemo {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://stock.scriptinglogic.net");

      /*  driver.findElement(By.cssSelector("input#login-username")).sendKeys("admin"); // #login-username
        driver.findElement(By.cssSelector("input#login-password")).sendKeys("admin"); // #login-password
        driver.findElement(By.cssSelector("input.button")).click(); // .blue
*/

        driver.findElement(By.cssSelector("#login-username")).sendKeys("admin"); // #login-username
        driver.findElement(By.cssSelector("#login-password")).sendKeys("admin"); // #login-password
        driver.findElement(By.cssSelector(".blue")).click(); // .blue

    }
}

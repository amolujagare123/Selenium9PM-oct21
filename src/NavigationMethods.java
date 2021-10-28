import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethods {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://facebook.com");

        driver.navigate().to("http://gmail.com");

        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

    }
}

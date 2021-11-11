import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/amolu/Downloads/amol.html");

        WebElement multiSelList = driver.findElement(By.id("multiSel"));

        Select multiSelect = new Select(multiSelList);

        Thread.sleep(4000);

        multiSelect.selectByIndex(0); // text 1

        Thread.sleep(4000);
        multiSelect.selectByIndex(1);// text 2

        Thread.sleep(4000);
        multiSelect.selectByIndex(2);// text 3

       /* Thread.sleep(4000);
        multiSelect.deselectByIndex(2);

        Thread.sleep(4000);
        multiSelect.deselectByIndex(0);*/

        Thread.sleep(4000);
        multiSelect.deselectAll();

    }
}

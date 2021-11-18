package JunitDemos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddCutomerAssertion {

    @Test
    public  void addCustomerTest() {

        // --- Login page ------------

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://stock.scriptinglogic.net/");

        WebElement txtUsername = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("admin");

        WebElement txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();

        //----------- Home page -----------

        WebElement lnkAddCustomer = driver.findElement(By.linkText("Add Customer"));
        lnkAddCustomer.click();

        // --- Add customer page ------

        WebElement txtName = driver.findElement(By.name("name"));
        txtName.sendKeys("Balaji");

        WebElement txtAddress = driver.findElement(By.name("address"));
        txtAddress.sendKeys("xyz");

        WebElement txtContact1 = driver.findElement(By.name("contact1"));
        txtContact1.sendKeys("67676767");

        WebElement txtContact2 = driver.findElement(By.name("contact2"));
        txtContact2.sendKeys("67676767");

        WebElement btnAdd = driver.findElement(By.name("Submit"));
        btnAdd.click();

        String expected = "Dublicat Entry. Please Verify";
        String actual = null;
        try {
            actual = driver.findElement(By.cssSelector("div.error-box")).getText();
        }
        catch (Exception e)
        {
            actual="";
        }

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals("incorrect error message or error message absent",expected,actual);


    }
}

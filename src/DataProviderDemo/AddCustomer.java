package DataProviderDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AddCustomer {
    WebDriver driver;

    @BeforeClass
    public void doLogin()
    {
        // --- Login page ------------

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://stock.scriptinglogic.net/");

        WebElement txtUsername = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("admin");

        WebElement txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();
    }




    @Test (dataProvider = "getData")
    public  void addCustomerTest(String name,String add,String contact1,
                                 String contact2) {

        //----------- Home page -----------

        WebElement lnkAddCustomer = driver.findElement(By.linkText("Add Customer"));
        lnkAddCustomer.click();

        // --- Add customer page ------
        WebElement txtName = driver.findElement(By.name("name"));
        txtName.sendKeys(name);

        WebElement txtAddress = driver.findElement(By.name("address"));
        txtAddress.sendKeys(add);

        WebElement txtContact1 = driver.findElement(By.name("contact1"));
        txtContact1.sendKeys(contact1);

        WebElement txtContact2 = driver.findElement(By.name("contact2"));
        txtContact2.sendKeys(contact2);

        WebElement btnAdd = driver.findElement(By.name("Submit"));
        btnAdd.click();
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        // 1. read the file
        FileInputStream fis = new FileInputStream("Data/myData.xls");

        // 2. convert the file object into workbook object
        HSSFWorkbook workbook = new HSSFWorkbook(fis);

        // 3. choose sheet from excel
        HSSFSheet sheet = workbook.getSheet("Add Customer");

        // 4. count the active rows
        int rowCount = sheet.getPhysicalNumberOfRows();

        int colCount = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount-1][colCount];


        for(int i=0;i<rowCount-1;i++)
        {
            HSSFRow row = sheet.getRow(i+1);

            for(int j=0;j<colCount;j++)
                data[i][j] = row.getCell(j).toString();

           /* data[i][0] = row.getCell(0).toString(); // name
            data[i][1] = row.getCell(1).toString(); // address
            data[i][2] = row.getCell(2).toString(); // contact1
            data[i][3] = row.getCell(3).toString(); // contact2*/
        }

        return data;
    }


}

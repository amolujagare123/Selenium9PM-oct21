package DataProviderDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginDataProviderEX {

    @Test (dataProvider = "getData")
    public void myTest1(String username,String password) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://stock.scriptinglogic.net");
        driver.findElement(By.cssSelector("#login-username")).sendKeys(username); // #login-username
        driver.findElement(By.cssSelector("#login-password")).sendKeys(password); // #login-password
        driver.findElement(By.cssSelector(".blue")).click(); // .blue

    }

    @DataProvider
    public Object[][] getData() throws IOException {

       // 1. read the file
        FileInputStream fis = new FileInputStream("Data/myData.xls");

        // 2. convert the file object into workbook object
        HSSFWorkbook workbook = new HSSFWorkbook(fis);

        // 3. choose sheet from excel
        HSSFSheet sheet = workbook.getSheet("Sheet1");

        // 4. count the active rows
        int rowCount = sheet.getPhysicalNumberOfRows();

        Object[][] data = new Object[rowCount][2];

        //5. scan the rows and read the cell values in individual row
        for(int i=0;i<rowCount;i++)
        {
            HSSFRow row = sheet.getRow(i); // 0
            data[i][0] = row.getCell(0).toString();
            data[i][1] = row.getCell(1).toString();
        }



        /*data[0][0] = "admin";
        data[0][1] = "admin";

        data[1][0] = "amol";
        data[1][1] = "amol123";

        data[2][0] = "deepa";
        data[2][1] = "deepa123";

        data[3][0] = "amar";
        data[3][1] = "amar123";*/

        return data;

    }

}

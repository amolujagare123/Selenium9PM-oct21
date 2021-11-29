package ExtentReportDemo.Util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot {

    public static String getScreenshot(WebDriver driver) throws IOException {
        // 1. create the object reference of TakesScreenshot
        // assign current driver to it

        TakesScreenshot ts = (TakesScreenshot) driver;

        // 2. call getScreenshotAs method

        File scrFile = ts.getScreenshotAs(OutputType.FILE);

        // 3. copy this file object into a real image

        String timeStamp = new SimpleDateFormat("_yyyyMMdd_hhmmss").format(new Date());

        String fileName = "IMG"+timeStamp+".png";

        FileUtils.copyFile(scrFile,new File("reports\\screenshots\\"+fileName));

        return fileName;
    }
}

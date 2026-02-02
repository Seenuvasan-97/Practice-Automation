package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName){
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotPath = System.getProperty("user.dir")+"/screenshots/"+testName+"_"+testName+".png";
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destination = new File(screenshotPath);
        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return screenshotPath;

    }

}

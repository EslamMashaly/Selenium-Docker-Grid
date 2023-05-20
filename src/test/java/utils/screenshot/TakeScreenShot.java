package utils.screenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenShot {

    private static WebDriver driver;

    public TakeScreenShot(WebDriver driver){
        this.driver=driver;
    }

    public static String screenShot(String testCaseName) throws IOException {
        TakesScreenshot ts=(TakesScreenshot)driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File file=new File(System.getProperty("user.dir") + "//ExtentReport//"+testCaseName+".png");
        FileUtils.copyFile(src,file);
        return System.getProperty("user.dir") + "//reports//"+testCaseName+".png";
    }
}
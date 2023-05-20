package utils;


import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import utils.dataReaders.ExcelReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Home.HomePage;
import utils.screenshot.TakeScreenShot;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;
    protected BasePage basePage;
    protected TakeScreenShot takeScreenShot;

    @Parameters({"BrowserName"})
    @BeforeMethod
    public void launchApplication(String browserName) throws MalformedURLException {
        if (DriverType.driverType.equals("local")) {
            if (browserName.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();

            } else if (browserName.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();

            } else if (browserName.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            }
        }
        else if(DriverType.driverType.equals("remote")) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setBrowserName(browserName);
            driver = new RemoteWebDriver(new URL("http://192.168.1.5:4444"), caps);
        }
        driver.get(Links.home);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        basePage = new BasePage(driver);
        takeScreenShot = new TakeScreenShot(driver);
    }

    @AfterMethod()
    public void CloseBrowser( ) {
        driver.quit();
    }



    @DataProvider(name = "ExcelData")
    public Object [][] registrationData() throws IOException {
        ExcelReader er=new ExcelReader();
        return er.getExcelData();
    }


}

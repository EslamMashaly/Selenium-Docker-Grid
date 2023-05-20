package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private WebDriver driver;

    public BasePage (WebDriver driver) {
        this.driver = driver;
    }

    /****Common Methods Used in Test Pages****/
    protected WebElement find(By locator){
        return driver.findElement(locator);
    }
    protected void click(By locator){
        find(locator).click();
    }
    protected String getText(By locator){
        return find(locator).getText();
    }
    protected void sendKeys(By locator, String text){
        find(locator).sendKeys(text);
    }
    protected void elementVisibilityExplicitWait(By locator, int duration){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

}

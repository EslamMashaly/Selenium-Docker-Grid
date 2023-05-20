package pages.Home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Login.LoginPage;
import pages.Register.RegisterPage;
import utils.BasePage;

import java.time.Duration;

public class HomePage extends BasePage {

private WebDriver driver;
private final By searchBar= By.cssSelector("div[id='entry_217822'] input[placeholder='Search For Products']");
private final By myAccountButton=By.xpath("//a[@role='button']//span[@class='title'][normalize-space()='My account']");
private final By loginButton=By.xpath("//span[normalize-space()='Login']");
private final By registerButton=By.xpath("//span[normalize-space()='Register']");
private final By registerText=By.cssSelector(".page-title");
private final By loginText=By.xpath("//h2[text()='Returning Customer']");

public HomePage (WebDriver driver){
    super(driver);
    this.driver=driver;
}

    public RegisterPage hoverToRegister(){
        hoverAndClick(registerButton,registerText);
        return new RegisterPage(driver);
    }
    public LoginPage hoverToLogin(){
        hoverAndClick(loginButton,loginText);
        return new LoginPage(driver);
    }

    private void hoverAndClick(By clickAfterHover, By waitingElement){
        Actions a = new Actions(driver);
        a.moveToElement(find(myAccountButton)).perform();
        click(clickAfterHover);
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(waitingElement)));
    }



}

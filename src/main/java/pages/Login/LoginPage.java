package pages.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.myAccount.MyAccountPage;
import utils.BasePage;

import java.time.Duration;

public class LoginPage extends BasePage {
    private WebDriver driver;

    private final By emailField=By.id("input-email");
    private final By passwordField=By.id("input-password");
    private final By loginButton=By.xpath("//input[@type='submit']");
    private final By warningMessage=By.xpath("//div[contains(@class,'danger')]");
    private final By myAccountText =By.xpath("//h2[text()='My Account']");

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public String getWarningMessageText(){
        return getText(warningMessage);
    }
    public void setEmailField(String email){
        sendKeys(emailField,email);
    }
    public void setPasswordField(String password){
        sendKeys(passwordField,password);
    }
    public void clickLoginButton(){
        click(loginButton);
    }
    public MyAccountPage confirmLogin(){
        click(loginButton);
        elementVisibilityExplicitWait(myAccountText,10);
        return new MyAccountPage(driver);
    }


}

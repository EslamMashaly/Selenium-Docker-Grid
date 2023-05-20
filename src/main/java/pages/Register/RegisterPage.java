package pages.Register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class RegisterPage extends BasePage {

    private WebDriver driver;
    private final By firstNameField =By.id("input-firstname");
    private final By lastNameField =By.id("input-lastname");
    private final By emailField =By.id("input-email");
    private final By phoneField =By.id("input-telephone");
    private final By passwordField =By.id("input-password");
    private final By passwordConfirmField =By.id("input-confirm");
    private final By checkBox=By.cssSelector("label[for='input-agree']");
    private final By continueButton=By.xpath("//input[@value='Continue']");
    private final By subscribeRadioButton=By.id("input-newsletter-no");
    private final By confirmCreationText=By.cssSelector(".page-title.my-3");
    private final By warningMessage=By.xpath("//div[contains(@class,'danger')]");
    private final By shortPasswordText=By.className("text-danger");

    public RegisterPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public void setFirstNameField(String fname){
        sendKeys(firstNameField,fname);
    }
    public void setLastNameField(String lname){
        sendKeys(lastNameField,lname);
    }
    public void setEmailField(String email){
        sendKeys(emailField,email);
    }
    public void setPhoneField(String number){
        sendKeys(phoneField,number);
    }
    public void setPasswordField(String pass){
        sendKeys(passwordField,pass);
    }
    public void setPasswordConfirmField(String confirm){
        sendKeys(passwordConfirmField,confirm);
    }
    public void agreePolicy(){
        click(checkBox);
    }

    public Boolean isSelected(){
        return driver.findElement(subscribeRadioButton).isSelected();
    }
    public void confirmRegistration(){
        click(continueButton);
        //WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(confirmCreationText)));
    }
    public String getAccountCreatedMessage(){
        return getText(confirmCreationText);
    }

    public String getWarningMessageText(){
        return getText(warningMessage);
    }

    public String getShortPasswordText(){
        return getText(shortPasswordText);
    }
}



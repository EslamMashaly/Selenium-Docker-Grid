package pages.myAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class MyAccountPage extends BasePage {
    private WebDriver driver;

    private final By myAccountText =By.xpath("//h2[text()='My Account']");

    public MyAccountPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public String getMyAccountText(){
       return getText(myAccountText);
    }
}

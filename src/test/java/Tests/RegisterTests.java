package Tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Register.RegisterPage;
import utils.BaseTests;


@Listeners(utils.listeners.Listeners.class)
public class RegisterTests extends BaseTests {


    RegisterPage registerPage;
    private final String email="4cdc715ae2e7@drmail.in";
    private final String password="8tReYbtx849Nirz";
    private final String phone="+201013564468";


    @Description("Already Registered Email Test case")
    @Test(priority = 1)
    public void alreadyRegisteredEmail() {
        registerPage=homePage.hoverToRegister();
        registerPage.setFirstNameField("Ali");
        registerPage.setLastNameField("Kamel");
        registerPage.setEmailField(email);
        registerPage.setPhoneField(phone);
        registerPage.setPasswordField(password);
        registerPage.setPasswordConfirmField(password);
        registerPage.agreePolicy();
        Assert.assertTrue(registerPage.isSelected());
        registerPage.confirmRegistration();
        Assert.assertEquals(registerPage.getWarningMessageText(),"Warning: E-Mail Address is already registered!");
    }

    @Description("Short Password Test case")
    @Test(priority = 2)
    public void enterShortPassword(){
        registerPage=homePage.hoverToRegister();
        registerPage.setFirstNameField("Ali");
        registerPage.setLastNameField("Kamel");
        registerPage.setEmailField(email);
        registerPage.setPhoneField(phone);
        registerPage.setPasswordField("123");
        registerPage.setPasswordConfirmField("123");
        registerPage.agreePolicy();
        Assert.assertTrue(registerPage.isSelected());
        registerPage.confirmRegistration();
        Assert.assertEquals(registerPage.getShortPasswordText(),"Password must be between 4 and 20 characters!");

    }

    @Description("Policy Agreement Test case")
    @Test(priority = 3)
    public void enterDataWithoutPolicyAgreement(){
        registerPage=homePage.hoverToRegister();
        registerPage.setFirstNameField("Ali");
        registerPage.setLastNameField("Kamel");
        registerPage.setEmailField(email);
        registerPage.setPhoneField(phone);
        registerPage.setPasswordField(password);
        registerPage.setPasswordConfirmField(password);
        Assert.assertTrue(registerPage.isSelected());
        registerPage.confirmRegistration();
        Assert.assertEquals(registerPage.getWarningMessageText(),"Warning: You must agree to the Privacy Policy!");
    }

    @Severity(value = SeverityLevel.CRITICAL)
    @Description("Valid Registration Test case")
    @Test(priority = 4,dataProvider = "ExcelData")
    public void testValidRegistration(String fname, String lname, String emailAddress, String phoneNum, String pass) {
        registerPage=homePage.hoverToRegister();
        registerPage.setFirstNameField(fname);
        registerPage.setLastNameField(lname);
        registerPage.setEmailField(emailAddress);
        registerPage.setPhoneField(phoneNum);
        registerPage.setPasswordField(pass);
        registerPage.setPasswordConfirmField(pass);
        registerPage.agreePolicy();
        Assert.assertTrue(registerPage.isSelected());
        registerPage.confirmRegistration();
        Assert.assertEquals(registerPage.getAccountCreatedMessage(),"Your Account Has Been Created!");

    }
}

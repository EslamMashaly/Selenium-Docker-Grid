package Tests;

import io.qameta.allure.Description;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Login.LoginPage;
import utils.BaseTests;
import utils.dataReaders.JsonDataReader;

import java.io.IOException;

@Listeners(utils.listeners.Listeners.class)
public class LoginTests extends BaseTests {
    LoginPage loginPage;

    @Description("Valid login")
    @Test(priority = 1)
    public void TestValidLoggingIn() throws IOException, ParseException {
        JsonDataReader jr =new JsonDataReader();
        jr.loginJsonReader();
        loginPage=homePage.hoverToLogin();
        loginPage.setEmailField(jr.loginEmail);
        loginPage.setPasswordField(jr.loginPassword);
        var myaccountPage =loginPage.confirmLogin();
        Assert.assertEquals(myaccountPage.getMyAccountText(),"My Account");

    }
    @Description("Invalid login test case")
    @Test(priority = 2)
    public void TestInValidLoggingIn() {
        loginPage=homePage.hoverToLogin();
        loginPage.setEmailField("6b0367d2946f@drmail.in");
        loginPage.setPasswordField("8tReYbtx849Nirz");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getWarningMessageText(),"Warning: No match for E-Mail Address and/or Password.");

    }
}

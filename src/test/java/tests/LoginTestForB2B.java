package tests;

import Utils.ConfigReader;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPageForB2b;
import pages.storeNameSelectionPageForB2b;

public class LoginTestForB2B extends BaseTest {

    @Test
    public void verifyLoginForB2B(){
        getDriver().get(ConfigReader.getProperty("b2bUrl"));
        LoginPageForB2b loginPageForB2b = new LoginPageForB2b(getDriver());
        storeNameSelectionPageForB2b storeNamePage = loginPageForB2b.login(ConfigReader.getProperty("usernameforB2B"), ConfigReader.getProperty("passwordforB2B"));
        Assert.assertTrue(storeNamePage.storeNameisSelected(), "Login successful for B2B");
    }

}

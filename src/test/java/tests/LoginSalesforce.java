package tests;

import Utils.ConfigReader;
import base.BaseTest;
import org.testng.annotations.Test;
import pages.SalesForceLoginWithValidCredentials;

public class LoginSalesforce extends BaseTest {
    @Test
    public void loginTestSF(){
        getDriver().get(ConfigReader.getProperty("salesforceURL"));
        SalesForceLoginWithValidCredentials sf = new SalesForceLoginWithValidCredentials(getDriver());
        sf.enteringUsername(ConfigReader.getProperty("sfUsername"));
        sf.enteringPassword(ConfigReader.getProperty("sfPassword"));
        sf.clickingLoginButton();

    }
}

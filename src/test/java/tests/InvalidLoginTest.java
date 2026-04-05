package tests;

import Utils.ConfigReader;
import Utils.ExtentReportManager;
import base.BaseTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InvalidLogin;
import pages.OrangeHrmLogin;

public class InvalidLoginTest extends BaseTest {
    @Test
    public void invalidloginTestforHRM(){
        getDriver().get(ConfigReader.getProperty("orangehrmURL"));
        InvalidLogin invalidLogin = new InvalidLogin(getDriver());
        invalidLogin.invalidUsernameEnter(ConfigReader.getProperty("invalidUsername"));
        invalidLogin.invalidPasswordEnter(ConfigReader.getProperty("invalidPassword"));
        invalidLogin.loginClick();
        invalidLogin.validateInvalid();
    }
}

package tests;

import Utils.ConfigReader;
import Utils.ExtentReportManager;
import base.BaseTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrangeHrmLogin;

public class OrangeHrmLoginTest extends BaseTest {
    @Test
    public void loginTestforHRM(){
        getDriver().get(ConfigReader.getProperty("orangehrmURL"));
        OrangeHrmLogin orangeHrmLogin = new OrangeHrmLogin(getDriver());
        orangeHrmLogin.usernameEnter(ConfigReader.getProperty("orangehrmUsername"));
        orangeHrmLogin.passwordEnter(ConfigReader.getProperty("orangehrmPassword"));
        orangeHrmLogin.loginClick();
        Assert.assertTrue(orangeHrmLogin.isDashBoardVisible(),"Dashboard is visible");
        ExtentReportManager.getTest().log(Status.PASS, "User logged in successfully");

    }
}

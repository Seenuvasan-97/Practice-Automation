package tests;

import Utils.ConfigReader;
import base.BaseTest;
import org.testng.annotations.Test;
import pages.UATLoginPage;

import java.awt.*;

public class UATLoginTest extends BaseTest {

    @Test
    private void LoginTestforUAT() throws AWTException {
        getDriver().get(ConfigReader.getProperty("UATUrl"));
        UATLoginPage uatLoginPage = new UATLoginPage(getDriver());
        uatLoginPage.usernameEnter(ConfigReader.getProperty("carerepUsername"));
        uatLoginPage.passwordEnter(ConfigReader.getProperty("carerepPassword"));
        uatLoginPage.navigateBack();

    }
}

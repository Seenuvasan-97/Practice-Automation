package tests;

import Utils.ConfigReader;
import base.BaseTest;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

public class BypassLogin extends BaseTest {
    @Test
    public void byPassLoginSF(){
        getDriver().get(ConfigReader.getProperty("https://cwc--uatsfdc.sandbox.lightning.force.com/"));

    }
}

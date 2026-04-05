package tests;

import Utils.ConfigReader;
import base.BaseTest;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

public class BypassLogin extends BaseTest {
    @Test
    public void byPassLoginSF(){
        getDriver().get(ConfigReader.getProperty("https://cwc--uatsfdc.sandbox.lightning.force.com/"));
        // Add cookie
        Cookie cookie = new Cookie("sid", "00D7d000008qWKM!AQEAQITaLG8uVywFlhKw6Pve8avca5fmpGtgErYQkf7vfOWceVKOkki_GVLwxBxrBQnJjXGaRkzbx53r3D1rsh9bGZ1LGHiI");
        getDriver().manage().addCookie(cookie);

// Refresh to apply session
        getDriver().navigate().refresh();
    }
}

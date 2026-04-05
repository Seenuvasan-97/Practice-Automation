package pages;

import Utils.ScreenshotUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class InvalidLogin extends OrangeHrmLogin {

    By usernameLocator = By.xpath("//input[@name='username']");
    By passwordLocator = By.xpath("//input[@name='password']");
    By loginButton = By.xpath("//button[text()=' Login ']");
    By invalidCredentialsPopup = By.xpath("//p[text()='Invalid credentials']");

    public InvalidLogin(WebDriver driver) {
        super(driver);
    }

    public void invalidUsernameEnter(String user){
        logger.info("Entering invalid username: {}", user);
        driver.findElement(usernameLocator).sendKeys(user);
    }
    public void invalidPasswordEnter(String pass){
        logger.info("Entering invalid password");
        driver.findElement(passwordLocator).sendKeys(pass);
    }
    public void loginClick(){
        logger.info("Clicking on login button");
        ScreenshotUtil.captureScreenshot(driver,"Invalid login test", "Login page after entering username");
        driver.findElement(loginButton).click();
    }
    public boolean validateInvalid(){
        WebElement we = driver.findElement(invalidCredentialsPopup);
        Assert.assertTrue(we.isDisplayed(),"Invalid pop-up displayed");
        return true;
    }
}

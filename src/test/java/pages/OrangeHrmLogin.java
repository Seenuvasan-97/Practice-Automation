package pages;

import Utils.ScreenshotUtil;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class OrangeHrmLogin {
    protected WebDriver driver;
    protected static final Logger logger = LoggerFactory.getLogger(OrangeHrmLogin.class);

    By usernameLocator = By.xpath("//input[@name='username']");
    By passwordLocator = By.xpath("//input[@name='password']");
    By loginButton = By.xpath("//button[text()=' Login ']");
    By dashBoard = By.xpath("//h6[text()='Dashboard']");


    public OrangeHrmLogin(WebDriver driver){

        this.driver=driver;
    }
    public void usernameEnter(String user){
        logger.info("Entering username: {}", user);
        driver.findElement(usernameLocator).sendKeys(user);
    }
    public void passwordEnter(String pass){
        logger.info("Entering password");
        driver.findElement(passwordLocator).sendKeys(pass);
    }
    public void loginClick(){
        logger.info("Clicking on login button");
        ScreenshotUtil.captureScreenshot(driver,"login test", "Login page after entering username");
        driver.findElement(loginButton).click();
    }
    public boolean isDashBoardVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement waitedDashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(dashBoard));
            logger.info("Waiting for dashboard to be visible");
            ScreenshotUtil.captureScreenshot(driver,"login test", "After login");
            return waitedDashboard.isDisplayed();
        }
        catch (NoSuchElementException e) {
            System.out.println("Dashboard element not found");
            return false;
        }



    }
}

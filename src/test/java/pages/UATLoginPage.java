package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

public class UATLoginPage {
    private WebDriver driver;

    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By loginButton = By.id("Login");

    public UATLoginPage(WebDriver driver){
        this.driver=driver;
    }
    public void usernameEnter(String carerepUsername){
        driver.findElement(usernameField).sendKeys(carerepUsername);
    }
    public void passwordEnter(String carerepPassword){
        driver.findElement(passwordField).sendKeys(carerepPassword);
    }
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
    public void navigateBack() throws AWTException {
        driver.navigate().back();
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement until = w.until(ExpectedConditions.visibilityOfElementLocated(By.id("forgot_password_link")));
        Actions actions = new Actions(driver);
        actions.contextClick(until).perform();
        Robot robot = new Robot();
        for (int i = 0; i <1; i++) {
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        String s = driver.getWindowHandle();
        Set<String> set = driver.getWindowHandles();
        for(String X:set){
            if (!s.equals(set)) {
                driver.switchTo().window(X);
            }
        }
        driver.findElement(By.id("un")).sendKeys("Seenu");



    }


}

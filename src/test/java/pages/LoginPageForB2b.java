package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageForB2b {
    private WebDriver driver;

    By usernameLocator = By.cssSelector("#username");
    By passwordLocator = By.xpath("//input[@name='password']");
    By loginButtonLocator = By.id("btnSubmit");

    public LoginPageForB2b(WebDriver driver){
        this.driver = driver;
    }

    public void enteringUsername(String usernameforB2B){
        driver.findElement(usernameLocator).sendKeys(usernameforB2B);
    }
    public void enteringPassword(String passwordforB2B){
        driver.findElement(passwordLocator).sendKeys(passwordforB2B);
    }
    public void clickLoginButton(){
        driver.findElement(loginButtonLocator).click();
    }
    public storeNameSelectionPageForB2b login(String username, String password){
        enteringUsername(username);
        enteringPassword(password);
        clickLoginButton();
        return new storeNameSelectionPageForB2b(driver);
    }




}

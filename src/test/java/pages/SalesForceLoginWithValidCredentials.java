package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SalesForceLoginWithValidCredentials {
    WebDriver driver;
    private By userName = By.xpath("//input[@id='username']");
    private By passWord = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//input[@id='Login']");

    public SalesForceLoginWithValidCredentials(WebDriver driver){
        this.driver=driver;
    }
    public void enteringUsername(String useR){
        driver.findElement(userName).sendKeys(useR);
    }
    public void enteringPassword(String pasS){
        driver.findElement(passWord).sendKeys(pasS);
    }
    public void clickingLoginButton(){
        driver.findElement(loginButton).click();
    }
}

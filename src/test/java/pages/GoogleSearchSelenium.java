package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchSelenium {
    private WebDriver driver;

    By googleSearch = By.xpath("//textarea[@class='gLFyf']");
    By searchButton = By.xpath("(//input[@class='gNO89b'])[2]");

    public GoogleSearchSelenium(WebDriver driver){
        this.driver=driver;
    }

    public void searchboxEnter(String username){
        driver.findElement(googleSearch).sendKeys(username);
    }
    public void clickSearch(){
        driver.findElement(searchButton).click();
    }

}

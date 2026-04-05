package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddEmployeeSucessPage extends OrangeHrmLogin{
    By confirmPD = By.xpath("//h6[text()='Personal Details']");

    public AddEmployeeSucessPage(WebDriver driver) {

        super(driver);
    }
    public boolean validateSuccessPage(){
        logger.info("validating adding employee");
        WebElement validate = driver.findElement(confirmPD);
        return validate.isDisplayed();


    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddNewEmployee extends OrangeHrmLogin {

    By pimButton = By.xpath("//span[text()='PIM']");
    By addButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    By firstNameField = By.cssSelector("[name='firstName']");
    By middleNameField = By.cssSelector("[name='middleName']");
    By lastNameField = By.cssSelector("[name='lastName']");
    By saveButton = By.xpath("(//button[@type='submit'])[1]");
    By verifyPersonalDetails= By.xpath("//h6[text()='Personal Details']");

    public AddNewEmployee(WebDriver driver){
        super(driver);
    }

    public void clickPimButton(){
        logger.info("Clicking PIM");
        driver.findElement(pimButton).click();
    }
    public void clickAddButton(){
        logger.info("Clicking Add button");
        driver.findElement(addButton).click();
    }
    public void enterFirstName(String firstname){
        logger.info("Entering first name: {}", firstname);
        driver.findElement(firstNameField).sendKeys(firstname);
    }
    public void enterMiddleName(String middleName){
        logger.info("Entering middle name: {}",middleName);
        driver.findElement(middleNameField).sendKeys(middleName);
    }
    public void enterLastName(String lastname){
        logger.info("Entering last name: {}",lastname);
        driver.findElement(lastNameField).sendKeys(lastname);
    }
    public void clickSaveButton(){
        logger.info("Clicking Save Button");
        driver.findElement(saveButton).click();
    }
    public void performingAddLine(String firstname, String middleName, String lastname){
        clickPimButton();
        clickAddButton();
        enterFirstName(firstname);
        enterMiddleName(middleName);
        enterLastName(lastname);
        clickSaveButton();
    }




}

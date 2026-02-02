package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class storeNameSelectionPageForB2b {
    private WebDriver driver;
    By storeNameDropdownLocator = By.xpath("(//div[@class = 'dropdown__header'])[1]");

    public storeNameSelectionPageForB2b(WebDriver driver){

        this.driver=driver;
    }
    public boolean storeNameisSelected(){
        return driver.findElement(storeNameDropdownLocator).isSelected();
    }

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestingDataprovider {
    @DataProvider(name = "different url")
    public Object[][] getData(){
        return new Object[][]{
                {"https://www.google.com/"},{"https://admintools.current.stage.ariasystems.net/"},{"https://support-sso.b2bsoft.com/account/login"}
        };
    }
    @Test(dataProvider = "different url")
    private void diffURL(String urlDiff){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(urlDiff);
    }
}

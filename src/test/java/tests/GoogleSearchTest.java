package tests;

import Utils.ConfigReader;
import base.BaseTest;
import org.testng.annotations.Test;
import pages.GoogleSearchSelenium;

public class GoogleSearchTest extends BaseTest {
    @Test
    public void googleTest(){
        getDriver().get(ConfigReader.getProperty("googleUrl"));
        GoogleSearchSelenium googleSearchSelenium = new GoogleSearchSelenium(getDriver());
        googleSearchSelenium.searchboxEnter("googleSearchField");
        googleSearchSelenium.clickSearch();
    }
}

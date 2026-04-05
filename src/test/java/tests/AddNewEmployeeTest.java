package tests;

import Utils.ConfigReader;
import Utils.ExtentReportManager;
import base.BaseTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AddEmployeeSucessPage;
import pages.AddNewEmployee;
import pages.OrangeHrmLogin;

public class AddNewEmployeeTest extends BaseTest {
    @Test()
    public void employeeAdd(){
        ExtentReportManager.getTest().log(Status.INFO,"Adding Employee begins");
        getDriver().get(ConfigReader.getProperty("orangehrmURL"));
        OrangeHrmLogin orangeHrmLogin = new OrangeHrmLogin(getDriver());
        orangeHrmLogin.usernameEnter(ConfigReader.getProperty("orangehrmUsername"));
        orangeHrmLogin.passwordEnter(ConfigReader.getProperty("orangehrmPassword"));
        orangeHrmLogin.loginClick();
        AddNewEmployee addNewEmployee=new AddNewEmployee(getDriver());
        addNewEmployee.performingAddLine(ConfigReader.getProperty("firstname"), ConfigReader.getProperty("middlename"), ConfigReader.getProperty("lastname"));
        AddEmployeeSucessPage addEmployeeSucessPage = new AddEmployeeSucessPage(getDriver());
        addEmployeeSucessPage.validateSuccessPage();
        Assert.assertTrue(addEmployeeSucessPage.validateSuccessPage(), "validation failed");
        ExtentReportManager.getTest().log(Status.INFO, "Employee details added successfully");


    }
}

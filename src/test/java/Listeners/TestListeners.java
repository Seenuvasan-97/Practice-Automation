package Listeners;

import Utils.ExtentManager;
import Utils.ScreenshotUtil;
import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {
    private static ExtentReports extentReports = ExtentManager.getExtentReports();
    private static ThreadLocal<ExtentTest>test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extentReports.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass("Test Passed");
        String screenshotPath = ScreenshotUtil.captureScreenshot(
                BaseTest.getDriver(),
                result.getMethod().getMethodName()
        );

        try {
            test.get().addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().fail(result.getThrowable());

        String screenshotPath = ScreenshotUtil.captureScreenshot(
                BaseTest.getDriver(),
                result.getMethod().getMethodName()
        );

        try {
            test.get().addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        extentReports.flush();
    }
}





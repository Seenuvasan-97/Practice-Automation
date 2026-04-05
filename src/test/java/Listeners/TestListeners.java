package Listeners;

import Utils.ExtentReportManager;
import Utils.ScreenshotUtil;
import base.BaseTest;
import com.aventstack.extentreports.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {

    private static final Logger logger =
            LoggerFactory.getLogger(TestListeners.class);

    // 🔹 Suite start
    @Override
    public void onStart(ITestContext context) {
        logger.info("========================================");
        logger.info("Test Suite Started: {}", context.getName());
        logger.info("========================================");

        // ✅ Initialize Extent report once
        ExtentReportManager.initReports();
    }

    // 🔹 Test start
    @Override
    public void onTestStart(ITestResult result) {
        logger.info("----------------------------------------");
        logger.info("Test Started: {}", result.getMethod().getMethodName());
        logger.info("Description: {}", result.getMethod().getDescription());
        logger.info("----------------------------------------");

        // ✅ Create Extent test
        ExtentReportManager.createTest(
                result.getMethod().getMethodName()
        );

        ExtentReportManager.getTest()
                .log(Status.INFO, "Test execution started");
    }

    // 🔹 Test success
    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("✓ Test PASSED: {} (Duration: {}ms)",
                result.getMethod().getMethodName(),
                result.getEndMillis() - result.getStartMillis());

        ExtentReportManager.getTest()
                .log(Status.PASS, "Test passed successfully");
    }

    // 🔹 Test failure
    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("✗ Test FAILED: {} (Duration: {}ms)",
                result.getMethod().getMethodName(),
                result.getEndMillis() - result.getStartMillis());

        logger.error("Failure Reason:", result.getThrowable());

        // 🔴 Log failure in Extent
        ExtentReportManager.getTest()
                .log(Status.FAIL, result.getThrowable());

        // 📸 Capture screenshot (UI tests only)
        try {
            String screenshotPath =
                    ScreenshotUtil.captureScreenshot(
                            BaseTest.getDriver(),
                            result.getMethod().getMethodName(),"Failure"
                    );

            ExtentReportManager.getTest()
                    .addScreenCaptureFromPath(screenshotPath);

        } catch (Exception e) {
            logger.error("Failed to capture screenshot", e);
        }
    }

    // 🔹 Test skipped
    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("⊘ Test SKIPPED: {}",
                result.getMethod().getMethodName());

        ExtentReportManager.getTest()
                .log(Status.SKIP,
                        result.getThrowable() != null
                                ? result.getThrowable().getMessage()
                                : "Test skipped");
    }

    // 🔹 Suite finish
    @Override
    public void onFinish(ITestContext context) {
        logger.info("========================================");
        logger.info("Test Suite Finished: {}", context.getName());
        logger.info("Total Tests Run: {}", context.getAllTestMethods().length);
        logger.info("Tests Passed: {}", context.getPassedTests().size());
        logger.info("Tests Failed: {}", context.getFailedTests().size());
        logger.info("Tests Skipped: {}", context.getSkippedTests().size());
        logger.info("========================================");

        // ✅ Flush Extent report
        ExtentReportManager.flushReports();
    }
}
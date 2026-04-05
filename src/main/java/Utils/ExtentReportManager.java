package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    private static String reportPath;

    public static synchronized void initReports() {
        if (extent == null) {

            String basePath = ConfigReader.getReportPath();

            // 🔥 ABSOLUTE SAFETY CHECK
            if (basePath == null || basePath.trim().isEmpty()) {
                basePath = System.getProperty("user.dir")
                        + File.separator + "reports" + File.separator;
            }

            String timestamp =
                    new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss")
                            .format(new Date());

            String reportFileName = "TestReport_" + timestamp + ".html";
            reportPath = basePath + reportFileName;

            File reportDir = new File(basePath);
            if (!reportDir.exists()) {
                reportDir.mkdirs();
            }

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(reportPath);

            sparkReporter.config().setReportName("OrangeHRM Automation Test Report");
            sparkReporter.config().setDocumentTitle("Test Execution Report");
            sparkReporter.config().setTheme(Theme.STANDARD);
            sparkReporter.config().setTimeStampFormat("yyyy-MM-dd HH:mm:ss");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Application", "Test Application");
            extent.setSystemInfo("Browser", ConfigReader.getBrowser());
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("User", System.getProperty("user.name"));
            extent.setSystemInfo("Java", System.getProperty("java.version"));
            extent.setSystemInfo("Environment", "QA");
        }
    }

    public static void createTest(String testName) {
        ExtentTest test = extent.createTest(testName);
        extentTest.set(test);
    }

    public static ExtentTest getTest() {

        return extentTest.get();
    }

    public static void flushReports() {
        if (extent != null) {
            extent.flush();
            System.out.println("Extent Report generated at: " + reportPath);
        }
        extentTest.remove();
    }
}

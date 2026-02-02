package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {
    private static ExtentReports extentReports;

    public static ExtentReports getExtentReports(){
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportPath = System.getProperty("user.dir")+"/reports/automation reports"+"_"+timeStamp+".html";
        if (extentReports == null) {

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setReportName("Automation tests report");
            sparkReporter.config().setDocumentTitle("Tests result");
            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);
            extentReports.setSystemInfo("Project", "B2B");
            extentReports.setSystemInfo("Tester", "Seenuvasan saravanan");

        }
return extentReports;

    }

}

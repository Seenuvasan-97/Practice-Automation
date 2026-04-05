package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;

    static {
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/data/testdata.properties");
            prop = new Properties();
            prop.load(fis);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties data file");
        }
    }
    public static String getProperty(String Key){
        return prop.getProperty(Key);

    }
    public static String getBrowser() {

        return System.getProperty("browser", getProperty("browser"));
    }
    public static String getReportPath() {

        return getProperty("report.path");
    }
}



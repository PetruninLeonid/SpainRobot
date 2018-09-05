package run;


import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ExtentReportManager {
    private static ExtentReports extent = getInstance();

    public static synchronized ExtentReports getInstance() {
        if (extent == null) {
            Map sysInfo = new HashMap();
            sysInfo.put("Start Time", new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));

            extent = new ExtentReports(System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "ExtentReport.html", true);
            extent.config().reportName("UI Automation Report").reportHeadline("[" + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()).toString() + "]");
            extent.addSystemInfo(sysInfo);
        }
        return extent;
    }
}

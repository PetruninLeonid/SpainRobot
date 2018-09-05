package run;

import com.relevantcodes.extentreports.ExtentTest;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class StaticDataProvider {
    public static String FIRST_RUN_REPORT_DIRECTORY = "";

    public static class RunTime {

        public static ExtentTest TEST;

    }

    public static class Timeouts {

        public static final long WAITING_TIME = 1000;

        public static final long _1_SECOND_TIMEOUT = 1000;

        public static final long _2_SECONDS_TIMEOUT = 2000;

        public static final long _3_SECONDS_TIMEOUT = 3000;

        public static final long _4_SECONDS_TIMEOUT = 4000;

        public static final long _5_SECONDS_TIMEOUT = 5000;

        public static final long _6_SECONDS_TIMEOUT = 6000;

        public static final long _7_SECONDS_TIMEOUT = 7000;

        public static final long _10_SECONDS_TIMEOUT = 10000;

        public static final long _15_SECONDS_TIMEOUT = 15000;

        public static final long _17_SECONDS_TIMEOUT = 15000;

        public static final long _20_SECONDS_TIMEOUT = 20000;

        public static final long IMPLICITLY_WAIT = 30;

        public static final long _30_SECONDS_TIMEOUT = 30000;

        public static final long _35_SECONDS_TIMEOUT = 35000;

        public static final long _60_SECONDS_TIMEOUT = 60000;

        public static final long _45_SECONDS_TIMEOUT = 45000;

        public static final long _90_SECONDS_TIMEOUT = 90000;

        public static final long _50_MILISEC_TIMEOUT = 50;

        public static final long _200_MILISEC_TIMEOUT = 200;

        public static final long _300_MILISEC_TIMEOUT = 300;

        public static final long _500_MILISEC_TIMEOUT = 500;

        public static final long _3500_MILISEC_TIMEOUT = 3500;

        public static final long _35_MILISEC_TIMEOUT = 35;
    }
}

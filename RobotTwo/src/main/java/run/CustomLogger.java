package run;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Reporter;

public class CustomLogger {
    private static Logger logger = Logger.getLogger("");

    public static synchronized Logger getInstance() {
        if (logger == null) logger = Logger.getLogger("");
        return logger;
    }

    public static void debug(String msg){
        //Parse message:
        String logMessage = String.valueOf(Thread.currentThread().getId()) + " " + parseArguments(msg);

        //Console log:
        logger.info(logMessage);

        //HTML Report log:
        Reporter.log(logMessage + " .<br/>");

        //Extent Report log:
        if(null != StaticDataProvider.RunTime.TEST) {
            StaticDataProvider.RunTime.TEST.log(LogStatus.INFO, logMessage);
            ExtentReportManager.getInstance().flush();
        }
    }

    public static void log(LogStatus logStatus, CharSequence... msg){
        //Parse message:
        String logMessage = String.valueOf(Thread.currentThread().getId()) + " " + parseArguments(msg);

        //Console log:
        if(logStatus.equals(LogStatus.ERROR)) {
            logger.error(logMessage);
        }else {
            logger.info(logMessage);
        }

        //HTML Report log:
        Reporter.log(logMessage + " .<br/>");

        //Extent Report log:
        if(null != StaticDataProvider.RunTime.TEST) {
            StaticDataProvider.RunTime.TEST.log(logStatus, "<pre>" + logMessage + "</pre>");
            ExtentReportManager.getInstance().flush();
        }
    }

    /** Function parses given arguments and converts special chars to readable one,
     * for example "SHIFT KEY" or "ENTER KEY". **/
    public static String parseArguments(Object ...args) {
        String lst = "";
        for (Object arg : args) {
            if (arg instanceof CharSequence) {
                StringBuilder sb = new StringBuilder(((CharSequence) arg).length());
                sb.append(arg);
                lst = sb.toString();
            } else if (arg instanceof CharSequence[]) {
                CharSequence[] s = (CharSequence[]) arg;
                String parameter = "";
                for (CharSequence charSequence : s) {
                    String tempString = charSequence.toString();
                    if (!isAscii(tempString)) {
                        for (int j = 0; j < tempString.length(); j++) {
                            String tempChar = String.valueOf(tempString.charAt(j));
                            tempChar = escapeNonAscii(tempChar);
                            // tempChar = keyInterpretation(tempChar);
                            // tempChar = (keyMap.get(tempChar) != null) ? keyMap.get(tempChar) : tempChar;
                            if (j == tempString.length() - 1) parameter = parameter + tempChar;
                            else parameter = parameter + tempChar + " + ";
                        }
                        lst=parameter;
                    } else lst=tempString;
                }
            } else
                lst=arg.toString();
        }
        return lst;
    }

    /** Function checks if given string in ASCII format. **/
    public static boolean isAscii(String s) {
        int length = s.length();
        for (int i = 0; i < length; i++) {
            final char c = s.charAt(i);
            if (c > 'z') {
                return false;
            }
        }
        return true;
    }

    /** Function escapes the non ascii encoding. **/
    public static String escapeNonAscii(String str) {
        StringBuilder retStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int cp = Character.codePointAt(str, i);
            int charCount = Character.charCount(cp);
            if (charCount > 1) {
                i += charCount - 1; // 2.
                if (i >= str.length()) {
                    throw new IllegalArgumentException("truncated unexpectedly");
                }
            }
            if (cp < 128) {
                retStr.appendCodePoint(cp);
            } else {
                retStr.append(String.format("\\u%x", cp));
            }
        }
        return retStr.toString();
    }

}

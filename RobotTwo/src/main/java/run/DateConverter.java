package run;

public class DateConverter {
    public static String converter(String[] date){
        String dd = (date[0]+date[1]);
        String yyyy = "20"+(date[7]+date[8]);
        String monthString = date[3]+date[4]+date[5];
        String month = null;
        if ("Jan".equals(monthString)) {
            month = "01";
        } else if ("Feb".equals(monthString)) {
            month = "02";
        } else if ("Mar".equals(monthString)) {
            month = "03";
        } else if ("Apr".equals(monthString)) {
            month = "04";
        } else if ("May".equals(monthString)) {
            month = "05";
        } else if ("Jun".equals(monthString)) {
            month = "06";
        } else if ("Jul".equals(monthString)) {
            month = "07";
        } else if ("Aug".equals(monthString)) {
            month = "08";
        } else if ("Sep".equals(monthString)) {
            month = "09";
        } else if ("Oct".equals(monthString)) {
            month = "10";
        } else if ("Nov".equals(monthString)) {
            month = "11";
        } else if ("Dec".equals(monthString)) {
            month = "12";
        }

        String intDate = dd+month+yyyy;
        return intDate;
    }
}

package run;

public class CountryChecker {
    public static String getCountry(String country){
        if(country.equals("Germany")){
            return "DE";
        }else if (country.equals("Austria")){
            return "AT";
        }else if (country.equals("Belgium")){
            return "BE";
        }else if (country.equals("Bulgaria")){
            return "BG";
        }else if (country.equals("Czech Republic")){
            return "CZ";
        }else if (country.equals("Cyprus")){
            return "CY";
        }else if (country.equals("Croatia")){
            return "HR";
        }else if (country.equals("Denmark")){
            return "DK";
        }else if (country.equals("Slovakia")){
            return "SK";
        }else if (country.equals("Slovenia")){
            return "SI";
        }else if (country.equals("Spain")){
            return "ES";
        }else if (country.equals("Estonia")){
            return "EE";
        }else if (country.equals("Finland")){
            return "FI";
        }else if (country.equals("France")){
            return "FR";
        }else if (country.equals("Greece")){
            return "EL";
        }else if (country.equals("Hungary")){
            return "HU";
        }else if (country.equals("Ireland")){
            return "IE";
        }else if (country.equals("Italy")){
            return "IT";
        }else if (country.equals("Latvia")){
            return "LV";
        }else if (country.equals("Lithuania")){
            return "LT";
        }else if (country.equals("Luxembourg")){
            return "LU";
        }else if (country.equals("Malta")){
            return "MT";
        }else if (country.equals("Netherlands")){
            return "NL";
        }else if (country.equals("Poland")){
            return "PL";
        }else if (country.equals("Portugal")){
            return "PT";
        }else if (country.equals("United Kingdom")){
            return "GB";
        }else if (country.equals("Romania")){
            return "RO";
        }else if (country.equals("Sweden")){
            return "SE";
        } else {
            System.out.println("Country wasn't detected!");
            return null;
        }
    }
}

package run;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CodigoChecker {
    public static String checker(String scvElement){
        String euSubCode = scvElement.replaceAll("\u0000", "");
       if (euSubCode.equals("1")){
           return "1.        ";
       } else if (euSubCode.equals("2")){
           return "2.        ";
       }else if (euSubCode.equals("3")) {
           return "3.        ";
       }else if (euSubCode.equals("4")) {
           return "4.        ";
       }else if (euSubCode.equals("5")) {
           return "5.        ";
       }else if (euSubCode.equals("6")) {
           return "6.        ";
       }else if (euSubCode.equals("7")) {
           return "7.        ";
       }else if (euSubCode.equals("8")) {
           return "8.        ";
       }else if (euSubCode.equals("9")) {
           return "9.        ";
       }else if (euSubCode.equals("10")) {
           return "10.       ";
       }else {
           return euSubCode;
       }

    }

}

package run;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parsers {
    public static String textFileParse(String fileName) throws IOException {
        String data = FileUtils.readFileToString(new File(fileName), "UTF-8");
        return data;
    }

    public static List<List<String>> readTXTFile(String fileAdress) throws IOException {
        String csvFileName = fileAdress;
        String line = null;
        BufferedReader stream = null;
        List<List<String>> csvData = new ArrayList<List<String>>();

        try {
            stream = new BufferedReader(new FileReader(csvFileName));
            while ((line = stream.readLine()) != null) {
                String[] splitted = line.split("\n");
                List<String> dataLine = new ArrayList<String>(splitted.length);
                for (String data : splitted) {
                    dataLine.add(data);
                }
                if ((dataLine.get(0).length())<(2)){
                } else {
                    csvData.add(dataLine);
                }
            }
        } finally {
            if (stream != null)
                stream.close();
        }

        return csvData.subList(1, csvData.size());
    }

    public static String[] splitNumber(String number){
       return number.replaceAll("\u0000", "").split("\\.");
    }

    public static double getProrata(String claimVat, String vatPaid){
        double x = Double.parseDouble(claimVat.replaceAll("\u0000",""));
        double y = Double.parseDouble(vatPaid.replaceAll("\u0000",""));
        double z = x/y*100;
        return z;
    }
}

package run;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Runner {

    //First page xpathes
    private static final String COUNTRY_FIELD = "//*[@id='PAI']/descendant::option[@value='%1$s']";
    private static final String YEAR_FIELD = "//*[@id='EJF']";
    private static final String VAT_ID = "//*[@id='NIF']";
    private static final String LEGAL_NAME = "//*[@id='APE']";
    private static final String CHECK_BOX = "//*[@id='AMB_1']";
    private static final String OPEN_PERIOD_CHECKBOX_POINT = "//*[@id='CAS']";
    private static final String START_DATE_FIELD = "//*[@id='FEI']";
    private static final String END_DATE_FIELD = "//*[@id='FEF']";
    private static final String SUBMIT_BUTTON = "//*[@id='enviar']";
    private static final String SECOND_PAGE_VALIRATOR = "//*[@id='P010']";

    //Second page xpathes
    private static final String FIRST_EMAIL = "//*[@id='A010228']";
    private static final String FIRST_TEL = "//*[@id='A010229']";
    private static final String ACTIVIDADES_FIRST_LINE = "#enlaceNACE1 > span";
    private static final String SECOND_EMAIL = "//*[@id='A010328']";
    private static final String SECOND_TEL = "//*[@id='A010329']";
    private static final String TIPO_DE_VIA = "//*[@id='S010303']/descendant::*[@value='CALLE']";
    private static final String COMPLEMENTO_DOMICILO = "//*[@id='A010313']";
    private static final String DECLARATION_DEL_SOLICITANTE = "//*[@id='C010408']";
    private static final String ACCOUNT_HOLDER_NAME = "//*[@id='A010601']";
    private static final String A_R = "//*[@id='S010602']/descendant::option[@value='%1$s']";
    private static final String BANK_NUMBER = "//*[@id='A010603']";
    private static final String BIC_BANK = "//*[@id='A010604']";
    private static final String CURRENCY = "//*[@id='S010605']/descendant::option[@value='%1$s']";
    private static final String PAGE_TWO_BUTTON = "//*[@id='pagina2']";
    private static final String THIRD_PAGE_VALIDATION = "//*[@id='capaCampos020']";

    //Third page xpathes
    //First invoice
    private static final String TYPE = "//*[@id='S020%2$s03%3$s']/descendant::option[@value='%1$s']";
    private static final String INVOICE_NUMBER = "//*[@id='A020%1$s04%2$s']";
    private static final String INVOICE_DATE = "//*[@id='A020%1$s05%2$s']";
    private static final String INVOICE_AMOUNT_EXCLUDING_VAT_1 = "//*[@id='A020%1$s30%2$s']";
    private static final String INVOICE_AMOUNT_EXCLUDING_VAT_2 = "//*[@id='D020%1$s30%2$s']";
    private static final String VAT_PAID_1 = "//*[@id='A020%1$s31%2$s']";
    private static final String VAT_PAID_2 = "//*[@id='D020%1$s31%2$s']";
    private static final String PRORATA_1 = "//*[@id='A020%1$s32%2$s']";
    private static final String PRORATA_2 = "//*[@id='D020%1$s32%2$s']";
    private static final String IMPORTE_SOLICITADO_1 = "//*[@id='A020%1$s33%2$s']";
    private static final String IMPORTE_SOLICITADO_2 = "//*[@id='D020%1$s33%2$s']";
    private static final String CODIGO = "//*[@id='S020%2$s1A%3$s']/descendant::option[contains(text(),'%1$s')]";
    private static final String OTROS = "//*[@id='A020%1$s1C%2$s']";
    private static final String IS_SIMPLIFIED_1 = "//*[@id='C020%1$s35%2$s']";
    private static final String PAIS_EMISOR_1 = "//*[@id='S020%2$s42%3$s']/descendant::option[@value='%1$s']";
    private static final String NVAT_1 = "//*[@id='A020%1$s36%2$s']";
    private static final String PAIS_EMISOR_DE_LA_REFERENCIA_1 = "//*[@id='S020%2$s43%3$s']/descendant::option[@value='%1$s']";
    private static final String REFERENCIAL_FISCAL_1 = "//*[@id='A020%1$s37%2$s']";
    private static final String APELLIDOS_Y_NOMBRE_1 = "//*[@id='A020%1$s38%2$s']";
    private static final String DIRECCTION_1 = "//*[@id='A020%1$s39%2$s']";
    private static final String LAST_PAIS_1 = "//*[@id='S020%2$s41%3$s']/descendant::option[@value='%1$s']";

    private static final String GUARDAR = "//*[@id='guardar']";
    private static final String NEXT_PAGE_BUTTON = "//*[@id=\"capaPaginaAdicional020\"]/table/tbody/tr/td[10]/strong/a";

    //Second invoice


    public static void main(String[] args) throws IOException {
        String username = System.getProperty("user.name");
        List csvData = Parsers.readTXTFile("C:\\Users\\"+username+"\\Desktop\\SpainRobot\\1.csv");
        int invoicesSize = csvData.size();
        String[] data1 = Parsers.textFileParse("C:\\Users\\"+username+"\\Desktop\\SpainRobot\\ReclaimData.txt").split("\n");
        csvData.get(0);

        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\"+username+"\\IdeaProjects\\RobotTwo\\RobotTwo\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Browser
        CustomLogger.debug("Start browser session");
        Browser browser = new Browser(driver);
        browser.navigate("https://www1.agenciatributaria.gob.es/static_files/common/internet/dep/aplicaciones/ov/ie63600i.html");
        System.out.println("Robot inside first page");
        System.out.println("Start filling the page withing the data from text file");

        browser.waitFor(20, ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(COUNTRY_FIELD, data1[0].substring(9, 11))))).click();

        //First info page filling
        browser.sendText(YEAR_FIELD, data1[1].substring(6, (data1[1].length() - 1)));
        browser.sendText(VAT_ID, data1[2].substring(8, data1[2].length() - 1));
        browser.sendText(LEGAL_NAME, data1[3].substring(12, data1[3].length() - 1));
        browser.waitFor(20, ExpectedConditions.elementToBeClickable(By.xpath(CHECK_BOX))).click();
        browser.waitFor(20, ExpectedConditions.elementToBeClickable(By.xpath(OPEN_PERIOD_CHECKBOX_POINT))).click();
        browser.sendText(START_DATE_FIELD, data1[4].substring(12, data1[4].length() - 1));
        browser.sendText(END_DATE_FIELD, data1[5].substring(10, data1[5].length() - 1));
        browser.waitFor(20, ExpectedConditions.elementToBeClickable(By.xpath(SUBMIT_BUTTON))).click();
        System.out.println("First Page Information Added");

        browser.waitFor(30, ExpectedConditions.visibilityOfElementLocated(By.xpath(SECOND_PAGE_VALIRATOR)));

        //Second page filling
        System.out.println("Start filling second page withing the data from text file");
        browser.sendText(FIRST_EMAIL, data1[6].substring(7, data1[6].length() - 1));
        browser.sendText(FIRST_TEL, data1[7].substring(11, data1[7].length() - 1));
        browser.waitFor(20, ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ACTIVIDADES_FIRST_LINE))).click();


        String before = browser.webDriver.getWindowHandle();
        for (String newWin : driver.getWindowHandles()) {
            driver.switchTo().window(newWin);
        }
        browser.waitFor(15, ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='datos']/descendant::td/descendant::a[contains(text(),'" + data1[8].substring(17, data1[8].length() - 1) + "')]"))).click();
        driver.switchTo().window(before);

        browser.sendText(SECOND_EMAIL, "vat.refund@vatbox.com");
        browser.sendText(SECOND_TEL, "916392508");
        browser.waitFor(20, ExpectedConditions.presenceOfElementLocated(By.xpath(TIPO_DE_VIA))).click();
        browser.sendText(COMPLEMENTO_DOMICILO, "CO: BUSINESS RISK SERVICIES");
        browser.waitFor(20, ExpectedConditions.visibilityOfElementLocated(By.xpath(DECLARATION_DEL_SOLICITANTE))).click();

        browser.sendText(ACCOUNT_HOLDER_NAME, data1[9].substring(21, data1[9].length() - 1));
        browser.waitFor(20, ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(A_R, data1[10].substring(5, data1[10].length() - 1))))).click();
        browser.sendText(BANK_NUMBER, data1[11].substring(13, data1[11].length() - 1));
        browser.sendText(BIC_BANK, data1[12].substring(10, data1[12].length() - 1));
        browser.waitFor(20, ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(CURRENCY, data1[13].substring(10, data1[13].length()))))).click();
        browser.waitFor(20, ExpectedConditions.visibilityOfElementLocated(By.xpath(PAGE_TWO_BUTTON))).click();
        browser.waitFor(30, ExpectedConditions.visibilityOfElementLocated(By.xpath(THIRD_PAGE_VALIDATION)));
        System.out.println("Second Page Information Added");

        //Third page filling
        int i = 0;
        String pageNumber = "0";
        int pageNumberInt = 0;
        System.out.println("Start to add data from csv file to web tables");
        for (i = 0; i < invoicesSize; i++) {
            String newPage = pageNumber + Integer.toString(pageNumberInt);
            String addPage;
            if (i <= 1) {
                addPage = "";
            } else if (i > 18) {
                addPage = Integer.toString(i / 2);
            } else {
                addPage = newPage;
            }
            //First invoice info adding
            String[] list1 = ((String) ((ArrayList) csvData.get(i)).get(0)).split("\t");
            if (list1[2].equals("\u0000S\u0000h\u0000i\u0000p\u0000m\u0000e\u0000n\u0000t\u0000s\u0000")) {
                browser.waitFor(20, ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(TYPE, "I  ", "1", addPage)))).click();
            } else {
                browser.waitFor(20, ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(TYPE, "P  ", "1", addPage)))).click();
            }
            browser.waitFor(20, ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(INVOICE_NUMBER, "1", addPage)))).sendKeys(list1[0]);

            //Need to convert date from csv to format ddmmyyyy
            String[] date = list1[21].substring(1).split("\u0000");
            String invoiceDate = DateConverter.converter(date);
            browser.sendText(String.format(INVOICE_DATE, "1", addPage), invoiceDate);

            String[] invoiceAmExcludingVat = Parsers.splitNumber(list1[17]);
            browser.sendText(String.format(INVOICE_AMOUNT_EXCLUDING_VAT_1, "1", addPage), invoiceAmExcludingVat[0]);
            if(invoiceAmExcludingVat.length>1){
                browser.sendText(String.format(INVOICE_AMOUNT_EXCLUDING_VAT_2, "1", addPage), invoiceAmExcludingVat[1]);
            }

            String[] vatPaid = Parsers.splitNumber(list1[15]);
            browser.sendText(String.format(VAT_PAID_1, "1", addPage), vatPaid[0]);
            if(vatPaid.length>1) {
                browser.sendText(String.format(VAT_PAID_2, "1", addPage), vatPaid[1]);
            }
            double prorata = Parsers.getProrata(list1[12], list1[15]);
            String[] prorataRez = String.valueOf(prorata).split("\\.");
            browser.sendText(String.format(PRORATA_1, "1", addPage), prorataRez[0]);
            browser.sendText(String.format(PRORATA_2, "1", addPage), prorataRez[1]);

            String[] claimVatAmount = Parsers.splitNumber(list1[12]);
            browser.sendText(String.format(IMPORTE_SOLICITADO_1, "1", addPage), claimVatAmount[0]);
            if(claimVatAmount.length>1) {
                browser.sendText(String.format(IMPORTE_SOLICITADO_2, "1", addPage), claimVatAmount[1]);
            }
            String euSubCode = list1[49].replaceAll("\u0000", "");
            String euSubCodeFin = CodigoChecker.checker(euSubCode);
            int euSubCodeFinLength = euSubCodeFin.length();
            String filled = StringUtils.repeat(" ", 10-euSubCodeFinLength);
            String subCodeFin = euSubCodeFin+filled;
            browser.waitFor(20, ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(CODIGO, subCodeFin, "1", addPage)))).click();

            if (euSubCode.equals("10")) {
                int x = 10;
                while (x > 0 && browser.waitFor(3, ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(OTROS, "1", addPage)))).getAttribute("style") == "background: lightyellow;") {
                    x--;
                }
                browser.sendText(String.format(OTROS, "1", addPage), list1[39].substring(3, list1[39].length()-4));
            }

            String isSimplified = list1[40].replaceAll("\u0000", "");
            if (isSimplified.equals("true") || isSimplified.equals("TRUE")) {
                browser.waitFor(20, ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(IS_SIMPLIFIED_1, "1", addPage)))).click();
            }


            if(isSimplified.equals("true") || isSimplified.equals("TRUE")){
                //DO NOT NOTHING
            }else {
                browser.waitFor(20, ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(PAIS_EMISOR_1, CountryChecker.getCountry(list1[20].replaceAll("\u0000", "")), "1", addPage)))).click();

                if (!list1[20].replaceAll("\u0000", "").equals("Germany")) {
                    browser.sendText(String.format(NVAT_1, "1", addPage), list1[27].replaceAll("\u0000", ""));
                } else {
                    if (list1[29].replaceAll("\u0000", "").equals("TRUE") && list1[30].replaceAll("\u0000", "").equals("FALSE")) {
                        browser.sendText(String.format(NVAT_1, "1", addPage), list1[27].replaceAll("\u0000", ""));
                    } else {
                        browser.waitFor(20, ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(PAIS_EMISOR_DE_LA_REFERENCIA_1, "DE", "1", addPage)))).click();
                        browser.sendText(String.format(REFERENCIAL_FISCAL_1, "1", addPage), list1[28].replaceAll("\u0000", ""));
                    }
                }
            }

            browser.sendText(String.format(APELLIDOS_Y_NOMBRE_1, "1", addPage), list1[24].replaceAll("\u0000", ""));
            String direccionText = list1[25].replaceAll("\u0000", "");
            if(direccionText.substring(0,1).equals("\"")){
                browser.sendText(String.format(DIRECCTION_1, "1", addPage), direccionText.substring(1, direccionText.length()-1));
            } else {
                browser.sendText(String.format(DIRECCTION_1, "1", addPage), direccionText.substring(0, direccionText.length()-1));
            }

            browser.waitFor(20, ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(LAST_PAIS_1, CountryChecker.getCountry(list1[20].replaceAll("\u0000", "")), "1", addPage)))).click();
            if (i == invoicesSize - 1) {
                browser.waitFor(10, ExpectedConditions.visibilityOfElementLocated(By.xpath(GUARDAR))).click();
                CustomLogger.debug("SESSION FINISHED");
            }
            i++;

            //Second invoice info adding
            String[] list2 = ((String) ((ArrayList) csvData.get(i)).get(0)).split("\t");
            if (list2[2].equals("\u0000S\u0000h\u0000i\u0000p\u0000m\u0000e\u0000n\u0000t\u0000s\u0000")) {
                browser.waitFor(20, ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(TYPE, "I  ", "2", addPage)))).click();
            } else {
                browser.waitFor(20, ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(TYPE, "P  ", "2", addPage)))).click();
            }
            browser.waitFor(20, ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(INVOICE_NUMBER, "2", addPage)))).sendKeys(list2[0]);

            //Need to convert date from csv to format ddmmyyyy
            String[] date1 = list2[21].substring(1).split("\u0000");
            String invoiceDate1 = DateConverter.converter(date1);
            browser.sendText(String.format(INVOICE_DATE, "2", addPage), invoiceDate1);

            String[] invoiceAmExcludingVat1 = Parsers.splitNumber(list2[17]);
            browser.sendText(String.format(INVOICE_AMOUNT_EXCLUDING_VAT_1, "2", addPage), invoiceAmExcludingVat1[0]);
            if(invoiceAmExcludingVat1.length>1) {
                browser.sendText(String.format(INVOICE_AMOUNT_EXCLUDING_VAT_2, "2", addPage), invoiceAmExcludingVat1[1]);
            }

            String[] vatPaid1 = Parsers.splitNumber(list2[15]);
            browser.sendText(String.format(VAT_PAID_1, "2", addPage), vatPaid1[0]);
            if(vatPaid1.length>1) {
                browser.sendText(String.format(VAT_PAID_2, "2", addPage), vatPaid1[1]);
            }
            double prorata1 = Parsers.getProrata(list2[12], list2[15]);
            String[] prorataRez1 = String.valueOf(prorata1).split("\\.");
            browser.sendText(String.format(PRORATA_1, "2", addPage), prorataRez1[0]);
            browser.sendText(String.format(PRORATA_2, "2", addPage), prorataRez1[1]);

            String[] claimVatAmount1 = Parsers.splitNumber(list2[12]);
            browser.sendText(String.format(IMPORTE_SOLICITADO_1, "2", addPage), claimVatAmount1[0]);
            if(claimVatAmount1.length>1) {
                browser.sendText(String.format(IMPORTE_SOLICITADO_2, "2", addPage), claimVatAmount1[1]);
            }


            String euSubCode1 = list2[49].replaceAll("\u0000", "");
            String euSubCodeFin1 = CodigoChecker.checker(euSubCode1);
            int euSubCodeFinLength1 = euSubCodeFin1.length();
            String filled1 = StringUtils.repeat(" ", 10-euSubCodeFinLength1);
            String subCodeFin1 = euSubCodeFin1+filled1;
            browser.waitFor(20, ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(CODIGO, subCodeFin1, "2", addPage)))).click();


            if (euSubCode1.equals("10")) {
                int x = 10;
                while (x > 0 && browser.waitFor(30, ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(OTROS, "2", addPage)))).getAttribute("style") == "background: lightyellow;") {
                    x--;
                }
                browser.sendText(String.format(OTROS, "2", addPage), list2[39].substring(3, list2[39].length()-4));
            }

            String isSimplified1 = list2[40].replaceAll("\u0000", "");
            if (isSimplified1.equals("true") || isSimplified1.equals("TRUE")) {
                browser.waitFor(20, ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(IS_SIMPLIFIED_1, "2", addPage)))).click();
            }

            if(isSimplified1.equals("true") || isSimplified1.equals("TRUE")){
                //DO NOT NOTHING
            } else {
                browser.waitFor(20, ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(PAIS_EMISOR_1, CountryChecker.getCountry(list2[20].replaceAll("\u0000", "")), "2", addPage)))).click();

                if (!list2[20].replaceAll("\u0000", "").equals("Germany")) {
                    browser.sendText(String.format(NVAT_1, "2", addPage), list2[27].replaceAll("\u0000", ""));
                } else {
                    if (list2[29].replaceAll("\u0000", "").equals("TRUE") && list2[30].replaceAll("\u0000", "").equals("FALSE")) {
                        browser.sendText(String.format(NVAT_1, "2", addPage), list2[27].replaceAll("\u0000", ""));
                    } else {
                        browser.waitFor(20, ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(PAIS_EMISOR_DE_LA_REFERENCIA_1, "DE", "2", addPage)))).click();
                        browser.sendText(String.format(REFERENCIAL_FISCAL_1, "2", addPage), list2[28].replaceAll("\u0000", ""));
                    }
                }
            }

            browser.sendText(String.format(APELLIDOS_Y_NOMBRE_1, "2", addPage), list2[24].replaceAll("\u0000", ""));
            String direccionText1 = list2[25].replaceAll("\u0000", "");
            if(direccionText1.substring(0,1).equals("\"")){
                browser.sendText(String.format(DIRECCTION_1, "2", addPage), direccionText1.substring(1, direccionText1.length()-1));
            } else {
                browser.sendText(String.format(DIRECCTION_1, "2", addPage), direccionText1.substring(0, direccionText1.length()-1));
            }

            browser.waitFor(20, ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(LAST_PAIS_1, CountryChecker.getCountry(list2[20].replaceAll("\u0000", "")), "2", addPage)))).click();
            if (i == invoicesSize - 1) {
                browser.waitFor(10, ExpectedConditions.visibilityOfElementLocated(By.xpath(GUARDAR))).click();
                CustomLogger.debug("SESSION FINISHED");

            } else {
                pageNumberInt++;
                browser.waitFor(10, ExpectedConditions.visibilityOfElementLocated(By.xpath(NEXT_PAGE_BUTTON))).click();
            }
        }
        CustomLogger.debug("CSV file was checked. Text file downloaded. System added "+i+" invoices");

    }


}

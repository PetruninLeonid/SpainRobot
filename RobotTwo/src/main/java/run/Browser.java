package run;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {
    WebDriver webDriver;

    public Browser(WebDriver webDriver){ this.webDriver = webDriver; }

    public void navigate(String url){
        CustomLogger.debug("Go to url: "+url);
        webDriver.get(url);
    }

    public <T> T waitFor(long waitUntil, ExpectedCondition<T> expectedCondition){
        WebDriverWait wait = new WebDriverWait(webDriver, waitUntil);
        return wait.until(expectedCondition);
    }

    /*public void sendText(String element, String text){
        CustomLogger.debug("Try to send text: "+ text);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].value = arguments[1];", waitFor(30, ExpectedConditions.visibilityOfElementLocated(By.xpath(element))), text);
    }*/

    public void sendText(String element, String text){
        CustomLogger.debug("Try to send text: "+ text);
        waitFor(30, ExpectedConditions.visibilityOfElementLocated(By.xpath(element))).sendKeys(text);
    }

    public void sendTextWithScript(String element, String text){
        CustomLogger.debug("Try to send text: "+ text);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].value = arguments[1];", waitFor(30, ExpectedConditions.visibilityOfElementLocated(By.xpath(element))), text);
    }

    public void killSession(){
        CustomLogger.debug("Session finished");
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.quit();
    }
}

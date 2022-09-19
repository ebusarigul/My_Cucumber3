package Pages;

import Utilities.GWD;
import io.cucumber.java.lv.Ja;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Parent {

    public void sendKeysFunction(WebElement element, String value){

        waitUntilVisible(element);  //gözükene kadar bekle
        scrollToElement(element);   //elemente kadar scroll yap
        element.clear();            //kutucugu temizle
        element.sendKeys(value);    //değeri gönder

    }

    public void clickFunction(WebElement element){

        waitUntilVisible(element);
        waitUntilClickable(element); // clickable olana kadar bekle
        scrollToElement(element);    // elemente kadar scroll yap
        element.click();             // elemente tıkla

    }

    public void verifyContainsText(WebElement element,String text){

        waitUntilVisible(element);   //gözükene kadar bekle
        Assert.assertTrue(element.getText().toLowerCase().contains(text.toLowerCase()));  // verify yap
    }

    public void waitUntilVisible(WebElement element){

        WebDriverWait wait =new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitUntilClickable(WebElement element){

        WebDriverWait wait =new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollToElement(WebElement element){

        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();",element);
    }

    public void waitUntilLoading() {
        WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("fuse-progress-bar > *"), 0));
    }
}

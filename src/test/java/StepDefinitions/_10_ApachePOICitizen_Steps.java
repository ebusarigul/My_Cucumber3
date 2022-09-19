package StepDefinitions;

import Pages.DialogContent;
import Utilities.ExcelUtility;
import Utilities.GWD;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class _10_ApachePOICitizen_Steps {

    DialogContent dc = new DialogContent();

    @When("User Create Citizenship with ApachePOI")
    public void userCreateCitizenshipWithApachePOI() {
        //Excelden oku ve CitizenShip i create et
        ArrayList <ArrayList<String>> tablo =
                ExcelUtility.getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx","testCitizen",2);

        for (ArrayList<String> satir  : tablo ){

            dc.findAndClick("addButton");
            dc.findAndSend("nameInput",satir.get(0));
            dc.findAndSend("shortName",satir.get(1));
            dc.findAndClick("saveButton");
            dc.findAndContainsText("successMessage","success");
            WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
            wait.until(ExpectedConditions
                    .invisibilityOfElementLocated(By.xpath("//div[contains(text(),'successfully')]")));
        }
    }

    @When("User Delete Citizenship with ApachePOI")
    public void userDeleteCitizenshipWithApachePOI() {
        //kaydettiklerini yine excelden okuyarak sil
        ArrayList <ArrayList<String>> tablo =
                ExcelUtility.getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx","testCitizen",1);

        for (ArrayList<String> satir : tablo){
            dc.searchAndDelete(satir.get(0));
            dc.findAndContainsText("successMessage","success");
        }

    }
}

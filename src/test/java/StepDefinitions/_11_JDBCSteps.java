package StepDefinitions;

import Pages.DialogContent;
import Utilities.DBUtility;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class _11_JDBCSteps {

    @Then("Send the query the database {string} and control match")
    public void sendTheQueryTheDatabaseAndControlMatch(String query) {

        //DB den gerekli listeyi alıcam
        List<List<String>> dbList = DBUtility.getListData(query);
        System.out.println("dbList = " + dbList);

        //Webden ekrandaki isimleri alıcam
        DialogContent dc = new DialogContent();
        List<WebElement> uiList = dc.waitUntilVisibleAllElement(dc.nameList);

        for (WebElement l : uiList){
            System.out.println(l.getText());
        }

        //karsılastırıcam
        for (int i = 0; i < dbList.size() ; i++) {
            Assert.assertEquals(dbList.get(i).get(1),uiList.get(i).getText(),"Hatalı durum");
        }


    }
}

package StepDefinitions;

import Pages.FormContent;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class _06_EntranceExamSteps {

    FormContent fc = new FormContent();

    @And("Click on the element in the Form")
    public void clickOnTheElementInTheForm(DataTable elements) {
        List<String> listElement = elements.asList(String.class);

        for (int i = 0; i < listElement.size(); i++) {

            fc.findAndClick(listElement.get(i));
        }

    }

    @And("User delete item from Form")
    public void userDeleteItemFromForm(DataTable elements) {

        List<String> listElement = elements.asList(String.class);
        for (int i = 0; i < listElement.size(); i++) {
            fc.searchAndDelete(listElement.get(i));
        }

    }

    @And("User sending the keys in Form content")
    public void userSendingTheKeysInFormContent(DataTable elements) {
        List<List<String>> listElement = elements.asLists(String.class);
        for (int i = 0; i < listElement.size(); i++) {

            fc.findAndSend(listElement.get(i).get(0), listElement.get(i).get(1));
        }
    }

    @When("Click on the ESC")
    public void clickOnTheESC() {
        Actions actions = new Actions(GWD.getDriver());
        actions.keyDown(Keys.ESCAPE).build().perform();
        actions.keyUp(Keys.ESCAPE).build().perform();
    }

    @When("Click on the ENTER")
    public void clickOnTheENTER(){
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//mat-option")));

        Actions actions = new Actions(GWD.getDriver());
        actions.keyDown(Keys.ENTER).build().perform();
        actions.keyUp(Keys.ENTER).build().perform();

    }
}

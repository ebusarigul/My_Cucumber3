package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormContent extends Parent{

    public FormContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath="(//mat-form-field[@formgroupname=\"academicPeriod\"]/div/div)[1]")
    private WebElement academicPeriod;

    @FindBy(xpath="(//mat-form-field[@formgroupname=\"gradeLevel\"]/div/div)[1]")
    private WebElement gradeLevel;

    @FindBy(xpath="//span[text()=' 2021-2022 ']")
    private WebElement select1;

    @FindBy(xpath="//span[text()=' 1 ']")
    private WebElement select2;

    @FindBy(xpath="//*[@fxlayoutalign=\"end center\"]/button")
    private WebElement back;

    @FindBy(xpath="//mat-form-field//input")
    private WebElement searchName;

    @FindBy(xpath="//ms-search-button//button")
    private WebElement searchButton;

    @FindBy(xpath = "//ms-delete-button//button")
    private WebElement deleteButton;

    @FindBy(xpath = "//span[contains(text(),'Delete')]")
    private WebElement deleteDialogButton;

    //---------------------------------------------------

    @FindBy(xpath = "//ms-text-field[@formcontrolname='firstName']//input")
    private WebElement firstName;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='lastName']//input")
    private WebElement lastName;

    @FindBy(xpath = "//input[@formcontrolname=\"employeeId\"]")
    private WebElement employeeid;

    @FindBy(xpath = "//input[@formcontrolname=\"documentNumber\"]")
    private WebElement documentNumber;

    @FindBy(xpath = "//input[@formcontrolname=\"personalId\"]")
    private WebElement personalId;

    @FindBy(xpath = "(//mat-form-field[@formgroupname=\"profile\"]/div/div)[1]")
    private WebElement gender;

    @FindBy(xpath = "//span[text()=' Male ']")
    private WebElement male;

    @FindBy(xpath = "//span[text()=' Female ']")
    private WebElement female;

    @FindBy(xpath = "(//mat-select)[2]")
    private WebElement employeeType;

    @FindBy(xpath = "//span[text()=' Other ']")
    private WebElement other;

    @FindBy(xpath = "(//mat-select)[5]")
    private WebElement qualification;

    @FindBy(xpath = "//span[text()=' Master ']")
    private WebElement master;

    @FindBy(xpath = "(//mat-select)[6]")
    private WebElement documentType;

    @FindBy(xpath = "//span[text()=' Passport ']")
    private WebElement passport;

    @FindBy(xpath = "//div[text()='Contact & Address']")
    private WebElement contactAddress;

    @FindBy(xpath = "//input[@formcontrolname=\"country\"]")
    private WebElement country;



    WebElement myElement;

    public void findAndClick(String strElement){  // 2.aşama
        // burda string isimden weblemente ulaşıcam
        switch (strElement)
        {
            case "academicPeriod" : myElement =academicPeriod; break;
            case "select1" : myElement =select1; break;
            case "gradeLevel" : myElement =gradeLevel; break;
            case "select2" : myElement =select2; break;
            case "back" : myElement =back; break;
            case "searchButton" : myElement =searchButton; break;
            case "deleteButton" : myElement =deleteButton; break;
            case "deleteDialogButton" : myElement =deleteDialogButton; break;
            case "gender" : myElement =gender; break;
            case "male" : myElement =male; break;
            case "employeeType" : myElement =employeeType; break;
            case "other" : myElement =other; break;
            case "qualification" : myElement =qualification; break;
            case "master" : myElement =master; break;
            case "documentType" : myElement =documentType; break;
            case "passport" : myElement =passport; break;
            case "contactAddress" : myElement =contactAddress; break;
            case "female" : myElement =female; break;

        }

        clickFunction(myElement);
    }

    public void findAndSend(String strElement, String value){  // 2.aşama
        // burda string isimden weblemente ulaşıcam
        switch (strElement)
        {
            case "searchName" : myElement =searchName; break;
            case "firstName" : myElement =firstName; break;
            case "lastName" : myElement =lastName; break;
            case "employeeid" : myElement =employeeid; break;
            case "documentNumber" : myElement =documentNumber; break;
            case "personalId" : myElement =personalId; break;
            case "country" : myElement =country; break;
        }

        sendKeysFunction(myElement, value);
    }

    public void searchAndDelete(String searchText){

        findAndSend("searchName",searchText);//arama kutucuguna kelimeyi yaz
        findAndClick("searchButton");//arama butonuna bas

        waitUntilLoading();

        findAndClick("deleteButton");//silme butonuna bas
        findAndClick("deleteDialogButton");//dialogdaki silme butonuna bas

    }
}

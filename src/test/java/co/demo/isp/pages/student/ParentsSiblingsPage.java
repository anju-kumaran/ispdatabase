package co.demo.isp.pages.student;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class ParentsSiblingsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@class='col-md-6 col-sm-6']//legend[text()='Parent 1 Info']")
    private WebElement liveText;

   // @FindBy(xpath = "//input[@placeholder='First Name' and contains(@ng-model,'Father')]")
    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement parentOneFirstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement parentOneLastName;

    @FindBy(xpath = "//input-and-date-picker[contains(@model,'Father')]//input")
    private WebElement parentOneBday;

    /*@FindBy(xpath = "//input-and-date-picker[contains(@model,'Father')]//button[@class='btn btn-default']")
    private WebElement parentOneDobPicker;*/

    @FindBy(xpath = "//input[@placeholder='Occupation' and contains(@ng-model,'F_')]")
    private WebElement parentOneOccupation;

    @FindBy(xpath = "//input[@placeholder='Primary Email' and contains(@ng-model,'Father')]")
    private WebElement parentOnePrimaryEmail;

    @FindBy(xpath = "//input[@type='tel' and contains(@ng-model,'Phone1')]")
    private WebElement parentOnePhone;

    @FindBy(xpath = "//selectize[@placeholder='Permit Type' and contains(@ng-model,'F_')]/parent::*/child::div//input")
    private WebElement parentOnePermitType;

   // @FindBy(xpath = "//selectize[@placeholder='Relationship' and contains(@ng-model,'Father')]//following::div[1]")
   // @FindBy(xpath = "//selectize[@placeholder='Relationship' and contains(@ng-model,'Father')]//following::input[@placeholder='Relationship']")
    @FindBy(xpath = "//selectize[@placeholder='Relationship' and contains(@ng-model,'Father')]/parent::*/child::div//input")
    private WebElement parentOneRelationship;

    @FindBy(xpath = "//input[@placeholder='Permit #' and contains(@ng-model,'F_')]")
    private WebElement parentOnePermitNumber;

   // @FindBy(xpath = "//input-and-date-picker[contains(@model,'F_Permit')]//input")
    @FindBy(xpath = "//p[@class='input-group floating-label']//input[@placeholder='Exp. Date']")
    private WebElement parentOnePermitExp;

   /* @FindBy(xpath = "//input-and-date-picker[contains(@model,'F_Permit')]//button[@class='btn btn-default']")
    private WebElement parentOnePermitDatePicker;*/

    @FindBy(xpath = "//input[@class='ng-pristine ng-valid']")
    private WebElement parentOneChkDeceased;

    @FindBy(xpath = "//input[@type='checkbox' and contains(@ng-model,'Responsible Father')]")
    private WebElement parentOneChkResponsible;

    @FindBy(xpath = "//input[@placeholder='First Name' and contains(@ng-model,'Mother')]")
    private WebElement parentTwoFirstName;

    @FindBy(xpath = "//input[@placeholder='Last Name' and contains(@ng-model,'Mother')]")
    private WebElement parentTwoLastName;

    @FindBy(xpath = "//input-and-date-picker[contains(@model,'Mother')]//input")
    private WebElement parentTwoBday;

    @FindBy(xpath = "//input-and-date-picker[contains(@model,'Mother')]//button[@class='btn btn-default']")
    private WebElement parentTwoDobPicker;

    @FindBy(xpath = "//input[@placeholder='Occupation' and contains(@ng-model,'M_')]")
    private WebElement parentTwoOccupation;

    @FindBy(xpath = "//input[@placeholder='Primary Email' and contains(@ng-model,'Mother')]")
    private WebElement parentTwoPrimaryEmail;

    @FindBy(xpath = "//input[@type='tel' and contains(@ng-model,'Phone2')]")
    private WebElement parentTwoPhone;

    @FindBy(xpath = "//selectize[@placeholder='Permit Type' and contains(@ng-model,'M_')]/parent::*/child::div//input")
    private WebElement parentTwoPermitType;

    @FindBy(xpath = "//selectize[@placeholder='Permit Type' and contains(@ng-model,'M_')]//following::div[@class='selectize-dropdown-content']//div[contains(@class,'option')]")
    private WebElement parentTwoPermitSelect;


   //@FindBy(xpath = "//selectize[@placeholder='Relationship' and contains(@ng-model,'Mother')]//following::div[1]")
    @FindBy(xpath = "//selectize[@placeholder='Relationship' and contains(@ng-model,'Mother')]//following::input[@placeholder='Relationship']")
    private WebElement parentTwoRelationship;

    @FindBy(xpath = "//input[@placeholder='Permit #' and contains(@ng-model,'M_')]")
    private WebElement parentTwoPermitNumber;

    @FindBy(xpath = "//input-and-date-picker[contains(@model,'M_Permit')]//input")
    private WebElement parentTwoPermitExp;

    @FindBy(xpath = "//input-and-date-picker[contains(@model,'M_Permit')]//button[@class='btn btn-default']")
    private WebElement parentTwoPermitDatePicker;

    @FindBy(xpath = "//input[@type='checkbox' and contains(@ng-model,'Deceased Mother')]")
    private WebElement parentTwoChkDeceased;

    @FindBy(xpath = "//input[@type='checkbox' and contains(@ng-model,'Responsible Mother')]")
    private WebElement parentTwoChkResponsible;

    @FindBy(xpath = "//input[@placeholder='Institution']")
    private WebElement institution;

    @FindBy(xpath = "//input[@placeholder='English ?']")
    private WebElement english;

    @FindBy(xpath = "//legend[text()='Address/Contact Info - Parent 1']/parent::*/child::div/div[2]/div//input")
    private WebElement addressForParentOne;

    @FindBy(xpath = "//legend[contains(text(),'Address/Contact Info - Parent 2')]//following::input[@placeholder='Address For']")
    private WebElement addressForParentTwo;

    @FindBy(xpath = "//label[text()='Home Phone']//following::input[@placeholder='Home Phone'][1]")
    private WebElement homePhoneOne;

    @FindBy(xpath = "//label[text()='Home Phone']//following::input[@placeholder='Home Phone'][2]")
    private WebElement homePhoneTwo;

    @FindBy(xpath = "//label[text()='Home Fax']//following::input[@placeholder='Home Fax'][1]")
    private WebElement homeFaxOne;

    @FindBy(xpath = "//label[text()='Home Fax']//following::input[@placeholder='Home Fax'][2]")
    private WebElement homeFaxTwo;

    @FindBy(xpath = "//label[text()='Home Cell']//following::input[@placeholder='Home Cell'][1]")
    private WebElement homeCellOne;

    @FindBy(xpath = "//label[text()='Home Cell']//following::input[@placeholder='Home Cell'][2]")
    private WebElement homeCellTwo;

    @FindBy(xpath = "//label[text()='Work Phone']//following::input[@placeholder='Work Phone'][1]")
    private WebElement workPhoneOne;

    @FindBy(xpath = "//label[text()='Work Phone']//following::input[@placeholder='Work Phone'][2]")
    private WebElement workPhoneTwo;

    @FindBy(xpath = "//label[text()='Work Fax']//following::input[@placeholder='Work Fax'][1]")
    private WebElement workFaxOne;

    @FindBy(xpath = "//label[text()='Work Fax']//following::input[@placeholder='Work Fax'][2]")
    private WebElement workFaxTwo;

    @FindBy(xpath = "//textarea[@placeholder='Parent 1 Address']")
    private WebElement parentOneAddress;

    @FindBy(xpath = "//textarea[@placeholder='Parent 2 Address']")
    private WebElement parentTwoAddress;

    @FindBy(xpath = "//label[text()='City']//following::input[@placeholder='City'][1]")
    private WebElement parentOneCity;

    @FindBy(xpath = "//label[text()='City']//following::input[@placeholder='City'][2]")
    private WebElement parentTwoCity;

    @FindBy(xpath = "//label[text()='Province']//following::input[@placeholder='Province'][1]")
    private WebElement parentOneProvince;

    @FindBy(xpath = "//label[text()='Province']//following::input[@placeholder='Province'][2]")
    private WebElement parentTwoProvince;

    @FindBy(xpath = "//selectize[@placeholder='Country']/parent::*/child::div/div/input")
    private WebElement parentOneCountry;

    //@FindBy(xpath = "//selectize[contains(@ng-model,'Country2')]//following::input[@placeholder='Country']")
    @FindBy(xpath = "//selectize[@placeholder='Country' and contains(@ng-model,'Country2')]/parent::*/child::div/div/input")
    private WebElement parentTwoCountry;

    @FindBy(xpath = "//label[text()='Postal Code']//following::input[@placeholder='Postal Code'][1]")
    private WebElement parentOnePostCode;

    @FindBy(xpath = "//label[text()='Postal Code']//following::input[@placeholder='Postal Code'][2]")
    private WebElement parentTwoPostCode;

    @FindBy(xpath = "//label[text()='Secondary Email']//following::input[@placeholder='Secondary Email'][1]")
    private WebElement parentOneSecondEmail;

    @FindBy(xpath = "//label[text()='Secondary Email']//following::input[@placeholder='Secondary Email'][2]")
    private WebElement parentTwoSecondEmail;

    @FindBy(xpath = "//textarea[@placeholder='Notes']")
    private WebElement notes;

    @FindBy(xpath = "//div[@class='col-md-2 col-sm-2']//input[contains(@ng-model,'Mother')]")
    private WebElement communicateMother;

    @FindBy(xpath = "//div[@class='col-md-2 col-sm-2']//input[contains(@ng-model,'Father')]")
    private WebElement communicateFather;

    @FindBy(xpath = "//div[@class='col-md-2 col-sm-2']//input[contains(@ng-model,'Agent')]")
    private WebElement communicateAgent;

    @FindBy(xpath = "//legend[@class='student-legend' and text()='Parent 1 Info']//following::div[@class='col-md-6 m-t-23 t-l']/button")
    private WebElement btnPrimaryEmailOne;

    @FindBy(xpath = "//legend[@class='student-legend' and text()='Parent 2 Info']//following::div[@class='col-md-6 m-t-23 t-l']/button")
    private WebElement btnPrimaryEmailTwo;

    @FindBy(xpath = "//legend[@class='student-legend' and text()='Address/Contact Info - Parent 1']//following::div[@class='col-md-6 m-t-23 t-l']/button")
    private WebElement btnSecondaryEmailOne;

    @FindBy(xpath = "//legend[@class='student-legend' and text()='Address/Contact Info - Parent 2']//following::div[@class='col-md-6 m-t-23 t-l']/button")
    private WebElement btnSecondaryEmailTwo;

    @FindBy(xpath = "//label[text()='Primary Email']//following::button[@class='btn btn-dark h-31'][1]")
    private WebElement quickEmailPrimaryOne;

    @FindBy(xpath = "//label[text()='Primary Email']//following::button[@class='btn btn-dark h-31'][3]")
    private WebElement quickEmailPrimaryTwo;

    @FindBy(xpath = "//label[text()='Secondary Email']//following::button[@class='btn btn-dark h-31'][1]")
    private WebElement quickEmailSecondaryOne;

    @FindBy(xpath = "//label[text()='Secondary Email']//following::button[@class='btn btn-dark h-31'][3]")
    private WebElement quickEmailSecondaryTwo;

    @FindBy(id = "siblingsHolder")
    private WebElement siblingsInfo;

    @FindBy(xpath = "//i[@class='fa fa-search searchIcon']")
    private WebElement siblingsSearch;


    public ParentsSiblingsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public ParentsSiblingsPage keyInParentOneFirstName(String name){
        parentOneFirstName = wait.until(ExpectedConditions.visibilityOf(parentOneFirstName));
        parentOneFirstName.sendKeys(name);

       // WebDriverWait wait = new WebDriverWait(driver, 10);
       // wait.until(ExpectedConditions.elementToBeClickable(parentOneFirstName));
        //wait.until(ExpectedConditions.visiblityofElementToBeClickable(parentOneFirstName));

        //this.parentOneFirstName.sendKeys(name);
        return this;
    }

    public ParentsSiblingsPage keyInParentOneLastName(String name){
        this.parentOneLastName.sendKeys(name);
        return this;
    }

    public ParentsSiblingsPage keyInParentOneBday(String birthDay){
        parentOneBday = wait.until(ExpectedConditions.elementToBeClickable(parentOneBday));
        this.parentOneBday.sendKeys(birthDay);
        return this;
    }

    /*public ParentsSiblingsPage selectParentOneDOB(String dateOfBirth){
        this.parentOneDobPicker.click();
        this.parentOneBday.sendKeys(dateOfBirth);
        return this;
    }*/

    public ParentsSiblingsPage keyInParentOneOccupation(String occupation){
        parentOneOccupation = wait.until(ExpectedConditions.visibilityOf(parentOneOccupation));
        this.parentOneOccupation.sendKeys(occupation);
        return this;
    }

    public ParentsSiblingsPage keyInParentOneEmail(String email){
        this.parentOnePrimaryEmail.sendKeys(email);
        return this;
    }

    public ParentsSiblingsPage keyInParentOnePhone(String phone){
        parentOnePhone = wait.until(ExpectedConditions.visibilityOf(parentOnePhone));
        this.parentOnePhone.sendKeys(phone);
        return this;
    }

    public ParentsSiblingsPage selectParentOnePermitType(String permitType) {
        /*WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(parentOnePermitType));
        Actions actions = new Actions(driver);
        actions.moveToElement(parentOnePermitType).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].click();", parentOnePermitType);

        //List<WebElement> elements = driver.findElements(By.xpath("//selectize[@placeholder='Permit Type' and contains(@ng-model,'F_')]//following::div[@class='selectize-dropdown-content']//div[contains(@class,'option')]"));
        List<WebElement> elements = driver.findElements(By.xpath("//selectize[@placeholder='Permit Type' and contains(@ng-model,'F_')]/parent::div/child::div/div[2]/div/div"));
        Iterator<WebElement> iterator = elements.iterator();
        while (iterator.hasNext()) {
            WebElement elm  = iterator.next();
            if(elm.getText().equals(permitType)) {
                //elm.click();
                js.executeScript("arguments[0].click();", elm);
                break;
            }
        }*/
        parentOnePermitType = wait.until(ExpectedConditions.elementToBeClickable(parentOnePermitType));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", parentOnePermitType);
        List<WebElement> elements = driver.findElements(By.xpath("//selectize[@placeholder='Permit Type' and contains(@ng-model,'F_')]/parent::*/child::div/div[2]/div/div"));
        Iterator<WebElement> iterator = elements.iterator();
        while (iterator.hasNext()) {
            WebElement elm  = iterator.next();
            if(elm.getText().equals(permitType)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elm);
                break;
            }
        }
        return this;
    }

    public ParentsSiblingsPage selectParentOneRelationship(String relationship){
        parentOneRelationship = wait.until(ExpectedConditions.visibilityOf(parentOneRelationship));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", parentOneRelationship);
        List<WebElement> elements = driver.findElements(By.xpath("//selectize[@placeholder='Relationship' and contains(@ng-model,'Father')]/parent::*/child::div/div[2]/div/div"));
        Iterator<WebElement> iterator = elements.iterator();
        while (iterator.hasNext()) {
            WebElement elm  = iterator.next();
            if(elm.getText().equals(relationship)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elm);
                break;
            }
        }
        return this;
    }

    public ParentsSiblingsPage keyInParentOnePermitNumber(String number){
        this.parentOnePermitNumber.sendKeys(number);
        return this;
    }

    public ParentsSiblingsPage keyInParentOnePermitExpDate(String expDate){
        parentOnePermitExp = wait.until(ExpectedConditions.elementToBeClickable(parentOnePermitExp));
        this.parentOnePermitExp.sendKeys(expDate);
        return this;
    }

    public ParentsSiblingsPage checkParentOneDeceased(){
        parentOneChkDeceased = wait.until(ExpectedConditions.elementToBeClickable(parentOneChkDeceased));
        this.parentOneChkDeceased.click();
        return this;
    }

    public ParentsSiblingsPage checkParentOneResponsible(){
        parentOneChkResponsible = wait.until(ExpectedConditions.elementToBeClickable(parentOneChkResponsible));
       this.parentOneChkResponsible.click();
       return this;
    }

    public ParentsSiblingsPage keyInInstitution(String institutionName){
        this.institution.sendKeys(institutionName);
        return this;
    }

    public ParentsSiblingsPage keyInParentTwoFirstName(String name){
        this.parentTwoFirstName.sendKeys(name);
        return this;
    }

    public ParentsSiblingsPage keyInParentTwoLastName(String name){
        this.parentTwoLastName.sendKeys(name);
        return this;
    }

    public ParentsSiblingsPage keyInParentTwoBday(String birthDay){
        this.parentTwoBday.sendKeys(birthDay);
        return this;
    }

    public ParentsSiblingsPage keyInParentTwoOccupation(String occupation){
        this.parentTwoOccupation.sendKeys(occupation);
        return this;
    }

    public ParentsSiblingsPage keyInParentTwoEmail(String email){
        this.parentTwoPrimaryEmail.sendKeys(email);
        return this;
    }

    public ParentsSiblingsPage keyInParentTwoPhone(String phone){
        this.parentTwoPhone.sendKeys(phone);
        return this;
    }

    public ParentsSiblingsPage selectParentTwoPermitType(String permitType){
        //this.parentTwoPermitType.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", parentTwoPermitType);
       // List<WebElement> elements = driver.findElements(By.xpath("//selectize[@placeholder='Permit Type' and contains(@ng-model,'M_')]//following::div[@class='selectize-dropdown-content']//div[contains(@class,'option')]"));
        List<WebElement> elements = driver.findElements(By.xpath("//selectize[@placeholder='Permit Type' and contains(@ng-model,'M_')]/parent::*/child::div/div[2]/div/div"));
        Iterator<WebElement> iterator = elements.iterator();
        while (iterator.hasNext()) {
            WebElement elm  = iterator.next();
            if(elm.getText().equals(permitType)) {
                //elm.click();
                js.executeScript("arguments[0].click();", elm);
                break;
            }
        }
        return this;
    }

    public ParentsSiblingsPage selectParentTwoRelationship(String relationship){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", parentTwoRelationship);
        List<WebElement> elements = driver.findElements(By.xpath("//selectize[@placeholder='Relationship' and contains(@ng-model,'Mother')]/parent::*/child::div/div[2]/div/div"));
        Iterator<WebElement> iterator = elements.iterator();
        while (iterator.hasNext()) {
            WebElement elm  = iterator.next();
            if(elm.getText().equals(relationship)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elm);
                break;
            }
        }
        return this;
    }

    public ParentsSiblingsPage keyInParentTwoPermitNumber(String number){
        this.parentTwoPermitNumber.sendKeys(number);
        return this;
    }

    public ParentsSiblingsPage keyInParentTwoPermitExpDate(String expDate){
        this.parentTwoPermitExp.sendKeys(expDate);
        return this;
    }

    public ParentsSiblingsPage checkParentTwoDeceased(){
        this.parentTwoChkDeceased.click();
        return this;
    }

    public ParentsSiblingsPage checkParentTwoResponsible(){
        if(!parentTwoChkResponsible.isSelected()){
            parentTwoChkResponsible.click();
        }
        return this;
    }
    public ParentsSiblingsPage selectEnglish(String speakEnglish){

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", english);
        List<WebElement> elements = driver.findElements(By.xpath("//selectize[@placeholder='English ?']/parent::*/child::div/div[2]/div/div"));
        Iterator<WebElement> iterator = elements.iterator();
        while (iterator.hasNext()) {
            WebElement elm  = iterator.next();
            if(elm.getText().equals(speakEnglish)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elm);
                break;
            }
        }
        return this;
    }
    public ParentsSiblingsPage selectAddressForParentOne(String addressFor){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addressForParentOne);
        List<WebElement> elements = driver.findElements(By.xpath("//legend[text()='Address/Contact Info - Parent 1']/parent::*/child::div/div[2]/div/div[2]/div/div"));
        Iterator<WebElement> iterator = elements.iterator();
        while (iterator.hasNext()) {
            WebElement elm  = iterator.next();
            if(elm.getText().equals(addressFor)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elm);
                break;
            }
        }
        return this;
    }
   /* public ParentsSiblingsPage selectAddressForParentTwo(String addressFor){
        this.addressForParentTwo.sendKeys(addressFor);
        return this;
    }*/
    public ParentsSiblingsPage selectAddressForParentTwo(String addressFor){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addressForParentTwo);
        List<WebElement> elements = driver.findElements(By.xpath("//legend[text()='Address/Contact Info - Parent 2']/parent::*/child::div/div[2]/div/div[2]/div/div"));
        Iterator<WebElement> iterator = elements.iterator();
        while (iterator.hasNext()) {
            WebElement elm  = iterator.next();
            if(elm.getText().equals(addressFor)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elm);
                break;
            }
        }
        return this;
    }

    public ParentsSiblingsPage keyInParentOneHomePhone(String homePhone){
        this.homePhoneOne.sendKeys(homePhone);
        return this;
    }

    public ParentsSiblingsPage keyInParentTwoHomePhone(String homePhone){
        this.homePhoneTwo.sendKeys(homePhone);
        return this;
    }

    public ParentsSiblingsPage keyInParentOneHomeFax(String homeFax){
        this.homeFaxOne.sendKeys(homeFax);
        return this;
    }

    public ParentsSiblingsPage keyInParentTwoHomeFax(String homeFax){
        this.homeFaxTwo.sendKeys(homeFax);
        return this;
    }

    public ParentsSiblingsPage keyInParentOneHomeCell(String homeCell){
        this.homeCellOne.sendKeys(homeCell);
        return this;
    }

    public ParentsSiblingsPage keyInParentTwoHomeCell(String homeCell){
        this.homeCellTwo.sendKeys(homeCell);
        return this;
    }

    public ParentsSiblingsPage keyInParentOneWorkPhone(String workPhone){
        this.workPhoneOne.sendKeys(workPhone);
        return this;
    }

    public ParentsSiblingsPage keyInParentTwoWorkPhone(String workPhone){
        this.workPhoneTwo.sendKeys(workPhone);
        return this;
    }

    public ParentsSiblingsPage keyInParentOneWorkFax(String workFax){
        this.workFaxOne.sendKeys(workFax);
        return this;
    }

    public ParentsSiblingsPage keyInParentTwoWorkFax(String workFax){
        this.workFaxTwo.sendKeys(workFax);
        return this;
    }

    public ParentsSiblingsPage keyInParentOneAddress(String address){
        this.parentOneAddress.sendKeys(address);
        return this;
    }

    public ParentsSiblingsPage keyInParentTwoAddress(String address){
        this.parentTwoAddress.sendKeys(address);
        return this;
    }

    public ParentsSiblingsPage keyInParentOneCity(String city){
        this.parentOneCity.sendKeys(city);
        return this;
    }

    public ParentsSiblingsPage keyInParentTwoCity(String city){
        this.parentTwoCity.sendKeys(city);
        return this;
    }

    public ParentsSiblingsPage keyInParentOneProvince(String province){
        this.parentOneProvince.sendKeys(province);
        return this;
    }

    public ParentsSiblingsPage keyInParentTwoProvince(String province){
        this.parentTwoProvince.sendKeys(province);
        return this;
    }

    public ParentsSiblingsPage selectParentOneCountry(String country){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",parentOneCountry);
        //List<WebElement> elements = driver.findElements(By.xpath("//selectize[@placeholder='Country']//following::div[@class='selectize-dropdown-content']//div[contains(@class,'option')]"));
        List<WebElement> elements = driver.findElements(By.xpath("//selectize[@placeholder='Country' and contains(@ng-model,'Address')]/parent::div/child::div/div[2]/div/div"));
        Iterator<WebElement> iterator = elements.iterator();
        while (iterator.hasNext()) {
            WebElement elm  = iterator.next();
            if(elm.getText().equals(country)) {
                js.executeScript("arguments[0].click();",elm);
                break;
            }
        }
        return this;
    }

    public ParentsSiblingsPage selectParentTwoCountry(String country){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", parentTwoCountry);
        List<WebElement> elements = driver.findElements(By.xpath("//selectize[@placeholder='Country' and contains(@ng-model,'Country2')]/parent::*/child::div/div[2]/div/div"));
        Iterator<WebElement> iterator = elements.iterator();
        while (iterator.hasNext()) {
            WebElement elm  = iterator.next();
            if(elm.getText().equals(country)) {
                js.executeScript("arguments[0].click();", elm);
                break;
            }
        }
        return this;
    }

    public ParentsSiblingsPage keyInParentOnePostalCode(String postalCode){
        this.parentOnePostCode.sendKeys(postalCode);
        return this;
    }

    public ParentsSiblingsPage keyInParentTwoPostalCode(String postalCode){
        this.parentTwoPostCode.sendKeys(postalCode);
        return this;
    }
    public ParentsSiblingsPage keyInParentOneSecondaryEmail(String secondaryEmail){
        this.parentOneSecondEmail.sendKeys(secondaryEmail);
        return this;
    }
    public ParentsSiblingsPage keyInParentTwoSecondaryEmail(String secondaryEmail){
        this.parentTwoSecondEmail.sendKeys(secondaryEmail);
        return this;
    }
    public ParentsSiblingsPage keyInNotes(String notes){
        this.notes.sendKeys(notes);
        return this;
    }
    public ParentsSiblingsPage checkCommunicateMother(){
        if(!communicateMother.isSelected()){
            communicateMother.click();
        }
        return this;
    }
    public ParentsSiblingsPage checkCommunicateFather(){
        if(!communicateFather.isSelected()){
            communicateFather.click();
        }
        return this;
    }
    public ParentsSiblingsPage checkCommunicateAgent(){
        if(!communicateAgent.isSelected()){
            communicateAgent.click();
        }
        return this;
    }
    public ParentsSiblingsPage searchSiblingsInfo(String siblings){
        this.siblingsInfo.sendKeys(siblings);
        this.siblingsSearch.click();
        return this;
    }

    public QuickEmailPage clickQuickEmailPrimaryOne(){
        this.quickEmailPrimaryOne.click();
        return new QuickEmailPage(driver);
    }
    public QuickEmailPage clickQuickEmailPrimaryTwo(){
        this.quickEmailPrimaryTwo.click();
        return new QuickEmailPage(driver);
    }
    public SiblingSearchPage clickSiblingsSearch(){
        this.siblingsSearch.click();
        return new SiblingSearchPage(driver);
    }

    public WebElement getLiveText() {
        return liveText;
    }
}

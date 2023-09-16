package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PIMPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//a[@href='/web/index.php/pim/viewPimModule']")
    WebElement pimButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")
    WebElement employeeNameSearch;

    @FindBy(xpath = "//label[text()='Employment Status']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']/div/div[@class='oxd-select-wrapper']")
    WebElement employeeStatusDropDown;

    @FindBy(xpath = "//label[text()='Sub Unit']/parent::div//following-sibling::div/div/div")
    WebElement subUnitDropDown;

    @FindBy(xpath = "//label[text()='Job Title']/parent::div//following-sibling::div/div/div")
    WebElement jobTitleDropDown;

    @FindBy(xpath = "//label[text()='Location']/parent::div//following-sibling::div/div/div")
    WebElement locationDropDown;

    @FindBy(xpath = "//label[text()='Nationality']/parent::div//following-sibling::div/div/div/div")
    WebElement nationalityDropDown;

    @FindBy(xpath = "//input[@value='1']")
    WebElement genderMale;
    @FindBy(xpath = "//input[@value='2']")
    WebElement genderFemale;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement addButton;

    @FindBy(name = "firstName")
    WebElement firstNameTextBox;

    @FindBy(name = "lastName")
    WebElement lastNameTextBox;

    @FindBy(xpath = "//label[text()='Employee Id']/parent::div/following-sibling::div//input[@class='oxd-input oxd-input--active']")
    WebElement idTextBox;

    @FindBy(xpath = "//button[text()=' Save ']")
    WebElement saveButton;

    @FindBy(xpath = "//h6[text()='PIM']")
    WebElement pageTitle;

    @FindBy(xpath = "//a[@href='/web/index.php/pim/viewJobDetails/empNumber/99']")
    WebElement jobButton;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//a[text()='Employee List']")
    WebElement employeeListButton;

    @FindBy(xpath = "//button[text()=' Search ']")
    WebElement searchButton;

    @FindBy(className = "oxd-userdropdown-tab")
    WebElement userDropDown;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")
    WebElement confirmDelete;
    public PIMPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickOnPimButton(){
        wait.until(ExpectedConditions.elementToBeClickable(pimButton));
        pimButton.click();
    }

    public void clickOnAddButton(){
        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        addButton.click();
    }

    public void clickOnSaveButton(){
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
    }

    public boolean pageTitleDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.isDisplayed();
    }

    public void setFirstNameTextBox(String firstName){
        wait.until(ExpectedConditions.visibilityOf(firstNameTextBox));
        firstNameTextBox.sendKeys(firstName);
    }

    public void setLastNameTextBox(String lastName){
        wait.until(ExpectedConditions.visibilityOf(lastNameTextBox));
        lastNameTextBox.sendKeys(lastName);
    }

    public void setEmployeeGender(String gender){

        if(gender.equalsIgnoreCase("Male")) {
            wait.until(ExpectedConditions.elementToBeClickable(genderMale));
            genderMale.click();
        }
        else{
            wait.until(ExpectedConditions.elementToBeClickable(genderFemale));
            genderFemale.click();
        }
    }

    public void clickOnJobButton(){
        wait.until(ExpectedConditions.elementToBeClickable(jobButton));
        jobButton.click();
    }

    public void setEmployeeStatusDropDown(String status) {
        wait.until(ExpectedConditions.elementToBeClickable(employeeStatusDropDown));
        employeeStatusDropDown.click();
        String statusXpath = String.format("//span[text()='%s']", status);
        WebElement statusSelection = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(statusXpath)));
        statusSelection.click();
    }

    public void setSubUnitDropDown(String unit) {
        wait.until(ExpectedConditions.elementToBeClickable(subUnitDropDown));
        subUnitDropDown.click();
        String unitXpath = String.format("//span[text()='%s']", unit);
        WebElement statusSelection = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(unitXpath)));
        statusSelection.click();
    }

    public void setJobTitleDropDown(String jobTitle) {
        wait.until(ExpectedConditions.elementToBeClickable(jobTitleDropDown));
        jobTitleDropDown.click();
        String jobTitleXpath = String.format("//span[text()='%s']", jobTitle);
        WebElement jobTitleSelection = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(jobTitleXpath)));
        jobTitleSelection.click();
    }

    public void setLocationDropDown(String location) {
        wait.until(ExpectedConditions.elementToBeClickable(locationDropDown));
        locationDropDown.click();
        String locationXpath = String.format("//span[text()='%s']", location);
        WebElement locationSelection = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locationXpath)));
        locationSelection.click();
    }

    public void setNationalityDropDown(String nationality) {
        wait.until(ExpectedConditions.elementToBeClickable(nationalityDropDown));
        nationalityDropDown.click();
        String nationalityXpath = String.format("//span[text()='%s']", nationality);
        WebElement nationalitySelection = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(nationalityXpath)));
        nationalitySelection.click();
    }
    public void clickOnSubmitButton(){
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();
    }

    public void clickOnEmployeeListButton(){
        wait.until(ExpectedConditions.elementToBeClickable(employeeListButton));
        employeeListButton.click();
    }


    public void clickOnSearchButton(){
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }

    public void setEmployeeNameSearch(String name){
        wait.until(ExpectedConditions.visibilityOf(employeeNameSearch));
        employeeNameSearch.sendKeys(name);
    }

    public boolean verifyEmployeeDisplayed(String name) throws InterruptedException {
        Thread.sleep(2000);
        String nameXpath = String.format("//div[text()='%s ']", name);
        try {
            WebElement nameSearchLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(nameXpath)));
            return nameSearchLabel.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public void setUserDropDownLogout(){
        wait.until(ExpectedConditions.elementToBeClickable(userDropDown));
        userDropDown.click();
        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/web/index.php/auth/logout']")));
        logout.click();
    }

    public void clickOnTrashIcon(){
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='oxd-icon bi-trash']/parent::button")));
        deleteButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmDelete));
        confirmDelete.click();
    }




}

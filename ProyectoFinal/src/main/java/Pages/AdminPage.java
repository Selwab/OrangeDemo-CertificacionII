package Pages;

import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AdminPage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "//a[@href='/web/index.php/admin/viewAdminModule']")
    WebElement adminButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/div/div[3]/div/i")
    WebElement sortComboBox;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/div/div[3]/div/div/ul/li[2]/span")
    WebElement sortDescendant;

    @FindBy(xpath = "//span[text()='Organization ']")
    WebElement organizationButton;

    @FindBy(xpath = "//button[text()=' Add ']")
    WebElement addButton;

    @FindBy(xpath = "//label[text()='Name']/parent::div/following-sibling::div/input")
    WebElement nameTextBox;

    @FindBy(className = "oxd-select-text-input")
    WebElement countryDropDown;

    @FindBy(xpath = "//button[text()=' Search ']")
    WebElement searchButton;

    @FindBy(xpath = "//label[text()='Name']/parent::div/following-sibling::div/input")
    WebElement searchNameTextBox;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")
    WebElement saveButton;
    public AdminPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clickOnAdminButton(){
        wait.until(ExpectedConditions.elementToBeClickable(adminButton));
        adminButton.click();
    }

    public void selectSortComboBox(String option) throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(sortComboBox));

        sortComboBox.click();
        wait.until(ExpectedConditions.visibilityOf(sortDescendant));
        sortDescendant.click();
    }

    public boolean areProductsInDescendantOrderByName(){
        List<WebElement> users = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()='Username']/following-sibling::div")));
        List<String> actualUserNames = new ArrayList<>();
        for( WebElement element: users){
            System.out.println("USER: " + element.getText());
            actualUserNames.add(element.getText());
        }
        boolean isSorted = Ordering.natural().reverse().isOrdered(actualUserNames);

        return isSorted;
    }

    public void clickOnLocationButton(){
        wait.until(ExpectedConditions.elementToBeClickable(organizationButton));
        organizationButton.click();
        WebElement locationButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Locations']")));
        locationButton.click();
    }

    public void clickAddButton(){
        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        addButton.click();
    }

    public void setNameTextBox(String name){
        wait.until(ExpectedConditions.visibilityOf(nameTextBox));
        nameTextBox.sendKeys(name);
    }

    public void setSearchNameTextBox(String name){
        wait.until(ExpectedConditions.visibilityOf(searchNameTextBox));
        searchNameTextBox.sendKeys(name);
    }

    public void setCountryDropDown(String country) {
        wait.until(ExpectedConditions.elementToBeClickable(countryDropDown));
        countryDropDown.click();
        String statusXpath = String.format("//span[text()='%s']", country);
        WebElement statusSelection = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(statusXpath)));
        statusSelection.click();
    }

    public void clickOnSearchButton(){
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }
    public void clickOnSaveButton(){
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
    }

}

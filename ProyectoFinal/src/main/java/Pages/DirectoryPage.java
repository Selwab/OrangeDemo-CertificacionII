package Pages;

import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DirectoryPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//a[@href='/web/index.php/directory/viewDirectory']")
    WebElement directoryButton;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-directory-card-header --break-words']")
    List<WebElement> employeesFonund;

    public DirectoryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void clickOnDirectoryButton(){
        wait.until(ExpectedConditions.elementToBeClickable(directoryButton));
        directoryButton.click();
    }


}

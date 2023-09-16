package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BuzzPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//textarea[@class='oxd-buzz-post-input']")
    WebElement textArea;

    @FindBy(xpath = "//button[text()=' Post ']")
    WebElement postButton;

    @FindBy(xpath = "//a[@href='/web/index.php/buzz/viewBuzz']")
    WebElement buzzButton;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-buzz-post-body-text']")
    List<WebElement> allPosts;
    public BuzzPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void setTextArea(String text){
        wait.until(ExpectedConditions.visibilityOf(textArea));
        textArea.sendKeys(text);
    }

    public void clickOnPostButton(){
        wait.until(ExpectedConditions.elementToBeClickable(postButton));
        postButton.click();
    }

    public void clickOnBuzzButton(){
        wait.until(ExpectedConditions.elementToBeClickable(buzzButton));
        buzzButton.click();
    }

    public boolean verifyPostIsUploaded(String text){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-buzz-post-body-text']")));

        if(allPosts.isEmpty()){
            return  false;
        }

        return allPosts.get(0).getText().equalsIgnoreCase(text);
    }

}

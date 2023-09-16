package StepDefinitions;

import Pages.BuzzPage;
import Utilities.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class BuzzSteps {
    BuzzPage buzzPage = new BuzzPage(DriverManager.getDriver().driver);

    @Given("I click on the Buzz button")
    public void clickOnBuzzButton(){
        buzzPage.clickOnBuzzButton();
    }

    @And("I fill the text area with {string}")
    public void fillTextArea(String text){
        buzzPage.setTextArea(text);
    }
    @And ("I click on the post button")
    public void clickOnSendButton(){
        buzzPage.clickOnPostButton();
    }
    @Then("I verify if the {string} post uploded correctly")
    public void verifyUpload(String text){
        Assertions.assertTrue(buzzPage.verifyPostIsUploaded(text));
    }


}

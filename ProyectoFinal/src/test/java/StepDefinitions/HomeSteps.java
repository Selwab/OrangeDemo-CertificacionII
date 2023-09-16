package StepDefinitions;

import Pages.HomePage;
import Utilities.DriverManager;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class HomeSteps {
    HomePage homePage = new HomePage(DriverManager.getDriver().driver);

    @Then("The home page should be displayed")
    public void verifyHomePageIsDisplayed() throws InterruptedException {
        Assertions.assertTrue(homePage.pageTitleDisplayed());
    }
}

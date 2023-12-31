package StepDefinitions;

import Pages.LoginPage;
import Utilities.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginSteps {
    LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);

    @Given("I set the user name field with {string}")
    public void setUserName(String userName){
        loginPage.setUserNameTextBox(userName);
    }

    @And("I set the password field with {string}")
    public void setPassword(String password){
        loginPage.setPasswordTextBox(password);
    }

    @When("I click on the login button")
    public void clickOnLoginButton() throws InterruptedException {
        loginPage.clickOnLoginButton();
    }
}

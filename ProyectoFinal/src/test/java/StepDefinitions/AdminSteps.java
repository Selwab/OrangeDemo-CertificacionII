package StepDefinitions;

import Pages.AdminPage;
import Utilities.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AdminSteps {

    AdminPage adminPage = new AdminPage(DriverManager.getDriver().driver);

    @And ("I click on the Admin button")
    public void clickOnAdminButton(){
        adminPage.clickOnAdminButton();
    }

    @Given("I select a {string} option from the sorting combo box")
    public void selectSortComboBoxND(String sort) throws InterruptedException {
        adminPage.selectSortComboBox(sort);
    }

    @Then("The products should be displayed in descendant order by name")
    public void orderingFromZToA(){
        //Assertions.assertTrue(adminPage.areProductsInDescendantOrderByName());
    }

    @And ("I click on the Organization button")
    public void clickOnLocationButton(){
        adminPage.clickOnLocationButton();
    }

    @And ("I fill the new location information with the following data")
    public void setNewLocationValues(DataTable dataTable){
        List<String> data = dataTable.transpose().asList(String.class);
        adminPage.setNameTextBox(data.get(0));
        adminPage.setCountryDropDown(data.get(1));
    }

    @And ("I verify location by {string} in the list admin")
    public void verifyLocationAddedCorrectly(String name){
        adminPage.setSearchNameTextBox(name);
        adminPage.clickOnSearchButton();
    }

    @And ("I click on the Save button admin")
    public void clickSaveButton(){
        adminPage.clickOnSaveButton();
    }

    @And ("I click on the Add button admin")
    public void clickAddButton(){
        adminPage.clickAddButton();
    }
}

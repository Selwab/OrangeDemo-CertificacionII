package StepDefinitions;

import Pages.PIMPage;
import Utilities.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class PIMSteps {
    PIMPage pimPage = new PIMPage(DriverManager.getDriver().driver);

    @Given ("I click on the PIM button")
    public void clickOnPIMButton(){
        pimPage.clickOnPimButton();
    }

    @And("I click on the Add button")
    public void clickOnAddButton(){
        pimPage.clickOnAddButton();
    }

    @Then ("I logout to orange demo page")
    public void logout(){
        pimPage.setUserDropDownLogout();
    }

    @And ("I fill the new employee information with the following data")
    public void fillEmployeeInformation(DataTable dataTable) throws InterruptedException {
        List<String> data = dataTable.transpose().asList(String.class);
        pimPage.setFirstNameTextBox(data.get(0));
        pimPage.setLastNameTextBox(data.get(1));
    }

    @And ("I click on the Save button")
    public void clickOnSaveButton() throws InterruptedException {
        pimPage.clickOnSaveButton();
    }

    @Then("The PIM page should be displayed")
    public void verifyHomePageIsDisplayed(){
        Assertions.assertTrue(pimPage.pageTitleDisplayed());
    }

    @Then ("I set the employee extra information with the following data")
    public void fillEmployeeExtraInformation(DataTable dataTable) throws InterruptedException {
        List<String> data = dataTable.transpose().asList(String.class);
        //pimPage.setEmployeeGender(data.get(0));
        pimPage.setNationalityDropDown(data.get(1));
    }

    @And ("I click on the Job button")
    public void clickOnJobButton(){
        pimPage.clickOnJobButton();
    }

    @And ("I set employees job information")
    public void setJobInformation(DataTable dataTable) throws InterruptedException {
        List<String> data = dataTable.transpose().asList(String.class);
        pimPage.setLocationDropDown(data.get(0));
        pimPage.setJobTitleDropDown(data.get(1));
        pimPage.setSubUnitDropDown(data.get(2));
        pimPage.setEmployeeStatusDropDown(data.get(3));
    }
    @Then ("I click on save button to submit information")
    public void clickOnSubmitButton(){
        pimPage.clickOnSubmitButton();
    }

    @Then ("I click on Employee List button")
    public void clickOnEployeeListButton(){
        pimPage.clickOnEmployeeListButton();
    }

    @And ("I verify employee by {string} in the list")
    public void searchEmployee(String name) throws InterruptedException {
        pimPage.setEmployeeNameSearch(name);
        pimPage.clickOnSearchButton();

        Assertions.assertTrue(pimPage.verifyEmployeeDisplayed(name));
    }

    //DELETE
    @Then ("I click delete button")
    public void clickOnDeleteButton(){
        pimPage.clickOnTrashIcon();
    }

    @And ("I verify employee {string} was deleted correctly")
    public void verifyEmployeeCorrectlyDeleted(String name) throws InterruptedException {
        Assertions.assertFalse(pimPage.verifyEmployeeDisplayed(name));
    }

}

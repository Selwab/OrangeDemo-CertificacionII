package StepDefinitions;

import Pages.DirectoryPage;
import Utilities.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

public class DirectorySteps {

    DirectoryPage directoryPage = new DirectoryPage(DriverManager.getDriver().driver);

    @And("click on the Directory button")
    public void clickOnDirectoryButton(){
        directoryPage.clickOnDirectoryButton();
    }
}

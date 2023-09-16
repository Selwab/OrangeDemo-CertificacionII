package StepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Given;

public class CommonSteps {
    @Given("I am in orange demo web page")
    public void goToSauceDemoPage(){
        DriverManager.getDriver().driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
        DriverManager.getDriver().driver.manage().window().maximize();
    }

    @AfterAll
    public static void afterScenario(){
        DriverManager.getDriver().driver.close();
    }
}

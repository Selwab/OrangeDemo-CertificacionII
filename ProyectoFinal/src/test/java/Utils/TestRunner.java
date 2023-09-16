package Utils;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/", //direccion de carpeta
        glue = {"StepDefinitions"},
        //tags = "@AddEmployee"
        //tags = "@DeleteEmployee"
        //tags = "@AddPost"
        //tags = "@AddLocation"
        //tags = "@VerifyAdminDescendantSortByName"
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class TestRunner {
}

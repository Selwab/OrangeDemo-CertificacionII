package stepDefinitions;


import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import Utilities.DriverManager;
import Utils.ScreenRecorderUtil;

public class Hooks {

    @Before
    public void beforeTest() throws Exception {
        ScreenRecorderUtil.startRecord("main");
    }

    @After
    public void afterTest() throws Exception {
        ScreenRecorderUtil.stopRecord();
    }

    @AfterAll
    public static void afterScenario(){
        DriverManager.getDriver().driver.close();
    }
}
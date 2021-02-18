package de.amazon.stepdefinitions;


import de.amazon.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {

    @Before
    public void setUp(){

    }

    /**
     * This method runs after every scenario and takes a screenshot if a step fails
     * @param scenario
     */
    @After()
    public void tearDown(Scenario scenario){
        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        if(scenario.isFailed()){
            scenario.attach(screenshot,"image/png", "screenshots");
        }
        Driver.closeDriver();
    }


}

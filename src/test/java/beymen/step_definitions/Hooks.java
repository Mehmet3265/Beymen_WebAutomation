package beymen.step_definitions;

import beymen.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @After
    public void tearDown(Scenario scenario){

        //if scenario fails, it takes screenshot
        if (scenario.isFailed()){
            byte[] screenshot = ( (TakesScreenshot) Driver.getDriver() ).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        //Driver.closeDriver();

    }

}

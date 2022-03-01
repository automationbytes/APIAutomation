package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features = "src/test/java/Features/firstget.feature",
		glue = {"StepDefn"},
		plugin = {"pretty","html: cucumber_reports/reports.html"},
		publish = true
		)


public class TestRunner {

}

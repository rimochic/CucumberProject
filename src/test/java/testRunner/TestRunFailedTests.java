package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
			(
				features = "@target/failedrerun.txt",
				glue = "stepDefinitions",
				monochrome = true,
				plugin = {"pretty", "html:target/reports.html", 
						"rerun:target/failedrerun.txt"}
			)
public class TestRunFailedTests {

}

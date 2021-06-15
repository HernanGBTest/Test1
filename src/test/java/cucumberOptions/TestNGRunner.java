package cucumberOptions;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/features",
		glue="stepDefinitions")
public class TestNGRunner extends AbstractTestNGCucumberTests {
	

}

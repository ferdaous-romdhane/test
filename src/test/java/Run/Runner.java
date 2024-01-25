package Run;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		tags="",
		features="src/test/features/Test1",
		glue="Test1",
		publish=true,
		plugin={"pretty","html:target/cucumber-report.html","json:target/cucumber-report"}
		
		)

public class Runner {

}

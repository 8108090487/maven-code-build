package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json"},
        monochrome = true
)
public class testrunner01 {
}
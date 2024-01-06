package StepDefinitions;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Dell\\eclipse-workspace\\CucumberJava\\src\\test\\resources\\Features\\React JS.feature", glue = "StepDefinitions")
public class TestRunner {
}
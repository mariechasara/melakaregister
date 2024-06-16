package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions", "hooks"},
        plugin = {"pretty", "html:reports/reports.html","json:reports/report.json"},
        monochrome = true
)
public class Runner extends AbstractTestNGCucumberTests {
}
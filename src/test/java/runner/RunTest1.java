package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)

@CucumberOptions(plugin = {"pretty", "html:target/cucumber-reports1/cucumber-pretty",
        "json:target/cucumber-reports/CucumberTestReport1.json",
        "rerun:target/cucumber-reports1/rerun.txt",
        "com.cucumber.listener.ExtentCucumberFormatter:target/extent.html",
        "json:target/json-report1/cucumber.json"},
        glue = "",
        features = "src/test/resources/",
        dryRun = false,
        tags = {"@vvvv"},

        monochrome = true)
public class RunTest1 extends AbstractTestNGCucumberTests {
};

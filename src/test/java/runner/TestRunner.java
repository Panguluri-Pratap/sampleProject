package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "steps",
        plugin = {
                "pretty",
                "html:target/CucumberReport.html",
                "json:target/cucumber.json"
        },
        monochrome = true,
        tags = "@elementdragging"
)
public class TestRunner extends AbstractTestNGCucumberTests {

}

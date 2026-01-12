package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import utils.DriverFactory;

@CucumberOptions(
        features = "src/test/java/features",
        glue = {"steps", "hooks"},
        plugin = {
                "pretty",
                "html:target/CucumberReport.html",
                "json:target/cucumber.json"
        },
        monochrome = true
        //tags= "@browseWindows"
       // tags = "@browseWindows or @alert or  @frame or @Test or @Test1 or @Hello or @StudentRegistration or @StudentRegister or @StudentLogin or @allItems or @dragAndDrop or @elementdragging or @dropdown "
)
public class TestRunner extends AbstractTestNGCucumberTests {

}

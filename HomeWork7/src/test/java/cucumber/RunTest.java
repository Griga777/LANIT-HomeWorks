package cucumber;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/java/cucumber/featuresFile",
        glue = "cucumber.steps",
        //tags = "@1 or @2 or @3 or @4"
        tags = "@1"
)

public class RunTest extends AbstractTestNGCucumberTests {

    public static void run(String[] args) {

    }
}

package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(

        features = {"src/test/java/FeatureFiles/_01_Login.feature",
                "src/test/java/FeatureFiles/_02_Country.feature"
        },
        glue = {"StepDefinitions"},
        dryRun = false  // true oldugunda testi calıstırmaz
                        // sadece feature lara ait steplerin
                        // varlıgını kontrol eder


)


public class _02_TestRunnerBelirliFeaturelar extends AbstractTestNGCucumberTests {

}

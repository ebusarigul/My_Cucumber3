package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(   // or oldugunda herhangi bir tanesi varsa calıstırır
                    // and oldugunda her ikisininde senaryoda tag olarak olan senaryoları calıstırır

        tags = "@Regression or @SmokeTest",       // hangi senaryolarda bu etiket varsa onlar calıstırılacak...
        features = {"src/test/java/FeatureFiles/"},
        glue = {"StepDefinitions"}


)


public class _05_TestRunnerRegression extends AbstractTestNGCucumberTests {
}     // Browser tipi vermek için, rapora ek parametre eklemek için sonra kullanacagız

package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="src/test/resources/Features/CostcoSouthwest.feature", // tells cucumber options where our feature files are kept
		glue = {"stepDefinitions"}, // tells cucumber options where all Step Definitions class are kept 
		//tags = {"@test3"}, // we can run all scenarios or any some scenario that we need with the help of tags 
		dryRun = false, // sets to false, will check if all steps in scenario has their mapped step definitions 
		monochrome = true, // if set to true, will make console output more readable 
		//strict =false, // if set to false, will fail the execution if there are any pending or undefined steps
		plugin = {"pretty", 		        
				"html:target/cucumber-reports/cucumber-pretty",
		        "json:target/cucumber-reports/CucumberTestReport.json",
		        "rerun:target/cucumber-reports/rerun.txt",
		        "json:target/cucumber-reports/CucumberTestReport.json"}
		)



public class TestRunner {

}

package org.sampleOne;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\ELCOT\\eclipse-workspace\\CucumberProject\\src\\test\\resources\\Feature\\feautreAdactin.feature", glue = "org.stepone")
public class CucumberProject {

}

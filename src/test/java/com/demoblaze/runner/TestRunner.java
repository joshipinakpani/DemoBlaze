package com.demoblaze.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
glue = "com.demoblaze.stepdef",
dryRun = false,
plugin = {"pretty", "html:reports/htmlreport.html"})
public class TestRunner {

}

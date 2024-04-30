package com.example.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@BRtest", features = {"src/test/resources/features/MyApplication.feature"}, glue = {"Cucumber_testng"},
plugin = {"html:target/cucumber-html-report"})
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {

}

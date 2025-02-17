package br.com.powerprogramers.customer_ms.bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "br.com.powerprogramers.customer_ms.bdd",
    plugin = {"pretty", "json:target/cucumber-report.json"})
public class CucumberTest {}

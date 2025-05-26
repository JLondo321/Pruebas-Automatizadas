package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/busqueda_bolsas.feature",
        glue = "stepsDefinition",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/html",
                "json:target/cucumber-reports/json/Cucumber.json",
                "junit:target/cucumber-reports/junit/Cucumber.xml"
        },
        tags = "@busqueda_bolsas"
)
public class BusquedaBolsasRunner {
}
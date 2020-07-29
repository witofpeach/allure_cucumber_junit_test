import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"src/main/java/ru/appline/stepdefs/"},
        features = {"src/test/resources/"},
        tags = {"@testMortgageResults"}
)
public class CucumberRunner {}

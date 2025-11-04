package tcs.challenge.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;;
import net.thucydides.core.reports.html.HtmlAggregateStoryReporter;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.Collections;
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/table_multiples_icons.feature",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = "tcs.challenge.stepdefinitions",
        tags = "@testQAOrange"
)
public class TestRunner {

    @AfterClass
    public static void generateReport() {
        try {
            System.out.println("🧾 Generando reporte Serenity HTML...");

            // Ruta donde Serenity guarda los JSON
            File outputDirectory = new File("target/site/serenity");

            HtmlAggregateStoryReporter reporter =
                    new HtmlAggregateStoryReporter("Serenity Report");

            reporter.setOutputDirectory(new File("target/site/serenity"));
            reporter.generateReportsForTestResultsFrom(outputDirectory);

            System.out.println("Reporte Serenity generado en: target/site/serenity/index.html");

        } catch (Exception e) {
            System.err.println("Error generando el reporte Serenity: " + e.getMessage());
        }
    }
}

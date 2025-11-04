package tcs.challenge.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Text;
import tcs.challenge.models.Login.LoginModel;
import tcs.challenge.navigation.NavigateTo;
import tcs.challenge.questions.CodeHash.Code;
import tcs.challenge.tasks.Login.Login;
import tcs.challenge.tasks.TableIcons.CountAndEnterEmoji;
import tcs.challenge.tasks.TableMultiples.SelectMultiples;
import tcs.challenge.ui.TableIconsPage.TableIconsPage;
import tcs.challenge.util.GetInfoFromTable;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class TableMultipleIconsStepDefinitions {

    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("enter the Evelart web portal")
    public void enter_the_evelart_web_portal(DataTable userLogin) {
        LoginModel loginModel = GetInfoFromTable.getLoginCredentials(userLogin);
        OnStage.theActorCalled("user").attemptsTo(
                NavigateTo.loginPage(),
                new Login(loginModel.getUsername(), loginModel.getPassword())
        );
    }
    @When("select the correct button to obtain the hash code.")
    public void select_the_correct_button_to_obtain_the_hash_code() {

        Actor actor = OnStage.theActorInTheSpotlight();

        for (int i = 1; i <= 10; i++) {
            OnStage.theActorInTheSpotlight().attemptsTo(
                    CountAndEnterEmoji.now(),
                    SelectMultiples.now(),
                    Scroll.to(TableIconsPage.SUBMIT_BUTTON),
                    Click.on(TableIconsPage.SUBMIT_BUTTON)
            );

            try {
                System.out.println("⏳ Esperando 10 segundos antes del siguiente ciclo...");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("⚠️ La espera fue interrumpida: " + e.getMessage());
            }
            String finalHashCode = Text.of(TableIconsPage.HASH_CODE).answeredBy(actor);
            actor.remember("final_hash_code", finalHashCode); // Guarda con un nombre significativo

        }
        System.out.println("✅ Proceso completado con éxito en los 10 ciclos.");

    }
    @Then("verify that the hash code is correct")
    public void verify_that_the_hash_code_is_correct() {
        Actor actor = OnStage.theActorInTheSpotlight();
        String finalHashCode = actor.recall("final_hash_code");

        Serenity.reportThat("The final hash code is: " + finalHashCode,
                () -> {} // No necesitamos acción real aquí
        );
        actor.should(
                seeThat("Code hash", Code.validateHashCode(),equalTo(finalHashCode))

        );
    }
}



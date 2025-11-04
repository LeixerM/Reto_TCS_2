package tcs.challenge.questions.TableMultiples;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import tcs.challenge.ui.TableMultiplesPage.TableMultiplePage;

import java.util.List;

public class CheckboxesList implements Question<List<WebElementFacade>> {
    @Override
    public List<WebElementFacade> answeredBy(Actor actor) {
        List<WebElementFacade> elements = TableMultiplePage.ALL_CHECKBOXES.resolveAllFor(actor);
        System.out.println("[CheckboxesList] Se encontraron " + elements.size() + " checkboxes.");
        return elements;
    }
    public static CheckboxesList onPage() {
        return new CheckboxesList();
    }
}

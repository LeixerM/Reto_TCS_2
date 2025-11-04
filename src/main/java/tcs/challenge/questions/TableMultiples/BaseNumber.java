package tcs.challenge.questions.TableMultiples;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import tcs.challenge.ui.TableMultiplesPage.TableMultiplePage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseNumber implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        String paragraph = Text.of(TableMultiplePage.PARAGRAPH_BASE_NUMBER).answeredBy(actor).trim();
        System.out.println("[BaseNumber] Texto leído: " + paragraph);

        Pattern pattern = Pattern.compile("multipl(?:o|ó)s?\\s+de\\s+(\\d+)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(paragraph);

        if (matcher.find()) {
            int base = Integer.parseInt(matcher.group(1));
            System.out.println("[BaseNumber] Número base detectado: " + base);
            return base;
        } else {
            System.out.println("[BaseNumber] No se encontró número base. Se devuelve 0.");
            return 0;
        }
    }

    public static BaseNumber fromPage() {
        return new BaseNumber();
    }
}


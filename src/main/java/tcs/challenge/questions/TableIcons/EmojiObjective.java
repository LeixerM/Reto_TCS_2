package tcs.challenge.questions.TableIcons;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import tcs.challenge.ui.TableIconsPage.TableIconsPage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiObjective implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        // Obtener el texto visible del primer párrafo
        String instructionText = Text.of(TableIconsPage.INSTRUCTION_PARAGRAPH).answeredBy(actor).trim();

        // Normalizar espacios
        String normalized = instructionText.replaceAll("\\s+", " ").trim();

        // Regex simple: capturar lo que está entre "cuantos" y "hay"
        Pattern pattern = Pattern.compile(".*cuantos\\s*(.*?)\\s*hay.*", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher matcher = pattern.matcher(normalized);

        String emoji = "";
        if (matcher.matches()) {
            emoji = matcher.group(1).trim();
        }

        // En caso de no encontrar, dejar vacío (el Task puede manejar errores si es necesario)
        System.out.println("[EmojiObjective] Texto instrucción: \"" + normalized + "\" -> Emoji detectado: \"" + emoji + "\"");
        return emoji;
    }

    public static EmojiObjective displayed() {
        return new EmojiObjective();
    }
}
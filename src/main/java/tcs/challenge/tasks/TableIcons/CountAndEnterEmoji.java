package tcs.challenge.tasks.TableIcons;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import tcs.challenge.questions.TableIcons.EmojiObjective;
import tcs.challenge.questions.TableIcons.EmojiSequence;
import tcs.challenge.ui.TableIconsPage.TableIconsPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CountAndEnterEmoji implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        // 1. Obtener emoji objetivo y secuencia usando Questions
        String emoji = actor.asksFor(EmojiObjective.displayed());
        String sequence = actor.asksFor(EmojiSequence.displayed());

        if (emoji == null || emoji.isEmpty()) {
            System.out.println("[CountAndEnterEmoji] No se detectó emoji objetivo en la instrucción.");
            // Opcional: podríamos lanzar una excepción o fallar la tarea, según política de tests.
            // throw new RuntimeException("No emoji objetivo detectado");
            return;
        }

        if (sequence == null) sequence = "";

        // 2. Contar ocurrencias del emoji en la secuencia
        int count = countOccurrences(sequence, emoji);

        System.out.println("[CountAndEnterEmoji] Emoji: \"" + emoji + "\" -> count = " + count);

        // 3. Escribir el número en el input
        actor.attemptsTo(
                Enter.theValue(String.valueOf(count)).into(TableIconsPage.NUMBER_INPUT)
        );
        System.out.println("*********************************************" + count);
    }

    // Método helper: cuenta ocurrencias no solapadas de 'sub' dentro de 'text'
    private int countOccurrences(String text, String sub) {
        if (sub.isEmpty() || text.isEmpty()) return 0;
        int count = 0;
        int idx = 0;
        while (true) {
            idx = text.indexOf(sub, idx);
            if (idx != -1) {
                count++;
                idx += sub.length(); // avanzar por la longitud del emoji (evita solapamiento)
            } else {
                break;
            }
        }
        return count;
    }

    public static CountAndEnterEmoji now() {
        return instrumented(CountAndEnterEmoji.class);
    }
}
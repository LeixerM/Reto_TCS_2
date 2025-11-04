package tcs.challenge.questions.TableIcons;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import tcs.challenge.ui.TableIconsPage.TableIconsPage;

import java.util.Queue;

public class EmojiSequence implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        String sequence = Text.of(TableIconsPage.SEQUENCE_PARAGRAPH).answeredBy(actor).trim();
        System.out.println("[EmojiSequence] Secuencia obtenida: \"" + sequence + "\"");
        return sequence;
    }

    public static EmojiSequence displayed() {
        return new EmojiSequence();
    }
}
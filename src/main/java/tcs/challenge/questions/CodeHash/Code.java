package tcs.challenge.questions.CodeHash;

import net.serenitybdd.screenplay.Question;
import tcs.challenge.ui.TableIconsPage.TableIconsPage;

public class Code {

    public static Question<String> validateHashCode(){
        return actor -> TableIconsPage.HASH_CODE.resolveFor(actor).getText().trim();
    }
}

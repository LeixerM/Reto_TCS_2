package tcs.challenge.ui.TableIconsPage;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TableIconsPage {




    public static final Target INSTRUCTION_PARAGRAPH = Target.the("párrafo de instrucción con el emoji objetivo")
            .located(By.xpath("(//p[contains(@class,'text-center text-xl')])[1]"));

    public static final Target SEQUENCE_PARAGRAPH = Target.the("párrafo que contiene la secuencia de emojis")
            .located(By.xpath("(//p[contains(@class,'text-center text-xl')])[2]"));


    public static final Target NUMBER_INPUT = Target.the("campo input para ingresar el número total")
            .located(By.xpath("//input[@type='number']"));

    public static final Target SUBMIT_BUTTON = Target.the("Submit button")
            .locatedBy("//button[contains(text(),'Enviar')]");

    public static final Target HASH_CODE = Target.the("Text hashs code")
            .located(By.xpath("/html/body/div/div/div/p"));

}

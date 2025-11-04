package tcs.challenge.ui.TableMultiplesPage;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TableMultiplePage {

    public static final Target PARAGRAPH_BASE_NUMBER = Target.the("párrafo con la instrucción del número base")
            .located(By.xpath("(//p[contains(@class,'text-center text-xl')])[3]"));

    public static final Target ALL_CHECKBOXES = Target.the("todos los checkboxes")
            .located(By.cssSelector("input[name='checkbox']"));

}

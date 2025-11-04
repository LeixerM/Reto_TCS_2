package tcs.challenge.ui.Login;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target INPUT_USERNAME = Target.the("username input").located(By.name("username"));
    public static final Target INPUT_PASSWORD = Target.the("password input").located(By.name("password"));
    public static final  Target BUTTON_LOG_IN = Target.the("login button").located(By.xpath("//button[@type='submit']"));


    ///Locators New URL verify message hash code

    // Campo blanco donde pegar el hash (ajusta el selector si es diferente)
    public static final Target INPUT_HASH = Target.the("campo para pegar el hash")
            .located(By.xpath("//pre[@class=' CodeMirror-line ']"));

    // Botón "Validar"
    public static final Target BUTTON_VALIDATE = Target.the("botón validar")
            .located(By.xpath("//button[@class='btn btn-success btn-sm']"));

    // Mensaje resultado (ajusta el selector si tu página lo muestra en otro elemento)
    public static final Target RESULT_MESSAGE = Target.the("mensaje resultado")
            .located(By.cssSelector("div.result, div.alert, #result, .message"));
}

package task;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import userInterface.BaseUI;

public class BuscarGoogleBasicTask implements Task {

    public static Performable buscar() {
        return Tasks.instrumented(BuscarGoogleBasicTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue("Pingüino").into(BaseUI.INP_BUSCAR).thenHit(Keys.ENTER)
                // Opcional: Click.on(BaseUI.BTN_BUSCAR) si el botón es funcional
        );
    }
}

package interaction;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import userInterface.BaseUI;

public class NavigateTo {
    public static Performable page() {
        return Task.where("{0} Abre pagina principal del Portal",
                Open.browserOn().the(BaseUI.class));
                }
}

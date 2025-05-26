package userInterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

//URL que se requiere automatizar
@DefaultUrl("https://www.google.com")
public class BaseUI extends PageObject {

    public static final Target INP_BUSCAR = Target.the("barra de búsqueda")
            .located(By.name("q"));

    public static final Target BTN_BUSCAR = Target.the("botón buscar")
            .located(By.name("btnK"));

    public static final Target BTN_LOGO = Target.the("logo de Google")
            .located(By.id("hplogo"));

    public static final Target RESULTADOS = Target.the("resultados de búsqueda")
            .located(By.id("search"));
}
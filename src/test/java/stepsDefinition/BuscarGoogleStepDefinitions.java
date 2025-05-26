package stepsDefinition;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.core.pages.WebElementState;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.targets.Target;
import org.hamcrest.Matcher;
import task.BuscarGoogleBasicTask;
import userInterface.BaseUI;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class BuscarGoogleStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("Ingresa a google")
    public void ingresaAGoogle() {
        OnStage.theActorCalled("Usuario").wasAbleTo(
                Open.browserOn().the(BaseUI.class)
        );
    }

    @When("Ingrese lo que quiere buscar")
    public void ingreseLoQueQuiereBuscar() {
        theActorInTheSpotlight().attemptsTo(
                BuscarGoogleBasicTask.buscar()
        );
    }







}

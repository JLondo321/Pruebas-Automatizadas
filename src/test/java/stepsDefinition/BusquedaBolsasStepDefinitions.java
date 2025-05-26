package stepsDefinition;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import task.BuscarBolsasTask;
import userInterface.ValidarResultadosBusqueda;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class BusquedaBolsasStepDefinitions {

    @Managed(uniqueSession = true)
    public WebDriver suNavegador;

    private Actor usuario;
    private String ultimaUrlVisitada;

    @Before
    public void configurarActor() {
        usuario = Actor.named("Usuario")
                .whoCan(BrowseTheWeb.with(suNavegador));
    }

    @Given("que el usuario está en la página principal de Bolsas y Empaques Colombia")
    public void queElUsuarioEstaEnLaPaginaPrincipal() {
        usuario.attemptsTo(
                Open.url("https://www.bolsasyempaquescolombia.com/")
        );
        ultimaUrlVisitada = "https://www.bolsasyempaquescolombia.com/";
    }



    @When("el usuario busca {string}")
    public void elUsuarioBusca(String terminoBusqueda) {
        usuario.attemptsTo(
                BuscarBolsasTask.conTermino(terminoBusqueda)
        );
    }



    @When("el usuario realiza una búsqueda vacía")
    public void elUsuarioRealizaUnaBusquedaVacia() {
        usuario.attemptsTo(
                BuscarBolsasTask.busquedaVacia()
        );
    }

    @Then("debería ver resultados de búsqueda")
    public void deberiaVerResultadosDeBusqueda() {
        usuario.should(
                seeThat("Los resultados de búsqueda son visibles",
                        ValidarResultadosBusqueda.sonVisibles(), is(true))
        );
    }

    @Then("debería ver productos relacionados con {string}")
    public void deberiaVerProductosRelacionadosCon(String termino) {
        usuario.should(
                seeThat("Hay productos en los resultados",
                        ValidarResultadosBusqueda.hayProductos(), is(true)),
                seeThat("El título contiene el término buscado",
                        ValidarResultadosBusqueda.contieneTérmino(termino), is(true))
        );
    }



    @Then("debería ver al menos {int} productos en los resultados")
    public void deberiaVerAlMenosProductosEnLosResultados(int cantidadMinima) {
        usuario.should(
                seeThat("La cantidad de productos es mayor o igual a " + cantidadMinima,
                        ValidarResultadosBusqueda.contarProductos(),
                        greaterThanOrEqualTo(cantidadMinima))
        );
    }


    @And("no debería ver mensaje de sin resultados")
    public void noDeberiaVerMensajeDeSinResultados() {
        usuario.should(
                seeThat("No hay mensaje de sin resultados",
                        ValidarResultadosBusqueda.noHayResultados(), is(false))
        );
    }

    @Then("el sistema debería manejar la búsqueda apropiadamente")
    public void elSistemaDeberiaManejarLaBusquedaApropiadamente() {
        // Verificar que o hay resultados o hay mensaje de sin resultados
        boolean hayResultados = ValidarResultadosBusqueda.sonVisibles().answeredBy(usuario);
        boolean hayMensajeSinResultados = ValidarResultadosBusqueda.noHayResultados().answeredBy(usuario);

        usuario.should(
                seeThat("El sistema maneja la búsqueda apropiadamente",
                        actor -> hayResultados || hayMensajeSinResultados, is(false))
        );
    }
}
package task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.waits.WaitUntil;
import question.ElementoPresente;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
public class BuscarBolsasTask implements Task {
    private String terminoBusqueda;
    private boolean esperarResultados;
    public BuscarBolsasTask(String terminoBusqueda) {
        this.terminoBusqueda = terminoBusqueda;
        this.esperarResultados = true;
    }
    public static BuscarBolsasTask conTermino(String termino) {
        return instrumented(BuscarBolsasTask.class, termino);
    }
    public BuscarBolsasTask sinEsperarResultados() {
        this.esperarResultados = false;
        return this;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ElementoPresente.CAMPO_BUSQUEDA, isVisible())
                        .forNoMoreThan(10).seconds()
        );
        if (terminoBusqueda != null && !terminoBusqueda.isEmpty()) {
            actor.attemptsTo(
                    Clear.field(ElementoPresente.CAMPO_BUSQUEDA),
                    Enter.theValue(terminoBusqueda)
                            .into(ElementoPresente.CAMPO_BUSQUEDA)
            );
        }
        actor.attemptsTo(
                Click.on(ElementoPresente.BOTON_BUSCAR)
        );
        if (esperarResultados) {
            try {
                actor.attemptsTo(
                        WaitUntil.the(ElementoPresente.CONTENEDOR_RESULTADOS, isVisible())
                                .forNoMoreThan(15).seconds()
                );
            } catch (Exception e) {
                actor.attemptsTo(
                        WaitUntil.the(ElementoPresente.MENSAJE_SIN_RESULTADOS, isVisible())
                                .forNoMoreThan(5).seconds()
                );
            }
        }
    }

    // Métodos estáticos para casos específicos
    public static Task busquedaSimple(String termino) {
        return new BuscarBolsasTask(termino);
    }
    public static Task busquedaVacia() {
        return new BuscarBolsasTask("").sinEsperarResultados();
    }
}
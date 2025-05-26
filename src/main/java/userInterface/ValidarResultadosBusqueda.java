package userInterface;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.questions.Value;
import question.ElementoPresente;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.util.List;

public class ValidarResultadosBusqueda {

    public static Question<Boolean> sonVisibles() {
        return actor -> Visibility.of(ElementoPresente.CONTENEDOR_RESULTADOS)
                .answeredBy(actor);
    }

    public static Question<Boolean> hayProductos() {
        return actor -> Visibility.of(ElementoPresente.PRODUCTOS_RESULTADO)
                .answeredBy(actor);
    }

    public static Question<String> obtenerTituloResultados() {
        return actor -> Text.of(ElementoPresente.TITULO_RESULTADO)
                .answeredBy(actor);
    }

    public static Question<Boolean> noHayResultados() {
        return actor -> Visibility.of(ElementoPresente.MENSAJE_SIN_RESULTADOS)
                .answeredBy(actor);
    }



    public static Question<Boolean> contieneTérmino(String termino) {
        return actor -> {
            String titulo = Text.of(ElementoPresente.TITULO_RESULTADO).answeredBy(actor);
            return titulo != null && titulo.toLowerCase().contains(termino.toLowerCase());
        };
    }

    public static Question<Boolean> hayPaginacion() {
        return actor -> Visibility.of(ElementoPresente.PAGINACION)
                .answeredBy(actor);
    }

    public static Question<Integer> contarProductos() {
        return actor -> ElementoPresente.PRODUCTOS_RESULTADO
                .resolveAllFor(actor)
                .size();
    }

    // This is for the "Búsqueda con campo vacío" fix
    public static final Target EMPTY_STATE_MESSAGE_CONTAINER = Target.the("Contenedor de mensaje de estado vacío")
            .located(By.cssSelector(".empty-state")); // This selector was confirmed from your screenshot

}
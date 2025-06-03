package userInterface;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.*;
import question.ElementoPresente;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
public class ValidarResultadosBusqueda {
    public static final Target FIRST_PRODUCT_ITEM = Target.the("primer producto de la lista")
            .located(By.cssSelector(".product-list .product-item:first-child"));
    public static final Target ADD_TO_CART_BUTTON = Target.the("botón Añadir al carrito")
            .located(By.cssSelector("button[data-action='add-to-cart']")); //
    public static final Target CART_ICON_LINK = Target.the("enlace del icono del carrito")
            .located(By.cssSelector("a.header__cart-toggle[data-action='toggle-mini-cart']")); //
    public static final Target CART_ICON_COUNT = Target.the("icono de cantidad del carrito")
            .located(By.cssSelector("form.mini-cart[data-item-count]")); // Common selector, verify this!
    public static final Target PRODUCT_DETAIL_PAGE_TITLE = Target.the("título de la página de detalle del producto")
            .located(By.cssSelector("h1.product-meta__title.heading"));
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

    public static Question<Integer> cartItemCount() {
        return actor -> {
            String countString = Attribute.of(CART_ICON_LINK)
                    .named("data-item-count")
                    .answeredBy(actor);  // Obtener el atributo real

            try {
                return Integer.parseInt(countString);
            } catch (NumberFormatException e) {
                return 0;  // Si no es número válido, devolver 0
            }
        };
    }
        public static Question<String> es() {
            return new Question<String>() {
                @Override
                public String answeredBy(Actor actor) {
                    return BrowseTheWeb.as(actor).getDriver().getCurrentUrl();
                }
            };
        }
    public static final Target EMPTY_STATE_MESSAGE_CONTAINER = Target.the("Contenedor de mensaje de estado vacío")
            .located(By.cssSelector(".empty-state"));
}
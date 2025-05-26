package question;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ElementoPresente {

    // Elementos de la barra de búsqueda
    public static final Target FORMULARIO_BUSQUEDA = Target.the("Formulario de búsqueda")
            .located(By.cssSelector("form[action='/search'][role='search']"));

    public static final Target CAMPO_BUSQUEDA = Target.the("Campo de búsqueda")
            .located(By.cssSelector("input[name='q'][type='text']"));

    public static final Target BOTON_BUSCAR = Target.the("Botón buscar")
            .located(By.cssSelector("button[type='submit'][aria-label='Buscar']"));



    // Elementos de resultados de búsqueda
// Example
    public static Target CONTENEDOR_RESULTADOS = Target.the("Contenedor de resultados")
            .located(By.cssSelector(".product-list.product-list--collection"));
    public static final Target PRODUCTOS_RESULTADO = Target.the("Productos en resultados")
            .located(By.cssSelector(".product-item, .collection-item, .grid-item"));

    public static final Target TITULO_RESULTADO = Target.the("Título de resultado de búsqueda")
            .located(By.cssSelector("h1, .page-title, .collection-title"));

    public static final Target MENSAJE_SIN_RESULTADOS = Target.the("Mensaje sin resultados")
            .located(By.cssSelector(".no-results, .empty-search, .search-empty, empty-state"));

    public static final Target NUMERO_RESULTADOS = Target.the("Número de resultados")
            .located(By.cssSelector(".results-count, .search-count"));

    // Elementos de paginación
    public static final Target PAGINACION = Target.the("Navegación de páginas")
            .located(By.cssSelector(".pagination, .page-navigation"));

    public static final Target SIGUIENTE_PAGINA = Target.the("Siguiente página")
            .located(By.cssSelector(".pagination .next, .page-next"));



}
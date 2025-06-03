# language: es
@busqueda_bolsas
Característica: Búsqueda de Bolsas en Bolsas y Empaques Colombia
  Como un cliente de Bolsas y Empaques Colombia
  Quiero poder buscar productos de bolsas en el sitio web
  Para encontrar fácilmente los productos que necesito

  Antecedentes:
    Dado que el usuario está en la página principal de Bolsas y Empaques Colombia

  @busqueda_simple @smoke
  Escenario: Búsqueda simple de bolsas
    Cuando el usuario busca "bolsas"
    Entonces debería ver resultados de búsqueda
    Y debería ver productos relacionados con "bolsas"
    Y debería ver al menos 1 productos en los resultados
    Y no debería ver mensaje de sin resultados

  @busqueda_compleja @regression
  Escenario: Búsqueda compleja con validaciones avanzadas
    Cuando el usuario busca "bolsas plasticas"
    Entonces debería ver resultados de búsqueda
    Y debería ver productos relacionados con "bolsas"
    Y debería ver al menos 5 productos en los resultados
    Y no debería ver mensaje de sin resultados

  @busqueda_vacia @edge_case
  Escenario: Búsqueda con campo vacío
    Cuando el usuario realiza una búsqueda vacía
    Entonces el sistema debería manejar la búsqueda apropiadamente

  @busqueda_variaciones @regression
  Esquema del escenario: Búsquedas con diferentes términos relacionados
    Cuando el usuario busca "<termino_busqueda>"
    Entonces debería ver resultados de búsqueda
    Y debería ver productos relacionados con "<termino_esperado>"
    Y debería ver al menos 1 productos en los resultados

    Ejemplos:
      | termino_busqueda      | termino_esperado |
      | bolsas plasticas      | bolsas           |
      | bolsas papel          | bolsas           |
      | bolsas biodegradables | bolsas           |
      | empaques              | empaques         |


  @busqueda_bolsas @agregar_carrito @smoke
  Escenario: Añadir un producto al carrito desde los resultados de búsqueda
    Dado que el usuario está en la página principal de Bolsas y Empaques Colombia
    Cuando el usuario busca "bolsas"
    Y selecciona el primer producto de la lista
    Y hace clic en el botón "Añadir al carrito"
    Y el icono del carrito debería mostrar la cantidad actualizada

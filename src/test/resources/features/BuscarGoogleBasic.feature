Feature: Buscar en google basica
  Como usuario
  Quiero realizar una búsqueda en Google
  Para encontrar información relevante

  Scenario: El usuario quiere buscar en google
    Given Ingresa a google
    When Ingrese lo que quiere buscar
    Then Valida los resultado
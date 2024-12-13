
Feature: Iniciar Sesion

    Scenario:  ingresar nombre de usuario incorrecto
      When se ingresa el nombre de usuario "Medic5"
      And se ingresa la contraseña "123456"
      Then se muestra el mensaje "Credenciales inválidas"
  Scenario: ingresar contraseña incorrecta
    When se ingresa el nombre de usuario "Medic1"
    And se ingresa la contraseña "123456465"
    Then se muestra el mensaje "Credenciales inválidas"


  Scenario: ingresar con un campo faltante
    When solo se ingresa el nombre de usuario "Medic1"
    Then se muestra el mensaje "Faltan completar campos"


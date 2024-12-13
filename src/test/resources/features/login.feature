Feature: Iniciar Sesion
    Como Médico
    Quiero iniciar sesión
    Para acceder a la historia clínica de los pacientes
    @login
    Scenario: ingresar nombre de usuario incorrecto
        Given ingreso a la pantalla de logueo
        When se ingresa el nombre de usuario
        And ingresa la contraseña
        Then se muestra el mensaje "nombre de usuario o contraseña incorrectos"

    Scenario: ingresar contraseña incorrecta
        Given ingreso a la pantalla de logueo
        When el medico ingresa el nombre de usuario
        And ingresa la contraseña incorrecta
        Then se muestra el mensaje "nombre de usuario o contraseña incorrectos"


    Scenario: ingresar nombre de usuario y contraseña incorrectas
        Given ingreso a la pantalla de logueo
        When el medico ingresa el nombre de usuario incorrecto
        And ingresa la contraseña incorrecta
        Then se muestra el mensaje "nombre de usuario o contraseña incorrectos"
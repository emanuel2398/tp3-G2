package edu.spring.istfi;

import edu.spring.istfi.controller.LoginController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;
@Component
public class StepsDefinitions {

    @Autowired
    private LoginController loginController;

    private ResponseEntity<?> response;

    @Dado("ingreso a la pantalla de logueo")
    public void dadoIngresoALaPantallaDeLogueo() {

    }

   @Cuando("el medico ingresa el nombre de usuario incorrecto")
    public void cuandoElMedicoIngresaElNombreDeUsuarioIncorrecto() {
        Map<String, String> credentials = Map.of("username", "usuarioInexistente", "password", "contraseñaCorrecta");
        response = loginController.login(credentials);
    }

    @Cuando("el medico ingresa el nombre de usuario")
    public void cuandoElMedicoIngresaElNombreDeUsuario() {
        Map<String, String> credentials = Map.of("username", "medicoValido", "password", "contraseñaCorrecta");
        response = loginController.login(credentials);
    }

    @Cuando("el medico ingresa el nombre de usuario {string} y la contraseña {string}")
    public void cuandoElMedicoIngresaElNombreDeUsuarioYLaContraseña(String username, String password) {
        Map<String, String> credentials = Map.of("username", username, "password", password);
        response = loginController.login(credentials);
    }


    @Entonces("se muestra el mensaje {string}")
    public void entoncesSeMuestraElMensaje(String mensajeEsperado) {
        assertEquals(mensajeEsperado, response.getBody());
    }
}

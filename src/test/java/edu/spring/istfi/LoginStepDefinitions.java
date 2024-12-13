package edu.spring.istfi;



import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;

public class LoginStepDefinitions {

    private RestTemplate restTemplate = new RestTemplate();
    private ResponseEntity<String> response;


    private void enviarCredenciales(String username, String password) {
        Map<String, String> credenciales = new HashMap<>();
        if (username != null) credenciales.put("username", username);
        if (password != null) credenciales.put("password", password);
        this.response = restTemplate.postForEntity("http://localhost:8080/login", credenciales, String.class);
    }

    @When("se ingresa el nombre de usuario {string}")
    public void ingresa_el_nombre_de_usuario(String nombreUsuario) {
        enviarCredenciales(nombreUsuario, "123456");
    }

    @When("se ingresa el nombre de usuario {string} y la contraseña {string}")
    public void ingresa_el_nombre_de_usuario_y_contraseña(String nombreUsuario, String contrasena) {
        enviarCredenciales(nombreUsuario, contrasena);
    }

    @When("solo se ingresa el nombre de usuario {string}")
    public void solo_ingresa_el_nombre_de_usuario(String nombreUsuario) {
        enviarCredenciales(nombreUsuario, null);
    }

    @Then("se muestra el mensaje {string}")
    public void se_muestra_el_mensaje(String mensajeEsperado) {
        assertEquals(mensajeEsperado, response.getBody());
    }
}
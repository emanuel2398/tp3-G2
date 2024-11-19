package edu.spring.istfi.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity

public abstract class Usuario extends Persona {
    private String username;
    private String password;

    public Usuario() {}

    public Usuario(String cuil, String dni, String nombreApellido, String email, String telefono, String direccion,
                   Date fechaDeNacimiento, String username, String password) {
        super(cuil, dni, nombreApellido, email, telefono, direccion, fechaDeNacimiento);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract String getRole();
}
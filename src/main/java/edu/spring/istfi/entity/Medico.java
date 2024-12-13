package edu.spring.istfi.entity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.Collections;
public class Medico implements UserDetails {
    private Long dni;
    private String nombreApellido;
    private String matricula;
    private String especialidad;
    private String username;
    private String password;

    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Medico(Long dni, String nombreApellido, String matricula, String especialidad, String username, String password) {
        this.dni = dni;
        this.nombreApellido = nombreApellido;
        this.matricula = matricula;
        this.especialidad = especialidad;
        this.username = username;
        setPassword(password);
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        // Aplica el hash siempre que se asigne una nueva contraseña.
        if (password != null && !password.isEmpty()) {
            this.password = passwordEncoder.encode(password);
        } else {
            throw new IllegalArgumentException("La contraseña no puede estar vacía.");
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
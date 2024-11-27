package edu.spring.istfi.entity;

public class Medico {
    private Long dni;
    private String nombreApellido;

    private String matricula;
    private String especialidad;



    public Medico(Long dni, String nombreApellido,
                   String matricula, String especialidad) {
        this.dni=dni;
        this.nombreApellido=nombreApellido;
        this.matricula = matricula;
        this.especialidad = especialidad;
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
}
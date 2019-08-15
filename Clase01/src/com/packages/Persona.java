package com.packages;
import java.time.LocalDate;
import java.time.Period;

public class Persona {
    private String nombre;
    private String apellido;
    private String dni;
    private char sexo;
    private LocalDate fechaNacimiento;
    private String nacionalidad;

    public Persona(String nombre, String apellido, String dni, char sexo, String nacionalidad, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return Period.between(this.fechaNacimiento, LocalDate.now()).getYears();
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getDni() {
        return dni;
    }
    public char getSexo() {
        return sexo;
    }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public String getNacionalidad() { return nacionalidad; }
}

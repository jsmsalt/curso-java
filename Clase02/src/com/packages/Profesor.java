package com.packages;
import java.time.LocalDate;

public class Profesor extends Persona {
    private String titulo;
    private String catedra;

    public Profesor(String nombre, String apellido, String dni, char sexo, String nacionalidad, LocalDate fechaNacimiento, String titulo, String catedra) {
        super(nombre, apellido, dni, sexo, nacionalidad, fechaNacimiento);
        this.titulo = titulo;
        this.catedra = catedra;
    }

    public String getTitulo() { return titulo; }
    public String getCatedra() {
        return catedra;
    }
}

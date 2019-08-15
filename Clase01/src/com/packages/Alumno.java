package com.packages;
import java.time.LocalDate;

public class Alumno extends Persona {
    private int nota;
    private String curso;

    public Alumno(String nombre, String apellido, String dni, char sexo, String nacionalidad, LocalDate fechaNacimiento, int nota, String curso) {
        super(nombre, apellido, dni, sexo, nacionalidad, fechaNacimiento);
        this.nota = nota;
        this.curso = curso;
    }

    public int getNota() {
        return nota;
    }
    public String getCurso() {
        return curso;
    }
}

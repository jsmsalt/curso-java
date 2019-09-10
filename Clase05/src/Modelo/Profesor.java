package Modelo;

import java.util.Date;

public class Profesor extends Persona {
    private String titulo;

    public Profesor() {
    }

    public Profesor(String titulo) {
        this.titulo = titulo;
    }

    public Profesor(int id, String nombre, String apellido, String dni, char sexo, Date fechaNacimiento, Contacto contacto, String titulo) {
        super(id, nombre, apellido, dni, sexo, fechaNacimiento, contacto);
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "titulo='" + titulo + '\'' +
                '}';
    }
}

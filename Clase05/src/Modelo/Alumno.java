package Modelo;
import java.util.Date;

public class Alumno extends Persona {
    private String matricula;

    public Alumno() {
    }

    public Alumno(String matricula) {
        this.matricula = matricula;
    }

    public Alumno(int id, String nombre, String apellido, String dni, char sexo, Date fechaNacimiento, Contacto contacto, String matricula) {
        super(id, nombre, apellido, dni, sexo, fechaNacimiento, contacto);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "matricula='" + matricula + '\'' +
                '}';
    }
}

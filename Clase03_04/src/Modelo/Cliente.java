package Modelo;
import java.util.Date;

public class Cliente extends Persona {
    private String cuil;
    private String nombre;
    private String apellido;
    private String dni;
    private char sexo;
    private Date fechaNacimiento;

    public Cliente(int id, String descripcion, Contacto contacto, String cuil, String nombre, String apellido, String dni, char sexo, Date fechaNacimiento) {
        super(id, descripcion, contacto);
        this.cuil = cuil;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Cliente() {

    }

    public String getCuil() {
        return this.cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public char getSexo() {
        return this.sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Cliente cuil(String cuil) {
        this.cuil = cuil;
        return this;
    }

    public Cliente nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Cliente apellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public Cliente dni(String dni) {
        this.dni = dni;
        return this;
    }

    public Cliente sexo(char sexo) {
        this.sexo = sexo;
        return this;
    }

    public Cliente fechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " cuil='" + getCuil() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", apellido='" + getApellido() + "'" +
            ", dni='" + getDni() + "'" +
            ", sexo='" + getSexo() + "'" +
            ", fechaNacimiento='" + getFechaNacimiento() + "'" +
            "}";
    }
}
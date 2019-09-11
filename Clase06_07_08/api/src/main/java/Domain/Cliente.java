package Domain;

public class Cliente extends Persona {
    public String apellido;
    public String dni;
    public String cuil;

    public Cliente() {
    }

    public Cliente(int id, String apellido, String dni, String cuil, String nombre, String direccion, String telefono, String pais, String provincia, String ciudad) {
        super(id, nombre, direccion, telefono, pais, provincia, ciudad);
        this.apellido = apellido;
        this.dni = dni;
        this.cuil = cuil;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", cuil='" + cuil + '\'' +
                '}';
    }
}

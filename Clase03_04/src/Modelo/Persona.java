package Modelo;

public class Persona {
    private int id;
    private String descripcion;
    private Contacto contacto;

    public Persona(int id, String descripcion, Contacto contacto) {
        this.id = id;
        this.descripcion = descripcion;
        this.contacto = contacto;
    }

    public Persona() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", contacto=" + contacto +
                '}';
    }
}
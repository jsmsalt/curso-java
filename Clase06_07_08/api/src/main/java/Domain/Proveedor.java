package Domain;

public class Proveedor extends Persona {
    public String cuit;

    public Proveedor() {
    }

    public Proveedor(String cuit) {
        this.cuit = cuit;
    }

    public Proveedor(String cuit, int id, String nombre, String direccion, String telefono, String pais, String provincia, String ciudad) {
        super(id, nombre, direccion, telefono, pais, provincia, ciudad);
        this.cuit = cuit;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "cuit=" + cuit + '}';
    }
}

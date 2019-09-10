package Domain;

public class Moneda {
    public int id;
    public String descripcion;
    public float cotizacion;

    public Moneda() {
    }

    public Moneda(int id, String descripcion, float cotizacion) {
        this.id = id;
        this.descripcion = descripcion;
        this.cotizacion = cotizacion;
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

    public float getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(float cotizacion) {
        this.cotizacion = cotizacion;
    }

    @Override
    public String toString() {
        return "Moneda{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", cotizacion=" + cotizacion +
                '}';
    }
}

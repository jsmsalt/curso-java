package Domain;

public class TipoPago {
    public int id;
    public String descripcion;

    public TipoPago() {
    }

    public TipoPago(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
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

    @Override
    public String toString() {
        return "TipoPago{" + "id=" + id + ", descripcion=" + descripcion + '}';
    }
}

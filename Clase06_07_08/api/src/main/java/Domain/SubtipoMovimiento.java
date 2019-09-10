package Domain;

public class SubtipoMovimiento {
    public int id;
    public String descripcion;

    public SubtipoMovimiento() {
    }

    public SubtipoMovimiento(int id, String descripcion) {
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
        return "SubtipoMovimiento{" + "id=" + id + ", descripcion=" + descripcion + '}';
    }
}

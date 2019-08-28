package Modelo;

public class DetalleMovimiento {
    private int id;
    private String descripcion;

    // Carniceria, Verduleria, Supermercado, Salida, etc
    public DetalleMovimiento(int id, String descripcion) {
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
        return "DetalleMovimiento{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}

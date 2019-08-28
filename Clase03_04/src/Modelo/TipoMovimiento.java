package Modelo;

public class TipoMovimiento {
    public static final int INGRESO = 1;
    public static final int EGRESO = 2;

    private int id;

    // Ingreso o Egreso
    public TipoMovimiento(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TipoMovimiento{" +
                "id=" + id +
                '}';
    }
}

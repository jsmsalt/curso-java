package Domain;

public class DeudaXPersona {
    private Cliente cliente;
    private Proveedor proveedor;
    private  float deuda = 0;

    public DeudaXPersona() {
    }

    public DeudaXPersona(Cliente cliente, Proveedor proveedor, float deuda) {
        this.cliente = cliente;
        this.proveedor = proveedor;
        this.deuda = deuda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public float getDeuda() {
        return deuda;
    }

    public void setDeuda(float deuda) {
        this.deuda = deuda;
    }

    @Override
    public String toString() {
        return "DeudaXPersona{" +
                "cliente=" + cliente +
                ", proveedor=" + proveedor +
                ", deuda=" + deuda +
                '}';
    }
}

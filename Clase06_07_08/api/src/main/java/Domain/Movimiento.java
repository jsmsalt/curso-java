package Domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class Movimiento {
    public static final byte INGRESO = 1;
    public static final byte EGRESO = 2;

    private int id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fecha;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fechaVencimiento;
    private float monto;
    private String descripcion;
    private SubtipoMovimiento subtipoMovimiento;
    private float cotizacion;
    private Moneda moneda;
    private TipoPago tipoPago;
    private byte tipoMovimiento;
    private Cliente cliente = null;
    private Proveedor proveedor = null;

    public Movimiento() {
    }

    public Movimiento(int id, Date fecha, Date fechaVencimiento, float monto, String descripcion, SubtipoMovimiento subtipoMovimiento, float cotizacion, Moneda moneda, TipoPago tipoPago, byte tipoMovimiento, Cliente cliente, Proveedor proveedor) {
        this.id = id;
        this.fecha = fecha;
        this.fechaVencimiento = fechaVencimiento;
        this.monto = monto;
        this.descripcion = descripcion;
        this.subtipoMovimiento = subtipoMovimiento;
        this.cotizacion = cotizacion;
        this.moneda = moneda;
        this.tipoPago = tipoPago;
        this.tipoMovimiento = tipoMovimiento;
        this.cliente = cliente;
        this.proveedor = proveedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public SubtipoMovimiento getSubtipoMovimiento() {
        return subtipoMovimiento;
    }

    public void setSubtipoMovimiento(SubtipoMovimiento subtipoMovimiento) {
        this.subtipoMovimiento = subtipoMovimiento;
    }

    public float getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(float cotizacion) {
        this.cotizacion = cotizacion;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public byte getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(byte tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
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

    @Override
    public String toString() {
        return "Movimiento{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", fechaVencimiento=" + fechaVencimiento +
                ", monto=" + monto +
                ", descripcion='" + descripcion + '\'' +
                ", subtipoMovimiento=" + subtipoMovimiento +
                ", cotizacion=" + cotizacion +
                ", moneda=" + moneda +
                ", tipoPago=" + tipoPago +
                ", tipoMovimiento=" + tipoMovimiento +
                ", cliente=" + cliente +
                ", proveedor=" + proveedor +
                '}';
    }
}

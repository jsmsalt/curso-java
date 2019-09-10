package Domain;

import java.util.Date;

public class Movimiento {
    public static final byte INGRESO = 1;
    public static final byte EGRESO = 2;

    // Cuando se registra el movimiento
    private Date fecha;

    // Cuando se vence la deuda
    private Date fechaVencimiento;

    // Cuanto se gastó
    private float monto;

    // Un dato que ayude a entender el movimiento
    private String descripcion;

    // Dónde compré o vendí (Carnicería, Verdulería, Peluquería, etc)
    private SubtipoMovimiento subtipoMovimiento;

    // Historial de cotización
    private float cotizacion;

    // Tipo de moneda utilizado
    private Moneda moneda;

    // Forma de pago (Efectivo, Débito, Crédito, etc)
    private TipoPago tipoPago;

    // Ingreso o Egreso
    private byte tipoMovimiento;

    // Cliente o Proveedor
    private Persona persona;

    public Movimiento() {
    }

    public Movimiento(Date fecha, Date fechaVencimiento, float monto, String descripcion, SubtipoMovimiento subtipoMovimiento, float cotizacion, Moneda moneda, TipoPago tipoPago, byte tipoMovimiento, Persona persona) {
        this.fecha = fecha;
        this.fechaVencimiento = fechaVencimiento;
        this.monto = monto;
        this.descripcion = descripcion;
        this.subtipoMovimiento = subtipoMovimiento;
        this.cotizacion = cotizacion;
        this.moneda = moneda;
        this.tipoPago = tipoPago;
        this.tipoMovimiento = tipoMovimiento;
        this.persona = persona;
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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "fecha=" + fecha + ", fechaVencimiento=" + fechaVencimiento + ", monto=" + monto + ", descripcion=" + descripcion + ", subtipoMovimiento=" + subtipoMovimiento + ", cotizacion=" + cotizacion + ", moneda=" + moneda + ", tipoPago=" + tipoPago + ", tipoMovimiento=" + tipoMovimiento + ", persona=" + persona + '}';
    }
}

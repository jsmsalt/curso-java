package Domain;

import java.util.Date;

public class FiltroMovimiento {
    private Date fechaInicio;
    private Date fechaFin;
    private int subtipo;
    private int tipoMovimiento;
    private int clienteId;
    private int proveedorId;

    public FiltroMovimiento() {
    }

    public FiltroMovimiento(Date fechaInicio, Date fechaFin, int subtipo, int tipoMovimiento, int clienteId, int proveedorId) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.subtipo = subtipo;
        this.tipoMovimiento = tipoMovimiento;
        this.clienteId = clienteId;
        this.proveedorId = proveedorId;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getSubtipo() {
        return subtipo;
    }

    public void setSubtipo(int subtipo) {
        this.subtipo = subtipo;
    }

    public int getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(int tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(int proveedorId) {
        this.proveedorId = proveedorId;
    }

    @Override
    public String toString() {
        return "FiltroMovimiento{" +
                "fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", subtipo=" + subtipo +
                ", tipoMovimiento=" + tipoMovimiento +
                ", clienteId=" + clienteId +
                ", proveedorId=" + proveedorId +
                '}';
    }
}

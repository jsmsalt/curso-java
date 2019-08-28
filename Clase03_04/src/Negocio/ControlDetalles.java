package Negocio;

import Modelo.DetalleMovimiento;

import java.util.ArrayList;

public class ControlDetalles {
    private ArrayList<DetalleMovimiento> _detalles = new ArrayList<DetalleMovimiento>();

    public ControlDetalles(ArrayList<DetalleMovimiento> detalles) {
        _detalles = detalles;
    }

    public ControlDetalles() {
    }

    public DetalleMovimiento agregarDetalle(DetalleMovimiento _detalle) {
        boolean nuevo = true;

        for (DetalleMovimiento detalle: _detalles) {
            if (detalle.getDescripcion().toLowerCase() == _detalle.getDescripcion().toLowerCase()) {
                nuevo = false;
                _detalle = detalle;
            }
        }

        if (nuevo && _detalle.getId() == 0) {
            _detalle.setId(_detalles.size() + 1);
            this._detalles.add(_detalle);
        }

        return _detalle;
    }

    public DetalleMovimiento detallePorID(int id) {
        for (DetalleMovimiento detalle: _detalles) {
            if (detalle.getId() == id) {
                return detalle;
            }
        }

        return null;
    }

    public ArrayList<DetalleMovimiento> getDetalles() {
        return _detalles;
    }

    public void setDetalles(ArrayList<DetalleMovimiento> detalles) {
        _detalles = detalles;
    }

    @Override
    public String toString() {
        return "ControlDetalles{" +
                "_detalles=" + _detalles +
                '}';
    }
}

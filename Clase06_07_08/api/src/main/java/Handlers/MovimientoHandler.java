package Handlers;

import Domain.*;
import java.util.ArrayList;

public class MovimientoHandler {
    private static ArrayList<Movimiento> _movimientos = new ArrayList<Movimiento>();

    public MovimientoHandler() {
    }

    public MovimientoHandler(ArrayList<Movimiento> _movimientos) {
        this._movimientos = _movimientos;
    }

    public static ArrayList<Movimiento> getMovimientos() {
        return _movimientos;
    }

    public static Movimiento getMovimiento(int id) {
        for (Movimiento movimiento:_movimientos) {
            if ( movimiento.getId() == id ) {
                return movimiento;
            }
        }
        return null;
    }

    public static Movimiento deleteMovimiento(int id) {
        for (int i = 0; i < _movimientos.size(); i++) {
            if ( _movimientos.get(i).getId() == id ) {
                return _movimientos.remove(i);
            }
        }

        return null;
    }

    public static Movimiento updateMovimiento(int id, Movimiento _movimiento) {
        int indexUpdate = -1;

        for (int i = 0; i < _movimientos.size(); i++) {
            /*if ( _movimientos.get(i).getDescripcion().toLowerCase().equals(_movimiento.getDescripcion().toLowerCase()) ) {
                return null;
            }*/

            if ( _movimientos.get(i).getId() == id ) {
                indexUpdate = i;
                break;
            }
        }

        if (indexUpdate != -1) {
            _movimiento.setId(_movimientos.get(indexUpdate).getId());
            _movimientos.set(indexUpdate, _movimiento);
            return _movimiento;
        }

        return null;
    }

    public static Movimiento addMovimiento(Movimiento _movimiento) {

        if (_movimiento.getSubtipoMovimiento() != null) {
            _movimiento.setSubtipoMovimiento(
                    SubtipoMovimientoHandler.getSubtipoMovimiento(
                            _movimiento.getSubtipoMovimiento().getId()
                    )
            );
        }

        if (_movimiento.getMoneda() != null) {
            _movimiento.setMoneda(
                    MonedaHandler.getMoneda(
                            _movimiento.getMoneda().getId()
                    )
            );
        }

        if (_movimiento.getTipoPago() != null) {
            _movimiento.setTipoPago(
                    TipoPagoHandler.getTipoPago(
                            _movimiento.getTipoPago().getId()
                    )
            );
        }

        if (_movimiento.getCliente() != null) {
            _movimiento.setCliente(
                    ClienteHandler.getCliente(
                            _movimiento.getCliente().getId()
                    )
            );
        }

        if (_movimiento.getProveedor() != null) {
            _movimiento.setProveedor(
                    ProveedorHandler.getProveedor(
                            _movimiento.getProveedor().getId()
                    )
            );
        }

        if (_movimiento.getSubtipoMovimiento() == null ||
            _movimiento.getMoneda() == null ||
            _movimiento.getTipoPago() == null ||
            (_movimiento.getCliente() == null && _movimiento.getProveedor() == null)) {
            return null;
        }

        _movimiento.setCotizacion(_movimiento.getMoneda().getCotizacion());

        _movimiento.setId(_movimientos.get(_movimientos.size() - 1).getId() + 1);
        _movimientos.add(_movimiento);
        return _movimiento;
    }

    public static ArrayList<Movimiento> addMovimientos(ArrayList<Movimiento> _movimientos) {
        for (int i = 0; i < _movimientos.size(); i++) {
            _movimientos.set(i, MovimientoHandler.addMovimiento(_movimientos.get(i)));
        }

        return _movimientos;
    }
}

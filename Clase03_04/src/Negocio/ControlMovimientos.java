package Negocio;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import Modelo.*;

public class ControlMovimientos {
    public ArrayList<Movimiento> _movimientos = new ArrayList<>();

    public ControlMovimientos(ArrayList<Movimiento> _movimientos) {
        this._movimientos = _movimientos;
    }

    public ControlMovimientos() {
    }

    public void agregarMovimiento(Movimiento _movimiento) {
        this._movimientos.add(_movimiento);
    }

    public ArrayList<Movimiento> verMovimientos(Date fechaInicio, Date fechaFin, int tipo) {
        ArrayList<Movimiento> aux = new ArrayList<>();
        for (Movimiento movimiento:_movimientos) {
            if(movimiento.getFecha().compareTo(fechaInicio) >= 0
                    && movimiento.getFecha().compareTo(fechaFin) <= 0
                    && movimiento.getTipoMovimiento().getId() == tipo) {
                aux.add(movimiento);
            }
        }
        
        return aux;
    }

    public ArrayList<Movimiento> verIngresos(Date fechaInicio, Date fechaFin) {
        return verMovimientos(fechaInicio, fechaFin, TipoMovimiento.INGRESO);
    }

    public ArrayList<Movimiento> verEgresos(Date fechaInicio, Date fechaFin) {
        return verMovimientos(fechaInicio, fechaFin, TipoMovimiento.EGRESO);
    }
    
    public ArrayList<Movimiento> verMovimientosPorDetalle(Date fechaInicio, Date fechaFin, int detalleID) {
        ArrayList<Movimiento> aux = new ArrayList<>();
        DetalleMovimiento detalle;

        for (Movimiento movimiento:_movimientos) {
            if ( movimiento.getDetalleMovimiento().getId() == detalleID
                && movimiento.getFecha().compareTo(fechaInicio) >= 0
                && movimiento.getFecha().compareTo(fechaFin) <= 0 ) {
                aux.add(movimiento);
            }
        }
        
        return aux;
    }

    public ArrayList<DeudaXPersona> deudaXAcreedor(Date fechaInicio, Date fechaFin) {
        // Se crea un hashmap donde key es el id de la persona relacionada al movimiento
        HashMap<Integer, DeudaXPersona> aux = new HashMap<Integer, DeudaXPersona>();

        // Recorremos todos los movimientos
        for (Movimiento movimiento: _movimientos) {
            // Comprobamos si la persona está almacenada en el hashmap
            DeudaXPersona auxdxp = aux.get(movimiento.getPersona().getId());

            // Si la persona no estaba en el hashmap creamos una nueva instancia
            if ( auxdxp == null ) {
                auxdxp = new DeudaXPersona(movimiento.getPersona(), 0);
            }

            // Comprobamos si es Cliente, de lo contrario es Proveedor
            if ( auxdxp.getPersona() instanceof Cliente ) {
                // Comprobamos si es ingreso o egreso
                if ( movimiento.getTipoMovimiento().getId() == TipoMovimiento.INGRESO ) {
                    auxdxp.setDeuda(auxdxp.getDeuda() - movimiento.getMonto());
                } else {
                    auxdxp.setDeuda(auxdxp.getDeuda() + movimiento.getMonto());
                }
            } else {
                // Comprobamos si es ingreso o egreso
                if ( movimiento.getTipoMovimiento().getId() == TipoMovimiento.INGRESO ) {
                    auxdxp.setDeuda(auxdxp.getDeuda() + movimiento.getMonto());
                } else {
                    auxdxp.setDeuda(auxdxp.getDeuda() - movimiento.getMonto());
                }
            }

            // Actualizamos los datos de la persona
            aux.put(movimiento.getPersona().getId(), auxdxp);
        }

        // Convertimos el hashnode en arraylist y lo devolvemos
        Collection<DeudaXPersona> values = aux.values();
        return new ArrayList<DeudaXPersona>(values);
    }

    public float porcentajeAhorro(Date fechaInicio, Date fechaFin) {
        float egresos = 0;
        float ingresos = 0;
        for (Movimiento movimiento: _movimientos) {
            if ( movimiento.getTipoMovimiento().getId() == TipoMovimiento.INGRESO ) {
                ingresos += movimiento.getMonto();
            } else {
                egresos += movimiento.getMonto();
            }
        }
        return egresos/ingresos;
    }

    public ArrayList<Movimiento> historial(Date fechaInicio, Date fechaFin, int personaID) {
        ArrayList<Movimiento> aux = new ArrayList<>();
        for (Movimiento movimiento:_movimientos) {
            if(movimiento.getFecha().compareTo(fechaInicio) >= 0
                    && movimiento.getFecha().compareTo(fechaFin) <= 0
                    && movimiento.getPersona().getId() == personaID) {
                aux.add(movimiento);
            }
        }

        return aux;
    }

    public ArrayList<Movimiento> getMovimientos() {
        return _movimientos;
    }

    public void setMovimientos(ArrayList<Movimiento> movimientos) {
        _movimientos = movimientos;
    }
}

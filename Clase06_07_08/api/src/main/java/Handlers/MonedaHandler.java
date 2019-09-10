package Handlers;

import Domain.Moneda;
import java.util.ArrayList;

public class MonedaHandler {
    private static ArrayList<Moneda> _monedas = new ArrayList<Moneda>();

    public MonedaHandler() {
    }

    public MonedaHandler(ArrayList<Moneda> _monedas) {
        this._monedas = _monedas;
    }

    public static ArrayList<Moneda> getMonedas() {
        return _monedas;
    }

    public static Moneda getMoneda(int id) {
        for (Moneda moneda:_monedas) {
            if ( moneda.getId() == id ) {
                return moneda;
            }
        }
        return null;
    }

    public static Moneda deleteMoneda(int id) {
        int index = 0;
        for (Moneda moneda:_monedas) {
            if ( moneda.getId() == id ) {
                return _monedas.remove(index);
            }
            index++;
        }
        return null;
    }

    public static Moneda updateMoneda(int id, String descripcion, float cotizacion) {
        int index = 0;
        int indexUpdate = -1;
        Moneda aux;

        for (Moneda moneda:_monedas) {
            if ( moneda.getDescripcion().toLowerCase().equals(descripcion.toLowerCase()) ) {
                return null;
            }

            if ( moneda.getId() == id ) {
                indexUpdate = index;
            }
            index++;
        }

        if (indexUpdate != -1) {
            aux = _monedas.get(indexUpdate);
            aux.setDescripcion(descripcion);
            aux.setCotizacion(cotizacion);
            _monedas.set(indexUpdate, aux);
            return aux;
        }

        return null;
    }

    public static Moneda addMoneda(String descripcion, float cotizacion) {
        for (Moneda moneda:_monedas) {
            if ( moneda.getDescripcion().toLowerCase().equals(descripcion.toLowerCase()) ) {
                return null;
            }
        }
        Moneda nuevo = new Moneda(_monedas.size() + 1, descripcion, cotizacion);
        _monedas.add(nuevo);

        return nuevo;
    }
}

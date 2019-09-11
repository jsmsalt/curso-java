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
        for (int i = 0; i < _monedas.size(); i++) {
            if ( _monedas.get(i).getId() == id ) {
                return _monedas.remove(i);
            }
        }
        return null;
    }

    public static Moneda updateMoneda(int id, Moneda _moneda) {
        int indexUpdate = -1;

        for (int i = 0; i < _monedas.size(); i++) {
            if ( _monedas.get(i).getDescripcion().toLowerCase().equals(_moneda.getDescripcion().toLowerCase()) ) {
                return null;
            }

            if ( _monedas.get(i).getId() == id ) {
                indexUpdate = i;
            }
        }

        if (indexUpdate != -1) {
            _moneda.setId(_monedas.get(indexUpdate).getId());
            _monedas.set(indexUpdate, _moneda);
            return _moneda;
        }

        return null;
    }

    public static Moneda addMoneda(Moneda _moneda) {
        if (_moneda.getDescripcion().length() == 0) {
            return null;
        }

        for (Moneda moneda:_monedas) {
            if ( moneda.getDescripcion().toLowerCase().equals(_moneda.getDescripcion().toLowerCase()) ) {
                return null;
            }
        }

        _moneda.setId(_monedas.get(_monedas.size() - 1).getId() + 1);
        _monedas.add(_moneda);
        return _moneda;
    }

    public static ArrayList<Moneda> addMonedas(ArrayList<Moneda> _monedas) {
        for (int i = 0; i < _monedas.size(); i++) {
            _monedas.set(i, MonedaHandler.addMoneda(_monedas.get(i)));
        }

        return _monedas;
    }
}

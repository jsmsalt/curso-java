package Negocio;
import Modelo.Moneda;
import java.util.ArrayList;

public class ControlMonedas {
    private ArrayList<Moneda> _monedas = new ArrayList<Moneda>();

    public void agregarMoneda(Moneda _moneda) {
        if (_moneda.getId() == 0) {
            _moneda.setId(_monedas.size() + 1);
        }

        this._monedas.add(_moneda);
    }

    public Moneda monedaPorID(int id) {
        for (Moneda moneda: _monedas) {
            if (moneda.getId() == id) {
                return moneda;
            }
        }

        return null;
    }

    public ArrayList<Moneda> getMonedas() {
        return _monedas;
    }

    public void setMonedas(ArrayList<Moneda> _monedas) {
        this._monedas = _monedas;
    }


}

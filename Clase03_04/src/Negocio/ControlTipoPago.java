package Negocio;
import Modelo.TipoPago;
import java.util.ArrayList;

public class ControlTipoPago {
    private ArrayList<TipoPago> _tiposPago = new ArrayList<TipoPago>();

    public ControlTipoPago() {
    }

    public ControlTipoPago(ArrayList<TipoPago> tiposPago) {
        _tiposPago = tiposPago;
    }

    public void agregarTipoPago(TipoPago _tipoPago) {
        if (_tipoPago.getId() == 0) {
            _tipoPago.setId(_tiposPago.size() + 1);
        }

        this._tiposPago.add(_tipoPago);
    }

    public TipoPago tipoPagoPorID(int id) {
        for (TipoPago tipoPago: _tiposPago) {
            if (tipoPago.getId() == id) {
                return tipoPago;
            }
        }

        return null;
    }

    public ArrayList<TipoPago> getTiposPago() {
        return _tiposPago;
    }

    public void setTiposPago(ArrayList<TipoPago> tiposPago) {
        _tiposPago = tiposPago;
    }
}

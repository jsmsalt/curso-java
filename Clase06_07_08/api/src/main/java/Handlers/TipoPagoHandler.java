package Handlers;

import Domain.TipoPago;
import java.util.ArrayList;

public class TipoPagoHandler {
    private static ArrayList<TipoPago> _tipopagos = new ArrayList<TipoPago>();

    public TipoPagoHandler() {
    }

    public TipoPagoHandler(ArrayList<TipoPago> _tipopagos) {
        this._tipopagos = _tipopagos;
    }

    public static ArrayList<TipoPago> getTipoPagos() {
        return _tipopagos;
    }

    public static TipoPago getTipoPago(int id) {
        for (TipoPago tipopago:_tipopagos) {
            if ( tipopago.getId() == id ) {
                return tipopago;
            }
        }
        return null;
    }

    public static TipoPago deleteTipoPago(int id) {
        for (int i = 0; i < _tipopagos.size(); i++) {
            if ( _tipopagos.get(i).getId() == id ) {
                return _tipopagos.remove(i);
            }
        }

        return null;
    }

    public static TipoPago updateTipoPago(int id, TipoPago _tipopago) {
        int indexUpdate = -1;

        for (int i = 0; i < _tipopagos.size(); i++) {
            if ( _tipopagos.get(i).getDescripcion().toLowerCase().equals(_tipopago.getDescripcion().toLowerCase()) ) {
                return null;
            }

            if ( _tipopagos.get(i).getId() == id ) {
                indexUpdate = i;
            }
        }

        if (indexUpdate != -1) {
            _tipopago.setId(_tipopagos.get(indexUpdate).getId());
            _tipopagos.set(indexUpdate, _tipopago);
            return _tipopago;
        }

        return null;
    }

    public static TipoPago addTipoPago(TipoPago _tipopago) {
        if (_tipopago.getDescripcion().length() == 0) {
            return null;
        }

        for (TipoPago tipopago:_tipopagos) {
            if ( tipopago.getDescripcion().toLowerCase().equals(_tipopago.getDescripcion().toLowerCase()) ) {
                return null;
            }
        }

        _tipopago.setId(_tipopagos.get(_tipopagos.size() - 1).getId() + 1);
        _tipopagos.add(_tipopago);
        return _tipopago;
    }

    public static ArrayList<TipoPago> addTipoPagos(ArrayList<TipoPago> _tipopagos) {
        for (int i = 0; i < _tipopagos.size(); i++) {
            _tipopagos.set(i, TipoPagoHandler.addTipoPago(_tipopagos.get(i)));
        }

        return _tipopagos;
    }
}

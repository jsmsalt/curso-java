package Handlers;

import Domain.TipoPago;
import java.util.ArrayList;

public class TipoPagoHandler {
    private static ArrayList<TipoPago> _tipospago = new ArrayList<TipoPago>();

    public TipoPagoHandler() {
    }

    public TipoPagoHandler(ArrayList<TipoPago> _tipospago) {
        this._tipospago = _tipospago;
    }

    public static ArrayList<TipoPago> getTipoPagos() {
        return _tipospago;
    }

    public static TipoPago getTipoPago(int id) {
        for (TipoPago tipopago:_tipospago) {
            if ( tipopago.getId() == id ) {
                return tipopago;
            }
        }
        return null;
    }

    public static TipoPago deleteTipoPago(int id) {
        int index = 0;
        for (TipoPago tipopago:_tipospago) {
            if ( tipopago.getId() == id ) {
                return _tipospago.remove(index);
            }
            index++;
        }
        return null;
    }

    public static TipoPago updateTipoPago(int id, String descripcion) {
        int index = 0;
        int indexUpdate = -1;
        TipoPago aux;

        for (TipoPago tipopago:_tipospago) {
            if ( tipopago.getDescripcion().toLowerCase().equals(descripcion.toLowerCase()) ) {
                return null;
            }

            if ( tipopago.getId() == id ) {
                indexUpdate = index;
            }
            index++;
        }

        if (indexUpdate != -1) {
            aux = _tipospago.get(indexUpdate);
            aux.setDescripcion(descripcion);
            _tipospago.set(indexUpdate, aux);
            return aux;
        }

        return null;
    }

    public static TipoPago addTipoPago(String descripcion) {
        for (TipoPago tipopago:_tipospago) {
            if ( tipopago.getDescripcion().toLowerCase().equals(descripcion.toLowerCase()) ) {
                return null;
            }
        }
        TipoPago nuevo = new TipoPago(_tipospago.size() + 1, descripcion);
        _tipospago.add(nuevo);

        return nuevo;
    }
}

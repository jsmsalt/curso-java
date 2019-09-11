package Handlers;

import Domain.Proveedor;
import java.util.ArrayList;

public class ProveedorHandler {
    private static ArrayList<Proveedor> _proveedores = new ArrayList<Proveedor>();

    public ProveedorHandler() {
    }

    public ProveedorHandler(ArrayList<Proveedor> _proveedores) {
        this._proveedores = _proveedores;
    }

    public static ArrayList<Proveedor> getProveedores() {
        return _proveedores;
    }

    public static Proveedor getProveedor(int id) {
        for (Proveedor proveedor:_proveedores) {
            if ( proveedor.getId() == id ) {
                return proveedor;
            }
        }
        return null;
    }

    public static Proveedor deleteProveedor(int id) {
        for (int i = 0; i < _proveedores.size(); i++) {
            if ( _proveedores.get(i).getId() == id ) {
                return _proveedores.remove(i);
            }
        }

        return null;
    }

    public static Proveedor updateProveedor(int id, Proveedor _proveedor) {
        int indexUpdate = -1;

        for (int i = 0; i < _proveedores.size(); i++) {
            if ( _proveedores.get(i).getCuit().toLowerCase().equals(_proveedor.getCuit().toLowerCase()) ) {
                return null;
            }

            if ( _proveedores.get(i).getId() == id ) {
                indexUpdate = i;
            }
        }

        if (indexUpdate != -1) {
            _proveedor.setId(_proveedores.get(indexUpdate).getId());
            _proveedores.set(indexUpdate, _proveedor);
            return _proveedor;
        }

        return null;
    }

    public static Proveedor addProveedor(Proveedor _proveedor) {
        for (Proveedor proveedor:_proveedores) {
            if ( proveedor.getCuit().toLowerCase().equals(_proveedor.getCuit().toLowerCase()) ) {
                return null;
            }
        }

        int newId = _proveedores.size() == 0 ? 1:_proveedores.get(_proveedores.size() - 1).getId() + 1;
        _proveedor.setId(newId);
        _proveedores.add(_proveedor);
        return _proveedor;
    }

    public static ArrayList<Proveedor> addProveedores(ArrayList<Proveedor> _proveedores) {
        for (int i = 0; i < _proveedores.size(); i++) {
            _proveedores.set(i, ProveedorHandler.addProveedor(_proveedores.get(i)));
        }

        return _proveedores;
    }
}

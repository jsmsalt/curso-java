package Handlers;

import Domain.Cliente;
import java.util.ArrayList;

public class ClienteHandler {
    private static ArrayList<Cliente> _clientes = new ArrayList<Cliente>();

    public ClienteHandler() {
    }

    public ClienteHandler(ArrayList<Cliente> _clientes) {
        this._clientes = _clientes;
    }

    public static ArrayList<Cliente> getClientes() {
        return _clientes;
    }

    public static Cliente getCliente(int id) {
        for (Cliente cliente:_clientes) {
            if ( cliente.getId() == id ) {
                return cliente;
            }
        }
        return null;
    }

    public static Cliente deleteCliente(int id) {
        for (int i = 0; i < _clientes.size(); i++) {
            if ( _clientes.get(i).getId() == id ) {
                return _clientes.remove(i);
            }
        }

        return null;
    }

    public static Cliente updateCliente(int id, Cliente _cliente) {
        int indexUpdate = -1;

        for (int i = 0; i < _clientes.size(); i++) {
            if ( _clientes.get(i).getCuil().toLowerCase().equals(_cliente.getCuil().toLowerCase()) ) {
                return null;
            }

            if ( _clientes.get(i).getId() == id ) {
                indexUpdate = i;
            }
        }

        if (indexUpdate != -1) {
            _cliente.setId(_clientes.get(indexUpdate).getId());
            _clientes.set(indexUpdate, _cliente);
            return _cliente;
        }

        return null;
    }

    public static Cliente addCliente(Cliente _cliente) {
        for (Cliente cliente:_clientes) {
            if ( cliente.getCuil().toLowerCase().equals(_cliente.getCuil().toLowerCase()) ) {
                return null;
            }
        }
        int newId = _clientes.size() == 0 ? 1:_clientes.get(_clientes.size() - 1).getId() + 1;
        _cliente.setId(newId);
        _clientes.add(_cliente);
        return _cliente;
    }

    public static ArrayList<Cliente> addClientes(ArrayList<Cliente> _clientes) {
        for (int i = 0; i < _clientes.size(); i++) {
            _clientes.set(i, ClienteHandler.addCliente(_clientes.get(i)));
        }

        return _clientes;
    }
}

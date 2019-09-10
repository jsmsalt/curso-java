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
        int index = 0;
        for (Cliente cliente:_clientes) {
            if ( cliente.getId() == id ) {
                return _clientes.remove(index);
            }
            index++;
        }
        return null;
    }

    public static Cliente updateCliente(int id, String apellido, String dni, String cuil, String nombre, String direccion, String telefono, String pais, String provincia, String ciudad) {
        int index = 0;
        int indexUpdate = -1;
        Cliente aux;

        for (Cliente cliente:_clientes) {
            if ( cliente.getId() == id ) {
                indexUpdate = index;
            }
            index++;
        }

        if (indexUpdate != -1) {
            aux = _clientes.get(indexUpdate);
            aux.setApellido(apellido);
            aux.setCuil(cuil);
            aux.setDni(dni);
            aux.setCiudad(ciudad);
            aux.setDireccion(direccion);
            aux.setNombre(nombre);
            aux.setPais(pais);
            aux.setProvincia(provincia);
            aux.setTelefono(telefono);
            _clientes.set(indexUpdate, aux);
            return aux;
        }

        return null;
    }

    public static Cliente addCliente(String apellido, String dni, String cuil, String nombre, String direccion, String telefono, String pais, String provincia, String ciudad) {
        for (Cliente cliente:_clientes) {
            if ( cliente.getDni().toLowerCase().equals(dni.toLowerCase()) ) {
                return null;
            }
        }
        Cliente nuevo = new Cliente(_clientes.size() + 1, apellido, dni, cuil, nombre, direccion, telefono, pais, provincia, ciudad);
        _clientes.add(nuevo);

        return nuevo;
    }
}

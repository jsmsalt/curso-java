package Handlers;

import Domain.SubtipoMovimiento;
import java.util.ArrayList;

public class SubtipoMovimientoHandler {
    private static ArrayList<SubtipoMovimiento> _subtiposmovimiento = new ArrayList<SubtipoMovimiento>();

    public SubtipoMovimientoHandler() {
    }

    public SubtipoMovimientoHandler(ArrayList<SubtipoMovimiento> _subtiposmovimiento) {
        this._subtiposmovimiento = _subtiposmovimiento;
    }

    public static ArrayList<SubtipoMovimiento> getSubtipoMovimientos() {
        return _subtiposmovimiento;
    }

    public static SubtipoMovimiento getSubtipoMovimiento(int id) {
        for (SubtipoMovimiento subtipomovimiento:_subtiposmovimiento) {
            if ( subtipomovimiento.getId() == id ) {
                return subtipomovimiento;
            }
        }
        return null;
    }

    public static SubtipoMovimiento deleteSubtipoMovimiento(int id) {
        int index = 0;
        for (SubtipoMovimiento subtipomovimiento:_subtiposmovimiento) {
            if ( subtipomovimiento.getId() == id ) {
                return _subtiposmovimiento.remove(index);
            }
            index++;
        }
        return null;
    }

    public static SubtipoMovimiento updateSubtipoMovimiento(int id, String descripcion) {
        int index = 0;
        int indexUpdate = -1;
        SubtipoMovimiento aux;

        for (SubtipoMovimiento subtipomovimiento:_subtiposmovimiento) {
            if ( subtipomovimiento.getDescripcion().toLowerCase().equals(descripcion.toLowerCase()) ) {
                return null;
            }

            if ( subtipomovimiento.getId() == id ) {
                indexUpdate = index;
            }
            index++;
        }

        if (indexUpdate != -1) {
            aux = _subtiposmovimiento.get(indexUpdate);
            aux.setDescripcion(descripcion);
            _subtiposmovimiento.set(indexUpdate, aux);
            return aux;
        }

        return null;
    }

    public static SubtipoMovimiento addSubtipoMovimiento(String descripcion) {
        for (SubtipoMovimiento subtipomovimiento:_subtiposmovimiento) {
            if ( subtipomovimiento.getDescripcion().toLowerCase().equals(descripcion.toLowerCase()) ) {
                return null;
            }
        }
        SubtipoMovimiento nuevo = new SubtipoMovimiento(_subtiposmovimiento.size() + 1, descripcion);
        _subtiposmovimiento.add(nuevo);

        return nuevo;
    }
}

package Handlers;

import Domain.SubtipoMovimiento;
import java.util.ArrayList;

public class SubtipoMovimientoHandler {
    private static ArrayList<SubtipoMovimiento> _subtipomovimientos = new ArrayList<SubtipoMovimiento>();

    public SubtipoMovimientoHandler() {
    }

    public SubtipoMovimientoHandler(ArrayList<SubtipoMovimiento> _subtipomovimientos) {
        this._subtipomovimientos = _subtipomovimientos;
    }

    public static ArrayList<SubtipoMovimiento> getSubtipoMovimientos() {
        return _subtipomovimientos;
    }

    public static SubtipoMovimiento getSubtipoMovimiento(int id) {
        for (SubtipoMovimiento subtipomovimiento:_subtipomovimientos) {
            if ( subtipomovimiento.getId() == id ) {
                return subtipomovimiento;
            }
        }
        return null;
    }

    public static SubtipoMovimiento deleteSubtipoMovimiento(int id) {
        for (int i = 0; i < _subtipomovimientos.size(); i++) {
            if ( _subtipomovimientos.get(i).getId() == id ) {
                return _subtipomovimientos.remove(i);
            }
        }
        return null;
    }

    public static SubtipoMovimiento updateSubtipoMovimiento(int id, SubtipoMovimiento _subtipomovimiento) {
        int indexUpdate = -1;

        for (int i = 0; i < _subtipomovimientos.size(); i++) {
            if ( _subtipomovimientos.get(i).getDescripcion().toLowerCase().equals(_subtipomovimiento.getDescripcion().toLowerCase()) ) {
                return null;
            }

            if ( _subtipomovimientos.get(i).getId() == id ) {
                indexUpdate = i;
            }
        }

        if (indexUpdate != -1) {
            _subtipomovimiento.setId(_subtipomovimientos.get(indexUpdate).getId());
            _subtipomovimientos.set(indexUpdate, _subtipomovimiento);
            return _subtipomovimiento;
        }

        return null;
    }

    public static SubtipoMovimiento addSubtipoMovimiento(SubtipoMovimiento _subtipomovimiento) {
        if (_subtipomovimiento.getDescripcion().length() == 0) {
            return null;
        }

        for (SubtipoMovimiento subtipomovimiento:_subtipomovimientos) {
            if ( subtipomovimiento.getDescripcion().toLowerCase().equals(_subtipomovimiento.getDescripcion().toLowerCase()) ) {
                return null;
            }
        }

        _subtipomovimiento.setId(_subtipomovimientos.get(_subtipomovimientos.size() - 1).getId() + 1);
        _subtipomovimientos.add(_subtipomovimiento);
        return _subtipomovimiento;
    }

    public static ArrayList<SubtipoMovimiento> addSubtipoMovimientos(ArrayList<SubtipoMovimiento> _subtipomovimientos) {
        for (int i = 0; i < _subtipomovimientos.size(); i++) {
            _subtipomovimientos.set(i, SubtipoMovimientoHandler.addSubtipoMovimiento(_subtipomovimientos.get(i)));
        }

        return _subtipomovimientos;
    }
}

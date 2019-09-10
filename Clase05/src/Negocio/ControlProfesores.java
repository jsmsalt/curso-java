package Negocio;
import Modelo.Alumno;
import Modelo.Profesor;
import java.util.ArrayList;

public class ControlProfesores {
    private ArrayList<Profesor> _profesores = new ArrayList<Profesor>();

    public ControlProfesores() {
    }

    public ControlProfesores(ArrayList<Profesor> profesores) {
        _profesores = profesores;
    }

    public ArrayList<Profesor> getProfesores() {
        return _profesores;
    }

    public Profesor agregarProfesor(Profesor _profesor) {
        if ( _profesor.getId() == 0 ) {
            _profesor.setId( _profesores.size() + 1 );
        }

        _profesores.add(_profesor);

        return _profesor;
    }

    public Profesor profesorPorID(int id) {
        for ( Profesor profesor:_profesores ) {
            if ( profesor.getId() == id ) {
                return profesor;
            }
        }

        return null;
    }

    public void setProfesores(ArrayList<Profesor> profesores) {
        _profesores = profesores;
    }

    @Override
    public String toString() {
        return "ControlProfesores{" +
                "_profesores=" + _profesores +
                '}';
    }
}

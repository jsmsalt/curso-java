package Negocio;
import Modelo.Alumno;
import java.util.ArrayList;

public class ControlAlumnos {
    private ArrayList<Alumno> _alumnos = new ArrayList<Alumno>();

    public ControlAlumnos() {
    }

    public ControlAlumnos(ArrayList<Alumno> alumnos) {
        _alumnos = alumnos;
    }

    public Alumno agregarAlumno(Alumno _alumno) {
        if ( _alumno.getId() == 0 ) {
            _alumno.setId( _alumnos.size() + 1 );
        }

        _alumnos.add(_alumno);

        return _alumno;
    }

    public Alumno alumnoPorID(int id) {
        for ( Alumno alumno:_alumnos ) {
            if ( alumno.getId() == id ) {
                return alumno;
            }
        }

        return null;
    }

    public ArrayList<Alumno> getAlumnos() {
        return _alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        _alumnos = alumnos;
    }

    @Override
    public String toString() {
        return "ControlAlumnos{" +
                "_alumnos=" + _alumnos +
                '}';
    }
}

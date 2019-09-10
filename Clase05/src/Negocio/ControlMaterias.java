package Negocio;
import Modelo.Alumno;
import Modelo.Materia;
import Modelo.Profesor;

import java.util.ArrayList;

public class ControlMaterias {
    private ArrayList<Materia> _materias = new ArrayList<Materia>();

    public ControlMaterias() {
    }

    public ControlMaterias(ArrayList<Materia> materias) {
        _materias = materias;
    }

    public Materia agregarMateria(Materia _materia) {

        for (Materia materia:_materias) {
            if ( materia.getNombre().toLowerCase().equals(_materia.getNombre().toLowerCase()) ) {
                return materia;
            }
        }

        if ( _materia.getId() == 0 ) {
            _materia.setId( _materias.size() + 1 );
        }

        _materias.add(_materia);

        return _materia;
    }

    public Materia materiaPorID(int id) {
        for ( Materia materia:_materias ) {
            if ( materia.getId() == id ) {
                return materia;
            }
        }

        return null;
    }

    public ArrayList<Alumno> alumnosPorMateria(Materia m) {
        ArrayList<Alumno> aux = new ArrayList<Alumno>();

        for ( Materia materia:_materias ) {
            if ( materia.getId() == m.getId() ) {
                aux.addAll(materia.getAlumnos());
            }
        }

        return aux;
    }

    public ArrayList<Alumno> alumnosPorProfesor(Profesor p) {
        ArrayList<Alumno> aux = new ArrayList<Alumno>();

        for ( Materia materia:_materias ) {
            if ( materia.getProfesor().getId() == p.getId() ) {
                aux.addAll(materia.getAlumnos());
            }
        }

        return aux;
    }

    public void asignarProfesor(Materia materia, Profesor profesor) {
        for (int i=0; i < _materias.size(); i++) {
            if ( _materias.get(i).getId() == materia.getId() ) {
                _materias.get(i).setProfesor(profesor);
                break;
            }
        }
    }

    public void inscribirAlumno(Materia materia, Alumno alumno) {
        for (int i=0; i < _materias.size(); i++) {
            if ( _materias.get(i).getId() == materia.getId() ) {
                ArrayList<Alumno> aux = _materias.get(i).getAlumnos();
                aux.add(alumno);
                _materias.get(i).setAlumnos(aux);
                break;
            }
        }
    }

    public ArrayList<Materia> getMaterias() {
        return _materias;
    }

    public void setMaterias(ArrayList<Materia> materias) {
        _materias = materias;
    }

    @Override
    public String toString() {
        return "ControlMaterias{" +
                "_materias=" + _materias +
                '}';
    }
}

package Negocio;
import Modelo.Alumno;
import Modelo.Materia;
import Modelo.Nota;
import java.util.ArrayList;

public class ControlNotas {
    private ArrayList<Nota> _notas = new ArrayList<Nota>();

    public ControlNotas() {
    }

    public ControlNotas(ArrayList<Nota> notas) {
        _notas = notas;
    }

    public Nota agregarNota(Nota _nota) {
        _notas.add(_nota);
        return _nota;
    }

    public ArrayList<Nota> notasPorMateria(Materia _materia) {
        ArrayList<Nota> aux = new ArrayList<Nota>();
        for ( Nota nota:_notas ) {
            if ( nota.getMateria().getId() == _materia.getId() ) {
                aux.add(nota);
            }
        }

        return aux;
    }

    public Nota notaPorMateriaAlumno(Materia _materia, Alumno _alumno) {
        for ( Nota nota:_notas ) {
            if ( nota.getMateria().getId() == _materia.getId() && nota.getAlumno().getId() == _alumno.getId() ) {
                return nota;
            }
        }

        return null;
    }

    public ArrayList<Nota> getNotas() {
        return _notas;
    }

    public void setNotas(ArrayList<Nota> notas) {
        _notas = notas;
    }

    @Override
    public String toString() {
        return "ControlNotas{" +
                "_notas=" + _notas +
                '}';
    }
}

package Modelo;

public class Nota {
    private Alumno alumno;
    private Materia materia;
    private float nota = -1;

    public Nota() {
    }

    public Nota(Alumno alumno, Materia materia, float nota) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "alumno=" + alumno +
                ", materia=" + materia +
                ", nota=" + nota +
                '}';
    }
}
package Negocio;

import Modelo.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    private static ControlAlumnos alumnos = new ControlAlumnos();
    private static ControlProfesores profesores = new ControlProfesores();
    private static ControlMaterias materias = new ControlMaterias();
    private static ControlNotas notas = new ControlNotas();

    public static void main(String[] args) {

        int opcion = 0;

        do {
            System.out.println("\n==========================================\n");

            opcion = opcionMenu();

            System.out.println("\n==========================================\n");

            switch (opcion) {
                case 1: {
                    cargarDatos();
                    Consola.stop();
                    break;
                }
                case 2: {
                    System.out.print("Nombre: ");
                    String nombre = Consola.readLine();
                    System.out.print("Apellido: ");
                    String apellido = Consola.readLine();
                    System.out.print("DNI: ");
                    String dni = Consola.readLine();

                    char sexo = ' ';
                    do {
                        System.out.print("Sexo (f o m): ");
                        sexo = Consola.readChar();
                    } while (!valido(sexo, new char[] {'f','m'}));

                    System.out.print("Fecha de nacimiento (dd-mm-aaaa): ");
                    Date fechaNacimiento = Consola.readDate();
                    System.out.print("Teléfono: ");
                    String telefono = Consola.readLine();
                    System.out.print("E-Mail: ");
                    String email = Consola.readLine();
                    System.out.print("País: ");
                    String pais = Consola.readLine();
                    System.out.print("Provincia: ");
                    String provincia = Consola.readLine();
                    System.out.print("Ciudad: ");
                    String ciudad = Consola.readLine();
                    System.out.print("Dirección: ");
                    String direccion = Consola.readLine();
                    System.out.print("Altura: ");
                    int altura = Consola.readInt();
                    System.out.print("Matrícula: ");
                    String matricula = Consola.readLine();

                    alumnos.agregarAlumno(new Alumno(
                            0,
                            nombre,
                            apellido,
                            dni,
                            sexo,
                            fechaNacimiento,
                            new Contacto(
                                    telefono,
                                    email,
                                    pais,
                                    provincia,
                                    ciudad,
                                    direccion,
                                    altura
                            ),
                            matricula
                    ));
                    break;
                }
                case 3: {
                    System.out.print("Nombre: ");
                    String nombre = Consola.readLine();
                    System.out.print("Apellido: ");
                    String apellido = Consola.readLine();
                    System.out.print("DNI: ");
                    String dni = Consola.readLine();

                    char sexo = ' ';
                    do {
                        System.out.print("Sexo (f o m): ");
                        sexo = Consola.readChar();
                    } while (!valido(sexo, new char[] {'f','m'}));

                    System.out.print("Fecha de nacimiento (dd-mm-aaaa): ");
                    Date fechaNacimiento = Consola.readDate();
                    System.out.print("Teléfono: ");
                    String telefono = Consola.readLine();
                    System.out.print("E-Mail: ");
                    String email = Consola.readLine();
                    System.out.print("País: ");
                    String pais = Consola.readLine();
                    System.out.print("Provincia: ");
                    String provincia = Consola.readLine();
                    System.out.print("Ciudad: ");
                    String ciudad = Consola.readLine();
                    System.out.print("Dirección: ");
                    String direccion = Consola.readLine();
                    System.out.print("Altura: ");
                    int altura = Consola.readInt();
                    System.out.print("Título: ");
                    String titulo = Consola.readLine();

                    profesores.agregarProfesor(new Profesor(
                            0,
                            nombre,
                            apellido,
                            dni,
                            sexo,
                            fechaNacimiento,
                            new Contacto(
                                    telefono,
                                    email,
                                    pais,
                                    provincia,
                                    ciudad,
                                    direccion,
                                    altura
                            ),
                            titulo
                    ));
                    break;
                }
                case 4: {
                    System.out.print("Ingresar nombre de la materia: ");
                    String nombre = Consola.readLine();
                    materias.agregarMateria(new Materia(0, nombre));
                    break;
                }
                case 5: {
                    Materia m = opcionMenuMateria();
                    Profesor p = opcionMenuProfesor();

                    if ( m!=null && p!=null  ) {
                        materias.asignarProfesor(m, p);
                        System.out.println(p.getNombre().toUpperCase() + " " + p.getApellido().toUpperCase() + " ahora es profesor de " + m.getNombre().toUpperCase() + "...");
                    } else {
                        System.out.println("No hay materias o profesores cargados....");
                    }

                    Consola.stop();
                    break;
                }
                case 6: {
                    Materia m = opcionMenuMateria();
                    Alumno a = opcionMenuAlumno();

                    if ( m!=null && a!=null  ) {
                        System.out.print("Nota: ");
                        float nota = Consola.readFloat();
                        notas.agregarNota(new Nota(a, m, nota));
                        materias.inscribirAlumno(m, a);
                        System.out.println(a.getNombre().toUpperCase() + " " + a.getApellido().toUpperCase() + " se inscribió a " + m.getNombre().toUpperCase() + " y su nota es " + nota + "...");
                    } else {
                        System.out.println("No hay materias o alumnos cargados....");
                    }

                    Consola.stop();
                    break;
                }
                case 7: {
                    Materia m = opcionMenuMateria();

                    if ( m != null ) {
                        System.out.println(m.getNombre().toUpperCase() + ":");
                        if ( materias.alumnosPorMateria(m).size() > 0 ) {
                            for (Alumno alumno:materias.alumnosPorMateria(m)) {
                                System.out.println("- " + alumno.getApellido() + ", " + alumno.getNombre());
                            }
                        } else {
                            System.out.println("No hay alumnos inscriptos...");
                        }
                    } else {
                        System.out.println("No hay materias cargadas...");
                    }

                    Consola.stop();
                    break;
                }
                case 8: {
                    Materia m = opcionMenuMateria();
                    if ( m != null ) {
                        if ( notas.getNotas().size() > 0 ) {
                            Nota menorNota = notas.getNotas().get(0);
                            Nota mayorNota = notas.getNotas().get(0);

                            for (Nota n:notas.notasPorMateria(m)) {
                                if ( n.getNota() > mayorNota.getNota() ) {
                                    mayorNota = n;
                                }

                                if ( n.getNota() < menorNota.getNota() ) {
                                    menorNota = n;
                                }
                            }

                            System.out.println("MAYOR NOTA:");
                            System.out.println("- " + mayorNota.getAlumno().getApellido() + ", " + mayorNota.getAlumno().getNombre());
                            System.out.println("- " + mayorNota.getNota() + "\n");

                            System.out.println("MENOR NOTA:");
                            System.out.println("- " + menorNota.getAlumno().getApellido() + ", " + menorNota.getAlumno().getNombre());
                            System.out.println("- " + menorNota.getNota() + "\n");
                        } else {
                            System.out.println("No hay notas cargadas...");
                        }
                    } else {
                        System.out.println("No hay materias cargadas...");
                    }

                    Consola.stop();
                    break;
                }
                case 9: {
                    int max_alumnos = 0;
                    Profesor max_profesor = null;

                    if ( profesores.getProfesores().size() > 0 ) {
                        for (Profesor p:profesores.getProfesores()) {
                            if ( materias.alumnosPorProfesor(p).size() > max_alumnos ) {
                                max_alumnos = materias.alumnosPorProfesor(p).size();
                                max_profesor = p;
                            }
                        }
                    }

                    System.out.println("PROFESOR CON MAS ALUMNOS:");

                    if ( max_profesor != null ) {
                        System.out.println("- " + max_profesor.getApellido() + ", " + max_profesor.getNombre());
                        System.out.println("- " + max_alumnos + " alumnos en todas sus materias\n\n");
                    } else {
                        System.out.println("No hay profesores con alumnos...");
                    }

                    Consola.stop();
                    break;
                }
                case 10: {
                    if ( materias.getMaterias().size() > 0 ) {
                        for ( Materia materia:materias.getMaterias() ) {
                            System.out.println("MATERIA: " + materia.getNombre());
                            if ( materia.getProfesor() != null ) {
                                System.out.println("PROFESOR: " + materia.getProfesor().getApellido() + ", " + materia.getProfesor().getNombre());
                            } else {
                                System.out.println("PROFESOR: No tiene profesor asignado");
                            }

                            if ( materia.getAlumnos().size() > 0 ) {
                                System.out.println("ALUMNOS: ");
                                for ( Alumno alumno:materia.getAlumnos() ) {
                                    System.out.println("- " + alumno.getApellido() + ", " + alumno.getNombre() + " (nota " + notas.notaPorMateriaAlumno(materia, alumno).getNota() + ")");
                                }
                            } else {
                                System.out.println("ALUMNOS: No hay alumnos inscriptos");
                            }
                            System.out.println("\n");
                        }
                    } else {
                        System.out.println("No hay materias cargadas...");
                    }
                    Consola.stop();
                    break;
                }
                case 11: {
                    System.out.println("Chau...!");
                    break;
                }
            }
        } while( opcion !=11 );
    }

    private static int opcionMenu() {
        System.out.println("╔══════════════╗");
        System.out.println("║     MENU     ║");
        System.out.println("╚══════════════╝");
        System.out.println("1. CARGAR DATOS PARA PRUEBAS");
        System.out.println("2. INGRESAR ALUMNO");
        System.out.println("3. INGRESAR PROFESOR");
        System.out.println("4. INGRESAR MATERIA");
        System.out.println("5. ASIGNAR PROFESOR A MATERIA");
        System.out.println("6. ASIGNAR MATERIA Y NOTA A ALUMNO");
        System.out.println("7. BUSCAR ALUMNOS POR MATERIA");
        System.out.println("8. BUSCAR MENOR Y MAYOR NOTA POR MATERIA");
        System.out.println("9. BUSCAR PROFESOR CON MÁS ALUMNOS");
        System.out.println("10. VER MATERIAS");
        System.out.println("11. SALIR\n");

        int opcion;

        do {
            System.out.print("[ELEGIR OPCION]: ");
            opcion = Consola.readInt();
        } while (!valido(opcion, new int[] {1,2,3,4,5,6,7,8,9,10,11}));
        System.out.println("");

        return opcion;
    }

    public static Alumno opcionMenuAlumno() {
        int opcion;
        Alumno res;

        if ( alumnos.getAlumnos().size() > 0 ) {
            System.out.println("╔════════════════╗");
            System.out.println("║     ALUMNO     ║");
            System.out.println("╚════════════════╝");

            for (Alumno alumno: alumnos.getAlumnos()) {
                System.out.println(alumno.getId() + ". " + alumno.getApellido().toUpperCase() + ", " + alumno.getNombre().toUpperCase());
            }
            System.out.println("");

            do {
                System.out.print("[ELEGIR OPCION]: ");
                opcion = Consola.readInt();
                res = alumnos.alumnoPorID(opcion);
            } while (res == null);

            return res;
        }

        return null;
    }

    public static Profesor opcionMenuProfesor() {
        int opcion;
        Profesor res;

        if ( profesores.getProfesores().size() > 0 ) {
            System.out.println("╔══════════════════╗");
            System.out.println("║     PROFESOR     ║");
            System.out.println("╚══════════════════╝");

            for (Profesor profesor: profesores.getProfesores()) {
                System.out.println(profesor.getId() + ". " + profesor.getApellido().toUpperCase() + ", " + profesor.getNombre().toUpperCase());
            }
            System.out.println("");

            do {
                System.out.print("[ELEGIR OPCION]: ");
                opcion = Consola.readInt();
                res = profesores.profesorPorID(opcion);
            } while (res == null);

            return res;
        }

        return null;
    }

    public static Materia opcionMenuMateria() {
        int opcion;
        Materia res;

        if ( materias.getMaterias().size() > 0 ) {
            System.out.println("╔═════════════════╗");
            System.out.println("║     MATERIA     ║");
            System.out.println("╚═════════════════╝");

            for (Materia materia: materias.getMaterias()) {
                System.out.println(materia.getId() + ". " + materia.getNombre().toUpperCase());
            }
            System.out.println("");

            do {
                System.out.print("[ELEGIR OPCION]: ");
                opcion = Consola.readInt();
                res = materias.materiaPorID(opcion);
            } while (res == null);

            return res;
        }

        return null;
    }

    public static void cargarDatos() {
        System.out.println("Cargando 5 materias...");
        materias.agregarMateria(new Materia(0, "Programación"));
        materias.agregarMateria(new Materia(0, "Fisica"));
        materias.agregarMateria(new Materia(0, "Química"));
        materias.agregarMateria(new Materia(0, "Análisis Matemático"));
        materias.agregarMateria(new Materia(0, "Sistemas"));

        System.out.println("Cargando 5 alumnos...");
        alumnos.agregarAlumno(new Alumno(
                0,
                "Luis",
                "Lopez",
                "1111111111",
                'm',
                fecha("11-11-1999"),
                new Contacto(
                        "22222222222",
                        "xxxx@gmail.com",
                        "Argentina",
                        "La Rioja",
                        "La Rioja",
                        "Calle Falsa",
                        123
                ),
                "SLK123"
        ));

        alumnos.agregarAlumno(new Alumno(
                0,
                "Jorge",
                "Martinez",
                "2222222222",
                'm',
                fecha("11-11-2000"),
                new Contacto(
                        "22222222222",
                        "xxxx@gmail.com",
                        "Argentina",
                        "La Rioja",
                        "La Rioja",
                        "Calle Falsa",
                        123
                ),
                "SLK124"
        ));

        alumnos.agregarAlumno(new Alumno(
                0,
                "Erica",
                "Rodriguez",
                "333333333",
                'f',
                fecha("11-11-2001"),
                new Contacto(
                        "22222222222",
                        "xxxx@gmail.com",
                        "Argentina",
                        "La Rioja",
                        "La Rioja",
                        "Calle Falsa",
                        123
                ),
                "SLK125"
        ));

        alumnos.agregarAlumno(new Alumno(
                0,
                "Tatiana",
                "Perez",
                "444444444",
                'f',
                fecha("11-11-1998"),
                new Contacto(
                        "22222222222",
                        "xxxx@gmail.com",
                        "Argentina",
                        "La Rioja",
                        "La Rioja",
                        "Calle Falsa",
                        123
                ),
                "SLK130"
        ));

        alumnos.agregarAlumno(new Alumno(
                0,
                "Mariana",
                "Romero",
                "5555555555",
                'f',
                fecha("11-11-1997"),
                new Contacto(
                        "22222222222",
                        "xxxx@gmail.com",
                        "Argentina",
                        "La Rioja",
                        "La Rioja",
                        "Calle Falsa",
                        123
                ),
                "SLK190"
        ));

        System.out.println("Cargando 3 profesores...");
        profesores.agregarProfesor(new Profesor(
                0,
                "Mariano",
                "Paez",
                "88888888",
                'm',
                fecha("11-11-1981"),
                new Contacto(
                        "22222222222",
                        "xxxx@gmail.com",
                        "Argentina",
                        "La Rioja",
                        "La Rioja",
                        "Calle Falsa",
                        123
                ),
                "Ingeniero en Sistemas"
        ));

        profesores.agregarProfesor(new Profesor(
                0,
                "Rosa",
                "Hernandez",
                "99999999999",
                'm',
                fecha("11-11-1986"),
                new Contacto(
                        "22222222222",
                        "xxxx@gmail.com",
                        "Argentina",
                        "La Rioja",
                        "La Rioja",
                        "Calle Falsa",
                        123
                ),
                "Licenciado en Sistemas"
        ));

        profesores.agregarProfesor(new Profesor(
                0,
                "Gonzalo",
                "Suarez",
                "33000987",
                'm',
                fecha("01-01-1980"),
                new Contacto(
                        "22222222222",
                        "xxxx@gmail.com",
                        "Argentina",
                        "La Rioja",
                        "La Rioja",
                        "Calle Falsa",
                        123
                ),
                "Analista en Sistemas"
        ));

        System.out.println("Asignando profesores a materias...");
        materias.asignarProfesor(materias.materiaPorID(1), profesores.profesorPorID(1));
        materias.asignarProfesor(materias.materiaPorID(2), profesores.profesorPorID(1));
        materias.asignarProfesor(materias.materiaPorID(3), profesores.profesorPorID(3));
        materias.asignarProfesor(materias.materiaPorID(4), profesores.profesorPorID(2));
        materias.asignarProfesor(materias.materiaPorID(5), profesores.profesorPorID(3));

        System.out.println("Inscribiendo alumnos en materias y asignando nota....");
        int alumno = 1;
        int materia = 1;
        notas.agregarNota(new Nota(alumnos.alumnoPorID(alumno), materias.materiaPorID(materia), 7));
        materias.inscribirAlumno(materias.materiaPorID(materia), alumnos.alumnoPorID(alumno));

        alumno = 1;
        materia = 2;
        notas.agregarNota(new Nota(alumnos.alumnoPorID(alumno), materias.materiaPorID(materia), 4));
        materias.inscribirAlumno(materias.materiaPorID(materia), alumnos.alumnoPorID(alumno));

        alumno = 1;
        materia = 3;
        notas.agregarNota(new Nota(alumnos.alumnoPorID(alumno), materias.materiaPorID(materia), 8));
        materias.inscribirAlumno(materias.materiaPorID(materia), alumnos.alumnoPorID(alumno));

        alumno = 1;
        materia = 4;
        notas.agregarNota(new Nota(alumnos.alumnoPorID(alumno), materias.materiaPorID(materia), 2));
        materias.inscribirAlumno(materias.materiaPorID(materia), alumnos.alumnoPorID(alumno));

        alumno = 2;
        materia = 5;
        notas.agregarNota(new Nota(alumnos.alumnoPorID(alumno), materias.materiaPorID(materia), 10));
        materias.inscribirAlumno(materias.materiaPorID(materia), alumnos.alumnoPorID(alumno));

        alumno = 2;
        materia = 4;
        notas.agregarNota(new Nota(alumnos.alumnoPorID(alumno), materias.materiaPorID(materia), 6));
        materias.inscribirAlumno(materias.materiaPorID(materia), alumnos.alumnoPorID(alumno));

        alumno = 2;
        materia = 3;
        notas.agregarNota(new Nota(alumnos.alumnoPorID(alumno), materias.materiaPorID(materia), 9));
        materias.inscribirAlumno(materias.materiaPorID(materia), alumnos.alumnoPorID(alumno));

        alumno = 3;
        materia = 3;
        notas.agregarNota(new Nota(alumnos.alumnoPorID(alumno), materias.materiaPorID(materia), 8));
        materias.inscribirAlumno(materias.materiaPorID(materia), alumnos.alumnoPorID(alumno));

        alumno = 3;
        materia = 1;
        notas.agregarNota(new Nota(alumnos.alumnoPorID(alumno), materias.materiaPorID(materia), 7));
        materias.inscribirAlumno(materias.materiaPorID(materia), alumnos.alumnoPorID(alumno));

        alumno = 3;
        materia = 5;
        notas.agregarNota(new Nota(alumnos.alumnoPorID(alumno), materias.materiaPorID(materia), 3));
        materias.inscribirAlumno(materias.materiaPorID(materia), alumnos.alumnoPorID(alumno));

        alumno = 4;
        materia = 1;
        notas.agregarNota(new Nota(alumnos.alumnoPorID(alumno), materias.materiaPorID(materia), 5));
        materias.inscribirAlumno(materias.materiaPorID(materia), alumnos.alumnoPorID(alumno));

        alumno = 4;
        materia = 2;
        notas.agregarNota(new Nota(alumnos.alumnoPorID(alumno), materias.materiaPorID(materia), 8));
        materias.inscribirAlumno(materias.materiaPorID(materia), alumnos.alumnoPorID(alumno));

        alumno = 5;
        materia = 3;
        notas.agregarNota(new Nota(alumnos.alumnoPorID(alumno), materias.materiaPorID(materia), 1));
        materias.inscribirAlumno(materias.materiaPorID(materia), alumnos.alumnoPorID(alumno));

        System.out.println("Carga completada...");

    }

    public static boolean valido(int val, int[] array) {
        for (int x : array) {
            if (x == val) {
                return true;
            }
        }
        return false;
    }

    public static boolean valido(char val, char[] array) {
        for (char x : array) {
            if (x == val) {
                return true;
            }
        }
        return false;
    }

    public static Date fecha(String f) {
        try {
            return new SimpleDateFormat("dd-MM-yyyy").parse(f);
        }  catch (ParseException e) {
            return null;
        }
    }
}

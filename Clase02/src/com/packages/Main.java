package com.packages;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
        ArrayList<Profesor> profesores = new ArrayList<Profesor>();

        int opcionMenu = 0;
        Map<String, Object> dataPersona = new HashMap<String, Object>();

        do {
            opcionMenu = opcionMenuPrincipal();
            System.out.println("\n\n");

            switch (opcionMenu) {
                /* CARGAR ALUMNO */
                case 1: {
                    dataPersona = cargarPersona(1);
                    alumnos.add(new Alumno(
                            (String) dataPersona.get("nombre"),
                            (String) dataPersona.get("apellido"),
                            (String) dataPersona.get("dni"),
                            (char) dataPersona.get("sexo"),
                            (String) dataPersona.get("nacionalidad"),
                            (LocalDate) dataPersona.get("nacimiento"),
                            (int) dataPersona.get("nota"),
                            (String) dataPersona.get("curso")
                    ));
                    break;
                }
                /* CARGAR PROFESOR */
                case 2: {
                    dataPersona = cargarPersona(2);
                    profesores.add(new Profesor(
                            (String) dataPersona.get("nombre"),
                            (String) dataPersona.get("apellido"),
                            (String) dataPersona.get("dni"),
                            (char) dataPersona.get("sexo"),
                            (String) dataPersona.get("nacionalidad"),
                            (LocalDate) dataPersona.get("nacimiento"),
                            (String) dataPersona.get("titulo"),
                            (String) dataPersona.get("catedra")
                    ));
                    break;
                }
                /* MOSTRAR ALUMNOS */
                case 3: {
                    if (alumnos.size() > 0) {
                        for (int i = 0; i < alumnos.size(); i++) {
                            mostrarPersona(alumnos.get(i));
                        }
                    } else {
                        System.out.println("No hay datos cargados...");
                    }
                    parar();
                    break;
                }
                /* MOSTRAR PROFESORES */
                case 4: {
                    if (profesores.size() > 0) {
                        for (int i = 0; i < profesores.size(); i++) {
                            mostrarPersona(profesores.get(i));
                        }
                    } else {
                        System.out.println("No hay datos cargados...");
                    }
                    parar();
                    break;
                }
                /* BUSCAR ALUMNOS */
                case 5: {
                    int opCampo = opcionMenuBusquedaCampo();
                    System.out.print("Ingrese el texto de busqueda: ");
                    String txtBusqueda = Consola.readLine();
                    System.out.println("\n");
                    ArrayList<Alumno> resultados = busquedaAlumno(alumnos,opCampo,txtBusqueda);
                    for (Alumno alumno:resultados) {
                        mostrarPersona(alumno);
                    }
                    parar();
                    break;
                }
                /* BUSCAR PROFESORES */
                case 6: {
                    int opCampo = opcionMenuBusquedaCampo();
                    System.out.print("Ingrese el texto de busqueda: ");
                    String txtBusqueda = Consola.readLine();
                    System.out.println("\n");
                    ArrayList<Profesor> resultados = busquedaProfesor(profesores,opCampo,txtBusqueda);
                    for (Profesor profesor:resultados) {
                        mostrarPersona(profesor);
                    }
                    parar();
                    break;
                }
                /* SALIR */
                case 7: {
                    System.out.println("Chau!");
                    break;
                }
            }

            System.out.println("\n\n");
        } while(opcionMenu != 7);
    }


    /**
     * Cargar datos de un alumno o profesor y devuelve los datos en una variable tipo Map
     * @param tipo
     * @return Map con datos del alumno o profesor
     */
    static Map<String, Object> cargarPersona(int tipo) {
        Map<String, Object> data = new HashMap<String, Object>();

        System.out.print("Ingrese nombre: ");
        data.put("nombre", Consola.readLine());

        System.out.print("Ingrese apellido: ");
        data.put("apellido", Consola.readLine());

        System.out.print("Ingrese DNI: ");
        data.put("dni", Consola.readLine());

        do {
            System.out.print("Ingrese sexo (F o M): ");
            data.put("sexo", Consola.readChar());
        } while (!valido((char) data.get("sexo"), new char[] {'f','m','F','M'}));

        System.out.print("Ingrese fecha de nacimiento (dd-mm-aaaa): ");
        data.put("nacimiento", Consola.readLocalDate());

        System.out.print("Ingrese nacinalidad: ");
        data.put("nacionalidad", Consola.readLine());

        if (tipo == 1) {
            System.out.print("Ingrese nota: ");
            data.put("nota", Consola.readInt());

            System.out.print("Ingrese curso: ");
            data.put("curso", Consola.readLine());
        } else {
            System.out.print("Ingrese titulo: ");
            data.put("titulo", Consola.readLine());

            System.out.print("Ingrese catedra: ");
            data.put("catedra", Consola.readLine());
        }
        return data;
    }


    /**
     * Imprime menú y devuelve la opción elegida
     * @return int
     */
    static int opcionMenuPrincipal() {
        System.out.println("╔══════════════╗");
        System.out.println("║     MENU     ║");
        System.out.println("╚══════════════╝");
        System.out.println("1. CARGAR ALUMNO");
        System.out.println("2. CARGAR PROFESOR");
        System.out.println("3. VER ALUMNOS");
        System.out.println("4. VER PROFESORES");
        System.out.println("5. BUSCAR ALUMNOS");
        System.out.println("6. BUSCAR PROFESORES");
        System.out.println("7. SALIR\n");

        int opcion;

        do {
            System.out.print("[ELEGIR OPCION]: ");
            opcion = Consola.readInt();
        } while (!valido(opcion, new int[] {1,2,3,4,5,6,7}));

        return opcion;
    }


    /**
     * Imprime menú y devuelve la opción elegida
     * @return int
     */
    static int opcionMenuBusquedaCampo() {
        System.out.println("╔════════════════════╗");
        System.out.println("║      BUSCAR POR    ║");
        System.out.println("╚════════════════════╝");
        System.out.println("1. NOMBRE");
        System.out.println("2. APELLIDO");
        System.out.println("3. DNI\n");

        int opcion;

        do {
            System.out.print("[ELEGIR OPCION]: ");
            opcion = Consola.readInt();
        } while (!valido(opcion, new int[] {1,2,3}));

        return opcion;
    }


    /**
     * Imprime los datos del alumno que recibe como parámetro
     * @param persona
     */
    static void mostrarPersona(Alumno persona) {
        System.out.println("\n-----------------------------------");
        System.out.println("Nombre y apellido: " + persona.getNombre() + " " + persona.getApellido());
        System.out.println("DNI: " + persona.getDni());
        System.out.println("Edad: " + persona.getEdad());
        System.out.println("Nacionalidad: " + persona.getNacionalidad());
        System.out.println("Sexo: " + persona.getSexo());
        System.out.println("Curso: " + persona.getCurso());
        System.out.println("Nota: " + persona.getNota());
        System.out.println("-----------------------------------\n");
    }


    /**
     * Imprime los datos del profesor que recibe como parámetro
     * @param persona
     */
    static void mostrarPersona(Profesor persona) {
        System.out.println("\n-----------------------------------");
        System.out.println("Nombre y apellido: " + persona.getNombre() + " " + persona.getApellido());
        System.out.println("DNI: " + persona.getDni());
        System.out.println("Edad: " + persona.getEdad());
        System.out.println("Nacionalidad: " + persona.getNacionalidad());
        System.out.println("Sexo: " + persona.getSexo());
        System.out.println("Titulo: " + persona.getTitulo());
        System.out.println("Catedra: " + persona.getCatedra());
        System.out.println("-----------------------------------\n");
    }


    /**
     * Busca el texto recibido en el campo especificado de cada alumno
     * @param alumnos
     * @param campo
     * @param txt
     * @return ArrayList
     */
    public static ArrayList<Alumno> busquedaAlumno(ArrayList<Alumno> alumnos, int campo, String txt) {
        ArrayList<Alumno> aux = new ArrayList<Alumno>();

        for (Alumno alumno: alumnos) {
            if (campo == 1 && alumno.getNombre().equals(txt)) {
                aux.add(alumno);
            }

            if (campo == 2 && alumno.getApellido().equals(txt)) {
                aux.add(alumno);
            }

            if (campo == 3 && alumno.getDni().equals(txt)) {
                aux.add(alumno);
            }
        }

        return aux;
    }


    /**
     * Busca el texto recibido en el campo especificado de cada profesor
     * @param profesores
     * @param campo
     * @param txt
     * @return ArrayList
     */
    public static ArrayList<Profesor> busquedaProfesor(ArrayList<Profesor> profesores, int campo, String txt) {
        ArrayList<Profesor> aux = new ArrayList<Profesor>();

        for (Profesor profesor: profesores) {
            if (campo == 1 && profesor.getNombre().equals(txt)) {
                aux.add(profesor);
            }

            if (campo == 2 && profesor.getApellido().equals(txt)) {
                aux.add(profesor);
            }

            if (campo == 3 && profesor.getDni().equals(txt)) {
                aux.add(profesor);
            }
        }

        return aux;
    }


    /**
     * Detiene la ejecución hasta que se presione ENTER
     */
    static void parar() {
        System.out.println("\nPresione ENTER para continuar...");
        Consola.readLine();
    }


    /**
     * Valida el caracter recibido comparándolo con el arreglo de caracteres válidos
     * @param val
     * @param array
     * @return Devuelve true si el caracter se encuentra en el arreglo
     */
    static boolean valido(char val, char[] array) {
        for (char x : array) {
            if (x == val) {
                return true;
            }
        }
        return false;
    }


    /**
     * Valida el entero recibido comparándolo con el arreglo de enteros válidos
     * @param val
     * @param array
     * @return Devuelve true si el entero se encuentra en el arreglo
     */
    static boolean valido(int val, int[] array) {
        for (int x : array) {
            if (x == val) {
                return true;
            }
        }
        return false;
    }
}

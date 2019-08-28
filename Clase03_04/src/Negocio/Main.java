 /*
    Repositorio:
 */
package Negocio;
import Modelo.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    private static ControlMovimientos movimientos = new ControlMovimientos();
    private static ControlMonedas monedas = new ControlMonedas();
    private static ControlPersonas personas = new ControlPersonas();
    private static ControlDetalles detalles = new ControlDetalles();
    private static ControlTipoPago tiposPago = new ControlTipoPago();

    public static void main(String[] args) {
        int opMenu;

        // Cargando datos para pruebas

        monedas.agregarMoneda(new Moneda(0,"ARS",0.018F));
        monedas.agregarMoneda(new Moneda(0,"USD",1.0F));
        monedas.agregarMoneda(new Moneda(0,"EUR",1.11F));

        detalles.agregarDetalle(new DetalleMovimiento(0, "Prestamo"));
        detalles.agregarDetalle(new DetalleMovimiento(0, "Devolución"));
        detalles.agregarDetalle(new DetalleMovimiento(0, "Indumentaria"));
        detalles.agregarDetalle(new DetalleMovimiento(0, "Alimentos"));
        detalles.agregarDetalle(new DetalleMovimiento(0, "Salud"));

        tiposPago.agregarTipoPago(new TipoPago(0, "Efectivo"));
        tiposPago.agregarTipoPago(new TipoPago(0, "Crédito"));
        tiposPago.agregarTipoPago(new TipoPago(0, "Débito"));

        personas.agregarPersona(new Cliente(
                0,
                "Juan Perez",
                new Contacto(
                        "3804111111",
                        "juancito@gmail.com",
                        "Argentina",
                        "La Rioja",
                        "La Rioja",
                        "Calle Falsa",
                        123
                ),
                "20-33222111-5",
                "Juan",
                "Perez",
                "33222111",
                'm',
                fecha("10-09-1995")
        ));

        personas.agregarPersona(new Cliente(
                0,
                "José López",
                new Contacto(
                        "351111111",
                        "jose@gmail.com",
                        "Argentina",
                        "Córdoba",
                        "Córdoba",
                        "Calle Falsa",
                        456
                ),
                "20-31222111-5",
                "José",
                "López",
                "31222111",
                'm',
                fecha("14-05-1999")
        ));

        personas.agregarPersona(new Cliente(
                0,
                "Marcelo Moreno",
                new Contacto(
                        "3804224444",
                        "marce_93@gmail.com",
                        "Argentina",
                        "La Rioja",
                        "La Rioja",
                        "Calle Falsa",
                        789
                ),
                "20-30666777-5",
                "Marcelo",
                "Moreno",
                "30666777",
                'm',
                fecha("05-02-1993")
        ));

        personas.agregarPersona(new Proveedor(
                0,
                "Farmacity",
                new Contacto(
                        "38047777",
                        "farmacity@hotmail.com",
                        "Argentina",
                        "La Rioja",
                        "La Rioja",
                        "Calle Falsa",
                        123
                ),
                "20-7777777-5",
                "Farmacity"
        ));

        movimientos.agregarMovimiento(
                new Movimiento(
                        fecha("10-08-2019"),
                        fecha("30-08-2019"),
                        10000.0F,
                        "préstamo a marcelo",
                        detalles.detallePorID(1),
                        monedas.monedaPorID(1).getCotizacion(),
                        monedas.monedaPorID(1),
                        tiposPago.tipoPagoPorID(1),
                        new TipoMovimiento(TipoMovimiento.EGRESO),
                        personas.personaPorID(3)
                 )
        );

        movimientos.agregarMovimiento(
                new Movimiento(
                        fecha("10-08-2019"),
                        fecha("03-09-2019"),
                        2000.0F,
                        "préstamo a josé",
                        detalles.detallePorID(1),
                        monedas.monedaPorID(1).getCotizacion(),
                        monedas.monedaPorID(1),
                        tiposPago.tipoPagoPorID(1),
                        new TipoMovimiento(TipoMovimiento.EGRESO),
                        personas.personaPorID(2)
                )
        );

        movimientos.agregarMovimiento(
                new Movimiento(
                        fecha("29-08-2019"),
                        null,
                        4000.0F,
                        "devolución de marcelo",
                        detalles.detallePorID(2),
                        monedas.monedaPorID(1).getCotizacion(),
                        monedas.monedaPorID(1),
                        tiposPago.tipoPagoPorID(1),
                        new TipoMovimiento(TipoMovimiento.INGRESO),
                        personas.personaPorID(3)
                )
        );

        movimientos.agregarMovimiento(
                new Movimiento(
                        fecha("30-08-2019"),
                        fecha("07-09-2019"),
                        4000.0F,
                        "préstamo de juan",
                        detalles.detallePorID(1),
                        monedas.monedaPorID(1).getCotizacion(),
                        monedas.monedaPorID(1),
                        tiposPago.tipoPagoPorID(1),
                        new TipoMovimiento(TipoMovimiento.INGRESO),
                        personas.personaPorID(1)
                )
        );

        movimientos.agregarMovimiento(
                new Movimiento(
                        fecha("03-09-2019"),
                        null,
                        2000.0F,
                        "devolución de josé",
                        detalles.detallePorID(2),
                        monedas.monedaPorID(1).getCotizacion(),
                        monedas.monedaPorID(1),
                        tiposPago.tipoPagoPorID(1),
                        new TipoMovimiento(TipoMovimiento.INGRESO),
                        personas.personaPorID(2)
                )
        );

        movimientos.agregarMovimiento(
                new Movimiento(
                        fecha("30-08-2019"),
                        null,
                        3500.0F,
                        "devolución de marcelo",
                        detalles.detallePorID(2),
                        monedas.monedaPorID(1).getCotizacion(),
                        monedas.monedaPorID(1),
                        tiposPago.tipoPagoPorID(1),
                        new TipoMovimiento(TipoMovimiento.INGRESO),
                        personas.personaPorID(3)
                )
        );

        do {
            opMenu = opcionMenuPrincipal();

            switch (opMenu) {
                case 1: {
                    for (Movimiento movimiento : movimientos.getMovimientos()) {
                        mostrarMovimiento(movimiento);
                    }
                    System.out.println("Presione [ENTER] para continuar...");
                    Consola.readChar();
                    break;
                }
                case 2: {
                    for (Movimiento movimiento : movimientos.verEgresos(fecha("01-07-2019"), fecha("31-12-2019"))) {
                        mostrarMovimiento(movimiento);
                    }
                    System.out.println("Presione [ENTER] para continuar...");
                    Consola.readChar();
                    break;
                }
                case 3: {
                    for (Movimiento movimiento : movimientos.verIngresos(fecha("01-07-2019"), fecha("31-12-2019"))) {
                        mostrarMovimiento(movimiento);
                    }
                    System.out.println("Presione [ENTER] para continuar...");
                    Consola.readChar();
                    break;
                }
                case 4: {
                    DetalleMovimiento d = opcionMenuDetalle();
                    if ( d != null ) {
                        for (Movimiento movimiento : movimientos.verMovimientosPorDetalle(fecha("01-07-2019"), fecha("31-12-2019"),d.getId())) {
                            mostrarMovimiento(movimiento);
                        }
                    } else {
                        System.out.println("No elegiste un detalle de la lista...");
                    }
                    System.out.println("Presione [ENTER] para continuar...");
                    Consola.readChar();
                    break;
                }
                case 5: {
                    float ahorro = movimientos.porcentajeAhorro(fecha("01-07-2019"), fecha("31-12-2019"));
                    System.out.println("\nPORCENTAJE DE AHORRO: " + ahorro + "\n");
                    System.out.println("Presione [ENTER] para continuar...");
                    Consola.readChar();
                    break;
                }
                case 6: {
                    for (DeudaXPersona deudaXPersona : movimientos.deudaXAcreedor(fecha("01-07-2019"), fecha("31-12-2019"))) {
                        System.out.println(
                                "Persona: " + deudaXPersona.getPersona().getDescripcion() + "\n" +
                                "Deuda: " + deudaXPersona.getDeuda() + "\n\n"
                        );
                    }
                    System.out.println("Presione [ENTER] para continuar...");
                    Consola.readChar();
                    break;
                }
                case 7: {
                    Persona p = opcionMenuPersona();
                    if ( p != null ) {
                        for (Movimiento movimiento : movimientos.historial(fecha("01-07-2019"), fecha("31-12-2019"),p.getId())) {
                            mostrarMovimiento(movimiento);
                        }
                    } else {
                        System.out.println("No elegiste una persona de la lista...");
                    }
                    System.out.println("Presione [ENTER] para continuar...");
                    Consola.readChar();
                    break;
                }
                case 8: {
                    System.out.println("Chau...!");
                    break;
                }
            }
        } while(opMenu != 8);
    }

    /**
     * Imprime menú y devuelve la opción elegida
     * @return int
     */
    public static int opcionMenuPrincipal() {
        System.out.println("╔══════════════╗");
        System.out.println("║     MENU     ║");
        System.out.println("╚══════════════╝");
        System.out.println("1. VER MOVIMIENTOS");
        System.out.println("2. VER EGRESOS DEL ULTIMO SEMESTRE");
        System.out.println("3. VER INGRESOS DEL ULTIMO SEMESTRE");
        System.out.println("4. VER MOVIMIENTOS POR DETALLE");
        System.out.println("5. VER PORCENTAJE DE AHORRO ULTIMO SEMESTRE");
        System.out.println("6. VER DEUDA POR CLIENTES O PROVEEDORES");
        System.out.println("7. VER HISTORIAL POR CLIENTES O PROVEEDORES");
        System.out.println("8. SALIR\n");

        int opcion;

        do {
            System.out.print("[ELEGIR OPCION]: ");
            opcion = Consola.readInt();
        } while (!valido(opcion, new int[] {1,2,3,4,5,6,7,8}));

        return opcion;
    }

    public static Persona opcionMenuPersona() {
        System.out.println("╔═════════════════╗");
        System.out.println("║     PERSONA     ║");
        System.out.println("╚═════════════════╝");

        System.out.println("0. SALIR");
        for (Persona persona: personas.getPersonas()) {
            System.out.println(persona.getId() + ". " + persona.getDescripcion().toUpperCase());
        }
        System.out.println("");

        int opcion;
        Persona per = null;

        do {
            System.out.print("[ELEGIR OPCION]: ");
            opcion = Consola.readInt();
            per = personas.personaPorID(opcion);
        } while (per == null || opcion == 0);

        return per;
    }

    public static DetalleMovimiento opcionMenuDetalle() {
        System.out.println("╔═════════════════╗");
        System.out.println("║     DETALLE     ║");
        System.out.println("╚═════════════════╝");

        System.out.println("0. SALIR");
        for (DetalleMovimiento detalle: detalles.getDetalles()) {
            System.out.println(detalle.getId() + ". " + detalle.getDescripcion().toUpperCase());
        }
        System.out.println("");

        int opcion;
        DetalleMovimiento det = null;

        do {
            System.out.print("[ELEGIR OPCION]: ");
            opcion = Consola.readInt();
            det = detalles.detallePorID(opcion);
        } while (det == null || opcion == 0);

        return det;
    }

    public static void mostrarMovimiento(Movimiento movimiento) {
        System.out.println(
                "Descripción: " + movimiento.getDescripcion() + "\n" +
                "Detalle: " + movimiento.getDetalleMovimiento().getDescripcion() + "\n" +
                "Monto: " + movimiento.getMonto() + "\n" +
                "Persona: " + movimiento.getPersona().getDescripcion() + "\n" +
                "Tipo de movimiento: " + (movimiento.getTipoMovimiento().getId() == TipoMovimiento.EGRESO ? "EGRESO":"INGRESO" ) + "\n" +
                "Tipo de pago: " + movimiento.getTipoPago().getDescripcion() + "\n\n"
        );
    }

    /**
     * Valida el caracter recibido comparándolo con el arreglo de caracteres válidos
     * @param val
     * @param array
     * @return Devuelve true si el caracter se encuentra en el arreglo
     */
    public static boolean valido(char val, char[] array) {
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
    public static boolean valido(int val, int[] array) {
        for (int x : array) {
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

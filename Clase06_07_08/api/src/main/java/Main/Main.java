/*
    REPOSITORIO: https://github.com/jsmsalt/curso-java
*/

package Main;

import static spark.Spark.*;
import Controllers.*;
import spark.Filter;

public class Main {

    public static void main(String[] args) {

        // Puerto
        port(8080);

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        // Rutas
        path("/api", () -> {

            // Moneda
            get("/monedas", MonedaController.getMonedas);
            get("/monedas/:id", MonedaController.getMoneda);
            delete("/monedas/:id", MonedaController.deleteMoneda);
            put("/monedas/:id", MonedaController.updateMoneda);
            post("/monedas", MonedaController.addMoneda);

            // Tipo Pago
            get("/tipopagos", TipoPagoController.getTipoPagos);
            get("/tipopagos/:id", TipoPagoController.getTipoPago);
            delete("/tipopagos/:id", TipoPagoController.deleteTipoPago);
            put("/tipopagos/:id", TipoPagoController.updateTipoPago);
            post("/tipopagos", TipoPagoController.addTipoPago);

            // Subtipo Movimiento
            get("/subtipos", SubtipoMovimientoController.getSubtiposMovimiento);
            get("/subtipos/:id", SubtipoMovimientoController.getSubtipoMovimiento);
            delete("/subtipos/:id", SubtipoMovimientoController.deleteSubtipoMovimiento);
            put("/subtipos/:id", SubtipoMovimientoController.updateSubtipoMovimiento);
            post("/subtipos", SubtipoMovimientoController.addSubtipoMovimiento);

            // Cliente
            get("/clientes", ClienteController.getClientes);
            get("/clientes/:id", ClienteController.getCliente);
            delete("/clientes/:id", ClienteController.deleteCliente);
            put("/clientes/:id", ClienteController.updateCliente);
            post("/clientes", ClienteController.addCliente);

            // Proveedores
            get("/proveedores", ProveedorController.getProveedores);
            get("/proveedores/:id", ProveedorController.getProveedor);
            delete("/proveedores/:id", ProveedorController.deleteProveedor);
            put("/proveedores/:id", ProveedorController.updateProveedor);
            post("/proveedores", ProveedorController.addProveedor);

            // Movimientos
            get("/movimientos/deudas", MovimientoController.getDeuda);
            get("/movimientos", MovimientoController.getMovimientos);
            get("/movimientos/:id", MovimientoController.getMovimiento);
            delete("/movimientos/:id", MovimientoController.deleteMovimiento);
            put("/movimientos/:id", MovimientoController.updateMovimiento);
            post("/movimientos", MovimientoController.addMovimiento);
        });

    }
}
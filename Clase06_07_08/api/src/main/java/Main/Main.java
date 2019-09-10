package Main;

import static spark.Spark.*;
import Controllers.MonedaController;
import Controllers.SubtipoMovimientoController;
import Controllers.TipoPagoController;

public class Main {

    public static void main(String[] args) {

        // Puerto
        port(8080);

        // Rutas
        path("/api", () -> {
            // Listar monedas
            // GET: http://localhost:8080/api/monedas
            get("/monedas", MonedaController.getMonedas);

            // Mostrar una moneda por ID
            // GET: http://localhost:8080/api/monedas/1
            get("/monedas/:id", MonedaController.getMoneda);

            // Eliminar moneda por ID
            // DELETE: http://localhost:8080/api/monedas/1
            delete("/monedas/:id", MonedaController.deleteMoneda);

            // Actualizar moneda por ID
            // PUT: http://localhost:8080/api/monedas/1
            // RECIBE: "descripcion" (ARS, USD, EUR, etc)
            put("/monedas/:id", MonedaController.updateMoneda);

            // Agregar moneda
            // POST: http://localhost:8080/api/monedas
            // RECIBE: "descripcion" (ARS, USD, EUR, etc)
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
        });

    }
}
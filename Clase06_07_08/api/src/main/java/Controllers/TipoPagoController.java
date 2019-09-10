package Controllers;

import Handlers.TipoPagoHandler;
import spark.Request;
import spark.Response;
import spark.Route;
import static Utils.JsonResponse.error;
import static Utils.JsonResponse.ok;

public class TipoPagoController {
    public static Route getTipoPagos = (Request request, Response response) -> ok(TipoPagoHandler.getTipoPagos(), response);

    public static Route getTipoPago = (Request request, Response response) -> {
        try {
            int id = Integer.parseInt(request.params(":id"));
            return ok(TipoPagoHandler.getTipoPago(id), response);
        } catch (Exception e) {
            return error("El ID es inválido", response);
        }
    };

    public static Route deleteTipoPago = (Request request, Response response) -> {
        try {
            int id = Integer.parseInt(request.params(":id"));
            return ok(TipoPagoHandler.deleteTipoPago(id), response);
        } catch (Exception e) {
            return error("El ID es inválido", response);
        }
    };

    public static Route updateTipoPago = (Request request, Response response) -> {
        String descripcion = request.queryParams("descripcion");

        if (descripcion != null) {
            try {
                int id = Integer.parseInt(request.params(":id"));
                return ok(TipoPagoHandler.updateTipoPago(id, descripcion), response);
            } catch (Exception e) {
                return error("El ID es inválido", response);
            }
        } else {
            return error("No se recibió descripción", response);
        }
    };

    public static Route addTipoPago = (Request request, Response response) -> {
        String descripcion = request.queryParams("descripcion");

        System.out.println(request.raw());

        if (descripcion != null) {
            return ok(TipoPagoHandler.addTipoPago(descripcion), response);
        } else {
            return error("No se recibió descripción", response);
        }
    };

}

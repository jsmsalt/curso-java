package Controllers;

import Handlers.SubtipoMovimientoHandler;
import spark.Request;
import spark.Response;
import spark.Route;
import static Utils.JsonResponse.error;
import static Utils.JsonResponse.ok;

public class SubtipoMovimientoController {
    public static Route getSubtiposMovimiento = (Request request, Response response) -> ok(SubtipoMovimientoHandler.getSubtipoMovimientos(), response);

    public static Route getSubtipoMovimiento = (Request request, Response response) -> {
        try {
            int id = Integer.parseInt(request.params(":id"));
            return ok(SubtipoMovimientoHandler.getSubtipoMovimiento(id), response);
        } catch (Exception e) {
            return error("El ID es inválido", response);
        }
    };

    public static Route deleteSubtipoMovimiento = (Request request, Response response) -> {
        try {
            int id = Integer.parseInt(request.params(":id"));
            return ok(SubtipoMovimientoHandler.deleteSubtipoMovimiento(id), response);
        } catch (Exception e) {
            return error("El ID es inválido", response);
        }
    };

    public static Route updateSubtipoMovimiento = (Request request, Response response) -> {
        String descripcion = request.queryParams("descripcion");

        if (descripcion != null) {
            try {
                int id = Integer.parseInt(request.params(":id"));
                return ok(SubtipoMovimientoHandler.updateSubtipoMovimiento(id, descripcion), response);
            } catch (Exception e) {
                return error("El ID es inválido", response);
            }
        } else {
            return error("No se recibió descripción", response);
        }
    };

    public static Route addSubtipoMovimiento = (Request request, Response response) -> {
        String descripcion = request.queryParams("descripcion");

        if (descripcion != null) {
            return ok(SubtipoMovimientoHandler.addSubtipoMovimiento(descripcion), response);
        } else {
            return error("No se recibió descripción", response);
        }
    };

}

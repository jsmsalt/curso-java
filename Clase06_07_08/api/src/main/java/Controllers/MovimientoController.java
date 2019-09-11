package Controllers;

import Domain.Movimiento;
import Handlers.MovimientoHandler;
import Utils.Mapper;
import com.fasterxml.jackson.core.type.TypeReference;
import spark.Request;
import spark.Response;
import spark.Route;
import java.util.ArrayList;
import static Utils.JsonResponse.ok;
import static Utils.JsonResponse.error;

public class MovimientoController {
    public static Route getMovimientos = (Request request, Response response) -> ok(MovimientoHandler.getMovimientos(), response);

    public static Route getMovimiento = (Request request, Response response) -> {
        try {
            int id = Integer.parseInt(request.params(":id"));
            return ok(MovimientoHandler.getMovimiento(id), response);
        } catch (Exception e) {
            return error("El ID es inválido", response);
        }
    };

    public static Route deleteMovimiento = (Request request, Response response) -> {
        try {
            int id = Integer.parseInt(request.params(":id"));
            return ok(MovimientoHandler.deleteMovimiento(id), response);
        } catch (Exception e) {
            return error("El ID es inválido", response);
        }
    };

    public static Route updateMovimiento = (Request request, Response response) -> {
        int id = -1;

        try {
            id = Integer.parseInt(request.params(":id"));
        } catch (Exception e) {
            return error("El ID es inválido", response);
        }

        ArrayList<Movimiento> movimientos = Mapper.fromJSON(request, new TypeReference<ArrayList<Movimiento>>() {});
        if (movimientos != null && movimientos.size() == 1) {
            return ok(MovimientoHandler.updateMovimiento(id, movimientos.get(0)), response);
        }

        return null;
    };

    public static Route addMovimiento = (Request request, Response response) -> {
        ArrayList<Movimiento> movimientos = Mapper.fromJSON(request, new TypeReference<ArrayList<Movimiento>>() {});
        if (movimientos != null) {
            return ok(MovimientoHandler.addMovimientos(movimientos), response);
        } else {
            return error("Los datos contienen errores", response);
        }
    };

}

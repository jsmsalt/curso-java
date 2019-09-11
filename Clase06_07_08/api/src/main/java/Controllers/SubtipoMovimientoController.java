package Controllers;

import Domain.SubtipoMovimiento;
import Handlers.SubtipoMovimientoHandler;
import Utils.Mapper;
import com.fasterxml.jackson.core.type.TypeReference;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.ArrayList;

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
        int id = -1;

        try {
            id = Integer.parseInt(request.params(":id"));
        } catch (Exception e) {
            return error("El ID es inválido", response);
        }

        ArrayList<SubtipoMovimiento> subtipomovimientos = Mapper.fromJSON(request, new TypeReference<ArrayList<SubtipoMovimiento>>() {});
        if (subtipomovimientos != null && subtipomovimientos.size() == 1) {
            return ok(SubtipoMovimientoHandler.updateSubtipoMovimiento(id, subtipomovimientos.get(0)), response);
        }

        return error("No se enviaron los parametros requeridos", response);
    };

    public static Route addSubtipoMovimiento = (Request request, Response response) -> {
        ArrayList<SubtipoMovimiento> subtipomovimientos = Mapper.fromJSON(request, new TypeReference<ArrayList<SubtipoMovimiento>>() {});
        if (subtipomovimientos != null) {
            return ok(SubtipoMovimientoHandler.addSubtipoMovimientos(subtipomovimientos), response);
        } else {
            return error("Los datos contienen errores", response);
        }
    };

}

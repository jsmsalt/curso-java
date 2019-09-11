package Controllers;

import Domain.Moneda;
import Handlers.MonedaHandler;
import Utils.Mapper;
import com.fasterxml.jackson.core.type.TypeReference;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.ArrayList;

import static Utils.JsonResponse.error;
import static Utils.JsonResponse.ok;

public class MonedaController {
    public static Route getMonedas = (Request request, Response response) -> ok(MonedaHandler.getMonedas(), response);

    public static Route getMoneda = (Request request, Response response) -> {
        try {
            int id = Integer.parseInt(request.params(":id"));
            return ok(MonedaHandler.getMoneda(id), response);
        } catch (Exception e) {
            return error("El ID es inválido", response);
        }
    };

    public static Route deleteMoneda = (Request request, Response response) -> {
        try {
            int id = Integer.parseInt(request.params(":id"));
            return ok(MonedaHandler.deleteMoneda(id), response);
        } catch (Exception e) {
            return error("El ID es inválido", response);
        }
    };

    public static Route updateMoneda = (Request request, Response response) -> {
        int id = -1;

        try {
            id = Integer.parseInt(request.params(":id"));
        } catch (Exception e) {
            return error("El ID es inválido", response);
        }

        ArrayList<Moneda> monedas = Mapper.fromJSON(request, new TypeReference<ArrayList<Moneda>>() {});
        if (monedas != null && monedas.size() == 1) {
            return ok(MonedaHandler.updateMoneda(id, monedas.get(0)), response);
        }

        return null;
    };

    public static Route addMoneda = (Request request, Response response) -> {
        ArrayList<Moneda> monedas = Mapper.fromJSON(request, new TypeReference<ArrayList<Moneda>>() {});
        if (monedas != null) {
            return ok(MonedaHandler.addMonedas(monedas), response);
        } else {
            return error("Los datos contienen errores", response);
        }
    };
}

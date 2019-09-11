package Controllers;

import Domain.TipoPago;
import Handlers.TipoPagoHandler;
import Utils.Mapper;
import com.fasterxml.jackson.core.type.TypeReference;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.ArrayList;

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
        int id = -1;

        try {
            id = Integer.parseInt(request.params(":id"));
        } catch (Exception e) {
            return error("El ID es inválido", response);
        }

        ArrayList<TipoPago> tipopagos = Mapper.fromJSON(request, new TypeReference<ArrayList<TipoPago>>() {});
        if (tipopagos != null && tipopagos.size() == 1) {
            return ok(TipoPagoHandler.updateTipoPago(id, tipopagos.get(0)), response);
        }

        return null;
    };

    public static Route addTipoPago = (Request request, Response response) -> {
        ArrayList<TipoPago> tipopagos = Mapper.fromJSON(request, new TypeReference<ArrayList<TipoPago>>() {});
        if (tipopagos != null) {
            return ok(TipoPagoHandler.addTipoPagos(tipopagos), response);
        } else {
            return error("Los datos contienen errores", response);
        }
    };

}

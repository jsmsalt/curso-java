package Controllers;

import Domain.Proveedor;
import Handlers.ProveedorHandler;
import Utils.Mapper;
import com.fasterxml.jackson.core.type.TypeReference;
import spark.Request;
import spark.Response;
import spark.Route;
import java.util.ArrayList;
import static Utils.JsonResponse.ok;
import static Utils.JsonResponse.error;

public class ProveedorController {
    public static Route getProveedores = (Request request, Response response) -> ok(ProveedorHandler.getProveedores(), response);

    public static Route getProveedor = (Request request, Response response) -> {
        try {
            int id = Integer.parseInt(request.params(":id"));
            return ok(ProveedorHandler.getProveedor(id), response);
        } catch (Exception e) {
            return error("El ID es inválido", response);
        }
    };

    public static Route deleteProveedor = (Request request, Response response) -> {
        try {
            int id = Integer.parseInt(request.params(":id"));
            return ok(ProveedorHandler.deleteProveedor(id), response);
        } catch (Exception e) {
            return error("El ID es inválido", response);
        }
    };

    public static Route updateProveedor = (Request request, Response response) -> {
        int id = -1;

        try {
            id = Integer.parseInt(request.params(":id"));
        } catch (Exception e) {
            return error("El ID es inválido", response);
        }

        ArrayList<Proveedor> proveedores = Mapper.fromJSON(request, new TypeReference<ArrayList<Proveedor>>() {});
        if (proveedores != null && proveedores.size() == 1) {
            return ok(ProveedorHandler.updateProveedor(id, proveedores.get(0)), response);
        }

        return error("No se enviaron los parametros requeridos", response);
    };

    public static Route addProveedor = (Request request, Response response) -> {
        ArrayList<Proveedor> proveedores = Mapper.fromJSON(request, new TypeReference<ArrayList<Proveedor>>() {});
        if (proveedores != null) {
            return ok(ProveedorHandler.addProveedores(proveedores), response);
        } else {
            return error("Los datos contienen errores", response);
        }
    };
}
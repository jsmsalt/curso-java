package Controllers;

import Domain.Cliente;
import Handlers.ClienteHandler;
import Utils.Mapper;
import com.fasterxml.jackson.core.type.TypeReference;
import spark.Request;
import spark.Response;
import spark.Route;
import java.util.ArrayList;
import static Utils.JsonResponse.ok;
import static Utils.JsonResponse.error;

public class ClienteController {
    public static Route getClientes = (Request request, Response response) -> ok(ClienteHandler.getClientes(), response);

    public static Route getCliente = (Request request, Response response) -> {
        try {
            int id = Integer.parseInt(request.params(":id"));
            return ok(ClienteHandler.getCliente(id), response);
        } catch (Exception e) {
            return error("El ID es inválido", response);
        }
    };

    public static Route deleteCliente = (Request request, Response response) -> {
        try {
            int id = Integer.parseInt(request.params(":id"));
            return ok(ClienteHandler.deleteCliente(id), response);
        } catch (Exception e) {
            return error("El ID es inválido", response);
        }
    };

    public static Route updateCliente = (Request request, Response response) -> {
        int id = -1;

        try {
            id = Integer.parseInt(request.params(":id"));
        } catch (Exception e) {
            return error("El ID es inválido", response);
        }

        ArrayList<Cliente> clientes = Mapper.fromJSON(request, new TypeReference<ArrayList<Cliente>>() {});
        if (clientes != null && clientes.size() == 1) {
            return ok(ClienteHandler.updateCliente(id, clientes.get(0)), response);
        }

        return null;
    };

    public static Route addCliente = (Request request, Response response) -> {
        ArrayList<Cliente> clientes = Mapper.fromJSON(request, new TypeReference<ArrayList<Cliente>>() {});
        if (clientes != null) {
            return ok(ClienteHandler.addClientes(clientes), response);
        } else {
            return error("Los datos contienen errores", response);
        }
    };
}

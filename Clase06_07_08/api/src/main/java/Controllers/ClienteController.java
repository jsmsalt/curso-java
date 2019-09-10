package Controllers;

public class ClienteController {
/*    public static Route getMonedas = (Request request, Response response) -> ok(MonedaHandler.getMonedas(), response);

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
        String descripcion = request.queryParams("descripcion");
        String cotizacion = request.queryParams("cotizacion");
        float cotizacionFloat = 0;

        try {
            cotizacionFloat = Float.parseFloat(cotizacion);
        } catch (Exception e) {
            return error("La cotización no es correcta.", response);
        }

        if (descripcion != null) {
            try {
                int id = Integer.parseInt(request.params(":id"));
                return ok(MonedaHandler.updateMoneda(id, descripcion, cotizacionFloat), response);
            } catch (Exception e) {
                return error("El ID es inválido", response);
            }
        } else {
            return error("No se recibió descripción", response);
        }
    };

    public static Route addMoneda = (Request request, Response response) -> {
        String descripcion = request.queryParams("descripcion");
        String cotizacion = request.queryParams("cotizacion");
        float cotizacionFloat = 0;

        try {
            cotizacionFloat = Float.parseFloat(cotizacion);
        } catch (Exception e) {
            return error("La cotización no es correcta.", response);
        }

        if (descripcion != null) {
            return ok(MonedaHandler.addMoneda(descripcion, cotizacionFloat), response);
        } else {
            return error("No se recibió descripción", response);
        }
    };*/
}

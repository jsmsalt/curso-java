package Utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import spark.Response;

public class JsonResponse {
    private static ObjectMapper mapper = new ObjectMapper();

    public static String ok(Object model, Response r) {
        try {
            r.body(mapper.writeValueAsString(model));
            r.status(200);

        } catch (Exception e) {
            r.body("{\"status\": \"" + e.getMessage() + "\"}");
            r.status(500);
        }

        r.type(ContentType.APPLICATION_JSON);
        return r.body();
    }

    public static String ok(String json, Response r) {
        r.body(json);
        r.status(200);
        r.type(ContentType.APPLICATION_JSON);
        return r.body();
    }

    public static String error(String message, Response r) {
        r.body("{\"status\": \"" + message + "\"}");
        r.status(500);
        r.type(ContentType.APPLICATION_JSON);
        return r.body();
    }
}
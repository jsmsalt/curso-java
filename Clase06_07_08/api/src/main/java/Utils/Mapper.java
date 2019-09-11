package Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import spark.Request;

public class Mapper {
    private static ObjectMapper mapper = new ObjectMapper();

    public static <T> T fromJSON(final Request request, final TypeReference<T> type) {
        T data = null;
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        if (request.contentType() == ContentType.APPLICATION_JSON) {
            try {
                data = mapper.readValue(request.body(), type);
            } catch (Exception e) {
                System.out.println(e);
                data = null;
            }
        }

        return data;
    }
}

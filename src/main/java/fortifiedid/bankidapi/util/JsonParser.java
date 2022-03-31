package fortifiedid.bankidapi.util;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.*;

public class JsonParser {

    public <E> E parse(byte[] data, Class<E> classType) throws JsonParserException {
        try {
            ObjectMapper mapper = createObjectMapper();

            mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(data, classType);
        } catch (Exception e) {
            throw new JsonParserException("Unable to parse json data:\n"
                    + "----- JSON DATA BEGINS HERE-----\n"
                    + new String(data) + "\n"
                    + "----- JSON DATA ENDS HERE -----", e);
        }
    }

    public String toJson(Object object) throws JsonParserException {
        try {
            ObjectMapper mapper = createObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

            String result = mapper.writeValueAsString(object);

            if ("null".equals(result)) {
                throw new Exception("Result was null (4 characters)");
            }

            return result;
        } catch (Exception e) {
            throw new JsonParserException("Cant produce json from object", e);
        }
    }

    private ObjectMapper createObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.PUBLIC_ONLY);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }
}

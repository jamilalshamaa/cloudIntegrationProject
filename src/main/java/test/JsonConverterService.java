package test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverterService {

    private ObjectMapper objectMapper = new ObjectMapper();

    // Method to convert an object to a JSON String
    public String convertToJson(MyAccount account) {
        try {
            return objectMapper.writeValueAsString(account);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert to JSON", e);
        }
    }
}

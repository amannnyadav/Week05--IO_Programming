import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonValidator {
    public static boolean isValidJson(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.readTree(json);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String jsonString = "{ \"name\": \"Alice\", \"email\": \"alice@example.com\" }";

        if (isValidJson(jsonString)) {
            System.out.println("Valid JSON");
        } else {
            System.out.println("Invalid JSON");
        }
    }
}

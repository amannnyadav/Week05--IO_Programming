import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PrintJsonKeysAndValues {
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("src/main/java/data.json")));
            JSONArray jsonArray = new JSONArray(content);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                System.out.println("Record " + (i + 1) + ":");
                for (String key : jsonObject.keySet()) {
                    System.out.println(key + ": " + jsonObject.get(key));
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
        }
    }
}


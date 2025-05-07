import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilterJsonFromFile {
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("src/main/java/studentData.json")));
            JSONArray originalArray = new JSONArray(content);
            JSONArray filteredArray = new JSONArray();

            for (int i = 0; i < originalArray.length(); i++) {
                JSONObject person = originalArray.getJSONObject(i);
                if (person.getInt("age") > 25) {
                    filteredArray.put(person);
                }
            }

            System.out.println("Filtered JSON (age > 25):");
            System.out.println(filteredArray.toString(2));

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
        }
    }
}


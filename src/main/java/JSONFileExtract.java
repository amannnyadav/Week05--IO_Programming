import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONFileExtract {
    public static void main(String[] args) throws IOException {
        String content=new String(Files.readAllBytes(Paths.get("src/main/java/data.json")));
        JSONArray jsonArray=new JSONArray(content);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject person = jsonArray.getJSONObject(i);
            String name = person.getString("name");
            String email = person.getString("email");
            System.out.println("Name: " + name + ", Email: " + email);
        }
    }
}

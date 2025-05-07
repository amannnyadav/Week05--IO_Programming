import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MergeJson {
    public static void main(String[] args) {
        try {
            String content1 = new String(Files.readAllBytes(Paths.get("src/main/java/file1.json")));
            String content2 = new String(Files.readAllBytes(Paths.get("src/main/java/file2.json")));
            JSONObject json1 = new JSONObject(content1);
            JSONObject json2 = new JSONObject(content2);
            for (String key : json2.keySet()) {
                json1.put(key, json2.get(key));
            }
            System.out.println("Merged JSON Object:\n" + json1.toString(2));

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

import org.json.JSONArray;
import org.json.XML;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonToXml {
    public static void main(String[] args) {
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get("src/main/java/data.json")));
            JSONArray json = new JSONArray(jsonContent);
            String xml = XML.toString(json, "user");
            System.out.println("Converted XML:\n" + xml);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

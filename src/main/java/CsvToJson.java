import org.json.CDL;
import org.json.JSONArray;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CsvToJson {
    public static void main(String[] args) {
        try {
            String csvData = new String(Files.readAllBytes(Paths.get("src/main/java/studentData.csv")));
            csvData = csvData.trim().replaceAll("[\\r\\n]+", "\n");
            JSONArray jsonArray = CDL.toJSONArray(csvData);
            System.out.println("Converted JSON:\n" + jsonArray.toString(2));

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

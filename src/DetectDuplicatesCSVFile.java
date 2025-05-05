import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DetectDuplicatesCSVFile {

    public static void detectDuplicatesById(String filePath) {
        Set<String> seenIds = new HashSet<>();
        List<String> duplicateRecords = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line=br.readLine();
            while ((line = br.readLine()) != null) {

                String[] columns = line.split(",");
                String id = columns[0].trim();

                if (seenIds.contains(id)) {
                    duplicateRecords.add(line);
                } else {
                    seenIds.add(id);
                }
            }

            if (duplicateRecords.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate records found:");
                for (String record : duplicateRecords) {
                    System.out.println(record);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "src/detectDuplicates.csv";
        detectDuplicatesById(filePath);
    }
}

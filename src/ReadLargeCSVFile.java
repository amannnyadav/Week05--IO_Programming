import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadLargeCSVFile {

    public static void readCsvInChunks(String filePath, int chunkSize) {
        int totalCount = 0;
        int currentCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line=br.readLine();
            ArrayList<String> chunk = new ArrayList<>(chunkSize);

            while ((line = br.readLine()) != null) {
                chunk.add(line);
                currentCount++;

                if (currentCount == chunkSize) {
                    totalCount += chunkSize;
                    System.out.println("Processed " + totalCount + " records");
                    chunk.clear();
                    currentCount = 0;
                }
            }

            if (!chunk.isEmpty()) {
                totalCount += chunk.size();
                System.out.println("Processed " + totalCount + " records");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "src/large_file.csv";
        int chunkSize = 100;
        readCsvInChunks(filePath, chunkSize);
    }
}
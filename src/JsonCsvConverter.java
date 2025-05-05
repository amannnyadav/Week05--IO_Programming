import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class JsonCsvConverter {

    public static void jsonToCsv(String jsonFilePath, String csvFilePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(jsonFilePath));
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line);
            }
            reader.close();

            JSONArray students = new JSONArray(jsonContent.toString());

            FileWriter csvWriter = new FileWriter(csvFilePath);
            csvWriter.append("ID,Name,Grade\n");

            for (int i = 0; i < students.length(); i++) {
                JSONObject student = students.getJSONObject(i);
                csvWriter.append(student.getString("id")).append(",");
                csvWriter.append(student.getString("name")).append(",");
                csvWriter.append(student.getString("grade")).append("\n");
            }

            csvWriter.flush();
            csvWriter.close();
            System.out.println("Converted JSON to CSV successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void csvToJson(String csvFilePath, String jsonFilePath) {
        JSONArray students = new JSONArray();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line= br.readLine();
            while ((line = br.readLine()) != null) {

                String[] values = line.split(",");
                JSONObject student = new JSONObject();
                student.put("id", values[0]);
                student.put("name", values[1]);
                student.put("grade", values[2]);
                students.put(student);
            }

            FileWriter jsonWriter = new FileWriter(jsonFilePath);
            jsonWriter.write(students.toString(4));
            jsonWriter.close();

            System.out.println("Converted CSV to JSON successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String jsonInput = "src/studentsData.json";
        String csvOutput = "src/studentsData.csv";
        String jsonOutput = "src/students_converted.json";

        jsonToCsv(jsonInput, csvOutput);
        csvToJson(csvOutput, jsonOutput);
    }
}

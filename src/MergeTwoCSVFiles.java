import java.io.*;
import java.util.*;

public class MergeTwoCSVFiles {
    public static void main(String[] args) {
        String inputFile1 = "src/student1.csv";
        String inputFile2 = "src/student2.csv";
        String output = "src/merged_students.csv";
        Map<Integer, String[]> studentInfoMap = new HashMap<>();

        try (
                BufferedReader br1 = new BufferedReader(new FileReader(inputFile1));
                BufferedReader br2 = new BufferedReader(new FileReader(inputFile2));
                BufferedWriter bw = new BufferedWriter(new FileWriter(output))
        ) {
            String line;
            br1.readLine();
            while ((line = br1.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    int id = Integer.parseInt(parts[0].trim());
                    studentInfoMap.put(id, new String[]{parts[1].trim(), parts[2].trim()});
                }
            }
            bw.write("ID,Name,Age,Marks,Grade\n");
            br2.readLine();
            while ((line = br2.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    int id = Integer.parseInt(parts[0].trim());
                    String marks = parts[1].trim();
                    String grade = parts[2].trim();

                    if (studentInfoMap.containsKey(id)) {
                        String[] nameAge = studentInfoMap.get(id);
                        bw.write(id + "," + nameAge[0] + "," + nameAge[1] + "," + marks + "," + grade + "\n");
                    }
                }
            }

            System.out.println("Merged file created successfully: " + output);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

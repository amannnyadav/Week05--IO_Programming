import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ModifyCSVFile {
    public static void main(String[] args) {
        String inputFilePath="src/employee.csv";
        String outputFilePath = "src/employees_updated.csv";
        List<String> updatedLines = new ArrayList<>();
        try(BufferedReader br=new BufferedReader(new FileReader(inputFilePath))){
            String line=br.readLine();
            updatedLines.add(line);
            while((line= br.readLine())!=null){
                String[] colums=line.split(",");
                String dept=colums[2].trim().trim().toLowerCase();
                double salary=Double.parseDouble(colums[3].trim().trim());
                if(dept.equals("it")){
                    salary*=1.10;
                    colums[3]=String.format("%.2f", salary);
                }
                updatedLines.add(String.join(",", colums));
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
                for (String updatedLine : updatedLines) {
                    bw.write(updatedLine);
                    bw.newLine();
                }
            }

            System.out.println("File updated successfully.");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

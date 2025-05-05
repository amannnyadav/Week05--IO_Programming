import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SortCSVRecordsColumn {
    public static void main(String[] args) {
        String filePath="src/employee.csv";
        List<String[]> records=new ArrayList<>();
        try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
            String line=br.readLine();
            String[] header = line.split(",");
            while((line= br.readLine())!=null){
                String[] columns=line.split(",");
                records.add(columns);
            }
            records.sort((e1, e2) -> Double.compare(Double.parseDouble(e2[3].trim()), Double.parseDouble(e1[3].trim())));
            System.out.println("Top 5 highest-paid employees:");
            System.out.println(String.join("\t", header));
            int count = 0;
            for (String[] employee : records) {
                if (count++ < 5) {
                    System.out.println(String.join("\t", employee));
                } else {
                    break;
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadCSVFilePrintData {
    public static void main(String[] args) {
        String filePath="src/students.csv";
        try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line= br.readLine())!=null){
                String[] columns=line.split(",");
                System.out.printf("%-5s %-15s %-5s %-5s%n", columns[0], columns[1], columns[2], columns[3]);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

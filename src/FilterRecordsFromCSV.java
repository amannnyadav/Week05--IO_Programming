import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecordsFromCSV {
    public static void main(String[] args) {
        String filePath="src/students.csv";
        try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
            String line=br.readLine();
            while((line=br.readLine())!=null){
                String[] column=line.split(",");
                int marks = Integer.parseInt(column[3]);
                if(marks>80){
                    System.out.printf("%-5s%-15s%-5s%-5s%n",column[0],column[1],column[2],column[3]);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

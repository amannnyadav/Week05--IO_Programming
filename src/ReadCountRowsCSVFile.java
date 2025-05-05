import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCountRowsCSVFile {
    public static void main(String[] args) {
        String filePath="src/students.csv";
        try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
            int count=0;
            br.readLine();
            while((br.readLine())!=null){
                count++;
            }
            System.out.println(count);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

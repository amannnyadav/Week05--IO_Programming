import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDataCSVFile {
    public static void main(String[] args) {
        String filePath="src/employee.csv";
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(filePath));){
            bw.write("ID,Name,Department,Salary\n");
            bw.write("104,Alice Williams,Finance,62000\n");
            bw.write("105,Bob Johnson,Sales,58000\n");
            System.out.println("CSV file written successfully!");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

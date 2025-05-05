import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchForRecordCSV {
    public static void main(String[] args) {
        String filePath="src/employee.csv";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee name to search: ");
        String targetName = scanner.nextLine().trim().toLowerCase();

        boolean found = false;
        try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
            String line=br.readLine();
            while ((line= br.readLine())!=null){
                String[] columns = line.split(",");
                String name = columns[1].trim().toLowerCase();

                if (name.equals(targetName)) {
                    String department = columns[2].trim();
                    String salary = columns[3].trim();
                    System.out.println("Department: " + department);
                    System.out.println("Salary: " + salary);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Employee not found.");
            }
        }catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

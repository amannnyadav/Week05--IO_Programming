import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ValidateCSVDataBeforeProcessing {
    public static void main(String[] args) {
        String filePath="src/data.csv";
        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        try(BufferedReader br=new BufferedReader(new FileReader(filePath))){
            String line=br.readLine();
            int lineNum=1;
            while((line=br.readLine())!=null){
                String[] columns=line.split(",");
                lineNum++;
                if (columns.length < 4) {
                    System.out.println("Line " + lineNum + ":Invalid format or missing columns");
                    continue;
                }

                String id = columns[0].trim();
                String name = columns[1].trim();
                String email = columns[2].trim();
                String phone = columns[3].trim();
                if (!emailPattern.matcher(email).matches() || !phone.matches("\\d{10}")) {
                    System.out.printf("%-5s%-15s%-25s%-12s%-5s%n",id,name,email,phone,"InValid Email or Phone Number");
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

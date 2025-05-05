import java.io.*;
import java.util.*;
class Student {
    private int id;
    private String name;
    private String age;
    private String marks;

    public Student(int id, String name, String age, String marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = age;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Age: %s, Marks: %s", id, name, age, marks);
    }
}

public class ConvertCSVDataJavaObjects {
    public static void main(String[] args) {
        String filePath = "src/students.csv";
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");

                if (columns.length < 4) {
                    System.out.println("Skipping invalid row: " + line);
                    continue;
                }

                int id = Integer.parseInt(columns[0].trim());
                String name = columns[1].trim();
                String email = columns[2].trim();
                String phone = columns[3].trim();

                Student student = new Student(id, name, email, phone);
                students.add(student);
            }

            System.out.println("Student List:");
            for (Student student : students) {
                System.out.println(student);
            }

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}


import java.lang.reflect.Constructor;
import java.util.Scanner;

class Student{
    int id;
    String name;

    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString(){
        return "id: "+id+" name: "+name;
    }
}
public class DynamicallyCreate {
    public static void main(String[] args) {
        try(Scanner scn = new Scanner(System.in)){
            System.out.print("Enter id: ");
            int num = scn.nextInt();
            System.out.print("Enter name: ");
            String name = scn.next();

            Class<?> claz = Student.class;
            Constructor<?> cons = claz.getConstructor(int.class, String.class);
            Object s = cons.newInstance(num, name);
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

class Car{
    int id;

    Car(int id){
        this.id = id;
    }
    private void setId(int id){
        this.id= id;
    }
    public int getId(){
        return id;
    }
}

public class GetClassInfo {
    public static void main(String[] args) throws ClassNotFoundException {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter class name to get all items inside it: ");
        String name = scn.next();
        Class<?> claz = Class.forName(name);
        System.out.println("Fields: ");
        for(Field field : claz.getDeclaredFields()){
            System.out.println(field.getName());
        }
        System.out.println();

        System.out.println("Methods: ");
        for(Method method : claz.getDeclaredMethods()){
            System.out.println(method.getName());
        }
        System.out.println();

        System.out.println("Constructors: ");
        for(Constructor cons : claz.getDeclaredConstructors()){
            System.out.println(cons.getName());
        }
    }
}

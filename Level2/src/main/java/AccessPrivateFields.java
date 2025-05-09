import java.lang.reflect.Field;

class Person{
    private int age = 4;
}

public class AccessPrivateFields {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        Class<?> claz = p.getClass();

        Field field = claz.getDeclaredField("age");
        field.setAccessible(true);
        System.out.println("Old value: "+field.get(p));
        field.set(p, 10);
        System.out.println("New value: "+field.get(p));
    }
}

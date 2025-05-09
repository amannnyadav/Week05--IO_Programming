import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface ImportantMethod {
    String level() default "HIGH";
}

class Service {
    @ImportantMethod
    void process() {
        System.out.println("Processing...");
    }

    @ImportantMethod(level = "LOW")
    void log() {
        System.out.println("Logging...");
    }

    void helper() {
        System.out.println("Helping...");
    }
}

class ImportantMethodsMarking {
    public static void main(String[] args) {
        Method[] methods = Service.class.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod im = m.getAnnotation(ImportantMethod.class);
                System.out.println(m.getName() + ": " + im.level());
            }
        }
    }
}
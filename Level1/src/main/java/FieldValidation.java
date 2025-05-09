import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@interface MaxLength {
    int value();
}

class User3 {
    @MaxLength(10)
    String username;

    User3(String username) {
        for (Field f : this.getClass().getDeclaredFields()) {
            if (f.isAnnotationPresent(MaxLength.class)) {
                MaxLength m = f.getAnnotation(MaxLength.class);
                try {
                    f.set(this, username);
                    String val = (String) f.get(this);
                    if (val.length() > m.value()) {
                        throw new IllegalArgumentException("Length exceeds " + m.value());
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

class FieldValidation {
    public static void main(String[] args) {
        new User3("Sanjay");
        new User3("VeryLongUsername");
    }
}

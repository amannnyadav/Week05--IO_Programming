import java.util.ArrayList;
import java.util.List;

public class Exercise3 {
    public static void main(String[] args) {
        @SuppressWarnings("Unchecked")
        List list = new ArrayList();
        list.add("A");
        list.add(100);
        list.add(3.14);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

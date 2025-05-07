import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

class User {
    public String name;
    public String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
public class ListToJsonArray {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Alice", "alice@example.com"));
        users.add(new User("Bob", "bob@example.com"));

        JSONArray jsonArray = new JSONArray();

        for (User user : users) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", user.name);
            jsonObject.put("email", user.email);
            jsonArray.put(jsonObject);
        }

        System.out.println("JSON Array:\n" + jsonArray.toString(2));
    }
}

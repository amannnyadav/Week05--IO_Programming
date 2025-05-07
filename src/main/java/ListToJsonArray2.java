import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
class User2 {
    public String name;
    public String email;
    public User2(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

public class ListToJsonArray2 {
    public static void main(String[] args) {
        List<User2> users = new ArrayList<>();
        users.add(new User2("Alice", "alice@example.com"));
        users.add(new User2("Bob", "bob@example.com"));
        JSONArray jsonArray = new JSONArray();
        for (User2 user : users) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", user.getName());
            jsonObject.put("email", user.getEmail());
            jsonArray.put(jsonObject);
        }

        System.out.println("JSON Array:\n" + jsonArray.toString(2));
    }
}


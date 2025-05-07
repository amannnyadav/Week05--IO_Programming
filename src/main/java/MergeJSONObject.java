import org.json.JSONObject;

public class MergeJSONObject {
    public static void main(String[] args) {
        JSONObject obj1 = new JSONObject();
        obj1.put("name", "Alice");
        obj1.put("email", "alice@example.com");

        JSONObject obj2 = new JSONObject();
        obj2.put("age", 30);
        obj2.put("city", "New York");

        for (String key : obj2.keySet()) {
            obj1.put(key, obj2.get(key));
        }

        System.out.println("Merged JSON: \n" + obj1.toString(2));
    }
}

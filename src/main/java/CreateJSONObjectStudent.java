import org.json.JSONArray;
import org.json.JSONObject;

public class CreateJSONObjectStudent {
    public static void main(String[] args) {
        JSONObject jo = new JSONObject();
        jo.put("name", "John");
        jo.put("age", 23);
        JSONArray ja = new JSONArray();
        ja.put("Maths");
        ja.put("Physics");
        ja.put("Chemistry");

        jo.put("subjects", ja);
        System.out.println(jo.toString(4));
    }
}

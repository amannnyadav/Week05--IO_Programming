import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.FileReader;
import java.io.FileWriter;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.util.ArrayList;
import java.util.List;

public class IPLAnalyzer {

    public static void main(String[] args) {
        censorJsonData("src/main/java/ipl_matches.json", "src/main/java/censored_ipl_matches.json");
        censorCsvData("src/main/java/ipl_matches.csv", "src/main/java/censored_ipl_matches.csv");
    }

    public static void censorJsonData(String inputPath, String outputPath) {
        try (FileReader reader = new FileReader(inputPath)) {
            JSONArray matches = new JSONArray(new JSONTokener(reader));

            JSONArray censoredMatches = new JSONArray();
            for (int i = 0; i < matches.length(); i++) {
                JSONObject match = matches.getJSONObject(i);

                String team1 = censorTeamName(match.getString("team1"));
                String team2 = censorTeamName(match.getString("team2"));

                JSONObject score = match.getJSONObject("score");
                JSONObject newScore = new JSONObject();
                for (String key : score.keySet()) {
                    String censoredKey = censorTeamName(key);
                    newScore.put(censoredKey, score.getInt(key));
                }

                JSONObject censoredMatch = new JSONObject();
                censoredMatch.put("match_id", match.getInt("match_id"));
                censoredMatch.put("team1", team1);
                censoredMatch.put("team2", team2);
                censoredMatch.put("score", newScore);
                censoredMatch.put("winner", censorTeamName(match.getString("winner")));
                censoredMatch.put("player_of_match", "REDACTED");

                censoredMatches.put(censoredMatch);
            }

            try (FileWriter writer = new FileWriter(outputPath)) {
                writer.write(censoredMatches.toString(2));
                System.out.println("JSON file processed and saved to: " + outputPath);
            }

        } catch (Exception e) {
            System.err.println("Error processing JSON: " + e.getMessage());
        }
    }

    public static void censorCsvData(String inputPath, String outputPath) {
        try (
                CSVReader reader = new CSVReader(new FileReader(inputPath));
                CSVWriter writer = new CSVWriter(new FileWriter(outputPath))
        ) {
            List<String[]> rows = reader.readAll();
            List<String[]> outputRows = new ArrayList<>();

            for (int i = 0; i < rows.size(); i++) {
                String[] row = rows.get(i);

                if (i == 0) {
                    outputRows.add(row);
                    continue;
                }

                String[] censored = new String[row.length];
                censored[0] = row[0];
                censored[1] = censorTeamName(row[1]);
                censored[2] = censorTeamName(row[2]);
                censored[3] = row[3];
                censored[4] = row[4];
                censored[5] = censorTeamName(row[5]);
                censored[6] = "REDACTED";

                outputRows.add(censored);
            }

            writer.writeAll(outputRows);
            System.out.println("CSV file processed and saved to: " + outputPath);

        } catch (Exception e) {
            System.err.println("Error processing CSV: " + e.getMessage());
        }
    }

    public static String censorTeamName(String name) {
        if (name.contains("Indians")) return name.replace("Indians", "***");
        if (name.contains("Challengers")) return name.replace("Challengers", "***");
        if (name.contains("Super Kings")) return name.replace("Super Kings", "***");
        if (name.contains("Capitals")) return name.replace("Capitals", "***");
        return name;
    }
}



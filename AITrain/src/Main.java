import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Locale;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {
    public static void main(String[] args) throws Exception {
        String inputPath = "src/resources/inputs/input1.json";
        String[] forbiddenStrings = {
            "idiot", "stupid", "bitch", "asshole", "nigga", "dumb", "moron", "retard", "jackass", 
            "shit", "fuck", "fucking", "fucker", "bullshit", "crap", "damn", "bastard", 
            "cunt", "slut", "whore", "dick", "cock", "pussy", "motherfucker", "son of a bitch",
            "prick", "twat", "wanker", "jerk", "dipshit", "scumbag", "douchebag", "arsehole", 
            "nigger", "spic", "chink", "kike", "gook", "cracker", "wetback", "beaner", "coon",
            "slur", "hobo", "drunkard", "tramp", "psycho", "lunatic", "imbecile", "scam",
            "hoe", "skank", "scumbucket", "shithead", "fag", "faggot", "dyke"
        };
        
        trainJSON(inputPath, forbiddenStrings);
    }

    public static void trainJSON(String JSONPath, String[] words) {
        JSONParser json = new JSONParser();
        String outputPath = regexJSON(JSONPath);

        // Output dosyasını sıfırla (varsa sil, yoksa yeni oluştur)
        File outputFile = new File(outputPath);
        if (outputFile.exists()) {
            outputFile.delete(); // Dosyayı sil
        }

        try {
            Object obj = json.parse(new FileReader(JSONPath));
            JSONArray jsonArray = (JSONArray) obj;

            for (Object item : jsonArray) {
                JSONObject jsonObject = (JSONObject) item;
                String text = (String) jsonObject.get("text");

                if (text.contains("?")) {
                    addTrainedJSON(jsonObject, "Unclear", outputPath);
                } else if (text.length() < 10) {
                    addTrainedJSON(jsonObject, "Too Short", outputPath);
                } else {
                    for (String word : words) {
                        String regex = "\\b" + word + "\\b"; // Kelimenin tam eşleşmesini kontrol et
                        if (text.toLowerCase(Locale.ENGLISH).matches(".*" + regex + ".*")) {
                            addTrainedJSON(jsonObject, "Inappropriate", outputPath);
                            break; // Bir kez bulduktan sonra döngüden çık
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String regexJSON(String inputPath) {
        String outputPath = inputPath.replace("input", "output");
        return outputPath;
    }

    @SuppressWarnings("unchecked")
    public static void addTrainedJSON(JSONObject trainingObject, String status, String path) {
        File filepath = new File(path);
        JSONArray jsonArray;

        if (filepath.exists()) {
            try (FileReader reader = new FileReader(filepath)) {
                JSONParser parser = new JSONParser();
                jsonArray = (JSONArray) parser.parse(reader);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } else {
            jsonArray = new JSONArray();
        }

        trainingObject.remove("text");
        trainingObject.put("status", status);
        jsonArray.add(trainingObject);

        try (FileWriter file = new FileWriter(filepath, false)) {
            file.write(jsonArray.toJSONString());
            file.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
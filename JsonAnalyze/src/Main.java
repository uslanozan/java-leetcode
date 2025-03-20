import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/*
 1️⃣ JSON Log Analysis
Logs received from a system will be in the following format:

[
{"timestamp": "2025-03-18T10:15:30", "level": "ERROR", "message": "Out of memory"},
{"timestamp": "2025-03-18T10:16:00", "level": "INFO", "message": "User logged in"},
{"timestamp": "2025-03-18T10:16:30", "level": "WARN", "message": "CPU usage high"},
{"timestamp": "2025-03-18T10:17:00", "level": "ERROR", "message": "Database connection failed"},
{"timestamp": "2025-03-18T10:17:30", "level": "INFO", "message": "User logged out"}
]
✅ Task:

Read these logs in JSON format.
How many of each log type (INFO, ERROR, WARN) are there? Store in Map<String, Integer>.
Put only ERROR logs in a separate list and print to the screen
 */

public class Main {
    public static void main(String[] args) {
        String testPath = "src/resources/rawLog.json";
        analyzeJSON(testPath);
    }

    @SuppressWarnings("unchecked")
    public static void analyzeJSON(String JSONPath){
        
        JSONParser parser = new JSONParser();
        Map<String, Integer> countLevel = new HashMap<>();
        
        try {
            // JSON dosyasını oku ve parse et
            Object obj = parser.parse(new FileReader(JSONPath));

            // JSON bir liste olduğu için JSONArray'e cast et
            // Eğer tek bir eleman olsaydı JSON içinde, JSONArray'e gerek kalmayacaktı
            JSONArray jsonArray = (JSONArray) obj;

            // JSON Array içindeki her nesneyi işle
            for (Object item : jsonArray) {
                JSONObject jsonObject = (JSONObject) item;
                
                String timeStamp = (String) jsonObject.get("timestamp");
                String level = (String) jsonObject.get("level");
                String message = (String) jsonObject.get("message");

                System.out.println("Zamanı: " + timeStamp);
                System.out.println("Level: " + level);
                System.out.println("Mesaj: " + message);
                System.out.println("-----------");

                // ERROR var ise yeni bir JSON dosyasına kaydet
                if(level.equals("ERROR")){
                    writeErrorToFile(jsonObject);
                }


                if(countLevel.containsKey(level)){
                    countLevel.put(level, countLevel.get(level) + 1);
                }else{
                    countLevel.put(level, 1);
                }
            }
            System.out.println(countLevel);
        } catch (Exception e) {
            e.printStackTrace();
        }
      
    }

    @SuppressWarnings("unchecked")
    private static void writeErrorToFile(JSONObject errorObject) {
        File filePath = new File("src/resources/newLog.json");
        JSONArray jsonArray;
    
        // Read existing file (if it exists)
        if (filePath.exists()) {
            try (FileReader reader = new FileReader(filePath)) {
                JSONParser parser = new JSONParser();
                jsonArray = (JSONArray) parser.parse(reader);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } else {
            jsonArray = new JSONArray();
        }
    
        // Add the new error object to the array
        jsonArray.add(errorObject);
    
        // Write the updated array back to the file
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(jsonArray.toJSONString());
            file.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

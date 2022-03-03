// Refrenced https://www.geeksforgeeks.org/parse-json-java/

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONWrite {
    public JSONWrite() {
        writeJsonToFile("./data/input.json", JSONMaker());
    }

    private JSONObject JSONMaker() {
        // creates JSON object
        JSONObject jo = new JSONObject();

        // fills in data
        jo.put("name", "John R. McCravy, III");
        jo.put("region", "Greenwood");
        jo.put("homeAddress", "P.O. Box 50658 Greenwood 29649");
        jo.put("colaAddress", "420B Blatt Bldg. Columbia 29201");
        jo.put("homePhone", "(864) 942-8501");
        jo.put("colaPhone", "(803) 212-6939");

        return jo;
    }

    private void writeJsonToFile(String fileName, JSONObject jsonObject) {
        try (FileWriter file = new FileWriter(fileName)) {

            file.write(jsonObject.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
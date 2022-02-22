import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;


public class JSONRead {
    Representative rep;

    public JSONRead() {
        setRepresentative(read());
    }

    private Representative read() {
        Representative representative;
        try {
            FileReader reader = new FileReader("./data/input.json");
            JSONParser parser = new JSONParser();
            JSONObject jo = (JSONObject) new JSONParser().parse(reader);

            String name = (String) jo.get("name");
            String region = (String) jo.get("region");
            String homeAddress = (String) jo.get("homeAddress");
            String colaAddress = (String) jo.get("colaAddress");
            String homePhone = (String) jo.get("homePhone");
            String colaPhone = (String) jo.get("colaPhone");

            representative = new Representative(name,region,homeAddress,colaAddress,homePhone,colaPhone);

        } catch (Exception e) {
            representative = null;
            e.printStackTrace();
        }
        return representative;
    }

    private void setRepresentative(Representative r) {
        if (r!= null) {
            this.rep = r;
        }
    }

    public Representative getRepresentative() {
        return this.rep;
    }
}

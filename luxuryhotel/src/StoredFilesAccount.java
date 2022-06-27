import java.io.FileReader;
import java.io.FileWriter;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class StoredFilesAccount {
    private String storedFile;
    private JsonArray memory;

    public StoredFilesAccount(String storedFile) {
        this.storedFile = storedFile;
        this.memory = read();
    }

    public int searchString(String key, String value) {
        int index = -1;

        String value2 = null;
        for (int i = 0; i < memory.size(); i++) {
            JsonObject jsonObject = memory.get(i).getAsJsonObject();
            
            value2 = jsonObject.get(key).getAsString();
            if (value.equals(value2)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public JsonArray read() {
        JsonArray jsonArray = null;
        
        try (FileReader reader = new FileReader(storedFile)) {
            jsonArray = (JsonArray) JsonParser.parseReader(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonArray;
    }

    public void update(String username, Integer password, String email, Integer phone) {
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("un", username);
        jsonObject.addProperty("ps", password);
        jsonObject.addProperty("email", email);
        jsonObject.addProperty("phone", phone);

        memory.add(jsonObject);
    }

    public void write() {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(storedFile)) {
            gson.toJson(memory, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JsonArray getMemory(){
        return this.memory;
    }
}

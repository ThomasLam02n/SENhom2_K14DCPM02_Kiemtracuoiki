import java.io.FileReader;
import java.io.FileWriter;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class StoredFilesHotel {
    private JsonArray memory;
    private String storedFile;

    public StoredFilesHotel(String storedFile) {
        this.storedFile = storedFile;
        this.memory = read();
    }

    public JsonArray getMemory() {
        return memory;
    }

    public void update(String name, String address, String location,int room_quantity, JsonArray evaluation, String utilities){
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("na", name);
        jsonObject.addProperty("add", address);
        jsonObject.addProperty("loca", location);
        jsonObject.addProperty("room", room_quantity);
        jsonObject.addProperty("uti", utilities);
        jsonObject.add("ev", evaluation);

        this.memory.add(jsonObject);
    }

    public int searchString(String key, String value) {
        int index = -1;
        String value2 = null;
        for (int i = 0; i < memory.size(); i++) {
            JsonObject jsonObject = memory.get(i).getAsJsonObject();
            value2 = jsonObject.get(key).getAsString();
            if (value.equalsIgnoreCase(value2)) {
                index = i++;
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

    public void write() {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(storedFile)) {
            gson.toJson(memory, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

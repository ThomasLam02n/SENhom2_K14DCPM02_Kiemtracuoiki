import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class StoredFilesHotel {
    private JsonArray memory;
    private String storeFile;

    public StoredFilesHotel( String storeFile) {
        this.storeFile = storeFile;
        this.memory = read(storeFile);
    }

    public JsonArray getMemory() {
        return this.memory;
    }
    public void update(String name, String address,int room_quantity, String evaluation, String utilities){
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("name", name);
        jsonObject.addProperty("address", address);
        jsonObject.addProperty("RoomQuantity", room_quantity);
        jsonObject.addProperty("Evaluation", evaluation);
        jsonObject.addProperty("utilities", utilities);
        
        this.memory.add(jsonObject);
    }
    // public void ssearch(String name, String evaluation){
    //     JsonObject jsonObject = new JsonObject();
    //     jsonObject.addProperty("name", name);
    //     jsonObject.addProperty("Evaluation", evaluation);
        
        
    //     this.memory.add(jsonObject);
    // }
    public JsonArray read(String storeFile) {
        JsonArray jsonArray = null;
           
        try (FileReader reader = new FileReader(storeFile)) {
            jsonArray = (JsonArray) JsonParser.parseReader(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonArray;
    }

    public void write() {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(this.storeFile)) {
            gson.toJson(memory, writer);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}

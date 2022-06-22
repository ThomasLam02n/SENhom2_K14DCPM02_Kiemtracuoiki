import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class StorefilesHotelController {
    private static final Hotel[] JsonArray = null;
    private JsonArray memory;
    private String storedFile;

    public StorefilesHotelController(String storedFile) {
        this.storedFile = storedFile;
        this.memory = read();
    }

    public JsonArray getMemory() {
        return memory;
    }
    public void update(String name, String address,int room_quantity, JsonArray evaluation, String utilities){
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("name", name);
        jsonObject.addProperty("address", address);
        jsonObject.addProperty("RoomQuantity", room_quantity);
        jsonObject.add("Evaluation", evaluation);
        jsonObject.addProperty("utilities", utilities);
        this.memory.add(jsonObject);
    }
    public int search(String key, String value) {
        int index = -1;
        String name = null;
        for (int i = 0; i < memory.size(); i++) {
            JsonObject jsonObject = memory.get(i).getAsJsonObject();
            name = jsonObject.get(key).getAsString();
            if (value.equalsIgnoreCase(name)) {
                index = i++;//
                break;
            }
        }
        return index;
    }

    public int searchAddressHotel(String key, String value) {
        int index = -1;
        String address = null;
        for (int i = 0; i < memory.size(); i++) {
            JsonObject jsonObject = memory.get(i).getAsJsonObject();
            address = jsonObject.get(key).getAsString();
            if (value.equalsIgnoreCase(address)) {
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

    public void parseHotelObject(JsonArray memory){
        String name = memory.getAsString();
    }

    public void write() {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(storedFile)) {
            gson.toJson(memory, writer);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public JsonArray getAll(){
        return this.memory;
    }

}

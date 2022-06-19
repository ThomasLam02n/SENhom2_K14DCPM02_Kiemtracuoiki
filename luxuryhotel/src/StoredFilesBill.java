import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class StoredFilesBill{
    private JsonArray memory;
    private String storeFile;

    public StoredFilesBill( String storeFile) {
        this.storeFile = storeFile;
        this.memory = read(storeFile);
    }

    public JsonArray getMemory() {
        return memory;
    }
    // public abstract void update();

    public int searchString(String key, String value) {
        int index = -1;
        String username = null;
        for (int i = 0; i < memory.size(); i++) {
            JsonObject jsonObject = memory.get(i).getAsJsonObject();
            
            username = jsonObject.get(key).getAsString();
            if (value.equalsIgnoreCase(username)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int searchInt(String key, Integer value) {
        int index = -1;
        Integer intdex2 = null;
        for (int i = 0; i < memory.size(); i++) {
            JsonObject jsonObject = memory.get(i).getAsJsonObject();
            
            intdex2 = jsonObject.get(key).getAsInt();
            if (value == intdex2) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int searchDouble(String key, double value) {
        int index = -1;
        double intdex2 = 0;
        for (int i = 0; i < memory.size(); i++) {
            JsonObject jsonObject = memory.get(i).getAsJsonObject();
            
            intdex2 = jsonObject.get(key).getAsInt();
            if (value == intdex2) {
                index = i;
                break;
            }
        }
        return index;
    }

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

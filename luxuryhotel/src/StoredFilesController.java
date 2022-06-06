import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public abstract class StoredFilesController {    
    private StoredFiles storedFiles;
    private JsonArray memory = storedFiles.getMemory();
    
    public StoredFilesController(StoredFiles storedFile) {
        StoredFiles storedFiles = storedFile;
        this.memory = read();
    }
    
    public JsonArray getMemory() {
        return memory;
    }
    // public abstract void update();

    public int search(String key, String value) {
        int index = -1;
        String username = null;
        for (int i = 0; i < memory.size(); i++) {
            JsonObject jsonObject = memory.get(i).getAsJsonObject();
            
            username = jsonObject.get(key).getAsString();
            if (value.equals(username)) {
                index = i;//
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

    public JsonArray read() {
        JsonArray jsonArray = null;
        
        
        try (FileReader reader = new FileReader(storedFiles.getStoredFile())) {
            jsonArray = (JsonArray) JsonParser.parseReader(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonArray;
    }

    // // add to memory
    // public void update(String username, Integer password, String email) {
    //     JsonObject jsonObject = new JsonObject();


    //     //JsonArray jsonArray = new JsonArray();
    //     //jsonArray.ad

    //     jsonObject.addProperty("un", username);
    //     jsonObject.addProperty("ps", password);
    //     jsonObject.addProperty("email", email);

    //     memory.add(jsonObject);
    //     // memory.ad
    // }

    public void write() {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(storedFiles.getStoredFile())) {
            gson.toJson(memory, writer);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}

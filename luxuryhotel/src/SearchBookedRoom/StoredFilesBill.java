package SearchBookedRoom;

import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class StoredFilesBill {
    private String nameFileBill;
    private JsonArray memory;// data on RAM


     /**
     * @param storedFile
     */
    public StoredFilesBill(String storedFile) {
        this.nameFileBill = storedFile;
        // tu dong doc du lieu tu file len memory
        this.memory = read();
    }

    // un mr teo
    /**
     * 
     * @param key
     * @param value
     * @return: index of elements *** -1: not found
     */
    // un //mrteo
    public int search(String key, Integer value) {
        // duyet
        int index = -1;

        
        // ...
        Integer id = null;
        for (int i = 0; i < memory.size(); i++) {
            JsonObject jsonObject = memory.get(i).getAsJsonObject();
            
           id  = jsonObject.get(key).getAsInt();
            if (value == id) {
                index = i;//
                break;
            }
        }
        return index;
    }

    public JsonArray read() {
        JsonArray jsonArray = null;
        
        
        try (FileReader reader = new FileReader(nameFileBill)) {
            jsonArray = (JsonArray) JsonParser.parseReader(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonArray;
    }

    public void write() {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(nameFileBill)) {
            gson.toJson(memory, writer);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public JsonArray getAll(){
        return this.memory;
    }
}

import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class SrotedFileAccountController {
    private String nameFiles;
    private SrotedFilesAccount srotedfileaccount = new SrotedFilesAccount();


    public SrotedFileAccountController(String nameFiles){
        this.nameFiles = nameFiles;
        // tu dong doc du lieu tu file len memory
        this.srotedfileaccount.memory = read();
    }
    public JsonArray read() {
        JsonArray jsonArray = null;
        
        
        try (FileReader reader = new FileReader(nameFiles)) {
            jsonArray = (JsonArray) JsonParser.parseReader(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonArray;
    }

    public int search(String key, String value) {
        // duyet
        int index = -1;

        
        // ...
        String username = null;
        for (int i = 0; i < srotedfileaccount.memory.size(); i++) {
            JsonObject jsonObject = srotedfileaccount.memory.get(i).getAsJsonObject();
            
            username = jsonObject.get(key).getAsString();
            if (value.equals(username)) {
                index = i;//
                break;
            }
        }
        return index;
    }


    // add to memory
    public void update(String username, Integer password, String email,Integer phonenumber) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("un", username);
        jsonObject.addProperty("ps", password);
        jsonObject.addProperty("email", email);
        jsonObject.addProperty("phone", phonenumber);

        srotedfileaccount.memory.add(jsonObject);
        // memory.ad
    }

    public void write() {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(nameFiles)) {
            gson.toJson(srotedfileaccount.memory, writer);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }



}

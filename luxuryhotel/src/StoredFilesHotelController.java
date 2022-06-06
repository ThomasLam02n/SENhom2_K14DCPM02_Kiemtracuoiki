import com.google.gson.JsonObject;

public class StoredFilesHotelController extends StoredFilesController{
    private static StoredFiles storedFiles;

    public StoredFilesHotelController(String storedFile) {
        super(storedFiles);
    }

    public void update(int id, int area, double price, String utilities) {
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("id", id);
        jsonObject.addProperty("area", area);
        jsonObject.addProperty("price", price);
        jsonObject.addProperty("utilities", utilities);

        storedFiles.getMemory().add(jsonObject);
    }

    // @Override
    // public void update() {
    //     // TODO Auto-generated method stub
        
    // }
}

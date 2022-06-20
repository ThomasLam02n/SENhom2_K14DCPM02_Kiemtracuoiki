import java.io.FileReader;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public  class StorefliesBookedRoom {
    private JsonArray memory;
    private String storeFile ;
    SimpleDateFormat ngayVN = new SimpleDateFormat("dd/MM/yyyy");

    public StorefliesBookedRoom( String storeFile) {
        this.storeFile = storeFile;
        this.memory = read();
    }

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
    

    public JsonArray read() {
        JsonArray jsonArray = null;
           
        try (FileReader reader = new FileReader(storeFile)) {
            jsonArray = (JsonArray) JsonParser.parseReader(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonArray;
    }

    public void update(String id, Integer idRoom, String username, Integer phoneNumber, 
    String email , Date check_in, Date check_out, double price) {
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("id", id);
        jsonObject.addProperty("id room", idRoom);
        jsonObject.addProperty("un", username);
        jsonObject.addProperty("phone", phoneNumber);
        jsonObject.addProperty("email", email);
        jsonObject.addProperty("date in", ngayVN.format(check_in));
        jsonObject.addProperty("date out", ngayVN.format(check_out));
        jsonObject.addProperty("price", price);
        
        this.memory.add(jsonObject);
    }
   
    public int searchDate(String key, Date value) {
        int index = -1;
        String date = "";
        Date date2 = null;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(value);
        int ngayNhap = calendar.get(Calendar.DATE);
        int thangNhap = calendar.get(Calendar.MONTH) + 1;
        int namNhap = calendar.get(Calendar.YEAR); 
        Calendar calendar2 = Calendar.getInstance();
        for (int i = 0; i < memory.size(); i++) {
            JsonObject jsonObject = memory.get(i).getAsJsonObject();
            
            date = jsonObject.get(key).getAsString();
            try {
                date2 = ngayVN.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            calendar2.setTime(date2);
            int ngay = calendar2.get(Calendar.DATE);
            int thang = calendar2.get(Calendar.MONTH) + 1;
            int nam = calendar2.get(Calendar.YEAR);

            if (nam == namNhap) {
                if (thang == thangNhap) {
                    if (ngay == ngayNhap) {
                        index = i;
                        break;
                    }
                }
            }
        }
        return index;
    }

    public void write() {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(storeFile)) {
            gson.toJson(memory, writer);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public JsonArray getAll(){
        return this.memory;
    }

    public String getNameFile() {
        return storeFile;
    }
}

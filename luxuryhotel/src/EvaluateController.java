import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class EvaluateController {
    public Scanner input = new Scanner(System.in);
    private Hotel hotel ;
    
    public EvaluateController() {
    }
    
    public EvaluateController(Hotel hotel) {
        this.hotel = hotel;
    
    }

    public void Evaluate(String nameHotel, String vote, String evaluate){
        List<Object> listcheck;
        listcheck = checkNameVail(nameHotel);
        
        if((boolean) listcheck.get(0)){
            int index = 0;
            index = Hotel.getHotels().searchString("na", nameHotel);
            JsonArray tenmArray = Hotel.getHotels().getMemory();
            JsonObject jsonObject = tenmArray.get(index).getAsJsonObject();
            String names = jsonObject.get("na").getAsString();
            JsonArray temArray1 = jsonObject.get("ev").getAsJsonArray();
            String address = jsonObject.get("add").getAsString();
            String locations = jsonObject.get("loca").getAsString();
            int room_quantity = jsonObject.get("room").getAsInt();
            String utilities = jsonObject.get("uti").getAsString();
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty(vote, evaluate);
            temArray1.add(jsonObject2);

            System.out.println(jsonObject.toString());
            tenmArray.remove(tenmArray.get(index));
            
            Hotel.getHotels().update(names, address, locations, room_quantity, temArray1, utilities);
            Hotel.getHotels().write();
        } else {
            System.out.println(listcheck.get(1).toString());
        }
    }   

    public List<Object> checkNameVail(String name){
        List<Object> list = new ArrayList<>();
        int index = 0;
        index = Hotel.getHotels().searchString("na", name);
        
        if(index != -1){
            list.add(true);
        } else{
            list.add(false);
            list.add("[ERRO] The hotel name does not exist.");
        }
        return list;
    }
}

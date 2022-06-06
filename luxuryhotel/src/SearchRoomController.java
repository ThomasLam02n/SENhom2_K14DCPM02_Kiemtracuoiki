import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class SearchRoomController {
    private Room roomObject;

    public void searchRoom(int area, double price, String utilities) {
        List<Object> listCheck;
        
        listCheck = check_room_valid(area, price, utilities);
        if (!(boolean) listCheck.get(0)) {
            System.out.println(listCheck.get(1));
            System.out.println(listCheck.get(2));
            System.out.println(listCheck.get(3));
        } else {
            System.out.println(listCheck.get(1));
            System.out.println(listCheck.get(2));
            System.out.println(listCheck.get(3));
        }
    }

    public List<Object> check_room_valid(int area, double price, String utilities) {
        List<Object> list = new ArrayList<>();
        JsonArray tempMemory = roomObject.getRooms().getMemory();
        int index = 0;
        int index2 = 0;
        int index3 = 0;
        index = roomObject.getRooms().searchInt("area", area);
        if (index == -1) {
            list.add(false);
            list.add("There is no suitable space.");
        }
        index2 = roomObject.getRooms().searchDouble("price", price);
        if (index2 == -1) {
            list.add(false);
            list.add("There is no matching price.");
        }
        index3 = roomObject.getRooms().search("utilities", utilities);
        if (index3 == -1) {
            // valid = false;
            list.add(false);
            list.add("There is no matching utility.");
        }
        if(index != -1 && index2 != -1 && index3 != -1){
            JsonObject jsonObject = tempMemory.get(index).getAsJsonObject();
            int areas = jsonObject.get("area").getAsInt();
            double prices = jsonObject.get("price").getAsDouble();
            String utilitiess = jsonObject.get("utilities").getAsString();
            list.add(true);
            list.add(areas);
            list.add(prices);
            list.add(utilitiess);
            return list;
        }
        return list;
    }
}

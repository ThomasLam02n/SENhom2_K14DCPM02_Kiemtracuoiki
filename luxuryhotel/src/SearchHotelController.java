import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class SearchHotelController {

    private Hotel hotelobject;
    private StorefilesHotelController hotels = new StorefilesHotelController("hotels.json");

    public SearchHotelController() {

    }

    public void searchHotelName(String name) {
        List<Object> listCheck;
        listCheck = checkHotel_Valid(name);
        if (!(boolean) listCheck.get(0)) {
            System.out.println(listCheck.get(1));
            System.out.println(listCheck.get(2));
            System.out.println(listCheck.get(3));
            System.out.println(listCheck.get(4));
            System.out.println(listCheck.get(5));
            System.out.println(listCheck.get(6));
        } else {
            System.out.println("Nhập lại đi bé ơi !!!");
        }

    }

    public void searchHotelLocations(String location) {
        List<Object> listCheck;
        listCheck = checklocationHotel(location);
        if(!(boolean)listCheck.get(0)){
            System.out.println(listCheck.get(1));
            System.out.println(listCheck.get(2));
            System.out.println(listCheck.get(3));
            System.out.println(listCheck.get(4));
            System.out.println(listCheck.get(5));
            System.out.println(listCheck.get(6));
        }else{
            System.out.println(listCheck.get(1));
            System.out.println(listCheck.get(2));
            System.out.println(listCheck.get(3));
            System.out.println(listCheck.get(4));
            System.out.println(listCheck.get(5));
            System.out.println(listCheck.get(6));

        }
    }

    public List<Object> checklocationHotel(String location){
        List<Object> list = new ArrayList<>();
        JsonArray tempMemory = hotels.getMemory();
        int index = 0;
        for(int i = 0; i < tempMemory.size(); i++){
            JsonObject jsonObject = tempMemory.get(i).getAsJsonObject();
            String locations = jsonObject.get("loca").getAsString();
            if(location.equalsIgnoreCase(locations)){
                index ++;
                String names = jsonObject.get("na").getAsString();
                String addresses = jsonObject.get("add").getAsString();
                String locationss = jsonObject.get("loca").getAsString(); 
                int rooms = jsonObject.get("room").getAsInt();
                String evaluations = jsonObject.get("ev").getAsString();
                String utilities = jsonObject.get("uti").getAsString();
                list.add(names);
                list.add(addresses);
                list.add(locations);
                list.add(rooms);
                list.add(evaluations);
                list.add(utilities);
            }
            if (index == 0) {
                list.add(false);
                list.add("There is no matching number of people.");
            }
        }
        return list;
    }

    /* public List<Object> check_room_valid(int aop) {  
        List<Object> list = new ArrayList<>();
        JsonArray tempMemory = rooms.getMemory();
        int index = 0;
        for (int i = 0; i < tempMemory.size(); i++) {
            // for (int j = 0; i < tempMemory.size(); j++) {
                
                JsonObject jsonObject = tempMemory.get(i).getAsJsonObject();
                
                int aops = jsonObject.get("amount of people").getAsInt();

                if (aop == aops) {
                    index ++;
                    int ids = jsonObject.get("id").getAsInt();
                    int areas = jsonObject.get("area").getAsInt();
                    double prices = jsonObject.get("price").getAsDouble();
                    String utilitiess = jsonObject.get("utilities").getAsString();
                    // int aops = jsonObject.get("amount of people").getAsInt();
                    list.add(true);
                    list.add(ids);
                    list.add(areas);
                    list.add(prices);
                    list.add(utilitiess);
                    list.add(aops);
                    // break;
                }
        if (index == 0) {
            list.add(false);
            list.add("There is no matching number of people.");
        }
        
        return list;
    }
    } */
                        
    public List<Object> checkHotel_Valid(String name) {
        List<Object> list = new ArrayList<>();
        JsonArray tempMemory = hotels.getMemory();
        int index = 0;
        index = Hotel.getHotels().search("na", name);
        if (index != -1) {
            list.add(false);
            list.add("[PRINT OUT] hotel infomation:");
            JsonObject jsonObject = tempMemory.get(index).getAsJsonObject();
            String names = jsonObject.get("na").getAsString();
            String addresses = jsonObject.get("add").getAsString();
            int rooms = jsonObject.get("room").getAsInt();
            String evaluations = jsonObject.get("ev").getAsString();
            String utilities = jsonObject.get("uti").getAsString();
            list.add(names);
            list.add(addresses);
            list.add(rooms);
            list.add(evaluations);
            list.add(utilities);
            return list;
        } else {
            list.add(true);
            list.add("[NOT FOUND OUT] hotel do not exist");
        }
        return list;

    }

}

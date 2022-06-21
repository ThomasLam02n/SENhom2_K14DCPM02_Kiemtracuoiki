import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class SearchHotelController {

    private Hotel hotelobject;
    private StorefilesHotelController hotels = new StorefilesHotelController("hotels.json");

    public Hotel getHotel(){
        return hotelobject;
    }
    public SearchHotelController() {

    }

    public SearchHotelController(Hotel hotelobject) {
        this.hotelobject = hotelobject;
    }
    
    public void searchHotelName(String name) {
        List<Object> listCheck;
        listCheck = checkHotel_Valid(name);
        if (!(boolean) listCheck.get(0)) {
            System.out.println(listCheck.get(1));
            System.out.print("Name: "+listCheck.get(2));
            System.out.print("\tAddress: "+listCheck.get(3));
            System.out.print("\tLocation: "+listCheck.get(4));
            System.out.print("\tRooms: "+listCheck.get(5));
            System.out.print("\tEvaluations: "+listCheck.get(6));
            System.out.println("\tUtilities: "+listCheck.get(7));
            this.hotelobject.setHotel(listCheck.get(2).toString(), listCheck.get(3).toString(), (int)listCheck.get(5),
             listCheck.get(6).toString(), listCheck.get(7).toString());
        } else {
            System.out.println("[NOT FOUND OUT] name hotel wrong baby !");
        }

    }

    public void searchLocation(String location) {
        List<Object> listCheck;
        listCheck = checkLocation_Valid(location);
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

    public List<Object> checkLocation_Valid(String location) {
        List<Object> list = new ArrayList<>();
        JsonArray tempMemory = hotels.getMemory();
        int index = 0;
        index = Hotel.getHotels().searchAddressHotel("loca", location);
        if (index != -1) {
            list.add(false);
            list.add("[FOUND OUT] hotel infomation:");
            JsonObject jsonObject = tempMemory.get(index).getAsJsonObject();
            String names = jsonObject.get("na").getAsString();
            String addresses = jsonObject.get("add").getAsString();
            String locations = jsonObject.get("loca").getAsString();
            int rooms = jsonObject.get("room").getAsInt();
            String evaluations = jsonObject.get("ev").getAsString();
            String utilities = jsonObject.get("uti").getAsString();
            
            list.add(names);
            list.add(addresses);
            list.add(locations);
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

    public List<Object> checkHotel_Valid(String name) {
        List<Object> list = new ArrayList<>();
        JsonArray tempMemory = hotels.getMemory();
        int index = 0;
        index = Hotel.getHotels().searchAddressHotel("na", name);
        if (index != -1) {
            list.add(false);
            list.add("[FOUND OUT] hotel infomation:");
            JsonObject jsonObject = tempMemory.get(index).getAsJsonObject();
            String names = jsonObject.get("na").getAsString();
            String addresses = jsonObject.get("add").getAsString();
            String locations = jsonObject.get("loca").getAsString();
            int rooms = jsonObject.get("room").getAsInt();
            if (jsonObject.get("ev").isJsonArray()) {
                JsonArray jsonArray = jsonObject.get("ev").getAsJsonArray();
                String str = "";
                for (int j = 0; j < jsonArray.size(); j++) {
                    JsonObject jsonObject2 = jsonArray.get(j).getAsJsonObject();
                    if (!jsonObject2.get("1").getAsString().equals("")) {
                        if (str.equals("")) {
                            str += jsonObject2.get("1").getAsString();
                        } else {
                            str += ", " + jsonObject2.get("1").getAsString();
                        }
                    }
                }
                list.add(names);
                list.add(addresses);
                list.add(locations);
                list.add(rooms);
                list.add(str);
            }
            String utilities = jsonObject.get("uti").getAsString();
            list.add(utilities);
            return list;
        } else {
            list.add(true);
            list.add("[NOT FOUND OUT] hotel do not exist");
        }
        return list;
    }

    public void viewHotel() {
        JsonArray tempMemory = hotels.getMemory();
        System.out.println("Name: \t\t Address: \t\t\t Location: \tRooms: \t Evaluations:  \t\t Utilities:");
        for (int i = 0; i < tempMemory.size(); i++) {
            JsonObject jsonObject = tempMemory.get(i).getAsJsonObject();
            System.out.print(jsonObject.get("na").getAsString());
            System.out.print(" \t " + jsonObject.get("add").getAsString());
            System.out.print("\t " + jsonObject.get("loca").getAsString());
            System.out.print("\t\t" + jsonObject.get("room").getAsInt());
            if (jsonObject.get("ev").isJsonArray()) {
                JsonArray jsonArray = jsonObject.get("ev").getAsJsonArray();
                String str = "";
                for (int j = 0; j < jsonArray.size(); j++) {
                    JsonObject jsonObject2 = jsonArray.get(j).getAsJsonObject();
                    if (!jsonObject2.get("1").getAsString().equals("")) {
                        if (str.equals("")) {
                            str += jsonObject2.get("1").getAsString();
                        } else {
                            str += ", " + jsonObject2.get("1").getAsString();
                        }
                    }
                }
                System.out.print("\t " + str);
            } else {
                System.out.print("\t " + jsonObject.get("ev").getAsString());
            }
            System.out.println("\t " + jsonObject.get("uti").getAsString());
        }
    }

}

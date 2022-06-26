import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class SearchHotelController {
    private Hotel hotelobject;
    private SearchRoomController searchRoomController;    
    private StoredFilesHotelController hotels = new StoredFilesHotelController("hotels.json");

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
            System.out.print("\tUtilities: "+listCheck.get(6));
            System.out.println("\tEvaluations: "+listCheck.get(7));
            this.hotelobject.setHotel(listCheck.get(2).toString(), listCheck.get(3).toString(), listCheck.get(4).toString(), (int)listCheck.get(5), listCheck.get(7).toString());
            
            String fileRoom = hotelobject.getName() + "ROOMS.json";
            SearchRoomController searchRoomController2 = new SearchRoomController(fileRoom);
            searchRoomController2.viewRoom();
        } else {
            System.out.println("[NOT FOUND OUT] Name hotel wrong baby !");
        }
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
            String utilities = jsonObject.get("uti").getAsString();
            JsonArray jsonArray = jsonObject.get("ev").getAsJsonArray();
            String evaluate = "";
            for (int j = 0; j < jsonArray.size(); j++) {
                JsonObject jsonObject2 = jsonArray.get(j).getAsJsonObject();
                if (jsonObject2.get("good") != null) {
                    if (evaluate.equals("")) {
                        evaluate += jsonObject2.get("good").getAsString();
                    } else {
                        evaluate += ", " + jsonObject2.get("good").getAsString();
                    }
                } else if (jsonObject2.get("normal") != null) {
                    if (evaluate.equals("")) {
                        evaluate += jsonObject2.get("normal").getAsString();
                    } else {
                        evaluate += ", " + jsonObject2.get("normal").getAsString();
                    }
                } else if (jsonObject2.get("bad") != null) {
                    if (evaluate.equals("")) {
                        evaluate += jsonObject2.get("bad").getAsString();
                    } else {
                        evaluate += ", " + jsonObject2.get("bad").getAsString();
                    }
                }
            }
            list.add(names);
            list.add(addresses);
            list.add(locations);
            list.add(rooms);
            list.add(utilities);
            list.add(evaluate);            
            
            return list;
        } else {
            list.add(true);
            list.add("[NOT FOUND OUT] hotel do not exist");
        }
        return list;
    }

    public void viewHotel() {
        JsonArray tempMemory = hotels.getMemory();
        System.out.println("Name: \t\t Address: \t\t\t Location: \tRooms: \t Utilities: \t Evaluations: ");
        for (int i = 0; i < tempMemory.size(); i++) {
            JsonObject jsonObject = tempMemory.get(i).getAsJsonObject();
            System.out.print(jsonObject.get("na").getAsString());
            System.out.print(" \t " + jsonObject.get("add").getAsString());
            System.out.print("\t " + jsonObject.get("loca").getAsString());
            System.out.print("\t\t" + jsonObject.get("room").getAsInt());
            System.out.print("\t " + jsonObject.get("uti").getAsString());
            JsonArray jsonArray = jsonObject.get("ev").getAsJsonArray();
            String str = "";
            for (int j = 0; j < jsonArray.size(); j++) {
                JsonObject jsonObject2 = jsonArray.get(j).getAsJsonObject();
                if (jsonObject2.get("good") != null) {
                    if (str.equals("")) {
                        str += jsonObject2.get("good").getAsString();
                    } else {
                        str += ", " + jsonObject2.get("good").getAsString();
                    }
                } else if (jsonObject2.get("normal") != null) {
                    if (str.equals("")) {
                        str += jsonObject2.get("normal").getAsString();
                    } else {
                        str += ", " + jsonObject2.get("normal").getAsString();
                    }
                } else if (jsonObject2.get("bad") != null) {
                    if (str.equals("")) {
                        str += jsonObject2.get("bad").getAsString();
                    } else {
                        str += ", " + jsonObject2.get("bad").getAsString();
                    }
                }
            }
            System.out.println("\t " + str);
        }
    }

}

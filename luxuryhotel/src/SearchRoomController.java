import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class SearchRoomController {
    private Room roomObject;
    private static StoredFilesRoom rooms;
    // private static StoredFilesRoom rooms = new StoredFilesRoom("rooms.json"); 

    public SearchRoomController() {
    }

    public SearchRoomController(String nameFile) {
        SearchRoomController.rooms = new StoredFilesRoom(nameFile);
    }
    public void searchRoom(int aop) { 
        List<Object> listCheck;
        
        listCheck = check_room_valid(aop);
        if (!(boolean) listCheck.get(0)) {
            for (int index = 1; index < listCheck.size(); index++) {
                System.out.println(listCheck.get(index));
            }
        } else {
            for (int index = 0; index < listCheck.size(); index++) {
                System.out.println(listCheck.get(index));
            }
        }
    }

    public void viewRoom() {
        JsonArray tempMemory = rooms.getMemory();
        System.out.println("ID: \t EREA: \t PRICE: \t UTILITIES: \t\t AMOUNT OF PEOPLE:");
        for (int i = 0; i < tempMemory.size(); i++) {
            JsonObject jsonObject = tempMemory.get(i).getAsJsonObject();
            System.out.print(jsonObject.get("id").getAsInt());
            System.out.print(" \t "+ jsonObject.get("area").getAsInt());
            System.out.print(" \t "+ jsonObject.get("price").getAsDouble());
            if (jsonObject.get("utilities").isJsonArray()) {
                JsonArray jsonArray = jsonObject.get("utilities").getAsJsonArray();
                String str = "";
                for (int j = 0; j < jsonArray.size(); j++) {
                    JsonObject jsonObject2 = jsonArray.get(j).getAsJsonObject();                    
                    if (!jsonObject2.get("1").getAsString().equals("")) {
                        if (str.equals("")) {
                            str += jsonObject2.get("1").getAsString();
                        } else {
                            str +=", " + jsonObject2.get("1").getAsString();
                        } 
                    }
                }
                System.out.print("\t " + str);
            } else { 
                System.out.print("\t "+ jsonObject.get("utilities").getAsString());
            }
            System.out.println("\t\t "+ jsonObject.get("amount of people").getAsInt());
        }
    }

    public List<Object> check_room_valid(int aop) {
        List<Object> list = new ArrayList<>();
        JsonArray tempMemory = rooms.getMemory();
        int index = 0;
        
        for (int i = 0; i < tempMemory.size(); i++) {
            JsonObject jsonObject = tempMemory.get(i).getAsJsonObject();
            
            int aops = jsonObject.get("amount of people").getAsInt();

            if (aop == aops) {
                index ++;
                int ids = jsonObject.get("id").getAsInt();
                int areas = jsonObject.get("area").getAsInt();
                double prices = jsonObject.get("price").getAsDouble();
                String utilitiess = "";
                if (jsonObject.get("utilities").isJsonArray()) {
                    JsonArray jsonArray = jsonObject.get("utilities").getAsJsonArray();
                    for (int j = 0; j < jsonArray.size(); j++) {
                        JsonObject jsonObject2 = jsonArray.get(j).getAsJsonObject();
                        String utilities1 = "";
                        for (int k = 0; k < jsonObject2.size(); k++) {
                            utilities1 += jsonObject2.get("1").getAsString();
                        }
                        if (utilitiess.equals("")) {
                            utilitiess += utilities1;
                        } else {
                            utilitiess += ", " + utilities1;
                        }
                    }
                } else {
                    utilitiess = jsonObject.get("utilities").getAsString();
                }
                
                list.add(true);
                list.add(ids);
                list.add("\t" + areas);
                list.add("\t" + prices);
                list.add("\t" + utilitiess);
                list.add("\t" + aops);
            }
        }
        if (index == 0) {
            list.add(false);
            list.add("There is no matching number of people.");
        }
        return list;
    }
    public Room getRooms() {
        return roomObject;
    }
}

import java.util.ArrayList;
import java.util.List;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class SearchRoomController {
    private Room roomObject;
    private static StoredFilesRoom rooms;; 

    public SearchRoomController() {
    }

    public SearchRoomController(String nameFile) {
        SearchRoomController.rooms = new StoredFilesRoom(nameFile);
    }
    
    public void searchRoom(int aop) { 
        List<Object> listCheck;
        listCheck = checkRoomValid(aop);

        if ((boolean) listCheck.get(0)) {
            JsonArray tempMemory = rooms.getMemory();
            String str = "";
            for (int i = 0; i < tempMemory.size(); i++) {
                JsonObject jsonObject = tempMemory.get(i).getAsJsonObject();
                
                int aops = jsonObject.get("amount of people").getAsInt();

                if (aop == aops) {
                    int ids = jsonObject.get("id").getAsInt();
                    int areas = jsonObject.get("area").getAsInt();
                    double prices = jsonObject.get("price").getAsDouble();
                    String utilitiess = "";
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
                    str += String.format("%-10d %-10d %-20.2f %-20d %-20s\n", ids, areas, prices, aops, utilitiess);
                }
            }

            System.out.printf("%-10s %-10s %-20s %-20s %-20s\n", "ID:", "AREA:", "PRICEC:", "AMOUNT OF PEOPLE:", "UTILITIES:");
            System.out.println(str.toString());            
        } else {
            for (int index = 1; index < listCheck.size(); index++) {
                System.out.println(listCheck.get(index));
            }
        }
    }

    public void viewRoom() {
        JsonArray tempMemory = rooms.getMemory();
        
        System.out.println("ID: \t EREA: \t PRICE: \t AMOUNT OF PEOPLE: \t UTILITIES:");

        for (int i = 0; i < tempMemory.size(); i++) {
            JsonObject jsonObject = tempMemory.get(i).getAsJsonObject();
            System.out.print(jsonObject.get("id").getAsInt());
            System.out.print(" \t "+ jsonObject.get("area").getAsInt());
            System.out.print(" \t "+ jsonObject.get("price").getAsDouble());
            System.out.print("\t "+ jsonObject.get("amount of people").getAsInt());
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
            System.out.println("\t\t\t " + str);
        }
    }

    public List<Object> checkRoomValid(int aop) {
        List<Object> list = new ArrayList<>();
        int index = 0;
        index = Room.getRooms().searchInt("amount of people", aop);

        if (index == -1) {
            list.add(false);
            list.add("There is no matching number of people.");
        } else{
            list.add(true);
        }
        return list;
    }
}

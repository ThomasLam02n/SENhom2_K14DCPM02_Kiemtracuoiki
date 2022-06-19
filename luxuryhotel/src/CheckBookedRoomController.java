import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class CheckBookedRoomController {
    private BookedRoom bookedRoom;

    public void SearchBookedRoom(String id){
        List<Object> listcheck;
        listcheck = check_bill_valid(id);

            if(!(boolean) listcheck.get(0)){
                System.out.println(listcheck.get(1));
            
            } else {
                for (int i = 1; i < listcheck.size(); i++) {
                    System.out.println(listcheck.get(i));
                }
                
            }
        }

    public List<Object> check_bill_valid(String id){
        List<Object> list = new ArrayList<>();
        JsonArray tempMemory = BookedRoom.getBookedRoom().getAll();
        int index = 0;
        index = BookedRoom.getBookedRoom().searchString("id", id);
        if(index == -1){
            list.add(false);
            list.add("This room id doesn't exist");
        }
        if(index != -1){
            JsonObject jsonObject = tempMemory.get(index).getAsJsonObject();
            String ids = jsonObject.get("id").getAsString();
            Integer idr = jsonObject.get("id room").getAsInt();
            String nameCusomer = jsonObject.get("um").getAsString();
            String date = jsonObject.get("date int").getAsString();
            String dateo = jsonObject.get("date out").getAsString();
            String email = jsonObject.get("email").getAsString();
            // boolean sate = jsonObject.get("sate").getAsBoolean();
            list.add(true);
            list.add(ids);
            list.add(idr);
            list.add(nameCusomer);
            list.add(date);
            list.add(dateo);
            list.add(email);
            // list.add(sate);
            return list;
        }

        return list;
      
    }
}

import java.util.ArrayList;
import java.util.List;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class CancelBookedRoomController {
    private BookedRoom bookedRoom;
    private Account account;
    private Bill bill;

    public CancelBookedRoomController() {
    }

    public CancelBookedRoomController(BookedRoom bookedRoom, Account account) {
        this.bookedRoom = bookedRoom;
        this.account = account;
    }

    public CancelBookedRoomController(BookedRoom bookedRoom) {
        this.bookedRoom = bookedRoom;
    }

    public void RemoveBill(String id, String name){
        List<Object> listcheck = checkBillVail(id, name);        
        JsonArray tem = BookedRoom.getBookedRoom().getMemory();
        int index =0;
        index = BookedRoom.getBookedRoom().searchString("id", id);
        
        if(index != -1){
            JsonObject jObject = tem.get(index).getAsJsonObject();
            String name2 = jObject.get("un").getAsString();
            if(name2.equals(name)){
                tem.remove(tem.get(index));
                BookedRoom.getBookedRoom().write();
            }
            System.out.println(listcheck.get(1));
        }else{
            System.out.println(listcheck.get(1));
        }
    }    

    public List<Object> checkBillVail(String id, String name){
        List<Object> list = new ArrayList<>();
        JsonArray tempArray = BookedRoom.getBookedRoom().getMemory();
        int index = 0;
        index = BookedRoom.getBookedRoom().searchString("id", id);
        
        if(index != -1){
            JsonObject tempoObject = tempArray.get(index).getAsJsonObject();
            String name2 = tempoObject.get("un").getAsString();
            
            if(name2.equals(name)){
                list.add(true);
                list.add("You do successful");
            }else{
                list.add(false);
                list.add("This is id of account dosen't exits");
            }
        }else{
            list.add(false);
            list.add("This is id dosen't exits");
        }
        
        return list;
    }
}

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class CheckBookedRoomController {
    private BookedRoom bookedRoom;

    public SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public CheckBookedRoomController() {
    }

    public CheckBookedRoomController(BookedRoom bookedRoom){
        this.bookedRoom = bookedRoom;
    }
    
    public BookedRoom getBookedRoom() {
        return bookedRoom;
    }

    public void searchBookedRoom(String id){
        List<Object> listcheck;
        listcheck = checkBillValid(id);

        if(!(boolean) listcheck.get(0)){
            System.out.println(listcheck.get(1));
        } else {
            System.out.println("ID ROOM: " + listcheck.get(2));
            System.out.println("USERNAME: " + listcheck.get(3));
            System.out.println("PHONENUMBER: " + listcheck.get(4));
            System.out.println("EMAIL: " + listcheck.get(5));
            System.out.println("DATE IN: " + listcheck.get(6));
            System.out.println("DATE OUT: " + listcheck.get(7));
        }
    }

    public List<Object> checkBillValid(String id){
        List<Object> list = new ArrayList<>();
        JsonArray tempMemory = BookedRoom.getBookedRoom().getMemory();
        int index = 0;
        index = BookedRoom.getBookedRoom().searchString("id", id);
        
        if(index != -1){
            JsonObject jsonObject = tempMemory.get(index).getAsJsonObject();
            String ids = jsonObject.get("id").getAsString();
            int idr = jsonObject.get("id room").getAsInt();
            String nameCusomer = jsonObject.get("un").getAsString();
            Integer phone = jsonObject.get("phone").getAsInt();
            String email = jsonObject.get("email").getAsString();
            String datei = jsonObject.get("date in").getAsString();
            String dateo = jsonObject.get("date out").getAsString();
            Boolean check = true;
            list.add(true);
            list.add(ids);
            list.add(idr);
            list.add(nameCusomer);
            list.add(phone);
            list.add(email);
            list.add(datei);
            list.add(dateo);

            try {
                this.bookedRoom.setBookedRoom(idr, nameCusomer, phone, email, dateFormat.parse(datei), dateFormat.parse(dateo), check);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            
            return list;
        } else{
            list.add(false);
            list.add("This room id doesn't exist");
        }
        return list;
    }
}


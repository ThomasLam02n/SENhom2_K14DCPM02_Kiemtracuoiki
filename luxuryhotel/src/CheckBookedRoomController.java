import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class CheckBookedRoomController {
    private BookedRoom bookedRoom;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public BookedRoom getBookedRoom() {
        return bookedRoom;
    }


    public CheckBookedRoomController(BookedRoom bookedRoom){
        this.bookedRoom = bookedRoom;
    }

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
        JsonArray tempMemory = bookedRoom.getBookedRoom().getAll();
        int index = 0;
        index = bookedRoom.getBookedRoom().searchString("id", id);
        if(index == -1){
            list.add(false);
            list.add("This room id doesn't exist");
        }
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
            list.add(nameCusomer);
            list.add(phone);
            list.add(email);
            list.add(datei);
            list.add(dateo);
            try {
                this.bookedRoom.setBookedRoom(nameCusomer, phone, email, idr, dateFormat.parse(datei), dateFormat.parse(dateo), check);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return list;
        }
        return list;
    }

    
   /*  public void Confirm(){
        List<BookedRoom> cf = new ArrayList<>();
        cf.add(check_bill_valid(id));
    } */
    }


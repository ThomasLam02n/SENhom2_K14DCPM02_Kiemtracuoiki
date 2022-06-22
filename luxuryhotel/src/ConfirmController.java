import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ConfirmController {
    private BookedRoom bookedRoom;
    private Bill bill;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public ConfirmController() {
    }

    public ConfirmController(BookedRoom bookedRoom) {
        this.bookedRoom = bookedRoom;
    }

    public ConfirmController(BookedRoom bookedRoom, Bill bill) {
        this.bookedRoom = bookedRoom;
        this.bill = bill;
    }

    public void confirm(String id) {
        List<Object> check_valid;
        check_valid = check_booked_valid(id);
        if ((boolean)check_valid.get(0)) {
            int index = 0;
            index = BookedRoom.getBookedRoom().searchString("id", id);
            JsonArray bookArray = BookedRoom.getBookedRoom().getAll();
            JsonObject bookObject = bookArray.get(index).getAsJsonObject();
            int idRoom = bookObject.get("id room").getAsInt();
            String username = bookObject.get("un").getAsString();
            Integer phone = bookObject.get("phone").getAsInt();
            String email = bookObject.get("email").getAsString();
            String datein = bookObject.get("date in").getAsString();
            String dateout = bookObject.get("date out").getAsString();
            double price = bookObject.get("price").getAsDouble();
            JsonArray service = new JsonArray();

            try {
                Bill.getStoredFilesBill().update(id, idRoom, username, phone, email, dateFormat.parse(datein), dateFormat.parse(dateout), service, price);
            } catch (ParseException e) {
                e.printStackTrace();
            }       

            Bill.getStoredFilesBill().write();
            
            try {
                this.bookedRoom.setBookedRoom(idRoom, username, phone, email, dateFormat.parse(datein), dateFormat.parse(dateout), false);
            } catch (ParseException e) {
                e.printStackTrace();
            }    

            System.out.println(check_valid.get(1));
            
        } else {
            System.out.println(check_valid.get(1));
        }
        

    }

    public List<Object> check_booked_valid(String id) {
        List<Object> list = new ArrayList<>();
        int index = 0;
        index = BookedRoom.getBookedRoom().searchString("id", id);
        if (index != -1) {
            list.add(true);
            list.add("[ST] successfull transaction! ");
        } else if(index == -1) {
            list.add(false);
            list.add("[FB] This booking has been confirmed");
        } 
        return list;
    }
}

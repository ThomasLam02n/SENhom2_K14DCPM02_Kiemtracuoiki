import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class BookingRoomController {
    private BookedRoom bookroom ;
    private Room room;
    private Account account;
    // private StorefliesBookedRoom bookedRoom = new StorefliesBookedRoom("bookedroom.json");
    public BookingRoomController(){
        
    }
    
    public BookingRoomController(Room room) {
        this.room = room;
    }

    public BookingRoomController(BookedRoom bookroom) {
        this.bookroom = bookroom;
    }

    public BookingRoomController(Account account) {
        this.account = account;
    }

    public BookingRoomController(BookedRoom bookroom, Room room, Account account) {
        this.bookroom = bookroom;
        this.room = room;
        this.account = account;
    }

    public void bookingRoom(int idRoom , Date check_in , Date check_out){
        List<Object> listCheck;
        listCheck = checkBookedRoom_valid(idRoom, check_in, check_out);

        List<Object> listCheck2;
        listCheck2 = check_date_valid(check_in, check_out);
        if(!(boolean) listCheck.get(0)){
            for (int i = 1; i < listCheck.size(); i++) {
                System.out.println(listCheck.toString());
            }
        } else if (!(boolean)listCheck2.get(0)) {
            for (int i = 1; i < listCheck2.size(); i++) {
                System.out.println(listCheck2.toString());
            }
        } else {
            JsonArray jsonArray = Account.getAccounts().getAll();
            this.account.checkLoggedIn();
            String nameCustomer = this.account.getUsername();
            Integer phoneNumber = this.account.getPhonenumber();
            String email =  this.account.getEmail();
            String id = createID(idRoom);
            BookedRoom.getBookedRoom().update(id, idRoom, nameCustomer, phoneNumber, email, check_in, check_out);
            BookedRoom.getBookedRoom().write();
            System.out.println(listCheck.get(1));
        } 
    }
    
    public List<Object> checkBookedRoom_valid(int idRoom , Date check_in , Date check_out){
        List<Object> list = new ArrayList<>();
        JsonArray tempMemory = Room.getRooms().getMemory();
        int index = 0;
        
        index = Room.getRooms().searchInt("id", idRoom);
        if (index == -1) {
            list.add(false);
            list.add("Room ID does not exist.");
            return list;
        } else if(index != -1){
            JsonObject jsonObject = tempMemory.get(index).getAsJsonObject();
            boolean check_booked = this.room.check_booked();
            // jsonObject.get("state").getAsBoolean();
            if(!check_booked){
                int areas = jsonObject.get("area").getAsInt();
                double prices = jsonObject.get("price").getAsDouble();
                JsonArray utilitiess = jsonObject.get("utilities").getAsJsonArray();
                int aop = jsonObject.get("amount of people").getAsInt();
                try {
                    this.room.setRoom(idRoom, areas, prices, utilitiess, aop);
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
                
                list.add(true);
                list.add("[BOOK ROOM SUCCESSFUL] You have successfully booked your room.");
                return list;
            } else {
                list.add(false);
                list.add("[ID ROOM EXISTS] This room ID is already booked.");
                return list;
            }
        }
        return list;
    }

    public List<Object> check_date_valid(Date check_in , Date check_out){
        List<Object> list = new ArrayList<>();
        boolean check = check(check_in, check_out);
        if(!check){
            list.add(false);
            list.add("Check-out date must be after booking date.");
        } else {
            list.add(true);
        }
        return list;
    }

    private String createID(int idRoom){
        String id = "";
        int index = 0;
        int index2 = 0;
        Random random = new Random();
        index = Room.getRooms().searchInt("id", idRoom);
        if (index != -1) {
            JsonArray jsonArray = Room.getRooms().getMemory();
            JsonObject jsonObject = jsonArray.get(index).getAsJsonObject();
            Integer ids = jsonObject.get("id").getAsInt();
            while (true) {
                Integer idss = random.nextInt(1000000000);
                id = ids.toString() + idss.toString();
                index2 = BookedRoom.getBookedRoom().searchString("id", id);
                if (index2 == -1) {
                    return id;
                }
            }
        }
        return id;
    }

    private boolean check(Date dateint, Date dateout) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateint);
        int ngayVao = calendar.get(Calendar.DATE);
        int thangVao = calendar.get(Calendar.MONTH) + 1;
        int namVao = calendar.get(Calendar.YEAR); 

        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(dateout);
        int ngayRa = calendar2.get(Calendar.DATE);
        int thangRa = calendar2.get(Calendar.MONTH) + 1;
        int namRa = calendar2.get(Calendar.YEAR);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if (namRa == (namVao + i)) {
                    if (thangRa == (thangVao + j)) {
                        if (ngayRa > ngayVao) {
                            return true;
                        } else if (j > 0) {
                            return true;
                        } else {
                            return false;
                        }
                    } else if (thangRa <= thangVao && i > 0) {
                        return true;
                    }
                }                 
            }            
        }
        return false;
    }      
}

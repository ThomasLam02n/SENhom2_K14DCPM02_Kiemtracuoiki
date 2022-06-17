import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class BookingRoomController {
    private static BookedRoom bookroom ;
    private static Room room ;
    private StorefliesBookedRoom bookedRoom = new StorefliesBookedRoom("bookroom.json");
    public void bookingRoom(String nameCustomer, int phoneNumber, String email , Integer idRoom){
        List<Object> listCheck;
        // nameCustomer, phoneNumber, email,
        // listCheck = checkBookedRoom_valid( idRoom);
        // if(!(boolean) listCheck.get(0)){
        //     System.out.println(listCheck.get(1));
        // }else{
        //     BookedRoom.getBookedRoom().update(nameCustomer, phoneNumber, email, idRoom);
        //     BookedRoom.getBookedRoom().write();
        //     System.out.println(listCheck.get(1));
        // }
        

        
    }
    public BookingRoomController(){
        
    }
    // String nameCustomer,int phoneNumber, String email,
    public static List<Object> checkBookedRoom_valid( Integer idRoom , Date check_in , Date check_out){
        List<Object> list = new ArrayList<>();
        JsonArray tempMemory = room.getRooms().getMemory();
        int index = 0;
        int index2 = 0;
        int index3 = 0;
       
        // index = BookedRoom.getBookedRoom().search("email", email) ;
        //  if(index != -1){
        //     list.add(false);
        //     list.add("[EMAIL EXISTS] This email is already in use ");
        //    return list;
        // }
        // index1 = BookedRoom.getBookedRoom()
        
        index2 = Room.getRooms().searchInt("id", idRoom);
        if (index2 != -1) {
            boolean check_booked = tempMemory.get(index2).getAsBoolean();
            if(check_booked){
                room.setRoom(tempMemory.get(index).getAsInt(), tempMemory.get(index).getAsDouble(), tempMemory.get(index).getAsString());
                list.add(false);
                list.add("[ID ROOM EXISTS] This room ID is already booked ");
            return list;
            }
        } else{
            list.add("id phong khong ton tai");
        }
        
        // index3 = BookedRoom.getBookedRoom().searchInt("pn", phoneNumber);
        // if(index3 != -1){
        //     list.add(false);
        //     list.add("[PHONE NUMBER EXISTS] Phone number barks you have been booked  ");
        //    return list;
        // }
        if(index == -1 && index2 != -1 && index3 == -1){
            list.add(true);
            list.add("[BOOK ROOM SUCCESSFUL] You have successfully booked your room   ");
           return list;
        }
         return list;
    }
    public void setDate(Date check_in , Date check_out){
        
        if(check_out.before(check_in)){
            System.out.println("Ngay tra phong phai sau ngay tra phong");
        }
    }
    
    
    
   
        
}

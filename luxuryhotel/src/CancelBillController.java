import java.util.Scanner;

import com.google.gson.JsonArray;

public class CancelBillController {
    static Scanner input = new Scanner(System.in);
    private Integer idRoom;
    private static Room room;
    private static BookedRoom bookedRoom;
    public Integer getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Integer idRoom) {
        this.idRoom = idRoom;
    }

    private BookingRoomController bookingRoomController = new BookingRoomController();
    
    public void CanelBill(){
        
        JsonArray tempArray = BookedRoom.getBookedRoom().getAll();
        int index = -1;
        Boolean temp = false;
        index = BookedRoom.getBookedRoom().searchInt("idRoom", idRoom);
        if(idRoom.equals(this.bookedRoom.getIdRoom())){
            // this.bookedRoom.setBookedRoom(idRoom, checkin_date, checkout_date);
            this.room.CancelBill();
            
        }else{
            System.out.println("[False] THIS ROOM ID IS NOT FINDED ");
        }
        
    }
}

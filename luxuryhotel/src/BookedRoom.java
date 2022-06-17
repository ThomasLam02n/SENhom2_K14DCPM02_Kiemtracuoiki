import java.util.Date;

public class BookedRoom {
    private static StorefliesBookedRoom bookRoom = new StorefliesBookedRoom("bookedroom.json");
    private String nameCustomer;
    private int phoneNumber;
    private String email;
    private int idRoom;
    private Date checkin_date;
    private Date checkout_date;

    
    public void  setBookedRoom( int idRoom, Date checkin_date,
            Date checkout_date) {
        
        this.idRoom = idRoom;
        this.checkin_date = checkin_date;
        this.checkout_date = checkout_date;
    }


    public static StorefliesBookedRoom getBookedRoom(){
        return bookRoom;
    }


    public Date getCheckin_date() {
        return checkin_date;
    }


    


    public Date getCheckout_date() {
        return checkout_date;
    }


    
    

}
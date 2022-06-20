import java.util.Date;

public class BookedRoom {
    private static StorefliesBookedRoom bookRoom = new StorefliesBookedRoom("bookedrooms.json");
    
    private String nameCustomer;
    private int phoneNumber;
    private String email;
    private int idRoom;
    private Date checkin_date;
    private Date checkout_date;
    private boolean checkBookedRoom;
    
    public BookedRoom() {
        this.nameCustomer = null;
        this.phoneNumber = 0;
        this.email = null;
        this.idRoom = 0;
        this.checkin_date = null;
        this.checkout_date = null;
        this.checkBookedRoom = false;
    }

    public BookedRoom(String nameCustomer, int phoneNumber, String email, int idRoom, Date checkin_date,
            Date checkout_date) {
        this.nameCustomer = nameCustomer;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.idRoom = idRoom;
        this.checkin_date = checkin_date;
        this.checkout_date = checkout_date;
    }

    public void  setBookedRoom(int idRoom, Date checkin_date, Date checkout_date) {
        this.idRoom = idRoom;
        this.checkin_date = checkin_date;
        this.checkout_date = checkout_date;
    }


    public void setBookedRoom(String name, int phonr, String  email, int idRoom, Date checkdi, Date checkdo, boolean check_booked){
        this.nameCustomer = name;
        this.idRoom = idRoom;
        this.email = email;
        this.phoneNumber = phonr;
        this.checkin_date = checkdi;
        this.checkout_date = checkdo;
        this.checkBookedRoom = true;
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

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    } 
    
    public boolean check_booked(){
        return checkBookedRoom;
    }

}

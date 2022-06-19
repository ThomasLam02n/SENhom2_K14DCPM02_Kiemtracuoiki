import java.util.Date;

public class BookedRoom {
    private static StorefliesBookedRoom bookRoom = new StorefliesBookedRoom("bookedrooms.json");
    
    private Integer id;
    private String nameCustomer;
    private int phoneNumber;
    private String email;
    private int idRoom;
    private boolean confirm;
    private Date checkin_date;
    private Date checkout_date;
    
    public BookedRoom() {
        this.id = null;
        this.nameCustomer = null;
        this.phoneNumber = 0;
        this.email = null;
        this.idRoom = 0;
        this.checkin_date = null;
        this.checkout_date = null;
    }
    
    public BookedRoom(String nameCustomer, int phoneNumber, String email, int idRoom, Date checkin_date){
        this.confirm = false;
    }

    public BookedRoom(Integer id ,String nameCustomer, int phoneNumber, String email, int idRoom, Date checkin_date,

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

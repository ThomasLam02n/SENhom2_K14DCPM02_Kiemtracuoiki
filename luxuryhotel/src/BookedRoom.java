import java.util.Date;

public class BookedRoom {    
    private String nameCustomer;
    private int phoneNumber;
    private String email;
    private int idRoom;
    private Date checkinDate;
    private Date checkoutDate;
    private boolean checkBookedRoom;
    private static StoredFilesBookedRoom bookedRoom; 
    
    public BookedRoom() {
        this.nameCustomer = null;
        this.phoneNumber = 0;
        this.email = null;
        this.idRoom = 0;
        this.checkinDate = null;
        this.checkoutDate = null;
        this.checkBookedRoom = false;
    }

    public BookedRoom(String nameFile) {
        BookedRoom.bookedRoom = new StoredFilesBookedRoom(nameFile);
    }

    public BookedRoom(String nameCustomer, int phoneNumber, String email, int idRoom, Date checkinDate,
            Date checkoutDdate) {
        this.nameCustomer = nameCustomer;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.idRoom = idRoom;
        this.checkinDate = checkinDate;
        this.checkinDate = checkoutDdate;
        this.checkBookedRoom = true;
    }

    public void  setBookedRoom(int idRoom, Date checkinDate, Date checkoutDate) {
        this.idRoom = idRoom;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
    }

    public void setBookedRoom(int idRoom, String name, int phonr, String  email,  Date checkdi, Date checkdo, boolean checkBooked){
        this.idRoom = idRoom;
        this.nameCustomer = name;
        this.phoneNumber = phonr;
        this.email = email;
        this.checkinDate = checkdi;
        this.checkoutDate = checkdo;
        this.checkBookedRoom = checkBooked;
    }

    public static StoredFilesBookedRoom getBookedRoom(){
        return bookedRoom;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public int getIdRoom() {
        return idRoom;
    }
    
    public boolean checkBooked() {
        return checkBookedRoom;
    }
}

package SearchBookedRoom;

public class BookedRoom {
    private static StoredFilesBill storedFilesBill = new StoredFilesBill("bookedrooms.json");
    private String nameCusomer;
    private Integer id;
    private double price;
    private boolean sate;


    public void setBookedRoom(String nameCusomer, Integer id, double price , boolean sate){
        this.id = id;
        this.nameCusomer = nameCusomer;
        this.price = price;
        this.sate = sate;
    }

    // public StoredFilesBill getBookedRoom(){
    //     return storedFilesBill;
    // }
    public static StoredFilesBill getStoredFilesBill() {
        return storedFilesBill;
    }
    
    public boolean sate(){
        return sate;
    }

}

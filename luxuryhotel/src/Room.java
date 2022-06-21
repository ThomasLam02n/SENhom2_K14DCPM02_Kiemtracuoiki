import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Room {
    private int id;
    private int area;
    private double price;
    private JsonArray utilities;
    private int amounOfPeople;
    private boolean booked;
    private static StoredFilesRoom rooms ;
    // private static StoredFilesRoom rooms = new StoredFilesRoom("rooms.json");

    public Room() {
    }

    public Room(String nameFile) {
        Room.rooms = new StoredFilesRoom(nameFile);
    }

    public Room(int id, int area, double price, JsonArray utilities, int amounOfPeople) {
        this.id = id;
        this.area = area;
        this.price = price;
        this.utilities = utilities;
        this.amounOfPeople = amounOfPeople;
        this.booked = false;
    }

    public static StoredFilesRoom getRooms() {
        return rooms;
    }

    public boolean check_booked() {
        return booked;
    }

    public void setRoom(int id, int area, double price, JsonArray utilities, int amounOfPeople) {
        this.id = id;
        this.area = area;
        this.price = price;
        this.utilities = utilities;
        this.amounOfPeople = amounOfPeople;
        this.booked = true;
    }
    // ? thạch
    public void CancelBill(){
        this.id = id;
        this.area = area;
        this.price = price;
        this.utilities = utilities;
        this.amounOfPeople = amounOfPeople;
        this.booked = false;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public int getId() {
        return id;
    }

   
    
}

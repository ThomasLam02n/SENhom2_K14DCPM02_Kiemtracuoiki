import com.google.gson.JsonArray;

public class Hotel {
    private String name;
    private String address;
    private int room_quantity;
    private JsonArray evaluation;
    private String utilities;
    private static StorefilesHotelController hotels = new StorefilesHotelController("hotels.json");
    
    public Hotel(){

    }

    public Hotel(String name, String address,int room_quantity, JsonArray evaluation, String utilities) {
        this.name = name;
        this.address = address;
        this.room_quantity = room_quantity;
        this.evaluation = evaluation;
        this.utilities = utilities;
    }
    public void setHotel(String name, JsonArray evaluation) {
        this.name = name;
                this.evaluation = evaluation;
       
    }

    public static StorefilesHotelController getHotels() {
        return hotels;
    }
    
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getRoom_quantity() {
        return room_quantity;
    }

    

    public String getUtilities() {
        return utilities;
    }

    
    
}
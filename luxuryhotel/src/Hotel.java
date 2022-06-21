import com.google.gson.JsonArray;

public class Hotel {
    private String name;
    private String address;
    private int room_quantity;
    private JsonArray evaluation;
    private String utilities;
    private boolean opening;
    private static StorefilesHotelController hotels = new StorefilesHotelController("hotels.json");
    // private static StorefilesHotelController hotels;
    
    public Hotel(){

    }

    public Hotel(String name, String address,int room_quantity, JsonArray evaluation, String utilities) {
        this.name = name;
        this.address = address;
        this.room_quantity = room_quantity;
        this.evaluation = evaluation;
        this.utilities = utilities;
    }

    public void setHotel(String name, JsonArray evaluation){
        this.name = name;
        this.evaluation = evaluation;
    }

    public void setHotel(String name, String address,int room_quantity, String utilities) {
        this.name = name;
        this.address = address;
        this.room_quantity = room_quantity;
        this.utilities = utilities;
        this.opening = true;
    }
   
    public static StorefilesHotelController getHotels() {
        return hotels;
    }

    public boolean check_opening(){
        return this.opening;
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

    public void setHotel(String string, String string2, int room_quantity2, String string3, String string4) {
    }

    
    
}

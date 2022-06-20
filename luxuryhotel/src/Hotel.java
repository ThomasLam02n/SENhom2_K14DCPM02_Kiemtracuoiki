public class Hotel {
    private String name;
    private String address;
    private int room_quantity;
    private String evaluation;
    private String utilities;
    private boolean opening;
    private static StorefilesHotelController hotels = new StorefilesHotelController("hotels.json");
    
    public Hotel(){

    }

    public Hotel(String name, String address,int room_quantity, String evaluation, String utilities) {
        this.name = name;
        this.address = address;
        this.room_quantity = room_quantity;
        this.evaluation = evaluation;
        this.utilities = utilities;
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

    
    
}

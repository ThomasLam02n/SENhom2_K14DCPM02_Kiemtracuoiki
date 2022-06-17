public class Room {
    private int id;
    private int area;
    private double price;
    private String utilities;
    private boolean booked;
    // private StoredFilesRoomController roomss = new StoredFilesRoomController("rooms.json");
    private static StoredFilesRoom rooms = new StoredFilesRoom("rooms.json");

    public static StoredFilesRoom getRooms() {
        return rooms;
    }

    // public StoredFilesRoomController getRoomss() {
    //     return roomss;
    // }

    public boolean check_booked() {

        return booked;
    }

    public void setRoom(int b, double price, String utilities) {
        this.area = b;
        this.price = price;
        this.utilities = utilities;
        this.booked = true;
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

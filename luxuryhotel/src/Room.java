public class Room {
    private int id;
    private int area;
    private double price;
    private String utilities;
    private boolean booked;
    // private StoredFilesRoomController roomss = new StoredFilesRoomController("rooms.json");
    private StoredFilesRoom rooms = new StoredFilesRoom("rooms.json");

    public StoredFilesRoom getRooms() {
        return rooms;
    }

    // public StoredFilesRoomController getRoomss() {
    //     return roomss;
    // }

    public boolean check_booked() {
        return booked;
    }

    public void setRoom(int area, double price, String utilities) {
        this.area = area;
        this.price = price;
        this.utilities = utilities;
        this.booked = true;
    }
}

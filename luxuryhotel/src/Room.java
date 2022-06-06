public class Room {
    private int id;
    private int area;
    private double price;
    private String utilities;
    private boolean booked;
    private StoredFilesHotelController rooms = new StoredFilesHotelController("rooms.json");

    public StoredFilesHotelController getRooms() {
        return rooms;
    }

    public void setRooms(StoredFilesHotelController rooms) {
        this.rooms = rooms;
    }

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

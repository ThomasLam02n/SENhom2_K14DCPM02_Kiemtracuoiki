public class TestDriveCheckBookedRoom {
    public static void main(String[] args) {
        BookedRoom bookedRoom = new BookedRoom();
        CheckBookedRoomController checkBookedRoomController = new CheckBookedRoomController(bookedRoom);
        checkBookedRoomController.SearchBookedRoom("104287813466");
    }
}

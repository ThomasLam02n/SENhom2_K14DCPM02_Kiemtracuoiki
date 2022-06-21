public class hotelTestDrive {
    public static void main(String[] args) {
        StorefilesHotelController hotels = new StorefilesHotelController("hotels.json");
        /* hotels.read(); */
        Room room = new Room();
        SearchHotelController searchHotelController = new SearchHotelController();
        SearchRoomController searchRoomController = new SearchRoomController();
        // searchHotelController.searchHotelName("GALLICI");
        /* searchHotelController.searchHotelName("REXIMON"); */
        /* searchHotelController.searchLocation("DANANG"); */
        searchHotelController.searchLocation("HCM");
        // searchRoomController.viewRoom();
        // searchHotelController.viewHotel();
    }
}

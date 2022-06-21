public class hotelTestDrive {
    public static void main(String[] args) {
        StorefilesHotelController hotels = new StorefilesHotelController("hotels.json");
        /* hotels.read(); */
        Room room = new Room();
        SearchHotelController searchHotelController = new SearchHotelController();
<<<<<<< HEAD
        SearchRoomController searchRoomController = new SearchRoomController();
=======
        SearchRoomController searchRoomController = new SearchRoomController("REXIMONDROOMS.json");

>>>>>>> dfec031c55f8244abb56274e29e18f8433e45af9
        // searchHotelController.searchHotelName("GALLICI");
        /* searchHotelController.searchHotelName("REXIMON"); */
        /* searchHotelController.searchLocation("DANANG"); */
        searchHotelController.searchLocation("HCM");
        // searchRoomController.viewRoom();
        // searchHotelController.viewHotel();
    }
}

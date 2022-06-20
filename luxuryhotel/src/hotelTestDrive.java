public class hotelTestDrive {
    public static void main(String[] args) {
        StorefilesHotelController hotels = new StorefilesHotelController("hotels.json");
        /* hotels.read(); */
        SearchHotelController searchHotelController = new SearchHotelController();
        SearchRoomController searchRoomController = new SearchRoomController();
        // searchHotelController.searchHotelName("GALLICI");
        searchHotelController.searchHotelName("REXIMON");
        /* searchHotelController.searchLocation("DANANG"); */

        // searchRoomController.viewRoom();
        // searchHotelController.viewHotel();
    }
}

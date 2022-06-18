public class hotelTestDrive {
    public static void main(String[] args) {
        StorefilesHotelController hotels = new StorefilesHotelController("hotels.json");
        /* hotels.read(); */
        SearchHotelController searchHotelController = new SearchHotelController();
        /* searchHotelController.searchHotelName("gallici"); */
        /* searchHotelController.checklocationHotel("HCM"); */
        searchHotelController.searchLocation("DANANG");
    }
}

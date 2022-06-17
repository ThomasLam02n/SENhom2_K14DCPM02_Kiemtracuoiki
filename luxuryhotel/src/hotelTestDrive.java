public class hotelTestDrive {
    public static void main(String[] args) {
        StorefilesHotelController hotels = new StorefilesHotelController("hotels.json");
        /* hotels.read(); */
        SearchHotelController searchHotelController = new SearchHotelController();
        /* searchHotelController.searchHotelName("REX"); */
        searchHotelController.checklocationHotel("HCM");
    }
}

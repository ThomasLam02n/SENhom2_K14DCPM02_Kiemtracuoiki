public class cancelbilltestdrive {
    public static void main(String[] args) {
        BookedRoom bookedRoom = new BookedRoom("REXIMONDBOOKEDROOMS.json");
        CancelBillController cvBillController = new CancelBillController(bookedRoom);
        cvBillController.RemoveBill("103259462757", null);

    }
}

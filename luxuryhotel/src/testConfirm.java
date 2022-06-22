import java.util.Scanner;

public class testConfirm {
    public static void main(String[] args) {
        String name = "GALLICI";
        BookedRoom bookedRoom = new BookedRoom(name+"BOOKEDROOMS.json");
        Bill bill = new Bill(name+"BILLS.json");
        ConfirmController confirmController = new ConfirmController(bookedRoom, bill);
        ConfirmUI confirmUI = new ConfirmUI(confirmController);
        Scanner s = new Scanner(System.in);
        System.out.print("nhap: ");
        String a = s.nextLine();
        confirmUI.handleCommand(a);
        confirmUI.handleInputs();
    }
}

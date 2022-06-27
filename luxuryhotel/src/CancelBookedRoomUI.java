import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CancelBookedRoomUI extends UITerminal {
    private Actions command;
    private Account account;
    private CancelBookedRoomController cancelBookedRoomController = new CancelBookedRoomController();
    
    public Scanner scanner = new Scanner(System.in);

    public CancelBookedRoomUI() {
    }

    public CancelBookedRoomUI(CancelBookedRoomController cancelBookedRoomController, Account account) {
        this.cancelBookedRoomController = cancelBookedRoomController;
        this.account = account;
    }

    @Override
    public String handleCommand(String rep) {
        String cmd = rep.toUpperCase();
        this.command = Actions.valueOf(cmd);

        if (this.command.equals(Actions.CB)) {

            return "Enter the request you want to find.";
        } else {
            return "Unkown command.";
        }
    }

    @Override
    public void handleInputs() {
        if (this.command.equals(Actions.CB)) {
            List<Object> list =  cancelBill();
            this.account.checkLoggedIn();
            String name = this.account.getUsername();
            cancelBookedRoomController.RemoveBill(list.get(0).toString(), name);
        }
    }

    private List<Object> cancelBill() {
        List<Object> list = new ArrayList<>();
        System.out.print("ID: ");
        String id = scanner.nextLine();

        list.add(id);
        
        return list;
    }
}

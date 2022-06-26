
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CancelBookedRoomUI extends UITerminal {
    private Actions command;
    private CancelBookedRoomController cancelBookedRoomController = new CancelBookedRoomController();
    Scanner scanner = new Scanner(System.in);
    private Account account;

    


    public CancelBookedRoomUI(CancelBookedRoomController cancelBookedRoomController, Account account) {
        this.cancelBookedRoomController = cancelBookedRoomController;
        this.account = account;
    }



    public CancelBookedRoomUI() {
    }

    

    public CancelBookedRoomUI(CancelBookedRoomController cancelBookedRoomController) {
        this.cancelBookedRoomController = cancelBookedRoomController;
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
        // TODO Auto-generated method stub
        if (this.command.equals(Actions.CB)) {
            List<Object> list =  CancelBill();
            this.account.checkLoggedIn();
            String name = this.account.getUsername();
            cancelBookedRoomController.RemoveBill(list.get(0).toString(), name);
        }
    }

    public List<Object> CancelBill() {
        List<Object> list = new ArrayList<>();
        System.out.print("ID: ");
        String id = scanner.nextLine();
        list.add(id);
        return list;
    }
}

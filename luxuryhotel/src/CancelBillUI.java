
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CancelBillUI extends UITerminal {
    private Actions command;
    private CancelBillController cancelBillController = new CancelBillController();
    Scanner scanner = new Scanner(System.in);
    private Account account;

    


    public CancelBillUI(CancelBillController cancelBillController, Account account) {
        this.cancelBillController = cancelBillController;
        this.account = account;
    }



    public CancelBillUI() {
    }

    

    public CancelBillUI(CancelBillController cancelBillController) {
        this.cancelBillController = cancelBillController;
    }



    @Override
    public String handleCommand(String rep) {
        // TODO Auto-generated method stub
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
            cancelBillController.RemoveBill(list.get(0).toString(), name);
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

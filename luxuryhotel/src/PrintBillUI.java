import java.util.ArrayList;
import java.util.List;

public class PrintBillUI extends UITerminal{
    private Actions command;
    private PrintBillController printBillController = new PrintBillController();
    
    public PrintBillUI() {
    }

    public PrintBillUI(PrintBillController printBillController) {
        this.printBillController = printBillController;
    }

    @Override
    public String handleCommand(String rep) {
        String cmd = rep.toUpperCase();
        this.command = Actions.valueOf(cmd);

        if (this.command.equals(Actions.PB)) {
            return "Enter the bill id you want to print.";
        } else {
            return "Unkown command.";
        }
    }

    @Override
    public void handleInputs() {
        if (this.command.equals(Actions.PB)) {
            List<Object> list =  printBillInput();
            this.printBillController.printBill(list.get(0).toString());
        }
    }

    public List<Object> printBillInput() {
        List<Object> list = new ArrayList<>();
        System.out.print("ID: ");
        String id = this.printBillController.scanner.nextLine();
        list.add(id);
        return list;
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConfirmUI extends UITerminal{
    private Actions command;
    private Bill bill;
    private ConfirmController confirmController;

    public ConfirmUI() {
    }

    public ConfirmUI(ConfirmController confirmController) {
        this.confirmController = confirmController;
    }

    @Override
    public String handleCommand(String rep) {
        String cmd = rep.toUpperCase();
        this.command = Actions.valueOf(cmd);

        if (this.command.equals(Actions.CF)) {
            return "room transaction confirmation";
        } else {
            return "Unkown command.";
        }
    }

    @Override
    public void handleInputs() {
        if (this.command.equals(Actions.CF)) {
            List<Object> list;
            list = confirmInput();
            confirmController.confirm(list.get(0).toString());
        }
        
    }

    private List<Object> confirmInput() {
        Scanner scanner = new Scanner(System.in);
        List<Object> list = new ArrayList<>();
        System.out.print("ID: ");
        String id = scanner.nextLine();
        list.add(id);
        return list;
    } 

}

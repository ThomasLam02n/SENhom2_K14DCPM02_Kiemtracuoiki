import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddServicesUI extends UITerminal {
    private Actions command;
    private AddServiceController addServiceController = new AddServiceController();
    Scanner scanner = new Scanner(System.in);
    public AddServicesUI() {
    }
    
    public AddServicesUI(AddServiceController addServiceController) {
        this.addServiceController = addServiceController;
    }

    @Override
    public String handleCommand(String rep) {
        String cmd = rep.toUpperCase();
        this.command = Actions.valueOf(cmd);

        if (this.command.equals(Actions.AS)) {
            return "Enter the name of the service you want to add.";
        } else {
            return "Unkown command.";
        }
    }

    @Override
    public void handleInputs() {
        if (this.command.equals(Actions.AS)) {
            addServiceController.viewService();
            while (true) {
                List<Object> list =  addServiceInput();
                addServiceController.addService((int)list.get(0), list.get(1).toString());
                System.out.print("Do you want to continue adding services?(Y/N): ");
                if (scanner.nextLine().equalsIgnoreCase("N")) {
                    break;
                }
            }
            
        }
    }

    public List<Object> addServiceInput() {
        List<Object> list = new ArrayList<>();
        System.out.print("ID room: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name Service: ");
        String nameSv = scanner.nextLine();
        list.add(id);
        list.add(nameSv);
        return list;
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckBookedRoomUI extends UITerminal {
    private Actions command;
    private CheckBookedRoomController checkBookedRoomController;
    public Scanner scanner = new Scanner(System.in);

    public CheckBookedRoomUI() {
    }

    public CheckBookedRoomUI(CheckBookedRoomController checkBookedRoomController) {
        this.checkBookedRoomController = checkBookedRoomController;
    }

    @Override
    public String handleCommand(String rep) {
        String cmd = rep.toUpperCase();
        this.command = Actions.valueOf(cmd);

        if (this.command.equals(Actions.SI)) {
            return "Enter the ID you want to find.";
        }else {
            return "Unkown command.";
        }
    }

    @Override
    public void handleInputs() {
        if (this.command.equals(Actions.SI)) {
            List<Object> list =  searchInputId();
            checkBookedRoomController.searchBookedRoom(list.get(0 ).toString());
        }
    }

    private List<Object> searchInputId() {
        List<Object> list = new ArrayList<>();
        System.out.print("ID: ");
        String id = scanner.nextLine();

        list.add(id);
        
        return list;
    }
    
}

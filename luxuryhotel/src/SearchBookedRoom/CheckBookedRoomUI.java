package SearchBookedRoom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Action.Actions;

public class CheckBookedRoomUI extends UIterminal {
    private Actions command;
    private CheckBookedRoomController checkBookedRoomController;
    Scanner scanner = new Scanner(System.in);

    

    public CheckBookedRoomUI(CheckBookedRoomController checkBookedRoomController) {
        this.checkBookedRoomController = checkBookedRoomController;
    }


    public CheckBookedRoomUI() {
    }


    @Override
    public String handleCommand(String rep) {
        // TODO Auto-generated method stub
        String cmd = rep.toUpperCase();
        this.command = Actions.valueOf(cmd);

        if (this.command.equals(Actions.SI)) {
            return "Enter the request you want to find.";
        } else {
            return "Unkown command.";
        }
    }

    @Override
    public void handleInputs() {
        // TODO Auto-generated method stub
        if (this.command.equals(Actions.SI)) {
            List<Object> list =  searchInputId();
            checkBookedRoomController.SearchBill((int)list.get(0 ));
        }
    }

    public List<Object> searchInputId() {
        List<Object> list = new ArrayList<>();
        System.out.print("ID: ");
        int id = scanner.nextInt();
        list.add(id);
        return list;
    }
    
}

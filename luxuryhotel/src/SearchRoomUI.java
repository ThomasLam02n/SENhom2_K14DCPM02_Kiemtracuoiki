import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchRoomUI extends UITerminal{
    private Actions command;
    private SearchRoomController searchRoomController;

    Scanner scanner = new Scanner(System.in);

    public SearchRoomUI() {
    }

    public SearchRoomUI(SearchRoomController searchRoomController) {
        this.searchRoomController = searchRoomController;
    }

    @Override
    public String handleCommand(String rep) {
        String cmd = rep.toUpperCase();
        this.command = Actions.valueOf(cmd);

        if (this.command.equals(Actions.SR)) {
            return "Enter the request you want to find.";
        } else {
            return "Unkown command.";
        }
    }

    @Override
    public void handleInputs() {
        if (this.command.equals(Actions.SR)) {
            this.searchRoomController.viewRoom();
            List<Object> list =  searchRoomInput();
            this.searchRoomController.searchRoom((int)list.get(0));
        }
    }

    public List<Object> searchRoomInput() {
        List<Object> list = new ArrayList<>();
        System.out.print("AMOUNT OF PEOPLE: ");
        int aop = scanner.nextInt();
        scanner.nextLine();
        list.add(aop);
        return list;
    }
}

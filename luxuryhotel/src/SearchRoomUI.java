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
            List<Object> list =  searchRoomInput();
            searchRoomController.searchRoom((int)list.get(0), (double)list.get(1), list.get(2).toString());
        }
    }

    public List<Object> searchRoomInput() {
        List<Object> list = new ArrayList<>();
        System.out.print("AREA: ");
        int area = scanner.nextInt();
        System.out.print("PRICE: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("UTILITIES: ");
        String utilities = scanner.nextLine();
        list.add(area);
        list.add(price);
        list.add(utilities);
        return list;
    }
}

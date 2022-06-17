import java.util.Scanner;

public class SearchHotelUI extends UITerminal{
    SearchHotelController searchHotelControllerObj;
    Scanner inputs = new Scanner(System.in);
    private Actions command;
    @Override
    public String handleCommand(String rep) {
         String cmd = rep.toUpperCase();
         this.command = Actions.valueOf(cmd);
        return null;
    }

    @Override
    public void handleInputs() {
        if(this.command.equals(Actions.REX));
    }

    public void searchHotelInput(String name){
        System.out.println("Name Hotel: ");
        name = inputs.nextLine();
    }
    
}

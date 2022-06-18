
import java.util.ArrayList;
import java.util.List;

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
        
    }

    public List<Object>searchHotelInput(){
        List<Object> list = new ArrayList<>();
        System.out.println("Name Hotel: ");
        String name = inputs.nextLine();
        list.add(name);
        return list;
    }
    
}

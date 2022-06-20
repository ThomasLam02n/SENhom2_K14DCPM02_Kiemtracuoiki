
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class SearchHotelUI extends UITerminal{
    SearchHotelController searchHotelControllerObj;
    Scanner inputs = new Scanner(System.in);
    private Actions command;

    
    SearchHotelUI(){

    }

    public SearchHotelUI(SearchHotelController searchHotelController){
        this.searchHotelControllerObj = searchHotelController;
    }
    @Override
    public String handleCommand(String rep) {
            String cmd = rep.toUpperCase();
            this.command = Actions.valueOf(cmd);
    
            if (this.command.equals(Actions.SH)) {
                return "Choose the hotel you want to stay:";
            } else {
                return "Unkown command.";
            }
    }

    @Override
    public void handleInputs() {
       if(this.command.equals(Actions.SH)){
        List<Object> list = searchHotelInput();
        this.searchHotelControllerObj.searchHotelName(list.get(0).toString());
       }
    }

    public List<Object> searchHotelInput(){
        List<Object> list = new ArrayList<>();
        System.out.print("Name of Hotel: ");
        String name = inputs.nextLine();
        list.add(name);
        return list;
    }
    
}

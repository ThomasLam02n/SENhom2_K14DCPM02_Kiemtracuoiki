import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchHotelUI extends UITerminal{
    private SearchHotelController searchHotelControllerObj;
    private Actions command;
    public Scanner inputs = new Scanner(System.in);
        
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
            this.searchHotelControllerObj.viewHotel();
            List<Object> list = searchHotelInput();
            
            this.searchHotelControllerObj.searchHotelName(list.get(0).toString());
       }
    }

    private List<Object> searchHotelInput(){
        List<Object> list = new ArrayList<>();
        System.out.print("Name of Hotel: ");
        String name = inputs.nextLine();

        list.add(name);
        
        return list;
    }  
}

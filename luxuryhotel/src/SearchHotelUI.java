
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

         if(this.command.equals(Actions.HCM.HANOI.DANANG)){
            return "[FOUND OUT] Hotel information";
         }else{
            return "[ERRO] Unknow command";
         }
    }

    @Override
    public void handleInputs() {
        if(this.command.equals(Actions.HANOI.toString())){
            searchHotelControllerObj.searchLocation("HANOI");
        }else if(this.command.equals(Actions.HCM.toString())){
            searchHotelControllerObj.searchLocation("HCM");
        }else if(this.command.equals(Actions.DANANG.toString())){
            searchHotelControllerObj.searchLocation("DANANG");
        }
    }
    
}

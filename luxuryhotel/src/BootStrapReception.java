import java.util.List;
import java.util.Scanner;

public class BootStrapReception {
    private static String prompt;
    private static Scanner scanner = new Scanner(System.in);
    private static CheckBookedRoomController checkBookedRoomController = new CheckBookedRoomController();
    private static CheckBookedRoomUI checkBookedRoomUI = new CheckBookedRoomUI(checkBookedRoomController);
   public static void main(String[] args) throws InterruptedException {
    System.out.println("management reception department");

    while(true){
        Thread.sleep(1000);
        disPlayOptions();
        System.out.println(getPrompt());
        

        //chon
        //command
        String rep = scanner.nextLine();


        //SI
        String resCmd;
        if(rep.toUpperCase().equals(Actions.SI.toString())){
            resCmd = checkBookedRoomUI.handleCommand(rep);
            System.out.println(resCmd);

            if(resCmd != null && !resCmd.equals("Unkown commad.")){
                checkBookedRoomUI.handleInputs();
            }
        }
        
        
      }
       
    }

   
    public static void disPlayOptions(){
        System.out.println("____________________________CRS MENU______________________");
        //check
        String str= "";
    
            str = "Enter one of the commands in the brackets: \n" + 
            "[SI] Check booked room";

            System.out.println(str);

        
    }


    public static String getPrompt() {
        return prompt;
      }


   
   
}

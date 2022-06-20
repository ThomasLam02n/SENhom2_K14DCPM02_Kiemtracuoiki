import java.lang.management.ThreadInfo;
import java.util.Scanner;

public class BootStrapReception {

    private static Scanner scanner = new Scanner(System.in);
    private static BookedRoom bookedRoom = new BookedRoom();
    private static CheckBookedRoomController checkBookedRoomController = new CheckBookedRoomController(bookedRoom);
    private static CheckBookedRoomUI checkBookedRoomUI = new CheckBookedRoomUI(checkBookedRoomController);

    public static void main(String[] args) throws InterruptedException {
       
       
       
        System.out.println("Front desk system");
        while(true){
            Thread.sleep(1000);
            displayOption();

            //chon
            //command
            String rep = scanner.nextLine();
            //si
            String rescmd;
            if(rep.toUpperCase().equals(Actions.SI.toString())){
                rescmd = checkBookedRoomUI.handleCommand(rep);
                System.out.println(rescmd);


                if(rescmd != null && !rescmd.equals("Unkown command.")){
                    checkBookedRoomUI.handleInputs();
                } 
            }else if(rep.toUpperCase().equals(Actions.CB.toString())){
                
            }
        }
    }


    public static void displayOption(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~CRS MENU~~~~~~~~~~~~~~~~~~~");
        // check
        String str = "";
        if(!checkBookedRoomController.getBookedRoom().check_booked()){
             str = "Enter one of the command in the brakets:\n" + 
                      "[SI] check booked room ";
                         System.out.println(str);
        }else if (checkBookedRoomController.getBookedRoom().check_booked()){
              System.out.println("Enter on of the conmand in brackets: \n"+
            "[CB] Confirm BookedRoom");
        }
    }


    
}

import java.util.Scanner;

public class BootStrapReception {
    private static Scanner scanner = new Scanner(System.in);
    private static BookedRoom bookedRoom = new BookedRoom("GALLICIBOOKEDROOMS.json");
    private static Bill bill = new Bill("GALLICIBILLS.json");
    private static CheckBookedRoomController checkBookedRoomController = new CheckBookedRoomController(bookedRoom);
    private static CheckBookedRoomUI checkBookedRoomUI = new CheckBookedRoomUI(checkBookedRoomController);

    private static PrintBillController printBillController = new PrintBillController(bill);
    private static PrintBillUI pBillUI =  new PrintBillUI(printBillController);

    private static ConfirmController confirmController = new ConfirmController(bookedRoom, bill);
    private static ConfirmUI confirmUI = new ConfirmUI(confirmController); 


    public static void main(String[] args){

        System.out.println("Front desk system");
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            displayOption();
            System.out.println("[EX] Exit");
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
                
            } else if(rep.toUpperCase().equals(Actions.PB.toString())){
                rescmd = pBillUI.handleCommand(rep);
                System.out.println(rescmd);
                if(rescmd != null && !rescmd.equals("Unkown command.")){
                        pBillUI.handleInputs();
                } else {
                    System.out.println("[ERROR] UnKown command.");
                } 
                
            } else if(rep.toUpperCase().equals(Actions.CF.toString())){
                rescmd = confirmUI.handleCommand(rep);
                System.out.println(rescmd);
                if(rescmd != null && !rescmd.equals("Unkown command")){
                        confirmUI.handleInputs();
                } else {
                    System.out.println("[ERROR] Unkown command.");
                }

            }  else if (rep.toUpperCase().equals(Actions.AS.toString())) {
                Hotel hotel = new Hotel();
                // String fileBill = hotel.getName() + "BILLS.json";
                // Bill bill = new Bill(fileBill);
                AddServiceController addServiceController = new AddServiceController(bill);
                AddServicesUI addServicesUI = new AddServicesUI(addServiceController);
                rescmd = addServicesUI.handleCommand(rep);
                System.out.println(rescmd);
                if (rescmd != null && !rescmd.equals("Unkown command.")) {
                    addServicesUI.handleInputs();
                    // displayOptionSearchRoom(searchRoomController);
                } else {
                    System.out.println("[ERRO] Unknown command");
                }
            }else if (rep.toUpperCase().equals(Actions.EX.toString())) {
                break;
            }
        }
    }
    
    public static void displayOption(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~CRS MENU~~~~~~~~~~~~~~~~~~~");
        // check
        String str = "";
        if(checkBookedRoomController.getBookedRoom().checkBooked()){
            str = "Enter on of the conmand in brackets: \n"+
            "[CF] Confirm BookedRoom";
            System.out.println(str);
        } else {
              
            str = "Enter one of the command in the brakets:\n" + 
                      "[SI] check booked room \n"+
                      "[AS] Add Services \n"
                      +"[PB] print bill";
            System.out.println(str);
        }
    }

}

import java.util.Scanner;

public class BootStrapReceptionGallici {
    private static BookedRoom bookedRoom = new BookedRoom("GALLICIBOOKEDROOMS.json");
    private static Bill bill = new Bill("GALLICIBILLS.json");

    private static CheckBookedRoomController checkBookedRoomController = new CheckBookedRoomController(bookedRoom);
    private static CheckBookedRoomUI checkBookedRoomUI = new CheckBookedRoomUI(checkBookedRoomController);

    private static PrintBillController printBillController = new PrintBillController(bill);
    private static PrintBillUI pBillUI =  new PrintBillUI(printBillController);

    private static ConfirmBookedRoomController confirmController = new ConfirmBookedRoomController(bookedRoom, bill);
    private static ConfirmUI confirmUI = new ConfirmUI(confirmController); 

    private static Scanner scanner = new Scanner(System.in);
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
            String rep = scanner.nextLine();
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
                AddServiceController addServiceController = new AddServiceController(bill);
                AddServicesUI addServicesUI = new AddServicesUI(addServiceController);
                rescmd = addServicesUI.handleCommand(rep);
                System.out.println(rescmd);

                if (rescmd != null && !rescmd.equals("Unkown command.")) {
                    addServicesUI.handleInputs();
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
        String str = "";
        if(checkBookedRoomController.getBookedRoom().checkBooked()){
            str = "Enter on of the conmand in brackets: \n"+
            "[CF] Confirm BookedRoom";
        } else {
            str = "Enter one of the command in the brakets:\n" + 
                      "[SI] check booked room \n"+
                      "[AS] Add Services \n"
                      +"[PB] print bill";
        }
        System.out.println(str);
    }

}

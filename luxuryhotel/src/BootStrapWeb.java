import java.util.Scanner;

public class BootStrapWeb {
    private static Hotel hotel = new Hotel();
    private static Account account = new Account();

    private static SearchHotelController searchHotelController = new SearchHotelController(hotel);
    private static SearchHotelUI searchHotelUI = new SearchHotelUI(searchHotelController);
      
    private static NewAccountController newAccountController = new NewAccountController(account);
    private static NewAccountUI newAccountUI = new NewAccountUI(newAccountController);

    private static LoginAccountController loginAccountController = new LoginAccountController(account);
    private static LoginAccountUI loginAccountUI = new LoginAccountUI(loginAccountController);

    private static String name = null;

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("============== Welcom to the LuxuryHotel System ==============");

        while (true) {
            
            displayOption(searchHotelController);
            displayOptionAccount(newAccountController);
            System.out.println("[EX] Exit");
            
            String prompt = getPromt(newAccountController);
            System.out.print(prompt);
            String rep = scanner.nextLine();
            String resCMD;

            if (rep.toUpperCase().equals(Actions.SH.toString()) && !hotel.checkOpening()) {
                resCMD = searchHotelUI.handleCommand(rep);
                searchHotelUI.handleInputs(); 
            }else if (rep.toUpperCase().equals(Actions.CA.toString())) {
                resCMD = newAccountUI.handleCommand(rep);
                System.out.println(resCMD);
                if (resCMD != null && !resCMD.equals("Unkown command.")) {
                    newAccountUI.handleInputs();
                }
            } else if (rep.toUpperCase().equals(Actions.LA.toString())
                    || (rep.toUpperCase().equals(Actions.LO.toString()) && account.checkLoggedIn())) {
                resCMD = loginAccountUI.handleCommand(rep);
                System.out.println(resCMD);
                if (resCMD != null && !resCMD.equals("Unkown command.")) {
                    loginAccountUI.handleInputs();
                }
            }else if (rep.toUpperCase().equals(Actions.BR.toString()) && !account.checkLoggedIn()) {
                System.out.println("[ATENSION] Login account before booking room !!!");
            }else if (rep.toUpperCase().equals(Actions.BR.toString()) && account.checkLoggedIn() && hotel.checkOpening()) {
                String fileRoom2 = hotel.getName() + "ROOMS.json";
                String fileBookedroom = hotel.getName() + "BOOKEDROOMS.json";

                Room room = new Room(fileRoom2);
                BookedRoom bookedRoom = new BookedRoom(fileBookedroom);
                BookingRoomController bookingRoomController = new BookingRoomController(bookedRoom, room,account);
                BookingRoomUI bookingRoomUI = new BookingRoomUI(bookingRoomController);

                resCMD = bookingRoomUI.handleCommand(rep);
                System.out.println(resCMD);
                if (resCMD != null && !resCMD.equals("Unkown command.")) {
                    bookingRoomUI.handleInputs();
                } else {
                    System.out.println("[ERRO] Unknown command");
                }
            }else if(rep.toUpperCase().equals(Actions.CB.toString()) && account.checkLoggedIn()){
                String fileBookedroom = hotel.getName() + "BOOKEDROOMS.json";

                BookedRoom bookedRoom = new BookedRoom(fileBookedroom);
                CancelBookedRoomController cancelBookedRoomController = new CancelBookedRoomController(bookedRoom, account);
                CancelBookedRoomUI cancelBookedRoomUI = new CancelBookedRoomUI(cancelBookedRoomController, account);

                resCMD = cancelBookedRoomUI.handleCommand(rep);
                System.out.println(resCMD);
                if (resCMD != null && !resCMD.equals("Unkown command.")) {
                    cancelBookedRoomUI.handleInputs();
                } else {
                    System.out.println("[ERRO] Unknown command");
                }
            }else if(rep.toUpperCase().equals(Actions.SR.toString())){
                String fileRoom2 = hotel.getName() + "ROOMS.json";

                Room room = new Room(fileRoom2);
                SearchRoomController searchRoomController = new SearchRoomController(fileRoom2);
                SearchRoomUI searchRoomUI = new SearchRoomUI(searchRoomController);

                resCMD = searchRoomUI.handleCommand(rep);
                System.out.println(resCMD);
                if (resCMD != null && !resCMD.equals("Unkown command.")) {
                    searchRoomUI.handleInputs();
                } else {
                    System.out.println("[ERRO] Unknown command");
                }
            }else if (rep.toUpperCase().equals(Actions.EX.toString())) {
                break;
            }
        } 
    }
    
    public static void displayOption(SearchHotelController searchHotelController) {
        String str = "";
        if(!hotel.checkOpening()){
            System.out.println("================ Hotel Menu ================");
            str = "Enter one of the commands in the brackets:\n" +    
                    "[SH] Search Hotel";
        } else if(account.checkLoggedIn()){
            str += "[SR] Search Room\n"+
            "[BR] Booking Room\n"+
            "[CB] Cancle Booked Roon";
        }else{
            str += "[SR] Search Room";
        }
        System.out.println(str);
    }

    public static void displayOptionAccount(NewAccountController newAccountController) {
        String str = "";
        if (!newAccountController.getAccount().checkLoggedIn()) {
            str =  
                "[CA] Create Account\n" +                
                  "[LA] Login Account";
            System.out.println(str);
        } else {
            System.out.println("[LO] Logout");
        }
    }

    public static String getPromt(NewAccountController newAccountController) {
        if (!newAccountController.getAccount().checkLoggedIn()) {
            return "";
        }

        return "LOGGED IN AS # " + newAccountController.getAccount().getUsername() + "\n";

    }

}
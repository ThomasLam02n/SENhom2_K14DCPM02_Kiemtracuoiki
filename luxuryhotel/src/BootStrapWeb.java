
import java.util.Date;
import java.util.Scanner;

public class BootStrapWeb {
    private static String name = null;
    private static Hotel hotel = new Hotel();
    private static Account account = new Account();
    public static void main(String[] args) throws InterruptedException {
     
        Scanner scanner = new Scanner(System.in);

     
        SearchHotelController searchHotelController = new SearchHotelController(hotel);
        SearchHotelUI searchHotelUI = new SearchHotelUI(searchHotelController);
      

       
        NewAccountController newAccountController = new NewAccountController(account);
        NewAccountUI newAccountUI = new NewAccountUI(newAccountController);

        LoginAccountController loginAccountController = new LoginAccountController(account);
        LoginAccountUI loginAccountUI = new LoginAccountUI(loginAccountController);


        System.out.println("============== Welcom to the LuxuryHotel System ==============");

        while (true) {
            
            displayOption(searchHotelController);
            displayOptionAccount(newAccountController);
            
            String prompt = getPromt(newAccountController);
            System.out.print(prompt);
            String rep = scanner.nextLine();
            String resCMD;

            if (rep.toUpperCase().equals(Actions.SH.toString()) || rep.toUpperCase().equals(Actions.SR.toString())) {
               
                resCMD = searchHotelUI.handleCommand(rep);
               
                if (rep.toUpperCase().equals(Actions.SH.toString()) && resCMD != null && !resCMD.equals("Unkown command.")) {
                    System.out.println(resCMD);
                    searchHotelUI.handleInputs();
                    String fileRoom = hotel.getName() + "ROOMS.json";
                    SearchRoomController searchRoomController2 = new SearchRoomController(fileRoom);
                    searchRoomController2.viewRoom();
                    if (account.checkLoggedIn()) {
                       
                        String rep2 = scanner.nextLine();
                        if (rep2.toUpperCase().equals(Actions.BR.toString())) {
                            String fileRoom2 = hotel.getName() + "ROOMS.json";
                            String fileBookedroom = hotel.getName() + "BOOKEDROOMS.json";
                            Room room = new Room(fileRoom2);
                            BookedRoom bookedRoom = new BookedRoom(fileBookedroom);
                            BookingRoomController bookingRoomController = new BookingRoomController(bookedRoom, room,account);
                            BookingRoomUI bookingRoomUI = new BookingRoomUI(bookingRoomController);
                            resCMD = bookingRoomUI.handleCommand(rep2);
                            System.out.println(resCMD);
                            if (resCMD != null && !resCMD.equals("Unkown command.")) {
                                bookingRoomUI.handleInputs();
                                // displayOptionSearchRoom(searchRoomController);
                            } else {
                                System.out.println("[ERRO] Unknown command");
                            }

                        }else if(rep2.toUpperCase().equals(Actions.CB.toString())){
                            String fileBookedroom = hotel.getName() + "BOOKEDROOMS.json";
                            BookedRoom bookedRoom = new BookedRoom(fileBookedroom);
                            CancelBillController cancelBillController = new CancelBillController(bookedRoom, account);
                            CancelBillUI cancelBillUI = new CancelBillUI(cancelBillController, account);
                            resCMD = cancelBillUI.handleCommand(rep2);
                            System.out.println(resCMD);
                            if (resCMD != null && !resCMD.equals("Unkown command.")) {
                                cancelBillUI.handleInputs();
                                // displayOptionSearchRoom(searchRoomController);
                            } else {
                                System.out.println("[ERRO] Unknown command");
                            }
                        }else if(rep2.toUpperCase().equals(Actions.SR.toString())){
                            String fileRoom2 = hotel.getName() + "ROOMS.json";
                            Room room = new Room(fileRoom2);
                            SearchRoomController searchRoomController = new SearchRoomController(fileRoom2);
                            SearchRoomUI searchRoomUI = new SearchRoomUI(searchRoomController);
                            resCMD = searchRoomUI.handleCommand(rep2);
                            System.out.println(resCMD);
                            if (resCMD != null && !resCMD.equals("Unkown command.")) {
                                searchRoomUI.handleInputs();
                                // displayOptionSearchRoom(searchRoomController);
                            } else {
                                System.out.println("[ERRO] Unknown command");
                            }
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
                            // displayOptionSearchRoom(searchRoomController);
                        } else {
                            System.out.println("[ERRO] Unknown command");
                        }
                    }else{
                        System.out.println("[ATENSION] Login account before booking room !!!");
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
                        // displayOptionSearchRoom(searchRoomController);
                    } else {
                        System.out.println("[ERRO] Unknown command");
                    }
                }

            } else if (rep.toUpperCase().equals(Actions.CA.toString())) {
                resCMD = newAccountUI.handleCommands(rep);
                System.out.println(resCMD);
                if (resCMD != null && !resCMD.equals("Unkown command.")) {
                    newAccountUI.handleInputs();
                }

            } else if (rep.toUpperCase().equals(Actions.LA.toString())
                    || rep.toUpperCase().equals(Actions.LO.toString())) {
                resCMD = loginAccountUI.handleCommands(rep);
                System.out.println(resCMD);
                if (resCMD != null && !resCMD.equals("Unkown command.")) {
                    loginAccountUI.handleInputs();

                }

            }/* else if(rep.toUpperCase().equals(Actions.CB.toString())){
                String fileBookedroom1 =  "REXIMONDBOOKEDROOMS.json";
                String fileBookedroom2 = "SIXSENSESBOOKEDROOMS.json";
                String fileBookedroom3 = "GALLICIBOOKEDROOMS.json";
                BookedRoom bookedRoom;
                CancelBillController cancelBillController;
                CancelBillUI cancelBillUI = new CancelBillUI();
                for (int i = 1; i < 4; i++) {
                    if (i == 1) {
                        bookedRoom = new BookedRoom(fileBookedroom1);
                    } else if (i == 2) {
                        bookedRoom = new BookedRoom(fileBookedroom2);
                    } else {
                        bookedRoom = new BookedRoom(fileBookedroom3);   
                    }
                    cancelBillController = new CancelBillController(bookedRoom, account);
                    cancelBillUI = new CancelBillUI(cancelBillController, account);
                    // resCMD = cancelBillUI.handleCommand(rep);
                    // System.out.println(resCMD);
                    // if (resCMD != null && !resCMD.equals("Unkown command.")) {
                    //     cancelBillUI.handleInputs();
                    // }
                }
                resCMD = cancelBillUI.handleCommand(rep);
                System.out.println(resCMD);
                if (resCMD != null && !resCMD.equals("Unkown command.")) {
                    cancelBillUI.handleInputs();
                } */

            else if (rep.toUpperCase().equals(Actions.BR.toString())) {
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
                }
            }
            // else if (rep.toUpperCase().equals(Actions.AS.toString())) {
            //     String fileBill = hotel.getName() + "BILLS.json";
            //     Bill bill = new Bill(fileBill);
            //     AddServiceController addServiceController = new AddServiceController(bill);
            //     AddServicesUI addServicesUI = new AddServicesUI(addServiceController);
            //     resCMD = addServicesUI.handleCommand(rep);
            //     System.out.println(resCMD);
            //     if (resCMD != null && !resCMD.equals("Unkown command.")) {
            //         addServicesUI.handleInputs();
            //         // displayOptionSearchRoom(searchRoomController);
            //     } else {
            //         System.out.println("[ERRO] Unknown command");
            //     }
            // }
        }

    }
    
    public static void displayOption(SearchHotelController searchHotelController) {
        if(!hotel.check_opening()){
        System.out.println("================ Hotel Menu ================");
        String str = "";
        str = "Enter one of the commands in the brackets:\n" +
                "[SH] Search Hotel";

        System.out.println(str);
        }else if(account.checkLoggedIn()){
            System.out.println("[SR] Search Room");
            System.out.println("[BR] Booking Room");
            System.out.println("[CB] Cancle Bill");
        }else{
            System.out.println("[SR] Search Room");
        }
        
    }

    public static void displayOptionAccount(NewAccountController newAccountController) {
        // check
        String str = "";
        if (!newAccountController.getAccount().checkLoggedIn()) {
            str = "[CA] Create Account\n" +
                  "[LA] Login Account";
            System.out.println(str);
        } else {
            System.out.println(
                    
                    "[LO] Logout");
        }
    }

    public static String getPromt(NewAccountController newAccountController) {
        if (!newAccountController.getAccount().checkLoggedIn()) {
            return "";
        }

        return "LOGGED IN AS # " + newAccountController.getAccount().getUsername() + " ";

    }

}
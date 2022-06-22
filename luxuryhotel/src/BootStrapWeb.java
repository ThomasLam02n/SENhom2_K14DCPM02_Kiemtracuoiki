
import java.util.Date;
import java.util.Scanner;

public class BootStrapWeb {
    private static String name = null;

    public static void main(String[] args) throws InterruptedException {
        Hotel hotel = new Hotel();
        SearchHotelController searchHotelController = new SearchHotelController(hotel);
        SearchHotelUI searchHotelUI = new SearchHotelUI(searchHotelController);

        Scanner scanner = new Scanner(System.in);
        Scanner scanners = new Scanner(System.in);

        Account account = new Account();
        NewAccountController newAccountController = new NewAccountController(account);
        NewAccountUI newAccountUI = new NewAccountUI(newAccountController);

        LoginAccountController loginAccountController = new LoginAccountController(account);
        LoginAccountUI loginAccountUI = new LoginAccountUI(loginAccountController);

        CancelBillController cancelBillController = new CancelBillController();
        CancelBillUI cancelBillUI = new CancelBillUI();

        System.out.println("Welcom to the LuxuryHotel System");

        while (true) {
            if (!hotel.check_opening()) {
                displayOption(searchHotelController);
            }
            displayOptionAccount(newAccountController);
            String prompt = getPromt(newAccountController);
            System.out.print(prompt);
            String rep = scanner.nextLine();
            String resCMD;

            if (rep.toUpperCase().equals(Actions.SH.toString())) {
                searchHotelController.viewHotel();
                resCMD = searchHotelUI.handleCommand(rep);
                System.out.println(resCMD);
                if (resCMD != null && !resCMD.equals("Unkown command.")) {
                    searchHotelUI.handleInputs();
                    String fileRoom = hotel.getName() + "ROOMS.json";
                    SearchRoomController searchRoomController2 = new SearchRoomController(fileRoom);
                    searchRoomController2.viewRoom();
                    System.out.println("[ATENTION] Login account before you booking room !");
                    if (account.checkLoggedIn()) {
                        System.out.println("[BR] Booking Room");
                        String rep2 = scanner.nextLine();
                        if (rep2.toUpperCase().equals(Actions.BR.toString())) {
                            String fileRoom2 = hotel.getName() + "ROOMS.json";
                            String fileBookedroom = hotel.getName() + "BOOKEDROOMS.json";

                            Room room = new Room(fileRoom2);
                            BookedRoom bookedRoom = new BookedRoom(fileBookedroom);
                            BookingRoomController bookingRoomController = new BookingRoomController(bookedRoom, room, account);
                            BookingRoomUI bookingRoomUI = new BookingRoomUI(bookingRoomController);

                            resCMD = bookingRoomUI.handleCommand(rep2);
                            System.out.println(resCMD);
                            if (resCMD != null && !resCMD.equals("Unkown command.")) {
                                bookingRoomUI.handleInputs();
                                // displayOptionSearchRoom(searchRoomController);
                            } else {
                                System.out.println("[ERRO] Unknown command");
                            }
                        }
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

                  /*   System.out.println("CB");
                        String rep3 = scanner.nextLine();
                        if (rep3.toUpperCase().equals(Actions.CB.toString())) {
                            resCMD = cancelBillUI.handleCommand(rep3);
                            System.out.println(resCMD);
                            if (resCMD != null && !resCMD.equals("Unkown command.")) {
                                cancelBillUI.handleInputs();
                            }
                        } */
                
                }
            }
             /*
               * else if (rep.toUpperCase().equals(Actions.AS.toString())) {
               * String fileBill = hotel.getName() + "BILLS.json";
               * Bill bill = new Bill(fileBill);
               * AddServiceController addServiceController = new AddServiceController(bill);
               * AddServicesUI addServicesUI = new AddServicesUI(addServiceController);
               * resCMD = addServicesUI.handleCommand(rep);
               * System.out.println(resCMD);
               * if (resCMD != null && !resCMD.equals("Unkown command.")) {
               * addServicesUI.handleInputs();
               * // displayOptionSearchRoom(searchRoomController);
               * } else {
               * System.out.println("[ERRO] Unknown command");
               * }
               * }
               */

        }

    }

    public static void displayOption(SearchHotelController searchHotelController) {
        System.out.println("================ Hotel Menu ================");
        String str = "";
        str = "Enter one of the commands in the brackets:\n" +
                "[SH] Search Hotel";
        System.out.println(str);
    }

    public static void displayOptionBookingRoom() {
        String str = "";
        str = "Enter one of the commands in the brackets:\n" +
                "[BR] Booking Room";
        System.out.println(str);
    }

    public static void displayOptionSearchRoom(SearchRoomController searchRoomController) {
        System.out.println("================ Room Menu ================");
        searchRoomController.viewRoom();
        String str = "";
        if (!searchRoomController.getRooms().checkBooked()) {
            str = "Enter one of the commands in the brackets:\n" +
                    "[SR] Search Room";
            System.out.println(str);
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
                    "[CB] Cancle Bill\n" +
                    "[LO] Logout");
        }
    }

    public static String getPromt(NewAccountController newAccountController) {
        if (!newAccountController.getAccount().checkLoggedIn()) {
            return "";
        }

        return "LOGGED IN AS # " + newAccountController.getAccount().getUsername();

    }

}
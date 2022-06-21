
import java.util.Date;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class BootStrapWeb {
    private static String name = null;

    public static void main(String[] args) throws InterruptedException {
        Hotel hotel = new Hotel();
        SearchHotelController searchHotelController = new SearchHotelController(hotel);
        SearchHotelUI searchHotelUI = new SearchHotelUI(searchHotelController);
        Scanner scanner = new Scanner(System.in);
        Scanner scanners = new Scanner(System.in);

        // Room room = new Room();
        // SearchHotelController searchHotelController = new SearchHotelController();
        SearchRoomController searchRoomController = new SearchRoomController("REXIMONDROOMS.json");

        // SearchHotelUI searchHotelUI = new SearchHotelUI(searchHotelController);
        SearchRoomUI searchRoomUI = new SearchRoomUI(searchRoomController);

        Account account = new Account();
        NewAccountController newAccountController = new NewAccountController(account);
        NewAccountUI newAccountUI = new NewAccountUI(newAccountController);

        LoginAccountController loginAccountController = new LoginAccountController(account);
        LoginAccountUI loginAccountUI = new LoginAccountUI(loginAccountController);

        System.out.println("Welcom to the LuxuryHotel System");

        while (true) {
            displayOption(searchHotelController);
            String rep = scanner.nextLine();
            String resCMD;
            if(rep.toUpperCase().equals(Actions.SH.toString())){
                resCMD = searchHotelUI.handleCommand(rep);
                System.out.println(resCMD);
                if (resCMD != null && !resCMD.equals("Unkown command.")) {
                    searchHotelUI.handleInputs();
                    // displayOptionSearchRoom(searchRoomController);

                }else{
                    System.out.println("[ERRO] Unknown command");
                }
            }else if (rep.toUpperCase().equals(Actions.LA.toString())) {
                resCMD = loginAccountUI.handleCommands(rep);
                System.out.println(resCMD);
                if (resCMD != null && !resCMD.equals("Unkown command.")) {
                    loginAccountUI.handleInputs();
                    // displayOptionSearchRoom(searchRoomController);
                }else{
                    System.out.println("[ERRO] Unknown command");
                }
            } else if (rep.toUpperCase().equals(Actions.BR.toString())) {
                String fileRoom = hotel.getName() + "ROOMS.json";
                String fileBookedroom = hotel.getName() + "BOOKEDROOMS.json";

                Room room = new Room(fileRoom);
                BookedRoom bookedRoom = new BookedRoom(fileBookedroom);
                BookingRoomController bookingRoomController = new BookingRoomController(bookedRoom, room, account);
                BookingRoomUI bookingRoomUI = new BookingRoomUI(bookingRoomController);

                resCMD = bookingRoomUI.handleCommand(rep);
                System.out.println(resCMD);
                if (resCMD != null && !resCMD.equals("Unkown command.")) {
                    bookingRoomUI.handleInputs();
                    // displayOptionSearchRoom(searchRoomController);
                }else{
                    System.out.println("[ERRO] Unknown command");
                }
            } else if (rep.toUpperCase().equals(Actions.PB.toString())) {
                String fileBill = hotel.getName() + "BILLS.json";
                Bill bill = new Bill(fileBill);
                PrintBillController billController = new PrintBillController(bill);
                PrintBillUI billUI = new PrintBillUI(billController);

                resCMD = billUI.handleCommand(rep);
                System.out.println(resCMD);
                if (resCMD != null && !resCMD.equals("Unkown command.")) {
                    billUI.handleInputs();
                    // displayOptionSearchRoom(searchRoomController);
                }else{
                    System.out.println("[ERRO] Unknown command");
                }
            } else if (rep.toUpperCase().equals(Actions.AS.toString())) {
                String fileBill = hotel.getName() + "BILLS.json";
                Bill bill = new Bill(fileBill);
                AddServiceController addServiceController = new AddServiceController(bill);
                AddServicesUI addServicesUI = new AddServicesUI(addServiceController);
                resCMD = addServicesUI.handleCommand(rep);
                System.out.println(resCMD);
                if (resCMD != null && !resCMD.equals("Unkown command.")) {
                    addServicesUI.handleInputs();
                    // displayOptionSearchRoom(searchRoomController);
                }else{
                    System.out.println("[ERRO] Unknown command");
                }
            } 
         
    
        }

    }

    public static void displayOption(SearchHotelController searchHotelController) {
        System.out.println("================ Hotel Menu ================");
        searchHotelController.viewHotel();
        String str = "";
            str = "Enter one of the commands in the brackets:\n" +
                    "[SH] Search Hotel";
            System.out.println(str);
    }

    public static void displayOptionSearchRoom(SearchRoomController searchRoomController) {
        System.out.println("================ Room Menu ================");
        searchRoomController.viewRoom();
        String str = "";
        if (!searchRoomController.getRooms().check_booked()) {
            str = "Enter one of the commands in the brackets:\n" +
                    "[SR] Search Room";
            System.out.println(str);
        }
    }

    public static void displayOptionAccount(NewAccountController newAccountController) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~CRS MENU~~~~~~~~~~~~~~~~~~~");
        // check
        String str = "";
        if (!newAccountController.getAccount().checkLoggedIn()) {
            str = "Enter one of the commands in the brackets:\n" +
                    "[CA] Create Account\n" +
                    "[LI] Login";
            System.out.println(str);
        } else {

            System.out.println("Enter on of the commands in brackets:\n " +
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
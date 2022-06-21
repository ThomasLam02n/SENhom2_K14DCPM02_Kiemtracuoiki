
import java.util.Date;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class BootStrapWeb {
    private static String name = null;

    public static void main(String[] args) throws InterruptedException {
          
        Scanner scanner = new Scanner(System.in);
        Scanner scanners = new Scanner(System.in);

        Room room = new Room();
        SearchHotelController searchHotelController = new SearchHotelController();
        SearchRoomController searchRoomController = new SearchRoomController("REXIMONDROOMS.json");

        SearchHotelUI searchHotelUI = new SearchHotelUI(searchHotelController);
        SearchRoomUI searchRoomUI = new SearchRoomUI(searchRoomController);

        Account account = new Account();
        NewAccountController newAccountController = new NewAccountController(account);
        NewAccountUI newAccountUI = new NewAccountUI(newAccountController);

        LoginAccountController loginAccountController = new LoginAccountController(account);
        LoginAccountUI loginAccountUI = new LoginAccountUI(loginAccountController);

        BookedRoom bookedRoom = new BookedRoom();
        BookingRoomController bookingRoomController = new BookingRoomController(bookedRoom, room, account);
        BookingRoomUI bookingRoomUI = new BookingRoomUI(bookingRoomController);

        System.out.println("Welcom to the LuxuryHotel System");
        System.out.println("OLALA");

        while (true) {
            displayOption();
            displayOptionAccount(newAccountController);

            String prompt = getPromt(newAccountController);
            System.out.print(prompt);

            String rep = scanner.nextLine();
            String resCMD;

            if (rep.toUpperCase().equals(Actions.SH.toString())) {
                resCMD = searchHotelUI.handleCommand(rep);
                System.out.println(resCMD);
                if (resCMD != null && !resCMD.equals("Unkown command.")) {
                    searchHotelUI.handleInputs();
                   /*  searchRoomController.viewRoom();
                    String rep2 = scanner.nextLine();
                    if(rep2.toUpperCase().equals(Actions.BR.toString())){
                        resCMD = bookingRoomUI.handleCommand(rep2);
                        System.out.println(resCMD);
                    } if (resCMD != null && !resCMD.equals("Unkown command.")) {
                        bookingRoomUI.handleInputs();
                    } */
                }

            }else if(rep.toUpperCase().equals(Actions.LA.toString()) || rep.toUpperCase().equals(Actions.LO.toString())){
                resCMD = loginAccountUI.handleCommands(rep);
                System.out.println(resCMD);
                if (resCMD != null && !resCMD.equals("Unkown command.")) {
                    loginAccountUI.handleInputs();
                    String rep2 = scanner.nextLine();
                    if(rep2.toUpperCase().equals(Actions.BR.toString())){
                        resCMD = bookingRoomUI.handleCommand(rep2);
                        System.out.println(resCMD);
                    } if (resCMD != null && !resCMD.equals("Unkown command.")) {
                        bookingRoomUI.handleInputs();
                    }

                }

            }else if(rep.toUpperCase().equals(Actions.CA.toString())){
                resCMD = newAccountUI.handleCommands(rep);
                System.out.println(resCMD);
                if (resCMD != null && !resCMD.equals("Unkown command.")) {
                    newAccountUI.handleInputs();
                }
            }
        }
    }


    public static void displayOption() {
        System.out.println("================ Hotel Menu ================");
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
        // check
        String str = "";
        if (!newAccountController.getAccount().checkLoggedIn()) {
            str =   "[CA] Create Account\n" +
                    "[LA] Login Account";
            System.out.println(str);

        } else {
            System.out.println("Enter on of the commands in brackets:\n " +
                    "[BR] Booking Room\n" +
                    "[CB] Cancle \n"+
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
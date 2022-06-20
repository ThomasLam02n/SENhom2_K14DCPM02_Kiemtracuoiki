
import java.util.Date;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class BootStrapWeb {
    private static String name = null;

    public static void main(String[] args) throws InterruptedException {
        SearchHotelController searchHotelController = new SearchHotelController();
        SearchRoomController searchRoomController = new SearchRoomController();
        SearchHotelUI searchHotelUI = new SearchHotelUI(searchHotelController);
        SearchRoomUI searchRoomUI = new SearchRoomUI(searchRoomController);
        Scanner scanner = new Scanner(System.in);
        Scanner scanners = new Scanner(System.in);

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
                    displayOptionSearchRoom(searchRoomController);
                }else{
                    System.out.println("[ERRO] Unknown command");
                }
            }
         
    
        }

        /*
         * while (true){
         * Thread.sleep(1000);
         * displayOption(newAccountController);
         * String prompt = getPromt(newAccountController);
         * System.out.print(prompt);
         * // chon
         * // command
         * String rep = scanner.nextLine();
         * // LI
         * String resCMD;
         * if (rep.toUpperCase().equals(Actions.CA.toString())) {
         * resCMD = newAccountUI.handleCommands(rep);
         * System.out.println(resCMD);
         * 
         * if (resCMD != null && !resCMD.equals("Unkown command.")) {
         * newAccountUI.handleInputs();
         * }
         * } else if (rep.toUpperCase().equals(Actions.LA.toString())
         * || rep.toUpperCase().equals(Actions.LO.toString())) {
         * resCMD = loginAccountUI.handleCommands(rep);
         * if (resCMD != null && !resCMD.equals("Unkown command.")) {
         * loginAccountUI.handleInputs();
         * }
         * }
         * }
         */
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
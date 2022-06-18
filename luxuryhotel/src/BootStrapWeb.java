
import java.util.Date;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class BootStrapWeb {
    private static  String name = null;

    public static void main(String[] args) throws InterruptedException{
        SearchHotelController searchHotelController = new SearchHotelController();
        Scanner scanner = new Scanner(System.in);

        Account account = new Account();
        NewAccountController newAccountController = new NewAccountController(account);
        NewAccountUI newAccountUI = new NewAccountUI(newAccountController);

        LoginAccountController loginAccountController = new LoginAccountController(account);
        LoginAccountUI loginAccountUI = new LoginAccountUI(loginAccountController);


        System.out.println("Welcom to the LuxuryHotel System");
        System.out.println("Hello");

        while (true){

            Thread.sleep(1000);
            displayOption(newAccountController);
            String prompt = getPromt(newAccountController);
            System.out.print(prompt);
            // chon
            // command
            String rep = scanner.nextLine();

            // LI
            String resCMD;
            if (rep.toUpperCase().equals(Actions.CA.toString())) {
                resCMD = newAccountUI.handleCommands(rep);
                System.out.println(resCMD);

                if (resCMD != null && !resCMD.equals("Unkown command.")) {
                    newAccountUI.handleInputs();
                }
            } else if (rep.toUpperCase().equals(Actions.LA.toString())
                    || rep.toUpperCase().equals(Actions.LO.toString())) {

                resCMD = loginAccountUI.handleCommands(rep);

                if (resCMD != null && !resCMD.equals("Unkown command.")) {
                    loginAccountUI.handleInputs();
                }
            }
            // String cmd = uiTerminal.handleCommands(rep);

            // if (cmd != null && !cmd.equals("Unkown command.")) {
            // System.out.println(cmd);
            // uiTerminal.handleInputs();
            // }
            // inpuScanner.nextLine();

/* 
            System.out.println("Location: ");
            String location = scanner.nextLine();
            System.out.println("Check in Date:");
            String cid = scanner.nextLine();
            System.out.println("Check out Date: ");
            String cod = scanner.nextLine();
            System.out.println("Amount of people:");
            int aop = scanner.nextInt(); */
        }
            
        }
    

    public static void displayOption(NewAccountController newAccountController){
        System.out.println("~~~~~~~~~~~~~~~~~~~~CRS MENU~~~~~~~~~~~~~~~~~~~");
        // check
        String str = "";
        if (!newAccountController.getAccount().checkLoggedIn()) {

            str = "Enter one of the commands in the    brackets:\n" +
                    "[CA] Create Account\n" +
                    "[LI] Login";
            System.out.println(str);
        } else {

            System.out.println("Enter on of the commands in      brackets:\n " +
                    "[LO] Logout");
        }
    }



    public static String getPromt(NewAccountController newAccountController){
        if(!newAccountController.getAccount().checkLoggedIn()){
            return "";
        }

        return "LOGGED IN AS # " + newAccountController.getAccount().getUsername();

    }


    public static void handleInputs(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Location: ");
        String location = scanner.nextLine();
        System.out.println("Check in Date:");
        String cid = scanner.nextLine();
        System.out.println("Check out Date: ");
        String cod = scanner.nextLine();
        System.out.println("Amount of people:");
        int aop = scanner.nextInt();
    }
}
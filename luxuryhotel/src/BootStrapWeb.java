
import java.util.Date;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class BootStrapWeb {
        
    public static void main(String[] args) throws InterruptedException {
       
          Scanner scanner = new Scanner(System.in);
          Account account = new Account();
           NewAccountController newAccountController = new NewAccountController(account);
           NewAccountUI newAccountUI =new NewAccountUI(newAccountController);

        //login

         LoginAccountController loginAccountController = new LoginAccountController(account);
          LoginAccountUI loginAccountUI = new LoginAccountUI(loginAccountController);
       

        System.out.println("Welcom to the LuxuryHotel System");

        while (true){
            Thread.sleep(5000);
            displayOption(newAccountController);
            String prompt = getPrompt(newAccountController);
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


    public static String getPrompt(NewAccountController newAccountController){
        
        if(!newAccountController.getAccount().checkLoggedIn()){
            return "";
        }

        return "LOGGED IN AS # " + newAccountController.getAccount().getUsername();
    }

    public void handleInputs(){
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
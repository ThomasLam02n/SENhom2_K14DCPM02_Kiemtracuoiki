
import java.util.Date;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class BootStrapWeb {
    private static  String name = null;

    public static void main(String[] args) throws InterruptedException{
        SearchHotelController searchHotelController = new SearchHotelController();
      


        System.out.println("Welcom to the LuxuryHotel System");
        System.out.println("Hello");

        while (true){

            
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
    

    public static void displayOption(){
      
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
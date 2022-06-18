import java.util.Scanner;

public class BootStrapWeb {
    public static void main(String[] args) throws InterruptedException {


        Account account = new Account();
        NewAccountController newAccountController = new NewAccountController(account);
       NewAccountUI newAccountUI = new NewAccountUI(newAccountController);

       //login 

       LoginAccountController loginAccountController = new LoginAccountController(account);
       LoginAccountUI loginAccountUI = new LoginAccountUI(loginAccountController);

       Scanner scanner = new Scanner(System.in);
        System.out.println("Welcom to the LuxuryHotel System");
        
        while(true){
            Thread.sleep(1000);
            displayOption(newAccountController);
            String prompt = getPrompt(newAccountController);
            System.out.println(prompt);

            String rep = scanner.nextLine();

            String resCMD;
            if(rep.toUpperCase().equals(Actions.CA.toString())){
                resCMD = newAccountUI.handleCommand(rep);
                System.out.println(resCMD);

                if(resCMD != null && !resCMD.equals("Unkown command.")){
                    newAccountUI.handleInputs();
                }
            } else if(rep.toUpperCase().equals(Actions.LA.toString()) 
            || rep.toUpperCase().equals(Actions.LO.toString())){
                resCMD = loginAccountUI.handleCommands(rep);
                if(resCMD != null && !resCMD.equals("Unkown command")){
                    loginAccountUI.handleInputs();
                }
            }
            
        }
    }

    public static void displayOption(NewAccountController newAccountController){
        System.out.println("__________________CRS MENU________________");

        //check

        String str = "";
        if(!newAccountController.getAccount().checkLoggedIn()){
            str = "Enter one of the command in the brackets: \n " +
            "[CA] Create Account\n" + 
            "[LA] Login"; 
            System.out.println(str);
        }else{
            System.out.println("Enter on of the commands in bracket:\n " + 
                    "[LO] logout");
        }

    }
    public static String getPrompt(NewAccountController newAccountController){
        if(!newAccountController.getAccount().checkLoggedIn()){
            return "";
        }

        return "LOGGED IN AS #" + newAccountController.getAccount().getUsername();
    }
}

import java.util.Scanner;

import Action.Actions;

public class NewAccountUI {
   private static Scanner sc = new Scanner(System.in);
   private Actions command;
   private newAccountController newAccountController;


public NewAccountUI(newAccountController newAccountController) {
    this.command = null;
    this.newAccountController = newAccountController;
}

//CA
public String handleCommands(String rep){
    String cmd = rep.toUpperCase();
    this.command =Actions.valueOf(cmd);
    if(this.command.equals(Actions.CA)){
        return "Enter a username , a password, a email, a phone";
    } else {
        return "Unkown command";
    }
}

public void handleInputs(){
    if(this.command.equals(Actions.CA)){
        Account account = createAccountInputs();
        newAccountController.create_account(account.getUsername(), account.getPassword(), account.getEmail(), account.getPhonenumber());
    }
}

   
   
private static Account createAccountInputs(){
       System.out.println("USERNAME: ");
       String username = sc.nextLine();
       System.out.println("PASSWORD: ");
       Integer password = sc.nextInt();
       sc.nextLine();
       System.out.println("EMAIL: ");
       String email = sc.nextLine();
       System.out.println("NUMBER PHONE: ");
       Integer phonenumber = sc.nextInt();
       return new Account(username, password, phonenumber, email);
   }

}

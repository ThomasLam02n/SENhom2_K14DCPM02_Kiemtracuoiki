import java.util.InputMismatchException;
import java.util.Scanner;

public class NewAccountUI extends UITerminal{
    private Actions command;
    private NewAccountController newAccountController;
    private static Scanner scanner = new Scanner(System.in);

    public NewAccountUI() {
    }

    public NewAccountUI( NewAccountController newAccountController) {
        this.command = null;
        this.newAccountController = newAccountController;
    }

    @Override
    public String handleCommand(String rep) {
        String cmd = rep.toUpperCase();
        this.command = Actions.valueOf(cmd);
        if (this.command.equals(Actions.CA)) {
            return "Enter a username, a password, a email";
        } else {
            return "Unkown command.";
        }
    }

    @Override
    public void handleInputs() {
        if (this.command.equals(Actions.CA)) {
            Account account = createAccountInputs();
            newAccountController.createAccount(account.getUsername(), account.getPassword(), account.getEmail(), account.getPhonenumber());
        }
    }

    private static Account createAccountInputs() {
        System.out.print("USERNAME: ");
        String username = scanner.nextLine();
        System.out.print("PASSWORD: ");
        Integer password = null;

        try {
            password = scanner.nextInt();
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }

        scanner.nextLine();
        System.out.print("EMAIL: ");
        String email = scanner.nextLine();
        System.out.print("PHONENUMBER: ");
        Integer phone = null;
        
        try {
            phone = scanner.nextInt();
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
        scanner.nextLine();
        
        return new Account(username, password, email, phone);
    }
}

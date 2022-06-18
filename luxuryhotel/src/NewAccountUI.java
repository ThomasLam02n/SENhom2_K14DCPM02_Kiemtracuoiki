import java.util.Scanner;

public class NewAccountUI extends UITerminal {
    private static Scanner scanner = new Scanner(System.in);
    private Actions command;
    private NewAccountController newAccountController;

    

    /**
     * @param command
     * @param newAccountController
     */
    public NewAccountUI( NewAccountController newAccountController) {
        this.command = null;
        this.newAccountController = newAccountController;
    }


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
        Integer password = scanner.nextInt();
        scanner.nextLine();
        System.out.print("EMAIL: ");
        String email = scanner.nextLine();
        System.out.print("PHONENUMBER: ");
        Integer phone = scanner.nextInt();
        scanner.nextLine();
        return new Account(username, password, email, phone);
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
}

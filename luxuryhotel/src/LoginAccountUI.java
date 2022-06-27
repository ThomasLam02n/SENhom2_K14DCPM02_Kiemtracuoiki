import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LoginAccountUI extends UITerminal{
    private LoginAccountController loginAccountController;
    private Actions command;

    private static Scanner scanner = new Scanner(System.in);

    public LoginAccountUI(LoginAccountController loginAccountController) {
        this.loginAccountController = loginAccountController;
        this.command = null;
    }

    @Override
    public String handleCommand(String rep) {
        String cmd = rep.toUpperCase();
        this.command = Actions.valueOf(cmd);
        if (this.command.equals(Actions.LO)) {
            return "Logging out ...";
        } else if (this.command.equals(Actions.LA)) {
            return "Enter a username, a password";
        } else {
            return "Unkown command.";
        }
    }

    @Override
    public void handleInputs() {
        if (this.command.equals(Actions.LA)) {
            List<Object> list =  loginInputs();
            this.loginAccountController.login(list.get(0).toString(), (int)list.get(1));
        }else if(this.command.equals(Actions.LO)){
            this.loginAccountController.logout();
        }
    }

    private List<Object> loginInputs() {
        List<Object> list = new ArrayList<>();
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

        list.add(username);
        list.add(password);
        
        return list;
    }

   


}

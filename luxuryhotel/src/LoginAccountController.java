import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class LoginAccountController {
    private Account account;
    
    public LoginAccountController() {
    }

    public LoginAccountController(Account account) {
        this.account = account;
    }

    public void login(String username, Integer password) {
        JsonArray tempMemory = Account.getAccounts().getMemory();
        int index = -1;
        index = Account.getAccounts().searchString("un", username);
        
        if (username.equals(this.account.getUsername())) {
            System.out.println("[ALREADY LOGGED IN] You have already logged in.");
        } else if (this.account.getUsername() != null && !this.account.getUsername().equals(username)) {
            System.out.println("[INVALID MULTIPLE LOGINS] You need  to logout first to try another login.");
        } else if (index != -1) {
            JsonObject jsonObject = tempMemory.get(index).getAsJsonObject();
            int passwordAcc = jsonObject.get("ps").getAsInt();
            if (passwordAcc == password) {
                String email = jsonObject.get("email").getAsString();
                this.account.setAccount(username, password, email);
                System.out.println("[LOGGED IN] You are logged in.");

            } else {
                System.out.println("[WRONG PASSWORD] The password  you enterd is incorrect!!!");
            }

        } else {
            System.out.println("[NOT REGISTERD] You have to  register first.!!! ");
        }
    }
    
    public void logout(){
        this.account.logout();
    }
}

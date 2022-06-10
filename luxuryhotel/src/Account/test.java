package Account;

public class test {
    public static void main(String[] args) {
        Account account = new Account();
        NewAccountController newAccountController = new NewAccountController(account);
        newAccountController.createAccount("erril", 2323, "pohng@po", 97272477);
    }
}

public class CreatedAccountTestDrive {
    public static void main(String[] args) {
        Account account = new Account();
        newAccountController newAccountController = new newAccountController(account);
        newAccountController.create_account("phong", 3932, "phongcodon@gmail.com", 328291163);
    }
}

public class TestDriveAccount {

    public static void main(String[] args) {
        Account account = new Account();
      /*   NewAccountController newAccountController = new NewAccountController(account);
     newAccountController.createAccount("cucaido", 198, "cucaido32@gmail.com", 32567172); */


     //login account 

        LoginAccountController loginAccountController = new LoginAccountController(account);
        loginAccountController.login("cucaido", 198);

    }
    
}

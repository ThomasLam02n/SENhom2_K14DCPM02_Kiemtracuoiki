import java.util.Date;

public class Account {
    private String username;
    private Integer password;
    private Integer phonenumber;
    private String email;
    private Date checkin_date;
    private Date checkout_date;
    private boolean loggedin;

    private static SrotedFileAccountController accounts = new SrotedFileAccountController("account.json");

    public Account() {
        this.username = null;
        this.password = null;
        this.phonenumber = null;
        this.email = null;
        this.checkin_date = null;
        this.checkout_date = null;
        this.loggedin = false;
    }


    public boolean checkLoggedIn() {
        return loggedin;
    }

    public Account(String username, Integer password, int phonenumber, String email) {
        this.username = username;
        this.password = password;
        this.phonenumber = phonenumber;
        this.email = email;
    }


    public void setAccount(String username,Integer password, String email){
        this.username = username;
        this.password = password;
        this.loggedin = true;
    }

    public void logout() {
        this.loggedin = false;
        this.username = null;
        this.password = null;
        this.email = null;
        System.out.println("[LOGGED_OUT] You have been logged out");

    }


    public static SrotedFileAccountController getAccounts() {
        return accounts;
    }

    public String getUsername() {
        return username;
    }

    public Integer getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }


    public Integer getPhonenumber() {
        return phonenumber;
    }
    
    
}

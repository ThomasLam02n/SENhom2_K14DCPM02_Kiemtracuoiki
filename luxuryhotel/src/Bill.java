import com.google.gson.JsonArray;

public class Bill {
    private String username;
    private int id;
    private double price;
    private JsonArray service;
    private boolean state_bill;
    private static StoredFilesBill storedFilesBill = new StoredFilesBill("bills.json");

    public Bill() {
    }

    public Bill(String username, int id, double price) {
        this.username = username;
        this.id = id;
        this.price = price;
    }

    // public void setBill(String username, String id, double price) {
    //     this.username = username;
    //     this.id = id;
    //     this.price = price;
    //     this.state_bill = true;
    // } 

    public Bill(String username, int id, double prices, JsonArray service) {
        this.username = username;
        this.id = id;
        this.price = prices;
        this.service = service;
        this.state_bill = true;
    }

    public void setBill(int id, JsonArray service, double prices) {
        this.id = id;
        this.service = service;
        this.price = prices;
    }

    public static StoredFilesBill getStoredFilesBill() {
        return storedFilesBill;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getUsername() {
        return username;
    }

    public boolean check_bill() {
        return state_bill;
    }
}

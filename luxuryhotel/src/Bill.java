import com.google.gson.JsonArray;

public class Bill {
    private String username;
    private int id;
    private double price;
    private JsonArray service;
    private boolean stateBill;
    private static StoredFilesBill storedFilesBill;

    public Bill() {
    }

    public Bill(String nameFile) {
        Bill.storedFilesBill = new StoredFilesBill(nameFile);
    }

    public Bill(String username, int id, double price) {
        this.username = username;
        this.id = id;
        this.price = price;
    }

    public Bill(String username, int id, double prices, JsonArray service) {
        this.username = username;
        this.id = id;
        this.price = prices;
        this.service = service;
        this.stateBill = true;
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

    public boolean checkBill() {
        return stateBill;
    }
}

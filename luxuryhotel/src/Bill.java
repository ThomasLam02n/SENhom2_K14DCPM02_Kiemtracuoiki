public class Bill {
    private String username;
    private String id;
    private double price;
    private boolean state_bill;
    private static StoredFilesBill storedFilesBill = new StoredFilesBill("bills.json");

    public Bill() {
    }

    public Bill(String username, String id, double price) {
        this.username = username;
        this.id = id;
        this.price = price;
    }

    public void setBill(String username, String id, double price) {
        this.username = username;
        this.id = id;
        this.price = price;
        this.state_bill = true;
    } 

    public static StoredFilesBill getStoredFilesBill() {
        return storedFilesBill;
    }

    public String getId() {
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

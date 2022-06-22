public class Service {
    private String username;
    private double  price;
    private boolean state_services;
    private static StoredFilesService service = new StoredFilesService("Services.json");
    private Room room;

    public Service() {
        this.username = null;
        this.price = 0;
    }

    public Service(String username, double price) {
        this.username = username;
        this.price = price;
    }

    public static StoredFilesService getService() {
        return service;
    }

    public String getUsername() {
        return username;
    }
    
    public double getPrice() {
        return price;
    }
    
}

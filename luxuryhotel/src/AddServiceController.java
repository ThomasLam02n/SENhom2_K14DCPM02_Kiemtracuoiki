import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class AddServiceController {
    private Service service;
    private Bill bill;
    public AddServiceController() {
    }

    public AddServiceController(Bill bill) {
        this.bill = bill;
    }

    public void viewService() {
        JsonArray tempMemory = Service.getService().getMemory();
        System.out.printf("%-10s %-10s\n","NAME:", "PRICE:");
        for (int i = 0; i < tempMemory.size(); i++) {
            JsonObject jsonObject = tempMemory.get(i).getAsJsonObject();
            System.out.printf("%-10s %-10s\n" , jsonObject.get("service").getAsString(), jsonObject.get("price").getAsDouble());
        }
    }

    public void addService(int idRoom, String nameService) {
        List<Object> listCheck;
        int index = 0;
        int index2 = 0;
        listCheck = serviceValid(idRoom, nameService);
        if (!(boolean) listCheck.get(0)) {
            for (int i = 1; i < listCheck.size(); i++) {
                System.out.println(listCheck.get(i));
            }
        } else {
            index = Bill.getStoredFilesBill().searchInt("id room", idRoom);
            index2 = Service.getService().searchString("service", nameService);
            JsonArray billArray = Bill.getStoredFilesBill().getMemory();
            JsonObject billObject = billArray.get(index).getAsJsonObject();
            JsonArray service = billObject.get("service").getAsJsonArray();
            String datein = billObject.get("date in").getAsString();
            String dateout = billObject.get("date out").getAsString();
            String id = billObject.get("id").getAsString();
            String username = billObject.get("un").getAsString();
            Integer phoneNumber = billObject.get("phone").getAsInt();
            String email = billObject.get("email").getAsString();
            int diffDays = 0;

            try {
                diffDays = (int)calculateTheDateOfUse(BookingRoomController.dateFormat.parse(datein), BookingRoomController.dateFormat.parse(dateout));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            JsonArray serArray = Service.getService().getMemory();
            JsonObject serObject = serArray.get(index2).getAsJsonObject();
            double prices = serObject.get("price").getAsDouble();

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("1", nameService);

            service.add(jsonObject);
            double pricesBill = billObject.get("price").getAsDouble();
            double price;

            if (nameService.equalsIgnoreCase("Laundry")) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter the number of clothes: ");
                int number = scanner.nextInt();
                price = ((prices * number) + pricesBill);
            } else{
                price = (prices * diffDays) + pricesBill;
            }            

            billArray.remove(billArray.get(index));

            try {
                Bill.getStoredFilesBill().update(id, idRoom, username, phoneNumber, email, BookingRoomController.dateFormat.parse(datein), BookingRoomController.dateFormat.parse(dateout), service, price);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            // this.bill.setBill(idRoom, service, price);
            Bill.getStoredFilesBill().write();
            
            for (int i = 1; i < listCheck.size(); i++) {
                System.out.println(listCheck.get(i));
            }
        }
    }

    public List<Object> serviceValid(int id, String nameService) {
        List<Object> list = new ArrayList<>();
        int index = 0;
        int index2 = 0;
        index = Bill.getStoredFilesBill().searchInt("id room", id);
        if (index != -1) {
           
            index2 = Service.getService().searchString("service", nameService);
            if (index2 == -1) {
                list.add(false);
                list.add("Service does not exist.");
            } else {
                list.add(true);
                list.add("Successfully added service.");
            }           
        } else {
            list.add(false);
            list.add("Room ID is incorrect.");
        }
        return list;
    }
    
    public long calculateTheDateOfUse(Date dateint, Date dateout) {
        long diffDays;
        long diff = dateout.getTime() - dateint.getTime();
        diffDays = (diff / 3600000)/24;
        return diffDays;
    }
}

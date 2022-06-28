import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class PrintBillController {
    private Bill bill;
    private Hotel hotel;
    public Scanner scanner = new Scanner(System.in);

    public PrintBillController() {
    }

    public PrintBillController(Bill bill) {
        this.bill = bill;
    }

    public void printBill(String id) {
        List<Object> listCheck;
        
        listCheck = billValid(id);
        int index = 0;
        
        if (!(boolean) listCheck.get(0)) {
            for (int i = 1; i < listCheck.size(); i++) {
                System.out.println(listCheck.get(i));
            }
        } else {
            JsonArray jsonArray = Bill.getStoredFilesBill().getMemory();
            index = Bill.getStoredFilesBill().searchString("id", id);
            JsonObject jsonObject = jsonArray.get(index).getAsJsonObject();
            // System.out.println("NAME HOTEL: " + this.hotel.getName());
            System.out.println("ID: " + jsonObject.get("id").getAsString());
            System.out.println("ROOM: " + jsonObject.get("id room").getAsInt());
            System.out.println("USERNAME: " + jsonObject.get("un").getAsString());
            System.out.println("PHONE: " + jsonObject.get("phone").getAsInt());
            System.out.println("Email: " + jsonObject.get("email").getAsString());
            System.out.println("Date in: " + jsonObject.get("date in").getAsString());
            System.out.println("Date out: " + jsonObject.get("date out").getAsString());
            System.out.println("Service: " + jsonObject.get("service").getAsJsonArray().toString());
            System.out.println("Price: " + jsonObject.get("price").getAsDouble());
            // System.out.println(jsonObject.toString());
            System.out.print("Do you want to print invoices?(Y/N): ");
            String print = scanner.nextLine();
            if (print.equalsIgnoreCase("Y")) {
                System.out.println("Invoice is being printed please wait.");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(listCheck.get(1));              
            }
        }
    }
    
    public List<Object> billValid(String id) {
        List<Object> list =  new ArrayList<>();
        int index = 0;
        index = Bill.getStoredFilesBill().searchString("id", id);

        if (index == -1) {
            list.add(false);
            list.add("ID does not exist.");
        } else {
            list.add(true);
            list.add("Print bill successful.");
        }
        return list;
    }
}

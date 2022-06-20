import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class PrintBillController {
    private Bill bill;
    Scanner scanner = new Scanner(System.in);

    public PrintBillController() {
    }

    public PrintBillController(Bill bill) {
        this.bill = bill;
    }

    public void printBill(String id) {
        List<Object> listCheck;
        
        listCheck = bill_valid(id);
        if (!(boolean) listCheck.get(0)) {
            for (int index = 1; index < listCheck.size(); index++) {
                System.out.println(listCheck.get(index));
            }
        } else {
            for (int index = 1; index < listCheck.size(); index++) {
                System.out.println(listCheck.get(index));
            }
            System.out.print("Do you want to print invoices?(Y/N): ");
            String print = scanner.nextLine();
            if (print.equalsIgnoreCase("Y")) {
                System.out.println("Invoice is being printed please wait.");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Print bill successful.");              
            }
        }
    }
    public List<Object> bill_valid(String id) {
        List<Object> list =  new ArrayList<>();
        int index = 0;
        index = Bill.getStoredFilesBill().searchString("id", id);
        if (index == -1) {
            list.add(false);
            list.add("ID does not exist.");
        } else {
            JsonArray tempMemory = Bill.getStoredFilesBill().getMemory();
            JsonObject jsonObject = tempMemory.get(index).getAsJsonObject();
            String username = jsonObject.get("username").getAsString();
            double price = jsonObject.get("price").getAsDouble();
            list.add(true);
            list.add(id);
            list.add(username);
            list.add(price);
        }
        return list;
    }
    public Bill getRooms() {
        return bill;
    }
}

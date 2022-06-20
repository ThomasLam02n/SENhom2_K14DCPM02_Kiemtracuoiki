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
        int index = 0;
        if (!(boolean) listCheck.get(0)) {
            for (int i = 1; i < listCheck.size(); i++) {
                System.out.println(listCheck.get(i));
            }
        } else {
            JsonArray jsonArray = Bill.getStoredFilesBill().getMemory();
            index = Bill.getStoredFilesBill().searchString("id", id);
            JsonObject jsonObject = jsonArray.get(index).getAsJsonObject();
            System.out.println(jsonObject.toString());
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
    public List<Object> bill_valid(String id) {
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
    
    // @Override
    // public String toString() {
    //     JsonArray tempMemory = Bill.getStoredFilesBill().getMemory();
    //     JsonObject jsonObject = tempMemory.get(this.bill.hashCode()).getAsJsonObject();
    //     String id = jsonObject.get("id").getAsString();
    //     int idRoom = jsonObject.get("id room").getAsInt();
    //     String username = jsonObject.get("un").getAsString();
    //     int phone = jsonObject.get("phone").getAsInt();
    //     String email = jsonObject.get("email").getAsString();
    //     String datein = jsonObject.get("date in").getAsString();
    //     String dateout = jsonObject.get("date out").getAsString();
    //     JsonArray service = jsonObject.get("service").getAsJsonArray();
    //     jsonObject.toString();
    //     double price = jsonObject.get("price").getAsDouble();
    //     //  System.out.println("id: "+ idRoom +
    //     //     "\nid room: "+ idRoom +
    //     //     "\nuser name:"+ username+
    //     //     "\nphone"+ phone+
    //     //     "\nemail"+ email+
    //     //     "\ndate in"+ datein+
    //     //     "\ndate out"+ dateout+
    //     //     "\nservice"+ service+
    //     //     "\nprice"+ price);
    //     return "id: "+ idRoom +
    //     "\nid room: "+ idRoom +
    //     "\nuser name:"+ username+
    //     "\nphone"+ phone+
    //     "\nemail"+ email+
    //     "\ndate in"+ datein+
    //     "\ndate out"+ dateout+
    //     "\nservice"+ service+
    //     "\nprice"+ price;
    // }
}

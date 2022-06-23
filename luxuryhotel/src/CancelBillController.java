import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class CancelBillController {
    private BookedRoom bookedRoom;
    private Account account;
    private Bill bill;

    
    public CancelBillController() {
    }

    

    public CancelBillController(BookedRoom bookedRoom, Account account) {
        this.bookedRoom = bookedRoom;
        this.account = account;
    }



    public CancelBillController(BookedRoom bookedRoom) {
        this.bookedRoom = bookedRoom;
    }



    public void RemoveBill(String id, String name){
        List<Object> listcheck = check_Bill_vail(id, name);
       

        //     if(!(boolean) listcheck.get(0)){
        //         System.out.println(listcheck.get(1));
            
        //     } else {
        //         for (int i = 1; i < listcheck.size(); i++) {
                   
        //             listcheck.remove(listcheck.get(i));
        //             bookedRoom.getBookedRoom().updateCancelBill(id);
        //         }
                
        //     }
        
        JsonArray tem = BookedRoom.getBookedRoom().getAll();
        int index =0;
        index = BookedRoom.getBookedRoom().searchString("id", id);
        if(index != -1){
            JsonObject jObject = tem.get(index).getAsJsonObject();
            String name2 = jObject.get("un").getAsString();
            if(name2.equals(name)){
                tem.remove(tem.get(index));
                BookedRoom.getBookedRoom().write();
            }
            System.out.println(listcheck.get(1));
        }else{
            System.out.println(listcheck.get(1));
        }

       
        }    

    public List<Object> check_Bill_vail(String id, String name){
        List<Object> list = new ArrayList<>();
        JsonArray tempArray = BookedRoom.getBookedRoom().getAll();
        int index = 0;
        // int index2 = 0;
        // JsonArray accArray = Account.getAccounts().getAll();
        index = BookedRoom.getBookedRoom().searchString("id", id);
        JsonObject tempoObject = tempArray.get(index).getAsJsonObject();
        String name2 = tempoObject.get("un").getAsString();
      
        if(index != -1){
            if(name2.equals(name)){
                list.add(true);
                list.add("You do successful");
            }else{
                list.add(false);
                list.add("This is id of account dosen't exits");
            }
        }else{
            list.add(false);
            list.add("This is id dosen't exits");
        }
        
        return list;
        // List<Object> list = new ArrayList<>();
        // JsonArray tempMemory = BookedRoom.getBookedRoom().getAll();
        // int index = 0;
        // index = BookedRoom.getBookedRoom().searchString("id", id);
        // if(index == -1){
        //     list.add(false);
        //     list.add("This room id doesn't exist");
        // }
        // if(index != -1){
        //     JsonObject jsonObject = tempMemory.get(index).getAsJsonObject();
        //     String ids = jsonObject.get("id").getAsString();
        //     String nameCusomer = jsonObject.get("un").getAsString();
        //     Integer phone = jsonObject.get("phone").getAsInt();
        //     String email = jsonObject.get("email").getAsString();
        //     // boolean sate = jsonObject.get("sate").getAsBoolean();

        //     list.add(true);
        //     list.add(ids);
        //     list.add(nameCusomer);
        //     list.add(phone);
        //     list.add(email);
        //     // list.add(sate);


        //     return list;
        // }

        // return list;
      
    }
}

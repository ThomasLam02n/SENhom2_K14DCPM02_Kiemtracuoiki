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

    public void RemoveBill(String id){
        List<Object> listcheck = check_Bill_vail(id);
       

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
            tem.remove(tem.get(index));
            BookedRoom.getBookedRoom().write();
            
            System.out.println(listcheck.get(1));
        }else{
            System.out.println(listcheck.get(1));
        }

       
        }    

    public List<Object> check_Bill_vail(String id){
        List<Object> list = new ArrayList<>();
        JsonArray tempArray = BookedRoom.getBookedRoom().getAll();
        int index = 0;
        
        index = bookedRoom.getBookedRoom().searchString("id", id);
        if(index == -1){
            list.add(false);
            list.add("This is id dosen't exits");
        }
        if(index != -1){
            list.add(true);
            list.add("You do successful");
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

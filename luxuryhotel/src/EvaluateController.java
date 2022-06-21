import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class EvaluateController {
    static Scanner input = new Scanner(System.in);
    private Hotel hotel ;
    
    public void Evaluate(String name, String evaluate){
        List<Object> listcheck  ;
        // List<Object> listcheck2;
        listcheck = checkName_vail(name);
        // listcheck2 = checkAddress_valid(address);
        if(!(boolean) listcheck.get(0)){
            int index = 0;
            index = Hotel.getHotels().search("na", name);
            JsonArray tenmArray = Hotel.getHotels().getMemory();
            JsonObject jsonObject = tenmArray.get(index).getAsJsonObject();
            JsonArray temArray1 = jsonObject.get("ev").getAsJsonArray();
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("1", evaluate);
            temArray1.add(jsonObject2);
            
            this.hotel.setHotel(name, temArray1);

            // for(int i =1 ;i< listcheck.size();i++){
            //     System.out.println(listcheck.toString());
            // }
            System.out.println(jsonObject.toString());

        }
        // else if(!(boolean) listcheck2.get(0)){
        //     System.out.println(listcheck2.toString());
        // }
        else {
             name = this.hotel.getName();
            //  address = this.hotel.getAddress();
            
           
        }
        


                    
        
        
    }   
    public void ArrayEvaluate(){
        List list = new ArrayList<>();
        list.add("Very bad");
        list.add("Bad");
        list.add("Normal");
        list.add("good");
        list.add("Very good");
    }
    public List<Object> checkName_vail(String name){
        List<Object> list = new ArrayList<>();
        JsonArray temp = Hotel.getHotels().getMemory();
        int index = 0;
        index = Hotel.getHotels().search("name", name);
        
        if(index != -1){
            list.add(true);
            

        }else
        {
            list.add(false);
            list.add("");
        }
        return list;
        
    }
    public List<Object> checkAddress_valid(String address){
        List<Object> list = new ArrayList();
        int index = 0;
        index = Hotel.getHotels().searchAddressHotel("address", address);
        if(index != -1){
            list.add(false);
        }else{
            list.add(true);
        }
        return list;

    }
    public List<Object> checkUtilities(String utilities ){
        List<Object> list = new ArrayList<>();
        int index = 0;
        index = Hotel.getHotels().search("utilities",utilities);
        if(index != -1){
            list.add(false);
        }else{
            list.add(true);
        }
        return list;
    }
}

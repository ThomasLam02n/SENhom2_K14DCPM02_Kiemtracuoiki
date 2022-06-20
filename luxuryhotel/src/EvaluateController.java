import java.util.Scanner;

public class EvaluateController {
    static Scanner input = new Scanner(System.in);
    private Hotel hotel ;
    
    public void Evaluate(){
        
        System.out.println("------- Evaluate ----------");
        System.out.println("1.Very bad");
        System.out.println("2.Bad");
        System.out.println("3.Normal");
        System.out.println("4.Good");
        System.out.println("5.Very Good");
        System.out.println("Please you choose:");
        int choose = input.nextInt();
        switch(choose){
            case 1:  
            String name = this.hotel.getName();
            String address = this.hotel.getAddress();
            int room_quantity = this.hotel.getRoom_quantity();
            String utilities = this.hotel.getUtilities();
            String evaluation = "very bad";
            Hotel.getHotels().update(name, address, room_quantity, evaluation, utilities);


                    
        }
        
    }   
}

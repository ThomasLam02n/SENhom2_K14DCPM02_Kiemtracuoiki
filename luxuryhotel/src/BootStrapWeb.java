
import java.util.Date;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class BootStrapWeb {
    private static  String name = null;

    public static void main(String[] args) {
        SearchHotelController searchHotelController = new SearchHotelController();


        System.out.println("Welcom to the LuxuryHotel System");

        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Location: ");
            String location = scanner.nextLine();
            System.out.println("Check in Date:");
            String cid = scanner.nextLine();
            System.out.println("Check out Date: ");
            String cod = scanner.nextLine();
            System.out.println("Amount of people:");
            int aop = scanner.nextInt();
            

        }
    }

    public void displayOption(){
       
    }

    public static void handleInputs(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Location: ");
        String location = scanner.nextLine();
        System.out.println("Check in Date:");
        String cid = scanner.nextLine();
        System.out.println("Check out Date: ");
        String cod = scanner.nextLine();
        System.out.println("Amount of people:");
        int aop = scanner.nextInt();
    }
}
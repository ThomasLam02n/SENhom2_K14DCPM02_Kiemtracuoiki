import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BookingRoomUI extends UITerminal{
    private Actions command;
    private BookingRoomController bookingRoomController;
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    static Scanner scanner = new Scanner(System.in);

    public BookingRoomUI() {
    }

    public BookingRoomUI(BookingRoomController bookingRoomController) {
        this.bookingRoomController = bookingRoomController;
    }

    @Override
    public String handleCommand(String rep) {
        String cmd = rep.toUpperCase();
        this.command = Actions.valueOf(cmd);

        if (this.command.equals(Actions.BR)) {
            return "Enter the request you want to find.";
        } else {
            return "Unkown command.";
        }
    }

    @Override
    public void handleInputs() {
        if (this.command.equals(Actions.BR)) {
            // List<Object> list =  bookingRoomInput();
           // bookingRoomController.searchRoom((int)list.get(0), (double)list.get(1), list.get(2).toString());
        }
    }

    public static BookedRoom bookingRoomInput() {
        List<Object> list = new ArrayList<>();
        // System.out.print("Name: ");
        // String nameCustomer = scanner.nextLine();
        // System.out.print("Phone Number: ");
        // int phoneNumber = scanner.nextInt();
        // scanner.nextLine();
        // System.out.print("Email: ");
        // String email = scanner.nextLine();
        System.out.println(" Nhap id phong:");
        int idRoom = scanner.nextInt();
        System.out.println("Nhap ngay dat phong theo dd-MM -yyyy:");
        String ngayDatPhong = scanner.nextLine();
        Date date2 = null;
        try {
            date2 = dateFormat.parse(ngayDatPhong);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        System.out.println("Nhap tra phong theo dd- MM-yyyy");
        
        String ngayTraPhong = scanner.nextLine();
        Date date3 = null;
        try {
            date3 = dateFormat.parse(ngayTraPhong);
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        // list.add(idRoom);
        // list.add(ngayDatPhong);
        // list.add(ngayTraPhong);
        
        
        // list.add(area);
        // list.add(price);
        // list.add(utilities);
        return new BookedRoom();
    }
}

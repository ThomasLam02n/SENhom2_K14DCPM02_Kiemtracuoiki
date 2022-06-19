import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BookingRoomUI extends UITerminal{
    private Actions command;
    private BookingRoomController bookingRoomController;
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
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
            List<Object> list =  bookingRoomInput();
            try {
                this.bookingRoomController.bookingRoom((int)list.get(0), dateFormat.parse(list.get(1).toString()), dateFormat.parse(list.get(2).toString()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Object> bookingRoomInput() {
        List<Object> list = new ArrayList<>();
        System.out.print("ID room: ");
        int idRoom = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Received date(dd/MM/yyyy): ");
        String ngayDatPhong = scanner.nextLine();
        Date date2 = null;
        try {
            date2 = dateFormat.parse(ngayDatPhong);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print("Pay date(dd/MM/yyyy): ");
        
        String ngayTraPhong = scanner.nextLine();
        Date date3 = null;
        try {
            date3 = dateFormat.parse(ngayTraPhong);
        } catch (Exception e) {
            e.printStackTrace();
        }
        list.add(idRoom);
        list.add(dateFormat.format(date2));
        list.add(dateFormat.format(date3));

        return list;
    }
}

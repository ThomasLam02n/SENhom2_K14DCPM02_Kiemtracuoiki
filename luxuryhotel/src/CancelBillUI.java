
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CancelBillUI extends UITerminal {
    private CancelBillController cancelBillController;
    static Scanner input =new Scanner(System.in);
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    @Override
    public String handleCommand(String rep) {
        // TODO Auto-generated method stub
        String cmd = rep.toUpperCase();
        this.command = Actions.valueOf(cmd);
        if(this.command.equals(Actions.CB)){
            return "Enter the request you want to find.";
        }else{
            return "Unkown cammand.";
        }
       
    }

    @Override
    public void handleInputs() {
        // TODO Auto-generated method stub
        if(this.command.equals(Actions.CB)){
            List<Object> list = CancelBill();
            this.cancelBillController.CanelBill();

        }
        
    }
    private List<Object> CancelBill(){
        List<Object> list = new ArrayList<>();
        System.out.println("Input id bookroom: ");
        Integer idRoom = input.nextInt();
        // System.out.println("Nhap ngay dat phong theo dd-MM -yyyy:");
        // String ngayDatPhong = input.nextLine();
        // Date date2 = null;
        // try {
        //     date2 = dateFormat.parse(ngayDatPhong);
        // } catch (Exception e) {
        //     //TODO: handle exception
        //     e.printStackTrace();
        // }
        // System.out.println("Nhap tra phong theo dd- MM-yyyy");
        
        // String ngayTraPhong = input.nextLine();
        // Date date3 = null;
        // try {
        //     date3 = dateFormat.parse(ngayTraPhong);
        // } catch (Exception e) {
        //     //TODO: handle exception
        //     e.printStackTrace();
        // }
        list.add(idRoom);
        
        return list;
    }
}

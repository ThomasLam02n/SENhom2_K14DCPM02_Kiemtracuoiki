import java.util.List;
import java.util.Scanner;

public class EvaluateUI extends UITerminal {
   
    static Scanner input =new Scanner(System.in);
   
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
        // if(this.command.equals(Actions.CB)){
        //     List<Object> list = CancelBill();
          

        // }
        
    }
    private void CancelBill(){
        System.out.println("------- Evaluate ----------");
        System.out.println("1.Very bad");
        System.out.println("2.Bad");
        System.out.println("3.Normal");
        System.out.println("4.Good");
        System.out.println("5.Very Good");
        System.out.println("Please you choose:");
        
    }   
}

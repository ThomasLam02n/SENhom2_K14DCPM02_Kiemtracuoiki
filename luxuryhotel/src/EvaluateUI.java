import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvaluateUI extends UITerminal {
    private Actions command;
    private EvaluateController evaluateController = new EvaluateController();
    Scanner input = new Scanner(System.in);
    public EvaluateUI(){

    }
    public EvaluateUI(EvaluateController evaluateController){
        this.evaluateController = evaluateController;
    }
    @Override
    public String handleCommand(String rep) {
        // TODO Auto-generated method stub
        String cmd = rep.toUpperCase();
        this.command = Actions.valueOf(cmd);

        if (this.command.equals(Actions.EV)) {
            return "Enter the name of the service you want to add.";
        } else {
            return "Unkown command.";
        }
    }
    @Override
    public void handleInputs() {
        // TODO Auto-generated method stub
        if (this.command.equals(Actions.EV)) {
            // addServiceController.viewService();
            while (true) {
                List<Object> list =  addEvaluateInput();
                // addServiceController.addService((int)list.get(0), list.get(1).toString());
                evaluateController.Evaluate(list.get(0).toString(), list.get(1).toString());
                System.out.print("Do you want to rate more?(Y/N): ");
                String n = input.nextLine();
                if (n.equalsIgnoreCase("N")) {
                    break;
                }
            }
            
        }
        
    }
    public List<Object> addEvaluateInput() {
        List<Object> list = new ArrayList<>();
        System.out.print("Name Hotel: ");
        String name = input.nextLine();
        // input.nextLine();
        System.out.println("Input Evalute");
        String i = input.nextLine();
        // System.out.println("");
        list.add(name);
        list.add(i);
        // list.add(nameSv);
        return list;
    }
    

}

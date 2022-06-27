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
        String cmd = rep.toUpperCase();
        this.command = Actions.valueOf(cmd);

        if (this.command.equals(Actions.EV)) {
            return "Enter your rating.";
        } else {
            return "Unkown command.";
        }
    }

    @Override
    public void handleInputs() {
        if (this.command.equals(Actions.EV)) {
            List<Object> list =  addEvaluateInput();
            evaluateController.Evaluate(list.get(0).toString(), list.get(1).toString(), list.get(2).toString());           
        }   
    }

    private List<Object> addEvaluateInput() {
        List<Object> list = new ArrayList<>();
        System.out.print("Name Hotel: ");
        String name = input.nextLine();
        System.out.print("Vote (good, normal, bad): ");
        String vote = input.nextLine();
        System.out.print("Input Evalute: ");
        String ev = input.nextLine();

        list.add(name);
        list.add(vote);
        list.add(ev);

        return list;
    }
    

}

public class BootStrapEvluate {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Bill bill = new Bill();
        EvaluateController evaluateController = new EvaluateController(hotel);
        EvaluateUI evaluateUI = new EvaluateUI();
        AddServiceController addServiceController = new AddServiceController(bill);
        AddServicesUI addServicesUI = new AddServicesUI();

        while (true) {
            displayEvaluate(evaluateController);
            String rep = evaluateController.input.nextLine();
            String resCMD;
            if (rep.toUpperCase().equals(Actions.EV.toString())) {
                resCMD = evaluateUI.handleCommand(rep);
                System.out.println(resCMD);
                if (resCMD != null && !resCMD.equals("Unkown command.")) {
                    evaluateUI.handleInputs();
                } else {
                    System.out.println("[ERRO] Unknown command");
                }
            }else if (rep.toUpperCase().equals(Actions.EX.toString())) {
                break;
            }
        }
    }

    public static void displayEvaluate(EvaluateController evaluateController) {
        System.out.println("=============== Evaluate Menu ====================");
        String str = "";
        str = "Enter one of the commands in the brackets:\n" +
                "[EV] Evaluate\n"+
                "[EX] Exit";
        System.out.println(str);
    }
}

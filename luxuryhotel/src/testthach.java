public  class testthach {
    public static void main(String[] args) {
        Hotel h = new Hotel();
        EvaluateController a = new EvaluateController(h);
        EvaluateUI I = new EvaluateUI(a);
        System.out.print("nhap: ");
        String s = I.input.nextLine();
        I.handleCommand(s);
        I.handleInputs();
    }
}

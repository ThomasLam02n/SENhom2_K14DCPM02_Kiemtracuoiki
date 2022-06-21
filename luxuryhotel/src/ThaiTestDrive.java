public class ThaiTestDrive {
    public static void main(String[] args) {
        Bill bill = new Bill();
        AddServiceController addServiceController = new AddServiceController(bill);
        AddServicesUI addServicesUI = new AddServicesUI(addServiceController);
        System.out.print("nhap: ");
        String s = addServicesUI.scanner.nextLine();
        addServicesUI.handleCommand(s);
        addServicesUI.handleInputs();
    }
}

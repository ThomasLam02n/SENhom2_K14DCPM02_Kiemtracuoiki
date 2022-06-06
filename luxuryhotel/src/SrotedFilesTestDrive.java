public class SrotedFilesTestDrive {
    public static void main(String[] args) {
        SrotedFileAccountController srotedFileAccountController = new SrotedFileAccountController("account.json");
        srotedFileAccountController.read();
        System.out.println("x");
}
}

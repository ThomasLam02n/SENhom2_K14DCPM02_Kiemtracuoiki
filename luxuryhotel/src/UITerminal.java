public abstract class UITerminal {
    private Actions command;
    public abstract String handleCommand(String rep);
    public abstract void handleInputs();
}

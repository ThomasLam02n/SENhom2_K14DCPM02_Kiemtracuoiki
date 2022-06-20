public abstract class UITerminal {
    public Actions command;
    public abstract String handleCommand(String rep);
    public abstract void handleInputs();
    
}

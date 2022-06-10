package SearchBookedRoom;

import Action.Actions;

public abstract class UIterminal {
    private Actions command;
    public abstract String handleCommand(String rep);
    public abstract void handleInputs();
}

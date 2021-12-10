package chiefcook.chiecook_coursework.mainMenu.commands;

import java.util.List;

public class ExitCommand implements IMenuCommand {
    public final static String NAME = "exit";

    @Override
    public void execute() {
        System.out.println("Exiting program");
        System.exit(0);
    }

    @Override
    public String getHelp() {
        return "Closes program\nUse: \'exit\' with no parameters";
    }
}

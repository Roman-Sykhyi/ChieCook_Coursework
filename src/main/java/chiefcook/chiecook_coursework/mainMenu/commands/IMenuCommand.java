package chiefcook.chiecook_coursework.mainMenu.commands;

import java.util.List;

public interface IMenuCommand {
    public void execute(List<String> params);
    public String getHelp();
}

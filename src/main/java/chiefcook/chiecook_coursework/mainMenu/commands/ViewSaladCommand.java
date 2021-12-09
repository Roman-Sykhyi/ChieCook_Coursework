package chiefcook.chiecook_coursework.mainMenu.commands;

import chiefcook.chiecook_coursework.controllers.SaladController;
import chiefcook.chiecook_coursework.mainMenu.MainMenu;
import org.apache.log4j.Logger;

import java.util.List;

public class ViewSaladCommand implements IMenuCommand {
    private static final Logger LOG = Logger.getLogger(ViewSaladCommand.class.getSimpleName());

    public static final String NAME = "viewSalad";

    private SaladController saladController;

    public ViewSaladCommand(SaladController saladController) {
        this.saladController = saladController;
    }

    @Override
    public void execute(List<String> params) {
        LOG.info("User views salad");
        System.out.println(saladController.getSaladInfo());
    }

    @Override
    public String getHelp() {
        return "Shows salad ingredients\nUse: \'viewSalad\' with no parameters";
    }
}

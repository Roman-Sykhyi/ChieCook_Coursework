package chiefcook.chiecook_coursework.mainMenu.commands;

import chiefcook.chiecook_coursework.controllers.SaladController;

import org.apache.log4j.Logger;

import java.util.List;

public class CalculateSaladCaloriesCommand implements IMenuCommand {
    private static final Logger LOG = Logger.getLogger(CalculateSaladCaloriesCommand.class.getSimpleName());

    public final static String NAME = "calculateCalories";

    private SaladController saladController;

    public CalculateSaladCaloriesCommand(SaladController saladController) {
        this.saladController = saladController;
    }

    @Override
    public void execute() {
        System.out.println("Salad total calories: " + saladController.getSaladCalories());
        LOG.info("User calculating salad calories");
    }

    @Override
    public String getHelp() {
        return "Show total salad calories\nUse: \'calculateCalories\' with no parameters";
    }
}

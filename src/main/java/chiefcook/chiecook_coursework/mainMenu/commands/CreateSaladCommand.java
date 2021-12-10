package chiefcook.chiecook_coursework.mainMenu.commands;

import chiefcook.chiecook_coursework.controllers.SaladController;

import org.apache.log4j.Logger;

import java.util.List;

public class CreateSaladCommand implements IMenuCommand {
    private static final Logger LOG = Logger.getLogger(CreateSaladCommand.class.getSimpleName());

    public final static String NAME = "createSalad";

    private SaladController saladController;

    public CreateSaladCommand(SaladController saladController) {
        this.saladController = saladController;
    }

    @Override
    public void execute(List<String> params) {
        LOG.info("User creating new salad");
        System.out.println("Creating new salad");
        saladController.createSalad();
    }

    @Override
    public String getHelp() {
        return "Creates new empty salad\nUse: \'createSalad\' with no parameters";
    }
}
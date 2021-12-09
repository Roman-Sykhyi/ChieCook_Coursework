package chiefcook.chiecook_coursework.mainMenu.commands;

import chiefcook.chiecook_coursework.controllers.VegetableController;

import org.apache.log4j.Logger;

import java.util.List;

public class ViewAvailableVegetablesCommand implements IMenuCommand {
    private static final Logger LOG = Logger.getLogger(ViewAvailableVegetablesCommand.class.getSimpleName());

    public final static String NAME = "vegetables";

    private VegetableController vegetableController;

    public ViewAvailableVegetablesCommand(VegetableController vegetableController) {
        this.vegetableController = vegetableController;
    }

    @Override
    public void execute(List<String> params) {
        LOG.info("User views available vegetables");
        System.out.println("Available vegetables:");
        System.out.println(vegetableController.getVegetablesInfo());
    }

    @Override
    public String getHelp() {
        return "Shows list of all available vegetables\nUse: \'vegetables\' with no parameters";
    }
}

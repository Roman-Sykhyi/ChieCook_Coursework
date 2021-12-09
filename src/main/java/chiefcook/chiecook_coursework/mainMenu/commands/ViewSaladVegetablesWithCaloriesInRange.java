package chiefcook.chiecook_coursework.mainMenu.commands;

import chiefcook.chiecook_coursework.controllers.SaladController;
import chiefcook.chiecook_coursework.models.Vegetable;
import org.apache.log4j.Logger;

import java.util.List;

public class ViewSaladVegetablesWithCaloriesInRange implements IMenuCommand {
    private static final Logger LOG = Logger.getLogger(ViewSaladVegetablesWithCaloriesInRange.class.getSimpleName());

    public final static String NAME = "viewVegetablesWithCaloriesInRange";

    private SaladController saladController;

    public ViewSaladVegetablesWithCaloriesInRange(SaladController saladController) {
        this.saladController = saladController;
    }

    @Override
    public void execute(List<String> params) {
        System.out.println("Vegetables in salad with calories in range " + params.get(0) + " to " + params.get(1) + ":");

        try {
            List<Vegetable> vegetables = saladController
                    .getVegetablesWithCaloriesInRange(Double.parseDouble(params.get(0)), Double.parseDouble(params.get(1)));

            for(Vegetable vegetable : vegetables) {
                System.out.println(vegetable.toString());
            }

            LOG.info("User views salad vegetables with calories in range [" + params.get(0) + "; " + params.get(1) + "]");
        } catch (Exception e) {
            LOG.error("Error finding vegetables with calories in a given range");
            LOG.error(e.getMessage());
            System.out.println("Error finding vegetables");
        }
    }

    @Override
    public String getHelp() {
        return "Show vegetables in salad that have calories in a given range\nUse: \'viewVegetablesWithCaloriesInRange [leftBound] [rightBound]\'";
    }
}

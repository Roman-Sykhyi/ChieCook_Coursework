package chiefcook.chiecook_coursework.commands;

import chiefcook.chiecook_coursework.controllers.SaladController;
import org.apache.log4j.Logger;

public class ViewSaladVegetablesWithCaloriesInRange implements IMenuCommand {
    private static final Logger LOG = Logger.getLogger(ViewSaladVegetablesWithCaloriesInRange.class.getSimpleName());

    public final static String NAME = "viewVegetablesWithCaloriesInRange";

    @Override
    public void execute() {
        /*System.out.println("Vegetables in salad with calories in range " + params.get(0) + " to " + params.get(1) + ":");

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
        }*/
    }
}

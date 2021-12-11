package chiefcook.chiecook_coursework.commands;

import chiefcook.chiecook_coursework.controllers.SaladController;

import org.apache.log4j.Logger;

public class SortVegetablesCommand implements IMenuCommand {
    private static final Logger LOG = Logger.getLogger(SortVegetablesCommand.class.getSimpleName());

    public final static String NAME = "sortVegetables";

    private SaladController saladController;

    public SortVegetablesCommand(SaladController saladController) {
        this.saladController = saladController;
    }

    @Override
    public void execute() {
        /*try {
            String sortType = params.get(0);

            if(sortType.equals("name")) {
                saladController.sortIngredientsByName();
            } else if (sortType.equals("weight")) {
                saladController.sortIngredientsByWeight();
            } else if (sortType.equals("calories")) {
                saladController.sortIngredientsByCalories();
            }
            else {
                System.out.println("Wrong argument");
                return;
            }

            LOG.info("User sorting salad vegetables by " + sortType);
            System.out.println("Sorting salad vegetables by " + sortType);
        } catch (Exception e) {
            LOG.error("Error sorting vegetables");
            LOG.error(e.getMessage());
            System.out.println("Error sorting vegetables");
        }*/
    }

    @Override
    public String getHelp() {
        return "Sorts vegetables in salad by given parameter\nUse \'sortVegetables [sortType]\' sortType: {name, weight, calories}";
    }
}

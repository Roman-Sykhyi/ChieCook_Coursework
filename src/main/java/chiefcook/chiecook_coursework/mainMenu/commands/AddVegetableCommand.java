package chiefcook.chiecook_coursework.mainMenu.commands;

import chiefcook.chiecook_coursework.controllers.SaladController;
import chiefcook.chiecook_coursework.controllers.VegetableController;
import chiefcook.chiecook_coursework.models.Vegetable;

import org.apache.log4j.Logger;

import java.util.List;

public class AddVegetableCommand implements IMenuCommand {
    private static final Logger LOG = Logger.getLogger(AddVegetableCommand.class.getSimpleName());

    public final static String NAME = "addVegetable";

    private VegetableController vegetableController;
    private SaladController saladController;

    public AddVegetableCommand(VegetableController vegetableController, SaladController saladController) {
        this.vegetableController = vegetableController;
        this.saladController = saladController;
    }

    @Override
    public void execute(List<String> params) {
        System.out.println("Adding vegetable to salad");

        try {
            Vegetable vegetable = vegetableController.getVegetable(params.get(0));
            Double weight = Double.parseDouble(params.get(1));

            saladController.addIngredient(vegetable, weight);
            LOG.info("User adding " + weight + " grams of " + vegetable.getName() + " to salad");
            System.out.println(weight + " grams of " + vegetable.getName() + " added to salad");
        } catch (Exception e) {
            LOG.error("Error adding vegetable");
            LOG.error(e.getMessage());
            System.out.println("Error adding vegetable");
        }
    }

    @Override
    public String getHelp() {
        return "Adds vegetable to salad\nUse: \'addVegetable [name] [weight]\'";
    }
}
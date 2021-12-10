package chiefcook.chiecook_coursework.controllers;

import chiefcook.chiecook_coursework.models.Salad;
import chiefcook.chiecook_coursework.models.Vegetable;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SaladController {
    private static final Logger LOG = Logger.getLogger(SaladController.class.getSimpleName());

    private Salad salad;

    public SaladController() {
        salad = new Salad();
    }

    public void createSalad() {
        salad = new Salad();
    }

    public void addIngredient(Vegetable vegetable, Double weight) {
        if (vegetable == null)
            throw new NullPointerException();

        salad.addIngedient(vegetable, weight);
    }

    public void removeIngredient(String name) {
        salad.removeIngredient(name);
    }

    public List<Vegetable> getVegetables() {
        return salad.getVegetables();
    }

    public String getSaladInfo() {
        String result = "";
        result += salad.toString();
        return result;
    }

    public Double getSaladCalories() {
        return salad.getTotalCalories();
    }

    public void sortIngredientsByName() {
        salad.sortByName();
    }

    public void sortIngredientsByWeight() {
        salad.sortByWeight();
    }

    public void sortIngredientsByCalories() {
        salad.sortByCalories();
    }

    public List<Vegetable> getVegetablesWithCaloriesInRange(double leftBound, double rightBound) {
        if(leftBound > rightBound) {
            throw new IllegalArgumentException("Left bound cannot be higher than right bound");
        }

        List<Vegetable> allVegetables = salad.getVegetables();
        List<Vegetable> result = new ArrayList<Vegetable>();

        for(Vegetable vegetable : allVegetables) {
            double calories = vegetable.getCalories();
            if(calories >= leftBound && calories <= rightBound) {
                result.add(vegetable);
            }
        }

        return result;
    }
}
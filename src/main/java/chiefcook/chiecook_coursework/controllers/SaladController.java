package chiefcook.chiecook_coursework.controllers;

import chiefcook.chiecook_coursework.builders.SaladBuilder;
import chiefcook.chiecook_coursework.models.Salad;
import chiefcook.chiecook_coursework.models.Vegetable;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SaladController {
    private static final Logger LOG = Logger.getLogger(SaladController.class.getSimpleName());

    private Salad salad;
    private SaladBuilder saladBuilder;

    public SaladController() {
        salad = new Salad();
    }

    public SaladController(SaladBuilder saladBuilder) {
        setSaladBuilder(saladBuilder);
        createSalad();
    }

    public void createSalad() {
        saladBuilder.createNewSalad();
        salad = saladBuilder.getSalad();
    }

    public void addIngredient(Vegetable vegetable, Double weight) {
        salad.addIngedient(vegetable, weight);
    }

    public void removeIngredient(String name) {
        salad.removeIngredient(name);
    }

    public String getSaladInfo() {
        String result = "Salad:\n";
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

    public void setSaladBuilder(SaladBuilder builder) {
        saladBuilder = builder;
    }
}
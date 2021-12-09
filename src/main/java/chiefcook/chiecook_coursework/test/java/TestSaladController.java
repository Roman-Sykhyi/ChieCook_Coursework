package chiefcook.chiecook_coursework.test.java;

import chiefcook.chiecook_coursework.controllers.SaladController;
import chiefcook.chiecook_coursework.models.Vegetable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestSaladController {
    @Test
    public void testGetSaladInfo() {
        SaladController saladController = new SaladController();
        Vegetable vegetable = new Vegetable("Vegetable", 100);
        saladController.addIngredient(vegetable, 100.0);

        String result = saladController.getSaladInfo();

        Assertions.assertEquals("Salad:\nVegetable - 100.0 grams\n", result);
    }

    @Test
    public void testGetVegetablesWithCaloriesInRange() {
        SaladController saladController = new SaladController();
        Vegetable vegetable1 = new Vegetable("Vegetable1", 50);
        Vegetable vegetable2 = new Vegetable("Vegetable2", 100);
        saladController.addIngredient(vegetable1, 100.0);
        saladController.addIngredient(vegetable2, 100.0);

        List<Vegetable> result = saladController.getVegetablesWithCaloriesInRange(0, 75);

        Assertions.assertEquals(vegetable1, result.get(0));
        Assertions.assertThrows(Exception.class, () -> result.get(1));
    }
}
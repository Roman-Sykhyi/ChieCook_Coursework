package chiefcook.chiecook_coursework.test.java;

import chiefcook.chiecook_coursework.models.Vegetable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestVegetable {
    @Test
    public void testGetName() {
        Vegetable vegetable = new Vegetable("vegetable", 10);

        String result = vegetable.getName();

        Assertions.assertEquals("vegetable", result);
    }

    @Test
    public void testGetCalories() {
        Vegetable vegetable = new Vegetable("vegetable", 10);

        double result = vegetable.getCalories();

        Assertions.assertEquals(10, result);
    }

    @Test
    public void testGetCaloriesOneGram() {
        Vegetable vegetable = new Vegetable("vegetable", 100);

        double result = vegetable.getCaloriesOneGram();

        Assertions.assertEquals(1, result);
    }
}
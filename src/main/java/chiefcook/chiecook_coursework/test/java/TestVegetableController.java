package chiefcook.chiecook_coursework.test.java;

import chiefcook.chiecook_coursework.controllers.VegetableController;
import chiefcook.chiecook_coursework.models.Vegetable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestVegetableController {
    final String filePath = "E:\\pp_labs\\ChiefCook\\VegetablesListForUnitTest.txt";

    @Test
    public void testInitAndGetVegetable() {
        VegetableController vegetableController = new VegetableController(filePath);

        Vegetable result = vegetableController.getVegetable("Vegetable");
        Assertions.assertNotNull(result);

        result = vegetableController.getVegetable("Vegetable123");
        Assertions.assertNull(result);
    }

    @Test
    public void testGetVegetablesInfo() {
        VegetableController vegetableController = new VegetableController(filePath);

        String result = vegetableController.getVegetablesInfo();
        String expected = "1. Vegetable, calories = 12.0\n2. Vegetable1, calories = 15.0\n";

        Assertions.assertEquals(expected, result);
    }
}
import chiefcook.chiecook_coursework.models.Salad;
import chiefcook.chiecook_coursework.models.Vegetable;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class TestSalad {
    @Test
    public void testAddIngredient() {
        //arrange
        Salad salad = new Salad();
        Vegetable vegetable = new Vegetable("Vegetable", 100);

        //act
        salad.addIngedient(vegetable, 10.0);
        Vegetable result = salad.getVegetables().get(0);

        //assert
        Assertions.assertEquals(vegetable.getName(), result.getName());
        Assertions.assertEquals(vegetable.getCalories(), result.getCalories());

        //act
        salad.addIngedient(vegetable, 10.0);
        result = salad.getVegetables().get(0);

        //assert
        Assertions.assertEquals(vegetable.getName(), result.getName());
        Assertions.assertThrows(Exception.class, () -> salad.getVegetables().get(1));
    }

    @Test
    public void testRemoveIngredient() {
        //arrange
        Salad salad = new Salad();
        Vegetable vegetable = new Vegetable("Vegetable", 100);
        salad.addIngedient(vegetable, 10.0);

        //act
        salad.removeIngredient("Vegetable");

        //assert
        Assertions.assertEquals(0, salad.getVegetables().size());
    }

    @Test
    public void testGetVegetables() {
        //arrange
        Salad salad = new Salad();

        Vegetable vegetable1 = new Vegetable("Vegetable1", 100);
        Vegetable vegetable2 = new Vegetable("Vegetable2", 100);
        Vegetable vegetable3 = new Vegetable("Vegetable3", 100);

        salad.addIngedient(vegetable1, 10.0);
        salad.addIngedient(vegetable2, 10.0);
        salad.addIngedient(vegetable3, 10.0);

        List<Vegetable> expectedVegetables = new ArrayList<>();
        expectedVegetables.add(vegetable1);
        expectedVegetables.add(vegetable2);
        expectedVegetables.add(vegetable3);

        //act
        List<Vegetable> result = salad.getVegetables();

        //assert
        Assertions.assertEquals(expectedVegetables.get(0), result.get(0));
        Assertions.assertEquals(expectedVegetables.get(1), result.get(1));
        Assertions.assertEquals(expectedVegetables.get(2), result.get(2));
    }

    @Test
    public void testGetTotalCalories() {
        //arrange
        Salad salad = new Salad();
        Vegetable vegetable = new Vegetable("Vegetable", 100);
        Vegetable vegetable1 = new Vegetable("Vegetable1", 50);
        salad.addIngedient(vegetable, 100.0);
        salad.addIngedient(vegetable1, 50.0);

        //act
        double calories = salad.getTotalCalories();

        //assert
        Assertions.assertEquals(125, calories);
    }

    @Test
    public void testSortByName() {
        //arrange
        Salad salad = new Salad();
        Vegetable vegetable1 = new Vegetable("a", 10);
        Vegetable vegetable2 = new Vegetable("b", 20);
        Vegetable vegetable3 = new Vegetable("c", 30);
        salad.addIngedient(vegetable2, 10.0);
        salad.addIngedient(vegetable3, 10.0);
        salad.addIngedient(vegetable1, 10.0);

        //act
        salad.sortByName();

        //assert
        Assertions.assertEquals(vegetable1, salad.getVegetables().get(0));
        Assertions.assertEquals(vegetable2, salad.getVegetables().get(1));
        Assertions.assertEquals(vegetable3, salad.getVegetables().get(2));
    }

    @Test
    public void testSortByWeight() {
//arrange
        Salad salad = new Salad();
        Vegetable vegetable1 = new Vegetable("a", 10);
        Vegetable vegetable2 = new Vegetable("b", 20);
        Vegetable vegetable3 = new Vegetable("c", 30);
        salad.addIngedient(vegetable2, 20.0);
        salad.addIngedient(vegetable1, 30.0);
        salad.addIngedient(vegetable3, 10.0);

        //act
        salad.sortByWeight();

        //assert
        Assertions.assertEquals(vegetable1, salad.getVegetables().get(0));
        Assertions.assertEquals(vegetable2, salad.getVegetables().get(1));
        Assertions.assertEquals(vegetable3, salad.getVegetables().get(2));
    }

    @Test
    public void testSortByCalories() {
        //arrange
        Salad salad = new Salad();
        Vegetable vegetable1 = new Vegetable("a", 30);
        Vegetable vegetable2 = new Vegetable("b", 20);
        Vegetable vegetable3 = new Vegetable("c", 10);
        salad.addIngedient(vegetable2, 10.0);
        salad.addIngedient(vegetable3, 10.0);
        salad.addIngedient(vegetable1, 10.0);

        //act
        salad.sortByCalories();

        //assert
        Assertions.assertEquals(vegetable1, salad.getVegetables().get(0));
        Assertions.assertEquals(vegetable2, salad.getVegetables().get(1));
        Assertions.assertEquals(vegetable3, salad.getVegetables().get(2));
    }
}
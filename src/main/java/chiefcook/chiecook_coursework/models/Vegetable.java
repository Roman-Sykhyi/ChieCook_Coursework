package chiefcook.chiecook_coursework.models;

public class Vegetable {
    private String name;
    private Double calories;

    public Vegetable(String name, double calories) {

        if(name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Name of vegetable cannot be empty");
        }

        if (calories <= 0) {
            throw  new IllegalArgumentException("Number of calories cannot be less or equal to 0");
        }

        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public Double getCalories() {
        return calories;
    }

    public Double getCaloriesOneGram() {
        return calories / 100;
    }

    @Override
    public String toString() {
        return  name +
                ", calories = " + calories;
    }
}
package chiefcook.chiecook_coursework.models;

import java.util.*;

public class Salad {
    private Map<Vegetable, Double> ingredients;

    public Salad() {
        ingredients = new LinkedHashMap<Vegetable, Double>();
    }

    public void addIngedient(Vegetable vegetable, Double weight) {
        if(weight <= 0)
            throw new IllegalArgumentException("Weight cannot be less than or equal to zero");

        Vegetable veg = null;

        for(Vegetable key : ingredients.keySet()) {
            if(key.getName().equals(vegetable.getName())) {
                veg = key;
            }
        }

        if(veg != null) {
            ingredients.put(veg, ingredients.get(veg) + weight);
        } else {
            ingredients.put(vegetable, weight);
        }
    }

    public void removeIngredient(String name) {
        ingredients.keySet().removeIf(vegetable -> vegetable.getName().equals(name));
    }

    public List<Vegetable> getVegetables() {
        return Collections.unmodifiableList(new ArrayList<Vegetable>(ingredients.keySet()));
    }

    public double getTotalCalories() {
        double result = 0;

        for (Map.Entry<Vegetable, Double> entry : ingredients.entrySet()) {
            result += entry.getKey().getCaloriesOneGram() * entry.getValue();
        }

        return result;
    }

    public void sortByName() {
        List<Map.Entry<Vegetable, Double>> entries =
                new ArrayList<Map.Entry<Vegetable, Double>>(ingredients.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Vegetable, Double>>() {
            public int compare(Map.Entry<Vegetable, Double> a, Map.Entry<Vegetable, Double> b){
                return a.getKey().getName().compareTo(b.getKey().getName());
            }
        });
        Map<Vegetable, Double> sortedMap = new LinkedHashMap<Vegetable, Double>();
        for (Map.Entry<Vegetable, Double> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        ingredients = sortedMap;
    }

    public void sortByWeight() {
        List<Map.Entry<Vegetable, Double>> entries =
                new ArrayList<Map.Entry<Vegetable, Double>>(ingredients.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Vegetable, Double>>() {
            public int compare(Map.Entry<Vegetable, Double> a, Map.Entry<Vegetable, Double> b){
                return b.getValue().compareTo(a.getValue());
            }
        });
        Map<Vegetable, Double> sortedMap = new LinkedHashMap<Vegetable, Double>();
        for (Map.Entry<Vegetable, Double> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        ingredients = sortedMap;
    }

    public void sortByCalories() {
        List<Map.Entry<Vegetable, Double>> entries =
                new ArrayList<Map.Entry<Vegetable, Double>>(ingredients.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Vegetable, Double>>() {
            public int compare(Map.Entry<Vegetable, Double> a, Map.Entry<Vegetable, Double> b){
                return b.getKey().getCalories().compareTo(a.getKey().getCalories());
            }
        });

        Map<Vegetable, Double> sortedMap = new LinkedHashMap<Vegetable, Double>();
        for (Map.Entry<Vegetable, Double> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        ingredients = sortedMap;

    }


    @Override
    public String toString() {
        String result = "";

        for(Map.Entry<Vegetable, Double> entry : ingredients.entrySet()) {
            result += entry.getKey().getName() + " - " + entry.getValue() + " грам\n";
        }

        return result;
    }
}
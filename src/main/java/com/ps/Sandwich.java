package com.ps;

import java.util.HashMap;

public class Sandwich {
    private String size;
    private String breadType;
    private HashMap<String, Integer> selectRegularToppings;
    private HashMap<String, Integer> selectPremiumToppings;
    private boolean isToasted;

    public Sandwich(String size, String breadType, boolean isToasted) {
        this.size = size;
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.selectRegularToppings = new HashMap<>();
        this.selectPremiumToppings = new HashMap<>();
    }

    public void addRegularTopping(String topping) {
        selectRegularToppings.put(topping, selectRegularToppings.getOrDefault(topping, 0) + 1);
    }

    public void addPremiumTopping(String topping) {
        selectPremiumToppings.put(topping, selectPremiumToppings.getOrDefault(topping, 0) + 1);
    }

    public double calculateCost(Topping topping) {
        double cost = 0.0;

        switch (size) {
            case "4\"":
                cost += 5.50;
                break;
            case "8\"":
                cost += 7.00;
                break;
            case "12\"":
                cost += 8.50;
                break;
        }

        for (String toppingName : selectRegularToppings.keySet()) {
            cost += topping.getToppingCost(toppingName) * selectRegularToppings.get(toppingName);
        }

        for (String toppingName : selectPremiumToppings.keySet()) {
            cost += topping.getToppingCost(toppingName) * selectPremiumToppings.get(toppingName);
        }

        if (isToasted) {
            cost += 1.00;
        }

        return cost;
    }

    @Override
    public String toString() {
        return "Sandwich [size=" + size + ", breadType=" + breadType + ", isToasted=" + isToasted +
                ", regularToppings=" + selectRegularToppings.keySet() +
                ", premiumToppings=" + selectPremiumToppings.keySet() + "]";
    }
}

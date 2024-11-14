package com.ps;

import java.util.HashMap;

public class Sandwich {
    private String size;
    private String breadType;
    private HashMap<String, Integer> selectRegularToppings;
    private HashMap<String, Integer> selectPremiumToppings;
    private boolean isToasted;

    private static final double SMALL_PRICE =5.50;
    private static final double MEDIUM_PRICE =7.00;
    private static final double LARGE_PRICE =8.50;


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

    private double getBasePrice() {

        switch (size) {
            case "4\"":
                return SMALL_PRICE;

            case "8\"":
                return MEDIUM_PRICE;
            case "12\"":
                return LARGE_PRICE;
            default:
                return 0.0;
        }
    }
public double calculateCost(Topping topping) {
        double cost = getBasePrice();
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
                ", premiumToppings=" + selectPremiumToppings.keySet() +
                ", cost=$" + String.format("%.2f",calculateCost(new Topping())) + "]";

    }
}

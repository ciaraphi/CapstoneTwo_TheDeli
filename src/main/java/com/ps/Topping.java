package com.ps;

import java.util.HashMap;
public class Topping {
    private static HashMap<String, Double> regularToppings;
    private static HashMap<String, Double> premiumToppings;

    public Topping() {
        regularToppings = new HashMap<>();
        premiumToppings = new HashMap<>();
        initializeToppings();
    }

    private void initializeToppings() {

        regularToppings.put("Lettuce", 0.0);
        regularToppings.put("Tomatoes", 0.0);
        regularToppings.put("Onion", 0.0);
        regularToppings.put("Pickles", 0.0);
        regularToppings.put("Jalapenos", 0.0);


        premiumToppings.put("Bacon", 1.50);
        premiumToppings.put("Avocado", 2.00);
        premiumToppings.put("Ham", 1.50);
        premiumToppings.put("Chicken", 1.50);
        premiumToppings.put("Turkey", 1.50);
    }
    public HashMap<String, Double> getRegularToppings() {
        return regularToppings;
    }
    public HashMap<String,Double> getPremiumToppings(){
        return premiumToppings;
    }
    public double getToppingCost(String toppingName) {
        if (premiumToppings.containsKey(toppingName)) {
            return premiumToppings.get(toppingName);
        } else if (regularToppings.containsKey(toppingName)) {
            return regularToppings.get(toppingName);
        }
        return 0.0;
    }
}


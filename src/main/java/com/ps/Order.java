package com.ps;

import java.util.ArrayList;

public class Order {
    private ArrayList<Sandwich> sandwiches;
    private ArrayList<Drink> drinks;
    private ArrayList<Chip> chips;

    public Order() {
        sandwiches = new ArrayList<>();
        drinks = new ArrayList<>();
        chips = new ArrayList<>();
    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChip(Chip chip) {
        chips.add(chip);
    }

    public double calculateTotalCost(Topping topping) {
        double total = 0.0;

        for (Sandwich sandwich : sandwiches) {
            total += sandwich.calculateCost(topping);
        }

        for (Drink drink : drinks) {
            total += drink.getPrice();
        }

        for (Chip chip : chips) {
            total += chip.getPrice();
        }

        return total;
    }

    public ArrayList<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public ArrayList<Chip> getChips() {
        return chips;
    }
}


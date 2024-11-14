package com.ps;

public class Drink {
    private String size;
    private double price;
    private String flavor;


    public Drink(String size, String flavor) {
        this.size = size;
        this.price = calculatedPrice();
        this.flavor = flavor;


    }
    private double calculatedPrice() {
        return switch (size.toLowerCase()) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 0.0;
        };
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Drink [size=" + size + ", flavor=" + flavor + ",price=" + price + "]";
    }
}
package com.ps;

public class Drink {
    private String size;
    private double price;
    private  String flavor;


    public Drink(String size, String flavor) {
        this.size = size;
        this.price = calculatedPrice();
        this.flavor = flavor;


    }
    private double calculatedPrice() {
        switch (size.toLowerCase()) {
            case "small" -> {
                return 2.00;
            }
            case "medium" -> {
                return 2.50;
            }
            case "large" -> {
                return 3.00;
                defualt:
                return 0.0;
            }
        }

        public double getPrice() {
            return price;
        }
        public String getFlavor(){
            return flavor;
        }
        @Override
        public String toString() {
            return "Drink [size=" + size + ", flavor=" + flavor + ",price=" + price + "]";
        }
    }


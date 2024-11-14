package com.ps;
    public class Chip {
        private double price;
        public Chip() {
            this.price = 1.50;
        }
        public double getPrice() {
            return price;
        }
        @Override
        public String toString() {
            return "Chip [price" + price + "]";
        }

        public void add(Chip chip) {

        }
    }


package com.ps;

import java.io.FileWriter;
import java.io.IOException;


    public class Receipt {
        private Order order;
        private Topping topping;
        public Receipt(Order currentOrder, Topping topping) {

            this.order = order;
            this.topping = topping;
        }

        public void printReceipt() {
            String receiptContent = generateReceiptContent();
            System.out.println(receiptContent); // Display receipt in the console
            saveReceiptToFile(receiptContent);
        }

        private String generateReceiptContent() {
            StringBuilder receipt = new StringBuilder();
            receipt.append("Cece's Deli Receipt\n");
            receipt.append("====================\n");

            // Sandwiches
            receipt.append("\nSandwiches:\n");
            for (Sandwich sandwich : order.getSandwiches()) {
                receipt.append(sandwich).append("\n");
            }

            // Drinks
            receipt.append("\nDrinks:\n");
            for (Drink drink : order.getDrinks()) {
                receipt.append(drink).append("\n");
            }

            // Chips
            receipt.append("\nChips:\n");
            for (Chip chip : order.getChips()) {
                receipt.append(chip).append("\n");
            }

            double totalCost = order.calculateTotalCost(topping);
            receipt.append("\n====================\n");
            receipt.append("Total Cost: $").append(String.format("%.2f", totalCost)).append("\n");
            receipt.append("Thank you for your order!");

            return receipt.toString();
        }

        private void saveReceiptToFile(String content) {
            try (FileWriter writer = new FileWriter("receipt.txt.")) {
                writer.write(content);
                System.out.println("Receipt saved to receipt.txt.");
            } catch (IOException e) {
                System.out.println("An error occurred while saving the receipt.");
            }
        }

        public void printAndSaveReceipt() {
        }
    }

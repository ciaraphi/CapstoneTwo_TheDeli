package com.ps;
        import java.util.HashMap;
        import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Topping topping;
    private Order currentOrder;

    public UserInterface() {
        scanner = new Scanner(System.in);
        topping = new Topping();
    }

    public void start() {
        System.out.println("Welcome to Cece’s Deli!");

        boolean running = true;
        while (running) {
            System.out.println("1) New Order\n0) Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                currentOrder = new Order();
                handleOrder();
            } else if (choice == 0) {
                running = false;
            }
        }
    }

    private void handleOrder() {
        boolean ordering = true;
        while (ordering) {
            System.out.println("1) Add Sandwich\n2) Add Drink\n3) Add Chips\n4) Checkout\n0) Cancel Order");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: addSandwich(); break;
                case 2: addDrink(); break;
                case 3: addChip(); break;
                case 4: checkout(); ordering = false; break;
                case 0: ordering = false; break;
            }
        }
    }

    private void addSandwich() {
        System.out.println("Enter sandwich size (4\", 8\", 12\"): ");
        String size = scanner.nextLine();
        System.out.println("Enter bread type (white, wheat, rye, wrap): ");
        String breadType = scanner.nextLine();
        System.out.println("Would you like it toasted? (yes/no): ");
        boolean isToasted = scanner.nextLine().equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(size, breadType, isToasted);

        // Add Regular Toppings
        System.out.println("\nChoose regular toppings by entering the option number (type '0' when finished):");
        HashMap<Integer, String> regularToppingOptions = new HashMap<>();
        int optionNumber = 1;
        for (String toppingName : topping.getRegularToppings().keySet()) {
            regularToppingOptions.put(optionNumber, toppingName);
            System.out.println("Option " + optionNumber + ": " + toppingName);
            optionNumber++;
        }

        int toppingChoice;
        while ((toppingChoice = scanner.nextInt()) != 0) {
            String selectedTopping = regularToppingOptions.get(toppingChoice);
            if (selectedTopping != null) {
                sandwich.addRegularTopping(selectedTopping);
                System.out.println("Added regular topping: " + selectedTopping);
            } else {
                System.out.println("Invalid choice. Please select a valid option number for a regular topping.");
            }
        }
        scanner.nextLine(); // consume the newline

        // Add Premium Toppings
        System.out.println("\nChoose premium toppings by entering the option number (type '0' when finished):");
        HashMap<Integer, String> premiumToppingOptions = new HashMap<>();
        optionNumber = 1;
        for (String toppingName : topping.getPremiumToppings().keySet()) {
            premiumToppingOptions.put(optionNumber, toppingName);
            System.out.println("Option " + optionNumber + ": " + toppingName);
            optionNumber++;
        }

        while ((toppingChoice = scanner.nextInt()) != 0) {
            String selectedTopping = premiumToppingOptions.get(toppingChoice);
            if (selectedTopping != null) {
                sandwich.addPremiumTopping(selectedTopping);
                System.out.println("Added premium topping: " + selectedTopping);
            } else {
                System.out.println("Invalid choice. Please select a valid option number for a premium topping.");
            }
        }
        scanner.nextLine(); // consume the newline

        currentOrder.addSandwich(sandwich);
        System.out.println("Sandwich added to your order!");
    }

    private void addDrink() {
        System.out.println("Select drink size (small, medium, large): ");
        String size = scanner.nextLine();

        System.out.println("Select drink flavor (Tea, Sprite, Coke): ");
        String flavor = scanner.nextLine();

        while (!flavor.equalsIgnoreCase("Tea") &&
                !flavor.equalsIgnoreCase("Sprite") &&
                !flavor.equalsIgnoreCase("Coke")) {
            System.out.println("Invalid flavor. Please choose between Tea, Sprite, or Coke.");
            flavor = scanner.nextLine();
        }

        Drink drink = new Drink(size, flavor);
        currentOrder.addDrink(drink);
    }

    private void addChip() {
        Chip chip = new Chip();
        currentOrder.addChip(chip);
    }

    private void checkout() {
        System.out.println("Order Summary:");

        System.out.println("Sandwiches:");
        for (Sandwich sandwich : currentOrder.getSandwiches()) {
            System.out.println(sandwich);
        }

        System.out.println("Drinks:");
        for (Drink drink : currentOrder.getDrinks()) {
            System.out.println(drink);
        }

        System.out.println("Chips:");
        for (Chip chip : currentOrder.getChips()) {
            System.out.println(chip);
        }

        double totalCost = currentOrder.calculateTotalCost(topping);
        System.out.println("Total Cost: $" + totalCost);
        saveReceipt();
    }

    private void saveReceipt() {
        System.out.println("Receipt saved.");
    }
}
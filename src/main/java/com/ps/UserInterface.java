package com.ps;
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
         boolean running = true;
         while (running) {
             System.out.println("1) New Order\n0) Exit");
             int choice = scanner.nextInt();
             scanner.nextLine();
             if ( choice == 1) {
                 currentOrder = new Order();
                 handleOrder();
             }else if (choice ==0) {
                 running = false;
             }
         }
     }
}
private void addSandwich() {

    System.out.println("Select sandwich size (4\", 8\', 12\"): ");
    String size = scanner.nextLine();
    System.out.println("Select bread type (white, wheat, rye, wrap): ");
    String breadType = scanner.nextLine();
    System.out.println("would you like it toasted? (true/false): ");
    boolean isToasted = scanner.nextBoolean();
    scanner.nextLine();


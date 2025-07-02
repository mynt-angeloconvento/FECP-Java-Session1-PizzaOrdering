package org.example;

import java.util.*;

public class Main {
    public static void addOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, String pizzaType,
            int quantity) {
        if (quantity <= 0) {
            System.out.println("Invalid quantity. Please enter a positive number.");
            return;
        }
        pizzas.add(pizzaType);
        quantities.add(quantity);
    }

    public static void updateOrder(ArrayList<Integer> quantities, int index, int newQuantity) {
        if (index < 0 || index >= quantities.size()) {
            System.out.println("Invalid order number.");
            return;
        }
        if (newQuantity <= 0) {
            System.out.println("Invalid quantity. Please enter a positive number.");
            return;
        }
        quantities.set(index, newQuantity);
    }

    public static void removeOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, int index) {
        if (index < 0 || index >= pizzas.size()) {
            System.out.println("Invalid order number.");
            return;
        }
        pizzas.remove(index);
        quantities.remove(index);
    }

    public static void printOrders(ArrayList<String> pizzas, ArrayList<Integer> quantities) {
        if (pizzas.isEmpty()) {
            System.out.println("No orders found.");
            return;
        }
        System.out.println("--- Current Orders ---");
        for (int i = 0; i < pizzas.size(); i++) {
            System.out.println((i + 1) + ". " + pizzas.get(i) + " x " + quantities.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Add Order");
        System.out.println("2. Update Order");
        System.out.println("3. Remove Order");
        System.out.println("4. View Orders");
        System.out.println("5. Exit");

        ArrayList<String> pizzas = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();

        while (true) {
            System.out.println();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Pizza type: ");
                    scanner.nextLine();
                    String pizzaType = scanner.nextLine();
                    System.out.print("Quantity: ");
                    int quantity = scanner.nextInt();
                    addOrder(pizzas, quantities, pizzaType, quantity);
                    break;
                case 2:
                    System.out.print("Order number to update: ");
                    int indexToUpdate = scanner.nextInt();
                    System.out.print("New quantity: ");
                    int newQuantity = scanner.nextInt();
                    updateOrder(quantities, indexToUpdate - 1, newQuantity);
                    break;
                case 3:
                    System.out.print("Order number to remove: ");
                    int indexToRemove = scanner.nextInt();
                    removeOrder(pizzas, quantities, indexToRemove - 1);
                    break;
                case 4:
                    printOrders(pizzas, quantities);
                    break;
                case 5:
                    System.out.println("--- Thank you! ---");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

    }
}
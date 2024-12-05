package org.designPatterns.Decorator;

/*
Problem Statement:
The goal is to design a system for ordering pizzas where customers can choose a base pizza and customize it by adding various toppings.
Each topping has an additional cost, and the total price of the pizza depends on the selected base and the toppings applied.

Solution:
We use the **Decorator Design Pattern** to solve this problem:
- The `BasePizza` abstract class represents the base pizza type.
- Concrete implementations of `BasePizza` (e.g., `FarmHouse`, `Margherita`, `VeggieDelight`) provide the base cost of different pizzas.
- The `ToppingsDecorator` abstract class allows for dynamically adding toppings to pizzas.
- Concrete decorators (`ExtraCheese`, `MushRoom`) extend `ToppingsDecorator` and modify the cost of the pizza by adding their specific topping's cost.

This design promotes flexibility and allows for easy addition of new toppings without altering existing code.
*/

public class DecoratorStrategyPattern {

    // Abstract class representing a base pizza
    public abstract static class BasePizza {
        public abstract int cost(); // Method to calculate the cost
    }

    // Abstract class for toppings (decorator)
    public abstract static class ToppingsDecorator extends BasePizza {}

    // Concrete base pizza implementations
    public static class FarmHouse extends BasePizza {
        @Override
        public int cost() {
            return 100; // Cost of FarmHouse pizza
        }
    }

    public static class Margherita extends BasePizza {
        @Override
        public int cost() {
            return 50; // Cost of Margherita pizza
        }
    }

    public static class VeggieDelight extends BasePizza {
        @Override
        public int cost() {
            return 120; // Cost of Veggie Delight pizza
        }
    }

    // Concrete decorator for Extra Cheese topping
    public static class ExtraCheese extends ToppingsDecorator {
        BasePizza basePizza; // Composition: wraps a BasePizza

        public ExtraCheese(BasePizza basePizza) {
            this.basePizza = basePizza; // Inject the base pizza
        }

        @Override
        public int cost() {
            return basePizza.cost() + 10; // Add the cost of extra cheese
        }
    }

    // Concrete decorator for Mushroom topping
    public static class MushRoom extends ToppingsDecorator {
        BasePizza basePizza; // Composition: wraps a BasePizza

        public MushRoom(BasePizza basePizza) {
            this.basePizza = basePizza; // Inject the base pizza
        }

        @Override
        public int cost() {
            return basePizza.cost() + 20; // Add the cost of mushrooms
        }
    }

    public static void main(String[] args) {
        /*
        Example:
        - Base pizza: Margherita (cost = 50)
        - Toppings: MushRoom (cost = 20), ExtraCheese (cost = 10)
        Total cost = 50 (Margherita) + 20 (MushRoom) + 10 (ExtraCheese) = 80
        */

        // Create a pizza with Margherita base and two toppings: MushRoom and ExtraCheese
        BasePizza pizza = new ExtraCheese(new MushRoom(new Margherita()));

        // Calculate and print the total cost
        System.out.println("Total Pizza Cost: " + pizza.cost()); // Expected Output: 80
    }
}

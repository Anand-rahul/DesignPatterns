package org.designPatterns.Factory;

public class FactoryPattern {

    /*
    Problem Statement:
    The goal is to create a flexible and reusable system for instantiating objects of different shapes (e.g., Circle, Rectangle, Square)
    without exposing the instantiation logic to the client. The client should be able to request a specific shape by its name
    and get an appropriate object instance.

    Solution:
    Use the **Factory Design Pattern**:
    - Define a `Shape` interface that provides a common contract for all shape types.
    - Implement concrete classes (e.g., `Circle`, `Rectangle`, `Square`) that implement the `Shape` interface.
    - Create a `ShapeFactory` class responsible for creating instances of shapes based on a provided input string.

    This design centralizes object creation, promotes loose coupling, and adheres to the **Open-Closed Principle** (OCP),
    as we can add new shapes without modifying the client code.
    */

    // Interface representing a generic shape
    public static interface Shape {
        void draw(); // Abstract method to draw the shape
    }

    // Concrete implementation of a Rectangle
    public static class Rectangle implements Shape {
        @Override
        public void draw() {
            System.out.println("Rectangle"); // Rectangle-specific behavior
        }
    }

    // Concrete implementation of a Square
    public static class Square implements Shape {
        @Override
        public void draw() {
            System.out.println("Square"); // Square-specific behavior
        }
    }

    // Concrete implementation of a Circle
    public static class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("Circle"); // Circle-specific behavior
        }
    }

    // Factory class for creating Shape objects
    public static class ShapeFactory {

        // Method to return a Shape instance based on input
        Shape getShape(String input) {
            return switch (input) {
                case "Circle" -> new Circle();
                case "Rectangle" -> new Rectangle();
                case "Square" -> new Square();
                default -> null; // Returns null if input does not match
            };
        }
    }

    // Main method to demonstrate the Factory Pattern
    public static void main(String[] args) {
        // Create a ShapeFactory instance
        ShapeFactory shapeFactory = new ShapeFactory();

        // Request a Circle from the factory and call its draw method
        Shape shape = shapeFactory.getShape("Circle");
        if (shape != null) {
            shape.draw(); // Output: Circle
        }

        // Request a Rectangle from the factory and call its draw method
        Shape shape1 = shapeFactory.getShape("Rectangle");
        if (shape1 != null) {
            shape1.draw(); // Output: Rectangle
        }

        // Attempt to request an unknown shape
        Shape unknownShape = shapeFactory.getShape("Triangle");
        if (unknownShape == null) {
            System.out.println("Invalid shape type!"); // Output for invalid input
        }
    }
}

package org.designPatterns.Factory;

public class AbstractFactoryPattern {

    /*
    Problem Statement:
    The goal is to provide a flexible system for creating families of related objects (e.g., Shapes and Colors)
    without specifying their concrete classes in the client code. For instance, a client should be able to
    create different types of shapes (Circle, Rectangle, Square) and colors (Red, Green, Blue) using abstract factories.

    Solution:
    Use the **Abstract Factory Design Pattern**:
    - Define abstract factories for creating families of objects (e.g., ShapeFactory for Shapes, ColorFactory for Colors).
    - Provide concrete implementations of these factories.
    - Use a FactoryProducer to return the appropriate factory based on the input.

    This design promotes loose coupling, flexibility, and adherence to the **Open-Closed Principle**.
    */

    // Common interface for all shapes
    public interface Shape {
        void draw(); // Abstract method to draw the shape
    }

    // Concrete implementations of Shape
    public static class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing a Circle");
        }
    }

    public static class Rectangle implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing a Rectangle");
        }
    }

    public static class Square implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing a Square");
        }
    }

    // Common interface for all colors
    public interface Color {
        void fill(); // Abstract method to fill with a color
    }

    // Concrete implementations of Color
    public static class Red implements Color {
        @Override
        public void fill() {
            System.out.println("Filling with Red color");
        }
    }

    public static class Green implements Color {
        @Override
        public void fill() {
            System.out.println("Filling with Green color");
        }
    }

    public static class Blue implements Color {
        @Override
        public void fill() {
            System.out.println("Filling with Blue color");
        }
    }

    // Abstract factory for creating shapes
    public static abstract class AbstractFactory {
        abstract Shape getShape(String shapeType);
        abstract Color getColor(String colorType);
    }

    // Factory for creating Shape objects
    public static class ShapeFactory extends AbstractFactory {
        @Override
        Shape getShape(String shapeType) {
            return switch (shapeType) {
                case "Circle" -> new Circle();
                case "Rectangle" -> new Rectangle();
                case "Square" -> new Square();
                default -> null;
            };
        }

        @Override
        Color getColor(String colorType) {
            return null; // Not responsible for creating colors
        }
    }

    // Factory for creating Color objects
    public static class ColorFactory extends AbstractFactory {
        @Override
        Shape getShape(String shapeType) {
            return null; // Not responsible for creating shapes
        }

        @Override
        Color getColor(String colorType) {
            return switch (colorType) {
                case "Red" -> new Red();
                case "Green" -> new Green();
                case "Blue" -> new Blue();
                default -> null;
            };
        }
    }

    // Factory producer to get the appropriate factory
    public static class FactoryProducer {
        public static AbstractFactory getFactory(String factoryType) {
            return switch (factoryType) {
                case "Shape" -> new ShapeFactory();
                case "Color" -> new ColorFactory();
                default -> null;
            };
        }
    }

    // Main method to demonstrate Abstract Factory Pattern
    public static void main(String[] args) {
        // Get a ShapeFactory
        AbstractFactory shapeFactory = FactoryProducer.getFactory("Shape");

        // Create and use Shape objects
        Shape circle = shapeFactory.getShape("Circle");
        circle.draw(); // Output: Drawing a Circle

        Shape rectangle = shapeFactory.getShape("Rectangle");
        rectangle.draw(); // Output: Drawing a Rectangle

        // Get a ColorFactory
        AbstractFactory colorFactory = FactoryProducer.getFactory("Color");

        // Create and use Color objects
        Color red = colorFactory.getColor("Red");
        red.fill(); // Output: Filling with Red color

        Color blue = colorFactory.getColor("Blue");
        blue.fill(); // Output: Filling with Blue color
    }
}


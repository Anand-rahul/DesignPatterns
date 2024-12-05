package org.designPatterns.Strategy;

public class StrategyDesignPatternViolated {

    static class Vehicle {
        public void drive() {
            System.out.println("drive invoked from Base Class");
        }
    }

    static class SportsVehicle extends Vehicle {
        @Override
        public void drive() {
            // Each subclass is overriding the drive method with its own implementation
            // instead of delegating to a separate strategy. This leads to code duplication
            // and violates the Strategy Design Pattern principles.
            System.out.println("drive invoked from Sports Vehicle Class");
        }

        public void loc() {
            System.out.println("Sports Vehicle Class");
        }
    }

    static class PassengerVehicle extends Vehicle {
        @Override
        public void drive() {
            // By overriding the drive method, the flexibility to change behavior
            // dynamically at runtime is lost, as the implementation is tightly coupled
            // to the subclass.
            System.out.println("drive invoked from Passenger Vehicle Class");
        }

        public void loc() {
            System.out.println("Passenger Vehicle Class");
        }
    }

    static class TowingVehicle extends Vehicle {
        public void loc() {
            System.out.println("Towing Vehicle Class");
        }
    }

    public static void main(String[] args) {
        SportsVehicle sp = new SportsVehicle();
        sp.drive();  // Specific implementation of drive is called
        sp.loc();

        TowingVehicle tw = new TowingVehicle();
        tw.drive();  // Base class implementation of drive is called
        tw.loc();

        Vehicle v = new Vehicle();
        v.drive();  // Base class implementation of drive is called
    }

    /*
    Explanation of Violation:
    1. Code Duplication:
       - The `drive` method is implemented differently in each subclass (`SportsVehicle`, `PassengerVehicle`).
       - This duplication violates the DRY (Don't Repeat Yourself) principle.

    2. Lack of Strategy:
       - Instead of delegating the `drive` behavior to separate strategy classes, it is directly implemented in the subclasses.
       - The Strategy Design Pattern encourages encapsulating varying behavior (like driving styles) into strategy classes to make them interchangeable.

    3. Tight Coupling:
       - The drive behavior is tightly coupled to the subclasses, which makes it harder to change or extend the functionality at runtime.

    4. Reduced Flexibility:
       - The design does not allow dynamic assignment or modification of behavior, which is a core advantage of the Strategy Design Pattern.

    To resolve this:
    - Define a `DriveStrategy` interface with a method `drive()`.
    - Implement different driving strategies (e.g., `SportsDriveStrategy`, `PassengerDriveStrategy`).
    - Use composition in the `Vehicle` class to delegate the `drive` behavior to a `DriveStrategy` instance.
    */
}

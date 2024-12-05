package org.designPatterns.Strategy;

public class StrategyDesignPattern {
    // Base Strategy Class
    static class DriveStrategy {
        void drive() {
            // Default drive behavior
            System.out.println("Invoked Drive Method from DriveStrategy Class");
        }
    }

    // Concrete Strategy for Normal Driving
    static class NormalDrive extends DriveStrategy {
        @Override
        void drive() {
            // Custom behavior for normal driving
            System.out.println("Invoked Drive Method from NormalDrive Class");
        }
    }

    // Concrete Strategy for Sports Driving
    static class SportsDrive extends DriveStrategy {
        @Override
        void drive() {
            // Custom behavior for sports driving
            System.out.println("Invoked Drive Method from SportsDrive Class");
        }
    }

    // Context Class
    static class Vehicle {
        // Delegates the driving behavior to the strategy
        DriveStrategy driveStrategy = new DriveStrategy();

        Vehicle(DriveStrategy driveStrategy) {
            // Composition: Accepts a strategy at runtime
            this.driveStrategy = driveStrategy;
        }

        void drive() {
            // Delegates the drive call to the strategy
            driveStrategy.drive();
        }
    }

    // Specific Vehicle with Sports Driving Strategy
    static class OffRoadVehicle extends Vehicle {
        OffRoadVehicle(SportsDrive driveStrategy) {
            // Injecting SportsDrive strategy
            super(driveStrategy);
        }

        @Override
        void drive() {
            // Delegating to the strategy
            super.drive();
        }
    }

    // Specific Vehicle with Normal Driving Strategy
    static class PassengerVehicle extends Vehicle {
        PassengerVehicle(NormalDrive normalDrive) {
            // Injecting NormalDrive strategy
            super(normalDrive);
        }

        @Override
        void drive() {
            // Delegating to the strategy
            super.drive();
        }
    }

    public static void main(String[] args) {
        // Instantiating strategies
        SportsDrive sportsDrive = new SportsDrive();
        NormalDrive normalDrive = new NormalDrive();

        // Injecting strategies into vehicles
        OffRoadVehicle offRoadVehicle = new OffRoadVehicle(sportsDrive);
        PassengerVehicle passengerVehicle = new PassengerVehicle(normalDrive);

        // Vehicles use their respective strategies
        offRoadVehicle.drive();  // Outputs: Invoked Drive Method from SportsDrive Class
        passengerVehicle.drive();  // Outputs: Invoked Drive Method from NormalDrive Class
    }

    /*
    Explanation of Adherence to the Strategy Design Pattern:

    1. Behavior Encapsulation:
       - The `DriveStrategy` defines the `drive()` behavior as a strategy interface.
       - Concrete strategies (`NormalDrive`, `SportsDrive`) provide specific implementations of the behavior.

    2. Delegation:
       - The `Vehicle` class delegates the `drive` behavior to a `DriveStrategy` instance, adhering to the open/closed principle.
       - New driving behaviors can be introduced without modifying the `Vehicle` class.

    3. Flexibility:
       - The `driveStrategy` instance can be dynamically changed at runtime to switch the driving behavior.

    4. Reusability:
       - The `NormalDrive` and `SportsDrive` classes can be reused across different vehicles, reducing code duplication.

    Key Benefits of This Design:
    - Adheres to the Single Responsibility Principle (SRP): Vehicle classes are only responsible for delegating driving behavior.
    - Promotes composition over inheritance: Drive behaviors are composed and not hard-coded into subclasses.
    */
}

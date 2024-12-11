package org.designPatterns.Projects.Elevator.Controller;



import org.designPatterns.Projects.Elevator.Components.ElevatorCar;

import java.util.ArrayList;
import java.util.List;

public class ElevatorCreator {
    public static List<ElevatorController> elevatorControllerList = new ArrayList<>();

    static {
        // Initialize multiple elevators and their controllers
        ElevatorCar elevatorCar1 = new ElevatorCar();
        elevatorCar1.id = 1;
        ElevatorController controller1 = new ElevatorController(elevatorCar1);

//        ElevatorCar elevatorCar2 = new ElevatorCar();
//        elevatorCar2.id = 2;
//        ElevatorController controller2 = new ElevatorController(elevatorCar2);

        elevatorControllerList.add(controller1);
//        elevatorControllerList.add(controller2);
    }
}

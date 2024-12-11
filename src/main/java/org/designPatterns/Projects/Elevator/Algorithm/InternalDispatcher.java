package org.designPatterns.Projects.Elevator.Algorithm;


import org.designPatterns.Projects.Elevator.State.Direction;
import org.designPatterns.Projects.Elevator.Components.ElevatorCar;
import org.designPatterns.Projects.Elevator.Controller.ElevatorController;
import org.designPatterns.Projects.Elevator.Controller.ElevatorCreator;

import java.util.List;

public class InternalDispatcher {
    List<ElevatorController> elevatorControllerList = ElevatorCreator.elevatorControllerList;

    public void submitInternalRequest(int floor, ElevatorCar elevatorCar) {
        for (ElevatorController controller : elevatorControllerList) {
            if (controller.elevatorCar == elevatorCar) {
                controller.submitInternalRequest(floor, elevatorCar.elevatorDirection);
                break;
            }
        }
    }
}
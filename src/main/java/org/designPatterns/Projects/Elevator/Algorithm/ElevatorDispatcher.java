package org.designPatterns.Projects.Elevator.Algorithm;


import org.designPatterns.Projects.Elevator.Controller.ElevatorController;
import org.designPatterns.Projects.Elevator.State.Direction;

public class ElevatorDispatcher extends ExternalDispatcher {
    @Override
    public void allocateElevator(int floor, Direction direction) {
        for (ElevatorController elevatorController : elevatorControllerList) {
            int elevatorID = elevatorController.elevatorCar.id;
            elevatorController.submitExternalRequest(floor, direction);
            System.out.println("Allocated elevator " + elevatorID + " to floor " + floor + " (" + direction + ")");
        }
    }
}

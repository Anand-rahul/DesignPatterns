package org.designPatterns.Projects.Elevator.Algorithm;



import org.designPatterns.Projects.Elevator.Controller.ElevatorController;
import org.designPatterns.Projects.Elevator.Controller.ElevatorCreator;
import org.designPatterns.Projects.Elevator.State.Direction;

import java.util.List;

public abstract class ExternalDispatcher {
    List<ElevatorController> elevatorControllerList = ElevatorCreator.elevatorControllerList;

    public abstract void allocateElevator(int floor, Direction direction);

    public void submitExternalRequest(int floor, Direction direction) {
        // Forward the request to the allocation strategy
        allocateElevator(floor, direction);
    }
}

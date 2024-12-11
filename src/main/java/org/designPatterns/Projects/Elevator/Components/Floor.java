package org.designPatterns.Projects.Elevator.Components;


import org.designPatterns.Projects.Elevator.Algorithm.ElevatorDispatcher;
import org.designPatterns.Projects.Elevator.Algorithm.ExternalDispatcher;
import org.designPatterns.Projects.Elevator.State.Direction;

public class Floor {
    public int floorNumber;
    public ExternalDispatcher externalDispatcher;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        externalDispatcher = new ElevatorDispatcher();
    }
    public void pressButton(Direction direction) {
        System.out.println("Floor " + floorNumber + " button pressed for direction: " + direction);
        externalDispatcher.submitExternalRequest(floorNumber, direction);
    }
}


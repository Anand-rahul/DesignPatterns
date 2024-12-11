package org.designPatterns.Projects.Elevator.Components;


import org.designPatterns.Projects.Elevator.State.Direction;

public class ElevatorDisplay {
    public int floor;
    public Direction direction;

    public void setDisplay(int floor, Direction direction) {
        // Update display with floor and direction
        this.floor = floor;
        this.direction = direction;
    }

    public void showDisplay() {
        // Print the current display state
        System.out.println("Current Floor: " + (floor) +" Going in Direction: " + direction);
    }
}

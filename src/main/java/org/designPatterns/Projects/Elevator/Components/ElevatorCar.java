package org.designPatterns.Projects.Elevator.Components;

import org.designPatterns.Projects.Elevator.State.Direction;
import org.designPatterns.Projects.Elevator.State.ElevatorState;

public class ElevatorCar {
    public int id;
    public ElevatorDisplay display;
    public InternalButtons internalButtons;
    public ElevatorState elevatorState;
    public int currentFloor;
    public Direction elevatorDirection;
    public ElevatorDoor elevatorDoor;

    public ElevatorCar() {
        display = new ElevatorDisplay();
        internalButtons = new InternalButtons();
        elevatorState = ElevatorState.IDLE;
        currentFloor = 0;
        elevatorDirection = Direction.UP;
        elevatorDoor = new ElevatorDoor();
    }

    public void showDisplay() {
        display.showDisplay();
    }

    public void pressButton(int destination) {
        System.out.println("Internal button pressed for floor: " + destination);
        internalButtons.pressButton(destination, this);
    }

    public void setDisplay() {
        this.display.setDisplay(currentFloor, elevatorDirection);
    }

    public void moveElevator(Direction dir, int destinationFloor) {
        System.out.println("Elevator moving from floor: " + currentFloor + " to floor: " + destinationFloor);

        if (currentFloor == destinationFloor) {
            System.out.println("Elevator already at the destination floor.");
            return;
        }

        if (currentFloor < destinationFloor) {
            elevatorDirection = Direction.UP;
            for (int i = currentFloor + 1; i <= destinationFloor; i++) {
                currentFloor = i;
                setDisplay();
                showDisplay();
            }
        } else {
            elevatorDirection = Direction.DOWN;
            for (int i = currentFloor - 1; i >= destinationFloor; i--) {
                currentFloor = i;
                setDisplay();
                showDisplay();
            }
        }
    }
}

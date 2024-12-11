package org.designPatterns.Projects.Elevator;


import org.designPatterns.Projects.Elevator.Components.Floor;
import org.designPatterns.Projects.Elevator.Controller.ElevatorController;
import org.designPatterns.Projects.Elevator.Controller.ElevatorCreator;
import org.designPatterns.Projects.Elevator.State.Direction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Floor> floorList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            floorList.add(new Floor(i));
        }

        ElevatorController controller = ElevatorCreator.elevatorControllerList.get(0);
        controller.elevatorCar.currentFloor = 2;
        controller.elevatorCar.elevatorDirection = Direction.UP;

        // Simulating multiple external requests
        floorList.get(0).pressButton(Direction.UP);  // Floor 1 UP
        floorList.get(3).pressButton(Direction.DOWN);  // Floor 4 DOWN
        floorList.get(5).pressButton(Direction.UP);  // Floor 6 UP
        floorList.get(8).pressButton(Direction.DOWN);  // Floor 9 DOWN

        // Simulating multiple internal requests
        controller.elevatorCar.pressButton(5);  // Internal request to Floor 5
        controller.elevatorCar.pressButton(7);  // Internal request to Floor 7
        controller.elevatorCar.pressButton(2);  // Internal request to Floor 2
        controller.elevatorCar.pressButton(8);  // Internal request to Floor 8

        new Thread(controller::controlElevator).start();
    }
}
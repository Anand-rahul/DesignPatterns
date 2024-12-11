package org.designPatterns.Projects.Elevator.Components;



import org.designPatterns.Projects.Elevator.Algorithm.InternalDispatcher;

import java.util.ArrayList;
import java.util.List;

public class InternalButtons {
    InternalDispatcher dispatcher = new InternalDispatcher();
    List<Integer> availableButtons;

    public InternalButtons() {
        availableButtons = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            availableButtons.add(i);
        }
    }

    public void pressButton(int destination, ElevatorCar elevatorCar) {
        if (availableButtons.contains(destination)) {
            dispatcher.submitInternalRequest(destination, elevatorCar);
        } else {
            System.out.println("Invalid floor selection: " + destination);
        }
    }
}

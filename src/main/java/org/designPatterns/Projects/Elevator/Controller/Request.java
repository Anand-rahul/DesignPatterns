package org.designPatterns.Projects.Elevator.Controller;


import org.designPatterns.Projects.Elevator.State.Direction;

public class Request {
    int floor;
    Direction direction;

    public Request(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
        System.out.println("Request created for floor: " + floor + " direction: " + direction);
    }
}

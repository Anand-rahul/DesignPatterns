package org.designPatterns.Projects.Elevator.Controller;


import org.designPatterns.Projects.Elevator.Components.ElevatorCar;
import org.designPatterns.Projects.Elevator.State.Direction;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ElevatorController {
    public PriorityQueue<Integer> upMinPQ;
    public PriorityQueue<Integer> downMaxPQ;
    public Queue<Request> stagingQueue;
    public ElevatorCar elevatorCar;

    public ElevatorController(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
        upMinPQ = new PriorityQueue<>();
        downMaxPQ = new PriorityQueue<>((a, b) -> b - a);
        stagingQueue = new LinkedList<>();
        System.out.println("ElevatorController initialized for elevator: " + elevatorCar.id);
    }

    public void submitInternalRequest(int floor, Direction direction) {
        System.out.println("Internal request submitted for floor: " + floor);
        Request newRequest = new Request(floor, direction);
        addToQueue(newRequest);
    }

    public void submitExternalRequest(int floor, Direction direction) {
        Request newRequest = new Request(floor, direction);
        if ((direction == Direction.UP && floor < elevatorCar.currentFloor && elevatorCar.elevatorDirection == Direction.UP) ||
                (direction == Direction.DOWN && floor > elevatorCar.currentFloor && elevatorCar.elevatorDirection == Direction.DOWN)) {
            System.out.println("Request staged for floor: " + floor + " direction: " + direction);
            stagingQueue.offer(newRequest);
        } else {
            addToQueue(newRequest);
        }
    }

    private void addToQueue(Request request) {
        if (request.direction == Direction.UP) {
            if (!upMinPQ.contains(request.floor)) {
                upMinPQ.offer(request.floor);
                System.out.println("Request added to upMinPQ: Floor " + request.floor);
            }
        } else {
            if (!downMaxPQ.contains(request.floor)) {
                downMaxPQ.offer(request.floor);
                System.out.println("Request added to downMaxPQ: Floor " + request.floor);
            }
        }
    }

    public void processStagedRequests() {
        System.out.println("Processing staged requests...");
        while (!stagingQueue.isEmpty()) {
            Request request = stagingQueue.poll();
            addToQueue(request);
        }
    }

    public void controlElevator() {
        while (!upMinPQ.isEmpty() || !downMaxPQ.isEmpty() || !stagingQueue.isEmpty()) {
            if (upMinPQ.isEmpty() && downMaxPQ.isEmpty()) {
                processStagedRequests();
            }

            if (!upMinPQ.isEmpty()) {
                int nextFloor = upMinPQ.poll();
                elevatorCar.moveElevator(Direction.UP, nextFloor);
            } else if (!downMaxPQ.isEmpty()) {
                int nextFloor = downMaxPQ.poll();
                elevatorCar.moveElevator(Direction.DOWN, nextFloor);
            }
        }
        System.out.println("All requests processed. Elevator is idle.");
    }
}


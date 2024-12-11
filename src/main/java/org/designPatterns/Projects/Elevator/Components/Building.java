package org.designPatterns.Projects.Elevator.Components;

import java.util.List;

public class Building {
    List<Floor> floorList;

    public Building(List<Floor> floors) {
        this.floorList = floors;
    }

    public void addFloors(Floor newFloor) {
        floorList.add(newFloor);
        System.out.println("Floor added: " + newFloor.floorNumber);
    }

    public void removeFloors(Floor removeFloor) {
        floorList.remove(removeFloor);
        System.out.println("Floor removed: " + removeFloor.floorNumber);
    }

    List<Floor> getAllFloorList() {
        return floorList;
    }
}

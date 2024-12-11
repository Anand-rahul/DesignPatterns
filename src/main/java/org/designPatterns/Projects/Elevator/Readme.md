
# Elevator System: Problem Statement and Solution Summary

## Problem Statement
The task was to design a simplified elevator system capable of handling multiple internal and external requests. The elevator should prioritize internal requests over external requests, operate using a well-defined set of states and directions, and manage floor requests efficiently while preventing collisions and ensuring optimal movement.

## Solution Overview
The implemented elevator system simulates an elevator's functionality using an object-oriented design. The system supports multiple requests from both internal and external dispatchers. Requests are stored in priority queues, with internal requests receiving higher priority.

---

## Key Objects and Their Responsibilities

1. **Main Class:**
    - Initializes floors and the elevator system.
    - Simulates multiple requests from external and internal dispatchers.
    - Starts the elevator control thread.

2. **ElevatorCar:**
    - Represents the elevator's state.
    - Handles movement logic and display updates.
    - Manages requests via `pressButton()`.

3. **ElevatorController:**
    - Manages the elevator's state, requests, and movement.
    - Contains two priority queues for `upMinPQ` and `downMaxPQ` requests.
    - Processes both internal and external requests with correct priority.

4. **InternalButtons:**
    - Manages the list of buttons available within the elevator.
    - Forwards internal button requests to the internal dispatcher.

5. **InternalDispatcher:**
    - Routes internal requests to the appropriate elevator controller.
    - Finds the correct controller for the elevator issuing the request.

6. **Floor:**
    - Represents a floor with external buttons for requesting the elevator.
    - Sends requests to the external dispatcher when buttons are pressed.

7. **ElevatorDisplay:**
    - Displays the current floor and movement direction of the elevator.

8. **Request Class:**
    - Encapsulates floor requests and associated directions.

---

## Methods Overview

- **`pressButton(int destination)`**: Triggers internal floor requests.
- **`moveElevator(Direction dir, int destinationFloor)`**: Manages floor-by-floor movement.
- **`submitInternalRequest(int floor, Direction direction)`**: Handles internal requests.
- **`submitExternalRequest(int floor, Direction direction)`**: Manages requests from floors.
- **`controlElevator()`**: Manages continuous processing of queued requests.
- **`processStagedRequests()`**: Manages deferred requests for later processing.

---

## Design Considerations
- **Concurrency:** Future plans involve adding multithreading and REST APIs.
- **Data Structures:** Priority queues ensure optimal floor servicing.
- **Expandability:** Easily extendable for additional features like multiple elevators or optimized dispatching.

This design ensures that the elevator system efficiently handles requests with minimal collisions while following an object-oriented structure that can scale with future enhancements.

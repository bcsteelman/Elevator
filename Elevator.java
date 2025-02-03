import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Elevator {
    //Tracks the current floor of the elevator
    private int currentFloor = 0;

    //Tracks the direction the elevator will travel to the floors
    //True is up, false is down
    private boolean direction;

    //Array used to store the floor inputs
    private List<Integer> inputs;

    //Constructor
    public Elevator(int numFloors){
        this.currentFloor = 1;
        this.direction = true;
        this.inputs = new ArrayList<>();
    }

    //No destructor because Java handles it

    //Function to add a floor input into the queue
    public void InputFloor(int floor){
        inputs.add(floor);
    }

    //Function to get the current floor of the elevator
    public int getFloor(){
        return currentFloor;
    }

    //Function that moves the elevator to different floors
    public void Move()
    {
        int newFloor = 0;
        int n = inputs.size();

        //Determines if the elevator will go up or down
        //If the first position in the array is less than the current floor, the elevator will travel down first
        //Vice versa if the first position is greater than the current floor
        if (inputs.get(0) < currentFloor){
            direction = false;
        } else{
            direction = true;
        }

        //If-else to determine if the array of floors needs to be sorted biggest to smallest
        if (direction == true){
            Collections.sort(inputs);
        } else {
            Collections.sort(inputs, Collections.reverseOrder());
        }

        //Gets the floor from the first position in the array, then deletes first position
        //Moves elevator to the new floor
        //Prints the current floor
        while (!inputs.isEmpty()){
            newFloor = inputs.get(0);
            inputs.remove(0);
            currentFloor = newFloor;
            System.out.println("Now on floor " + currentFloor);
        }
    }
}

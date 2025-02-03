import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Elevator elevator = new Elevator(20);
        Scanner s = new Scanner(System.in);
        int temp = 0;
        int floorInput = 0;
        int currentFloor = 0;
        String quit = null;

        //Boolean to keep track if the user has entered a floor,such as the user pressing 0 immediately,
        //simulating leaving an elevator without changing floors
        boolean enteredFloor = false;

        //Prompting user to enter or "exit" elevator
        System.out.print("Enter 'quit' to stop or press Enter to continue: ");
        quit = s.nextLine();

        //While loop that keeps looping until user enters "quit"
        while (!quit.equalsIgnoreCase("quit")) {

            //Boolean set to false until the user entes a floor to move to
            enteredFloor = false;

            //Do while loop that keeps prompting user to enter floors
            //Breaks when the user enters 0

             do {
                System.out.print("Enter floor: ");

                //Try catch block to only allow integers greater than 0
                //Prompts user to enter again if it is a valid entry
                try {

                    //Checks if the scanner has an integer
                    if (s.hasNextInt()) {
                        temp = s.nextInt();
                        s.nextLine();

                        //Checks if entry is less than 0
                        if (temp < 0){
                            throw new IllegalArgumentException("Invalid Entry. Negative Number.");
                        }

                        //Checks if the user has not entered a floor, and has entered 0
                        if (temp == 0 && !enteredFloor) {
                            break;
                        }

                        //If user entered a floor to move to, the entry is added to the array
                        //Once a floor to move to is entered, the boolean variable is set to true,
                        //indicating the elevator will move to a different floor
                        if (temp != 0) {
                            floorInput = temp;
                            elevator.InputFloor(floorInput);
                            currentFloor = floorInput;
                            enteredFloor = true;
                        }
                    }
                    else{
                        throw new IllegalArgumentException("Invalid Entry. Not a number. ");
                    }

                }
                //Catches thrown exceptions, prompts and gets new entry from the user
                catch (IllegalArgumentException e) {
                    System.out.print(e.getMessage());
                    System.out.print("Enter floor: ");
                    s.nextLine();
                    s.hasNextInt();
                 }

                if (temp == 0) {
                    break;
                }

            }while (floorInput != 0);


             //Statement checking if the user has entered a floor
             if (enteredFloor) {
                 elevator.Move();
             }

            System.out.print("Enter 'quit' to stop or press Enter to continue: ");
            quit = s.nextLine();
        }

        System.out.println("Exiting Elevator");
        s.close();
    }
}



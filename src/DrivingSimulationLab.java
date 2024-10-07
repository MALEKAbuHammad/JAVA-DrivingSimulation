import java.util.Scanner;

public class DrivingSimulationLab{
    public static boolean isEngineOn = false;
    public static int speed =0;
    public static String gear = "P";
    public static Scanner keyBoard = new Scanner(System.in);

    public static void startSimulation(){
        boolean displayMenu = true;
        while(displayMenu) {
            displayDashboard();
            int choice = getUserChoice();
            processChoice(choice);
        }
    }

    public static void displayDashboard(){
        System.out.println("------ Car Dashboard ------");
        System.out.println("Speed: " + speed);
        System.out.println("Engine: " + (isEngineOn ? "On" : "Off"));
        System.out.println("Gear: " + gear);
        System.out.println("Menu:");
        System.out.println("1. Turn on/off the engine");
        System.out.println("2. Change gear (P, D, R)");
        System.out.println("3. Accelerate");
        System.out.println("4. Brake");
        System.out.println("5. Exit");
    }

    public static int getUserChoice(){
        System.out.print("Enter your choice: ");
        return keyBoard.nextInt();
    }

    public static void processChoice(int choice){
        switch (choice){
            case 1 :
                toggleEngine();
                break;
            case 2 :
                changeGear();
                break;
            case 3 :
                accelerate();
                break;
            case 4 :
                brake();
                break;
            case 5 :
                exitSimulation();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void toggleEngine(){
        isEngineOn = !isEngineOn;
    }
    public static void changeGear(){
        System.out.print("enter the desired gear (P, D, or R): ");
        gear= keyBoard.next();
    }
    public static void accelerate(){
       if(isEngineOn && !gear.equals("P"))
           speed+=10;
       else
           System.out.println("Cannot apply accelerate while engine is off or car not moving.");
    }
    public static void brake(){
       if(isEngineOn && speed > 0)
           speed-=5;
       else
           System.out.println("Cannot apply braking while engine is off or car not moving");
    }
    public static void exitSimulation(){
        System.out.println("Turning off engine and exiting the car. Goodbye!");
        System.exit(0);
    }

    public static void main(String[] args) {
        startSimulation();
    }
}


import java.text.ParseException;
import java.util.Scanner;

public class Formula1ChampionshipMenu {
    static Scanner scan = new Scanner(System.in);
    static Formula1ChampionshipManager formula1ChampionshipManager = new Formula1ChampionshipManager();
    public static void main(String[] args) {menu();}

    public static void menu() { //opening menu
        System.out.println(
                        "WELCOME TO\n"+
                        "FORMULA 1 RACING CAR CHAMPIONSHIP\n\n"+
                        "Select 1: Create new driver\n" +
                        "Select 2: Delete a driver and the team\n" +
                        "Select 3: Change driver of a team\n" +
                        "Select 4: Display statistics of driver\n" +
                        "Select 5: Display the Formula1 driver table\n" +
                        "Select 6: Add completed race information\n" +
                        "Select 7: Save information\n" +
                        "Select 8: Load information\n" +
                        "Select 9: Access the GUI\n" +
                        "Select 0: Exit program");
        System.out.println(" ");
        System.out.println("Enter your choice: ");
        int choice = scan.nextInt();
        scan.nextLine();
        switch(choice) {
            case 1:
                newDriver();
                break;
            case 2:
                deleteDriver();
                break;
            case 3:
                changeDriver();
                break;
            case 4:
                driverStats();
                break;
            case 5:
                System.out.println(" ");
                formula1ChampionshipManager.championshipDriverTable();
                menu();
                break;
            case 6:
                try {
                    completedRaceDetails();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case 7:
                saveInfo();
                break;
            case 8:
                formula1ChampionshipManager.loadInfo();
                break;
            case 9:
                new Formula1ChampionshipGUI();
                break;
            case 0:
                exit();
                break;
            default:
                System.out.println("Please enter a valid option from the menu!");
                menu();
        }
    }

    private static void newDriver() { //adding a new driver to the championship

        Formula1Driver formula1Driver = new Formula1Driver("","",0,0,0,0,0,0,0,0,0,0,0,0);

        System.out.println("Enter the first name of the driver: ");
        String name = scan.next();
        scan.nextLine();
        System.out.println("Enter the name of the team: ");
        String team = scan.nextLine();
        System.out.println("If any other details are available, select Y, if not, select N: ");
        String other = scan.next();

        Formula1ChampionshipManager formula1ChampionshipManager = new Formula1ChampionshipManager();
        if(other.equalsIgnoreCase("Y")){
            System.out.print("How many first places? ");
            int firstPNo = scan.nextInt();
            System.out.print("How many second places? ");
            int secondPNo = scan.nextInt();
            System.out.print("How many third places? ");
            int thirdPNo = scan.nextInt();
            System.out.print("How many fourth places? ");
            int fourthPNo = scan.nextInt();
            System.out.print("How many fifth places? ");
            int fifthPNo = scan.nextInt();
            System.out.print("How many sixth places? ");
            int sixthPNo = scan.nextInt();
            System.out.print("How many seventh places? ");
            int seventhPNo = scan.nextInt();
            System.out.print("How many eighth places? ");
            int eighthPNo = scan.nextInt();
            System.out.print("How many ninth places? ");
            int ninthPNo = scan.nextInt();
            System.out.print("How many tenth places? ");
            int tenthPNo = scan.nextInt();
            int currentPoints = (firstPNo*25)+(secondPNo*18)+(thirdPNo*15)+(fourthPNo*12)+(fifthPNo*10)
                    +(sixthPNo*8)+(seventhPNo*6)+(eighthPNo*4)+(ninthPNo*2)+tenthPNo;
            int numberOfRaces = firstPNo + secondPNo + thirdPNo + fourthPNo + fifthPNo
                    +sixthPNo + seventhPNo + eighthPNo+ ninthPNo + tenthPNo;
            formula1ChampionshipManager.addNewDriver(formula1Driver,name,team,numberOfRaces,firstPNo,
                    secondPNo,thirdPNo,fourthPNo, fifthPNo, sixthPNo, seventhPNo, eighthPNo, ninthPNo, tenthPNo, currentPoints);
            System.out.println("Do you want to add another driver? (Y/N)");
            String choice = scan.next();
            if (choice.equalsIgnoreCase("Y")) {
                newDriver();
            } else if (choice.equalsIgnoreCase("N")) {
                menu();
            } else {
                System.err.print("Please enter a valid input!\n");
                menu();
            }
        }else if(other.equalsIgnoreCase("N")){
            formula1ChampionshipManager.addNewDriver(formula1Driver,name,team);
            System.out.println("Do you want to add another driver? (Y/N)");
            String choice = scan.next();
            scan.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                newDriver();
            } else if (choice.equalsIgnoreCase("N")) {
                menu();
            } else {
                System.err.print("Please enter a valid input!\n");
                menu();
            }
        }else{
            System.err.print("Please enter a valid input!\n");
            menu();
        }
    }

    private static void deleteDriver() { //delete an existing driver and the team
        Formula1ChampionshipManager formula1ChampionshipManager = new Formula1ChampionshipManager();
        System.out.println("Names of the existing drivers: ");
        formula1ChampionshipManager.displayDriverNames();
        System.out.println("Enter the name of the driver you want to delete : ");
        String deleteName = scan.nextLine();
        Formula1ChampionshipManager formulaTeam = new Formula1ChampionshipManager();
        boolean result = formulaTeam.deleteDriver(deleteName);
        if (result == true) {
            System.out.println("Driver is deleted successfully!");
        } else {
            System.out.println("Driver not found! Please enter valid name!Back to main menu!");
        }
        menu();
    }

    private static void changeDriver() { //change the name of a driver in the championship
        Formula1ChampionshipManager driver = new Formula1ChampionshipManager();
        System.out.println("Names and team names of the current drivers respectively: ");
        driver.displayDriverNameAndTeamName();
        System.out.println("Enter the name of the driver: ");
        String driverName = scan.next();
        System.out.println("What is the new driver's name?");
        String newDriverName = scan.next();
        Formula1ChampionshipManager formulaTeam = new Formula1ChampionshipManager();
        boolean result = formulaTeam.changeTeamDriver(driverName, newDriverName);
        if (result == true) {
            System.out.println("Driver whose name is "+driverName+" got changed to "+newDriverName+"!");
        } else {
            System.out.println("Driver not found! Back to main menu!");

        }
        menu();
    }

    private static void driverStats() { //display statistics of a driver in the championship
        Formula1ChampionshipManager driver = new Formula1ChampionshipManager();
        driver.displayDriverNames();
        System.out.println("Which driver's statistics do you want to be displayed?");
        String driverName = scan.next();
        Formula1ChampionshipManager formulaTeam = new Formula1ChampionshipManager();
        formulaTeam.displayStats(driverName);
        menu();
    }

    private static void completedRaceDetails() throws ParseException { //enter the details of a completed race
        Formula1ChampionshipManager formula1ChampionshipManager = new Formula1ChampionshipManager();
        formula1ChampionshipManager.completedRaceDetails();
    }

    public static  void saveInfo() { //save information so far entered to a file
        Formula1ChampionshipManager.saveInfo();
        System.out.println("\nSaving the information entered so far...Checkout your specified output file..\n");
        menu();
    }

    public static void exit() { //exit from the program
        System.out.println("Do you want to Exit? (Y/N)");
        String choice = scan.next();
        if (choice.equalsIgnoreCase("Y")) {
            System.out.println("Program terminated!");
        } else if (choice.equalsIgnoreCase("N")) {
            menu();
        } else {
            System.out.println("Please enter a valid input!");
        }
        System.exit(0);
    }

}

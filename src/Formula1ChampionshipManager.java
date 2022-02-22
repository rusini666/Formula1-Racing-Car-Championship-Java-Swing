import java.io.*;
import java.text.ParseException;
import java.util.*;
import java.util.List;

public class Formula1ChampionshipManager implements ChampionshipManager, Serializable{

    static List<Formula1Driver> driver = new ArrayList<>(); //arraylist storing driver info

    static List<String> randomLocations = new ArrayList<>(); //arraylist populated with random locations
    static List<String> randomDates = new ArrayList<>(); //arraylist populated with random dates

    static List<Formula1Driver> newRaces = new ArrayList<>();//arraylist with randomly and manually generated races

    static { //populate the randomLocations and randomDates arraylists
        randomLocations.add("Colombo");
        randomLocations.add("LA");
        randomLocations.add("Colombia");
        randomLocations.add("Brooklyn");
        randomLocations.add("Seoul");
        randomLocations.add("Wuhan");
        randomLocations.add("Busan");
        randomLocations.add("Birmingham");
        randomDates.add("2021/12/1");
        randomDates.add("2022/1/1");
        randomDates.add("2021/12/1");
        randomDates.add("2020/1/12");
        randomDates.add("2021/12/1");
        randomDates.add("2021/12/1");
        randomDates.add("2019/5/8");
        randomDates.add("2020/9/9");
    }

    static Scanner scan = new Scanner(System.in);

    public static void menu() { Formula1ChampionshipMenu.menu();}

    @Override
    public void addNewDriver(Formula1Driver formula1Driver, String driverName, String teamName,
                             int numberOfRaces, int firstPNo, int secondPNo, int thirdPNo,int fourthPNo,int fifthPNo,
                             int sixthPNo,int seventhPNo,int eighthPNo,int ninthPNo,int tenthPNo, int currentPoints) {
        formula1Driver = new Formula1Driver(driverName, teamName, numberOfRaces, firstPNo, secondPNo, thirdPNo, fourthPNo, fifthPNo, sixthPNo, seventhPNo, eighthPNo,
                ninthPNo, tenthPNo, currentPoints);
        driver.add(formula1Driver);
    }

    @Override
    public void addNewDriver(Formula1Driver formula1Driver, String driverName, String teamName) {
        formula1Driver = new Formula1Driver(driverName, teamName);
        driver.add(formula1Driver);

    }

    @Override
    public boolean deleteDriver(String driverName) {
        deleteFromNewRace(driverName);
        for(int i = 0; i < driver.size(); i++){
            if(driver.get(i).getDriverName().equalsIgnoreCase(driverName)){
                driver.remove(i);
                return true;
            }
        }
        return false;
    }

    public void deleteFromNewRace(String driverName) {
        for(int i = 0; i < newRaces.size(); i++){
            if(newRaces.get(i).getDriverName().equalsIgnoreCase(driverName)){
                newRaces.remove(i);
            }
        }
    }

    @Override
    public boolean changeTeamDriver(String driverName, String newDriverName) {
        changeNewRaceDriver(driverName, newDriverName);
        for(int i = 0; i < driver.size(); i++){
           if(driver.get(i).getDriverName().equalsIgnoreCase(driverName)) {
               Formula1Driver index = driver.get(i);
               index.setDriverName(newDriverName);
               return true;
           }
        }return false;
    }

    public void changeNewRaceDriver(String driverName, String newDriverName) {
        for(int i = 0; i < newRaces.size(); i++){
            if(newRaces.get(i).getDriverName().equalsIgnoreCase(driverName)) {
                Formula1Driver index = newRaces.get(i);
                index.setDriverName(newDriverName);
            }
        }
    }

    @Override
    public void displayDriverNames(){
        for (int i = 0; i < driver.size(); i++) {
            System.out.print(driver.get(i).getDriverName() + " | ");
        }
        System.out.println("");
    }

    @Override
    public void displayDriverNameAndTeamName(){
        for (int i = 0; i < driver.size(); i++) {
            System.out.print(driver.get(i).getDriverName() + " - "+driver.get(i).getDriverTeamName()+" | ");
        }
        System.out.println("");
    }

    @Override
    public void displayStats(String driverName) {
        for(int i = 0; i < driver.size(); i++) {
            if (driver.get(i).getDriverName().equalsIgnoreCase(driverName)) {
                System.out.println("+----------------+----------------+--------------------+--------------+---------------+--------------+");
                System.out.println("|   Team Name    | Current Points | Races Participated | First Places | Second Places | Third Places |");
                System.out.println("+----------------+----------------+--------------------+--------------+---------------+--------------+");
                System.out.println(String.format("%15s %15s %15s %15s %15s %15s", driver.get(i).getDriverTeamName() ,driver.get(i).getCurrentPoints()
                        , driver.get(i).getNumberOfRaces() , driver.get(i).getFirstPNo() , driver.get(i).getSecondPNo() , driver.get(i).getThirdPNo()));
                System.out.println("+----------------+----------------+--------------------+--------------+---------------+--------------+");
            }
        }
    }


    @Override
    public void championshipDriverTable() {
        System.out.println("+---------------+----------------+----------------+-------------------+--------------+---------------+--------------+");
        System.out.println("|  Driver Name  |   Team Name    | Current Points |Races Participated | First Places | Second Places | Third Places |");
        System.out.println("+---------------+----------------+----------------+-------------------+--------------+---------------+--------------+");
        Collections.sort(driver, Formula1Driver.formula1Driver);
        for(Formula1Driver str: driver){
            System.out.println(str);
        }
        System.out.println("+---------------+----------------+----------------+-------------------+--------------+---------------+--------------+");
    }

    @Override
    public void completedRaceDetails() throws ParseException {
        System.out.println("Please enter the day [dd]: "); //ask user for the day
        int d = scan.nextInt();
        System.out.println("Please enter the month [mm]: ");//ask user for the month
        int m = scan.nextInt();
        System.out.println("Please enter the year [yyyy]:  ");//ask user for the year
        int y = scan.nextInt();
        String raceDate =  y + "/" + m + "/" + d;
        System.out.println("Date the race was completed : " + raceDate);

        scan.nextLine();
        System.out.println("What was the location of the race?");
        String raceLocation = scan.nextLine();

        displayDriverNames();

        for(int i = 0; i < driver.size(); i++){
            System.out.print("What's the position of driver, "+driver.get(i).getDriverName()+" of team "+driver.get(i).getDriverTeamName()+"? ");
            int position = scan.nextInt(); //user enters the position of the driver
            Formula1Driver formula1Driver = new Formula1Driver(driver.get(i).getDriverName(),driver.get(i).getDriverTeamName(),position,raceDate,raceLocation,"Manual");
            newRaces.add(formula1Driver);
            switch(position) { //updates the tables according to the position
                case 1:
                    driver.get(i).setCurrentPoints(driver.get(i).getCurrentPoints() + 25);
                    driver.get(i).setFirstPNo(driver.get(i).getFirstPNo()+1);
                    driver.get(i).setNumberOfRaces(driver.get(i).getNumberOfRaces()+1);
                    break;
                case 2:
                    driver.get(i).setCurrentPoints(driver.get(i).getCurrentPoints() + 18);
                    driver.get(i).setSecondPNo(driver.get(i).getSecondPNo()+1);
                    driver.get(i).setNumberOfRaces(driver.get(i).getNumberOfRaces()+1);
                    break;
                case 3:
                    driver.get(i).setCurrentPoints(driver.get(i).getCurrentPoints() + 15);
                    driver.get(i).setThirdPNo(driver.get(i).getThirdPNo()+1);
                    driver.get(i).setNumberOfRaces(driver.get(i).getNumberOfRaces()+1);
                    break;
                case 4:
                    driver.get(i).setCurrentPoints(driver.get(i).getCurrentPoints() + 12);
                    driver.get(i).setFourthPNo(driver.get(i).getFourthPNo()+1);
                    driver.get(i).setNumberOfRaces(driver.get(i).getNumberOfRaces()+1);
                    break;
                case 5:
                    driver.get(i).setCurrentPoints(driver.get(i).getCurrentPoints() + 10);
                    driver.get(i).setFifthPNo(driver.get(i).getFifthPNo()+1);
                    driver.get(i).setNumberOfRaces(driver.get(i).getNumberOfRaces()+1);
                    break;
                case 6:
                    driver.get(i).setCurrentPoints(driver.get(i).getCurrentPoints() + 8);
                    driver.get(i).setSixthPNo(driver.get(i).getSixthPNo()+1);
                    driver.get(i).setNumberOfRaces(driver.get(i).getNumberOfRaces()+1);
                    break;
                case 7:
                    driver.get(i).setCurrentPoints(driver.get(i).getCurrentPoints() + 6);
                    driver.get(i).setSeventhPNo(driver.get(i).getSeventhPNo()+1);
                    driver.get(i).setNumberOfRaces(driver.get(i).getNumberOfRaces()+1);
                    break;
                case 8:
                    driver.get(i).setCurrentPoints(driver.get(i).getCurrentPoints() + 4);
                    driver.get(i).setEighthPNo(driver.get(i).getEighthPNo()+1);
                    driver.get(i).setNumberOfRaces(driver.get(i).getNumberOfRaces()+1);
                    break;
                case 9:
                    driver.get(i).setCurrentPoints(driver.get(i).getCurrentPoints() + 2);
                    driver.get(i).setNinthPNo(driver.get(i).getNinthPNo()+1);
                    driver.get(i).setNumberOfRaces(driver.get(i).getNumberOfRaces()+1);
                    break;
                case 10:
                    driver.get(i).setCurrentPoints(driver.get(i).getCurrentPoints() + 1);
                    driver.get(i).setTenthPNo(driver.get(i).getTenthPNo()+1);
                    driver.get(i).setNumberOfRaces(driver.get(i).getNumberOfRaces()+1);
                default:
                    System.out.println("Please enter a valid integer!");
            }

        }
        System.out.println("Updated race table: ");
        raceCompletedTable();
        menu();
    }

    public void raceCompletedTable(){

        System.out.println("+------------------+-------------------+-------------------+-------------------+");
        System.out.println("|   Driver Name    |     Team Name     |     Race Date     |     Location      | ");
        System.out.println("+------------------+-------------------+-------------------+-------------------+");
        for(int i = 0; i < driver.size(); i++) {
            System.out.println(String.format("%17s %17s %17s %17s", newRaces.get(i).getDriverName() ,
                    newRaces.get(i).getDriverTeamName() ,newRaces.get(i).getDate(),newRaces.get(i).getLocation()));
        }
        System.out.println("+------------------+-------------------+-------------------+-------------------+");
    }

    public static void saveInfo() {
        //serializing an object
        try {
            FileOutputStream fileOut = new FileOutputStream("Formula1ChampionshipInfo.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(driver);
            out.writeObject(newRaces);
            out.close();
            fileOut.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadInfo() {
        // deserializing an object
        System.out.println("Saved Information of the Drivers: ");
        System.out.println("+---------------+----------------+----------------+-------------------+--------------+---------------+--------------+");
        System.out.println("|  Driver Name  |   Team Name    | Current Points |Races Participated | First Places | Second Places | Third Places |");
        System.out.println("+---------------+----------------+----------------+-------------------+--------------+---------------+--------------+");
        try {
            FileInputStream fileIn = new FileInputStream("Formula1ChampionshipInfo.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            driver = (ArrayList<Formula1Driver>) in.readObject();
            newRaces = (ArrayList<Formula1Driver>) in.readObject();

            for (Formula1Driver is : driver) {
                System.out.println(is);
            }
            System.out.println("+---------------+----------------+----------------+-------------------+--------------+---------------+--------------+");
            in.close();
            fileIn.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        menu();
    }

}

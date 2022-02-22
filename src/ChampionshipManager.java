import java.text.ParseException;

public interface ChampionshipManager {

    void addNewDriver(Formula1Driver squad, String driverName, String teamName, int numberOfRaces, int firstPNo, int secondPNo, int thirdPNo,
                      int fourthPNo, int fifthPNo, int sixthPNo,int seventhPNo,int eighthPNo,int ninthPNo,int tenthPNo, int currentPoints);

    void addNewDriver(Formula1Driver formula1Driver, String driverName, String teamName);

    boolean changeTeamDriver(String driverName, String newDriverName);

    boolean deleteDriver(String driverName);

    void displayStats(String driverName);

    void displayDriverNameAndTeamName();

    void displayDriverNames();

    void completedRaceDetails() throws ParseException;

    void championshipDriverTable();

    void loadInfo();

}

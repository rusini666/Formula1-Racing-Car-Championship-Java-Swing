import java.io.Serializable;
import java.util.*;

public class Formula1Driver extends Driver implements Serializable {

    private int position;
    private String generate;
    private String date, location;
    private int currentPoints;
    private int numberOfRaces;
    private int firstPNo;
    private int secondPNo;
    private int thirdPNo;
    private int fourthPNo;
    private int fifthPNo;
    private int sixthPNo;
    private int seventhPNo;
    private int eighthPNo;
    private int ninthPNo;
    private int tenthPNo;
    private String driverName, driverTeamName;

    public Formula1Driver(String driverName, String driverTeamName, int numberOfRaces,
                          int firstPNo, int secondPNo, int thirdPNo,int fourthPNo, int fifthPNo, int sixthPNo,
                          int seventhPNo, int eighthPNo, int ninthPNo, int tenthPNo, int currentPoints) {
        this.driverName = driverName;
        this.driverTeamName = driverTeamName;
        this.numberOfRaces = numberOfRaces;
        this.firstPNo = firstPNo;
        this.secondPNo = secondPNo;
        this.thirdPNo = thirdPNo;
        this.fourthPNo = fourthPNo;
        this.fifthPNo = fifthPNo;
        this.sixthPNo = sixthPNo;
        this.seventhPNo = seventhPNo;
        this.eighthPNo = eighthPNo;
        this.ninthPNo = ninthPNo;
        this.tenthPNo = tenthPNo;
        this.currentPoints = currentPoints;
    }

    public Formula1Driver(String driverName,String driverTeamName,int position, String date, String location,String generate) {
        this.driverName = driverName;
        this.position = position;
        this.date = date;
        this.location = location;
        this.driverTeamName = driverTeamName;
        this.generate = generate;
    }

    @Override
    public String toString() {
        return String.format("%15s %15s %15s %15s %15s %15s %15s ", driverName , driverTeamName , currentPoints , numberOfRaces , firstPNo , secondPNo , thirdPNo);
    }

    public Formula1Driver(String driverName, String driverTeamName) {
        this.driverName = driverName;
        this.driverTeamName = driverTeamName;
    }

    //getters and setters
    @Override
    public int getCurrentPoints() {
        return currentPoints;
    }

    @Override
    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }

    @Override
    public int getNumberOfRaces() {
        return numberOfRaces;
    }

    @Override
    public void setNumberOfRaces(int numberOfRaces) {
        this.numberOfRaces = numberOfRaces;
    }

    @Override
    public int getFirstPNo() {
        return firstPNo;
    }

    @Override
    public void setFirstPNo(int firstPNo) {
        this.firstPNo = firstPNo;
    }

    @Override
    public int getSecondPNo() {
        return secondPNo;
    }

    @Override
    public void setSecondPNo(int secondPNo) {
        this.secondPNo = secondPNo;
    }

    @Override
    public int getThirdPNo() {
        return thirdPNo;
    }

    @Override
    public void setThirdPNo(int thirdPNo) {
        this.thirdPNo = thirdPNo;
    }

    @Override
    public int getFourthPNo() {
        return fourthPNo;
    }

    @Override
    public void setFourthPNo(int fourthPNo) {
        this.fourthPNo = fourthPNo;
    }

    @Override
    public int getFifthPNo() {
        return fifthPNo;
    }

    @Override
    public void setFifthPNo(int fifthPNo) {
        this.fifthPNo = fifthPNo;
    }

    @Override
    public int getSixthPNo() {
        return sixthPNo;
    }

    @Override
    public void setSixthPNo(int sixthPNo) {
        this.sixthPNo = sixthPNo;
    }

    @Override
    public int getSeventhPNo() {
        return seventhPNo;
    }

    @Override
    public void setSeventhPNo(int seventhPNo) {
        this.seventhPNo = seventhPNo;
    }

    @Override
    public int getEighthPNo() {
        return eighthPNo;
    }

    @Override
    public void setEighthPNo(int eighthPNo) {
        this.eighthPNo = eighthPNo;
    }

    @Override
    public int getNinthPNo() {
        return ninthPNo;
    }

    @Override
    public void setNinthPNo(int ninthPNo) {
        this.ninthPNo = ninthPNo;
    }

    @Override
    public int getTenthPNo() {
        return tenthPNo;
    }

    @Override
    public void setTenthPNo(int tenthPNo) {
        this.tenthPNo = tenthPNo;
    }

    @Override
    public String getDriverName() {
        return driverName;
    }

    @Override
    public void setDriverName(String driverName) {this.driverName = driverName;}

    @Override
    public String getDriverTeamName() {
        return driverTeamName;
    }

    @Override
    public void setDriverTeamName(String driverTeamName) {
        this.driverTeamName = driverTeamName;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String getGenerate() {
        return generate;
    }

    @Override
    public void setGenerate(String generate) {
        this.generate = generate;
    }

    public static Comparator<Formula1Driver> formula1Driver = (d1, d2) -> {

        int currentPoints1 = d1.getCurrentPoints();
        int currentPoints2 = d2.getCurrentPoints();
        int firstPoints1 = d1.getFirstPNo();
        int firstPoints2 = d2.getFirstPNo();

        if(currentPoints2 != currentPoints1)
            return currentPoints2 - currentPoints1;
        else
            return firstPoints2 - firstPoints1;
    };

}





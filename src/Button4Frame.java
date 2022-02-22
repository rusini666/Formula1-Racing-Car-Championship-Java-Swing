import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Button4Frame {

    public Button4Frame() {

        JPanel displayPanel = new JPanel();

        JButton backButton = new JButton("< BACK");
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(displayPanel, BorderLayout.CENTER);

        content.add(backButton, BorderLayout.SOUTH);

        String col[] = {"Driver Name", "Team Name", "Number of Races", "First Places", "Second Places", "Third Places","Fourth Places",
                "Fifth Places","Sixth Places","Seventh Places","Eighth Places","Ninth Places","Tenth Places","Current Points"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);

        ArrayList<Integer> list = new ArrayList<>();//arraylist with random integers from 1-10
        for (int idx = 1; idx <= 10; idx++) {
            list.add(idx);
        }
        Collections.shuffle(list);//shuffling the items in the arraylist

        for(int i = 0; i < Formula1ChampionshipManager.driver.size(); i++) {

            int startingPosition = list.get(i);

            switch (startingPosition) {
                case 1:
                    Formula1ChampionshipManager.driver.get(i).setCurrentPoints(Formula1ChampionshipManager.driver.get(i).getCurrentPoints() + 25);
                    Formula1ChampionshipManager.driver.get(i).setFirstPNo(Formula1ChampionshipManager.driver.get(i).getFirstPNo() + 1);
                    Formula1ChampionshipManager.driver.get(i).setNumberOfRaces(Formula1ChampionshipManager.driver.get(i).getNumberOfRaces() + 1);
                    break;
                case 2:
                    Formula1ChampionshipManager.driver.get(i).setCurrentPoints(Formula1ChampionshipManager.driver.get(i).getCurrentPoints() + 18);
                    Formula1ChampionshipManager.driver.get(i).setSecondPNo(Formula1ChampionshipManager.driver.get(i).getSecondPNo() + 1);
                    Formula1ChampionshipManager.driver.get(i).setNumberOfRaces(Formula1ChampionshipManager.driver.get(i).getNumberOfRaces() + 1);
                    break;
                case 3:
                    Formula1ChampionshipManager.driver.get(i).setCurrentPoints(Formula1ChampionshipManager.driver.get(i).getCurrentPoints() + 15);
                    Formula1ChampionshipManager.driver.get(i).setThirdPNo(Formula1ChampionshipManager.driver.get(i).getThirdPNo() + 1);
                    Formula1ChampionshipManager.driver.get(i).setNumberOfRaces(Formula1ChampionshipManager.driver.get(i).getNumberOfRaces() + 1);
                    break;
                case 4:
                    Formula1ChampionshipManager.driver.get(i).setCurrentPoints(Formula1ChampionshipManager.driver.get(i).getCurrentPoints() + 12);
                    Formula1ChampionshipManager.driver.get(i).setFourthPNo(Formula1ChampionshipManager.driver.get(i).getFourthPNo() + 1);
                    Formula1ChampionshipManager.driver.get(i).setNumberOfRaces(Formula1ChampionshipManager.driver.get(i).getNumberOfRaces() + 1);
                    break;
                case 5:
                    Formula1ChampionshipManager.driver.get(i).setCurrentPoints(Formula1ChampionshipManager.driver.get(i).getCurrentPoints() + 10);
                    Formula1ChampionshipManager.driver.get(i).setFifthPNo(Formula1ChampionshipManager.driver.get(i).getFifthPNo() + 1);
                    Formula1ChampionshipManager.driver.get(i).setNumberOfRaces(Formula1ChampionshipManager.driver.get(i).getNumberOfRaces() + 1);
                    break;
                case 6:
                    Formula1ChampionshipManager.driver.get(i).setCurrentPoints(Formula1ChampionshipManager.driver.get(i).getCurrentPoints() + 8);
                    Formula1ChampionshipManager.driver.get(i).setSixthPNo(Formula1ChampionshipManager.driver.get(i).getSixthPNo() + 1);
                    Formula1ChampionshipManager.driver.get(i).setNumberOfRaces(Formula1ChampionshipManager.driver.get(i).getNumberOfRaces() + 1);
                    break;
                case 7:
                    Formula1ChampionshipManager.driver.get(i).setCurrentPoints(Formula1ChampionshipManager.driver.get(i).getCurrentPoints() + 6);
                    Formula1ChampionshipManager.driver.get(i).setSeventhPNo(Formula1ChampionshipManager.driver.get(i).getSeventhPNo() + 1);
                    Formula1ChampionshipManager.driver.get(i).setNumberOfRaces(Formula1ChampionshipManager.driver.get(i).getNumberOfRaces() + 1);
                    break;
                case 8:
                    Formula1ChampionshipManager.driver.get(i).setCurrentPoints(Formula1ChampionshipManager.driver.get(i).getCurrentPoints() + 4);
                    Formula1ChampionshipManager.driver.get(i).setEighthPNo(Formula1ChampionshipManager.driver.get(i).getEighthPNo() + 1);
                    Formula1ChampionshipManager.driver.get(i).setNumberOfRaces(Formula1ChampionshipManager.driver.get(i).getNumberOfRaces() + 1);
                    break;
                case 9:
                    Formula1ChampionshipManager.driver.get(i).setCurrentPoints(Formula1ChampionshipManager.driver.get(i).getCurrentPoints() + 2);
                    Formula1ChampionshipManager.driver.get(i).setNinthPNo(Formula1ChampionshipManager.driver.get(i).getNinthPNo() + 1);
                    Formula1ChampionshipManager.driver.get(i).setNumberOfRaces(Formula1ChampionshipManager.driver.get(i).getNumberOfRaces() + 1);
                    break;
                case 10:
                    Formula1ChampionshipManager.driver.get(i).setCurrentPoints(Formula1ChampionshipManager.driver.get(i).getCurrentPoints() + 1);
                    Formula1ChampionshipManager.driver.get(i).setTenthPNo(Formula1ChampionshipManager.driver.get(i).getTenthPNo() + 1);
                    Formula1ChampionshipManager.driver.get(i).setNumberOfRaces(Formula1ChampionshipManager.driver.get(i).getNumberOfRaces() + 1);
                default:
                    // code block
            }

            Object[] data = {Formula1ChampionshipManager.driver.get(i).getDriverName(), Formula1ChampionshipManager.driver.get(i).getDriverTeamName(),
                    Formula1ChampionshipManager.driver.get(i).getNumberOfRaces(), Formula1ChampionshipManager.driver.get(i).getFirstPNo(),
                    Formula1ChampionshipManager.driver.get(i).getSecondPNo(), Formula1ChampionshipManager.driver.get(i).getThirdPNo(),
                    Formula1ChampionshipManager.driver.get(i).getFourthPNo(), Formula1ChampionshipManager.driver.get(i).getFifthPNo(),
                    Formula1ChampionshipManager.driver.get(i).getSixthPNo(), Formula1ChampionshipManager.driver.get(i).getSeventhPNo(),
                    Formula1ChampionshipManager.driver.get(i).getEighthPNo(), Formula1ChampionshipManager.driver.get(i).getNinthPNo(),
                    Formula1ChampionshipManager.driver.get(i).getTenthPNo(), Formula1ChampionshipManager.driver.get(i).getCurrentPoints()};

            tableModel.addRow(data);
        }

        JTable table = new JTable(tableModel);

        JFrame window = new JFrame("Updated Table after Generation of Probabilistic Race");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setSize(600, 400);

        Container contentPane = window.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
        contentPane.add(backButton, BorderLayout.SOUTH);

        Formula1ChampionshipManager.saveInfo();//save information of the randomly generated race

        backButton.addActionListener(e -> {
            window.dispose();
            new Formula1ChampionshipGUI();
        });
    }
}
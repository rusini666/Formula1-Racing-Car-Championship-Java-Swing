import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Button2Frame {

    public Button2Frame() {

        JPanel displayPanel = new JPanel();

        JButton backButton = new JButton("< BACK");
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(displayPanel, BorderLayout.CENTER);

        content.add(backButton, BorderLayout.SOUTH);

        String col[] = {"Driver Name", "Team Name", "Number of Races", "First Places", "Second Places", "Third Places", "Current Points"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);

        for (int i = 0; i < Formula1ChampionshipManager.driver.size(); i++) {
            String driverName = Formula1ChampionshipManager.driver.get(i).getDriverName();
            String teamName = Formula1ChampionshipManager.driver.get(i).getDriverTeamName();
            int numberOfRaces = Formula1ChampionshipManager.driver.get(i).getNumberOfRaces();
            int firstPNo = Formula1ChampionshipManager.driver.get(i).getFirstPNo();
            int secondPNo = Formula1ChampionshipManager.driver.get(i).getSecondPNo();
            int thirdPNo = Formula1ChampionshipManager.driver.get(i).getThirdPNo();
            int currentPoints = Formula1ChampionshipManager.driver.get(i).getCurrentPoints();

            Object[] data = {driverName, teamName, numberOfRaces, firstPNo, secondPNo, thirdPNo,
                    currentPoints};

            tableModel.addRow(data);
        }
        //creating a JTable and sorting it - https://stackoverflow.com/questions/28823670/how-to-sort-jtable-in-shortest-way
        JTable table = new JTable(tableModel);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
        table.setRowSorter(sorter);

        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(3, SortOrder.DESCENDING));
        sorter.setSortKeys(sortKeys);

        table.getTableHeader().setEnabled(false);

        JFrame window = new JFrame("GUI Test");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setSize(1000, 400);

        Container contentPane = window.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
        contentPane.add(backButton, BorderLayout.SOUTH);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.dispose();
                new Formula1ChampionshipGUI();
            }
        });
    }


}

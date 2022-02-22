import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Button5Frame {
    public Button5Frame() {

        JPanel panel = new JPanel();

        JButton backButton = new JButton("Back to buttons");
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(panel, BorderLayout.NORTH);

        content.add(backButton, BorderLayout.SOUTH);

        String values[] = {"Team Name","Position","Location","Date","Random or Manual"};
        DefaultTableModel model = new DefaultTableModel(values, 0);

        for (int i = 0; i < Formula1ChampionshipManager.newRaces.size(); i++) {
            String teamName = Formula1ChampionshipManager.newRaces.get(i).getDriverTeamName();
            String location = Formula1ChampionshipManager.newRaces.get(i).getLocation();
            String strDate = Formula1ChampionshipManager.newRaces.get(i).getDate();
            int position = Formula1ChampionshipManager.newRaces.get(i).getPosition();
            String randomOrManual = Formula1ChampionshipManager.newRaces.get(i).getGenerate();
            Object[] abc= {teamName,position,location, strDate,randomOrManual};
            model.addRow(abc);
        }
        JFrame window = new JFrame("Ascending Order of Dates");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setSize(850, 620);

        JTable table = new JTable(model);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
        table.setRowSorter(sorter);

        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(3, SortOrder.ASCENDING)); //sort the dates in ascending order
        sorter.setSortKeys(sortKeys);
        table.getTableHeader().setEnabled(false);
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

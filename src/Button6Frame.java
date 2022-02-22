import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button6Frame {
    //search box with JTextField and JButton - https://coderanch.com/t/706406/java/create-search-box-JTextField-JButton
    public static JTextField driverName = new JTextField();//text box to search drivers name
    public Button6Frame() {
        JFrame f = new JFrame("Filter the Driver's Statistics");

        f.setSize(390, 300);//set size and location of frame
        f.setLocation(100, 150);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//make sure it quits when x is clicked

        f.setDefaultLookAndFeelDecorated(true);//set look and feel
        JLabel labelM = new JLabel("Enter the name of the driver: ");
        labelM.setBounds(50, 50, 200, 30);

        driverName.setBounds(50, 100, 200, 30);//set size of the text box

        f.add(labelM);
        f.add(driverName);
        f.setLayout(null);
        f.setVisible(true);

        JButton b = new JButton("Search");//add search button
        b.setBounds(50, 150, 100, 30);//add button to the frame

        f.add(b);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new Search();//closes Button6Frame and displays the frame with the filtered name
            }
        });
    }
}

class Search {
    public Search() {
        JPanel displayPanel = new JPanel();

        JButton backButton = new JButton("< BACK");
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(displayPanel, BorderLayout.CENTER);

        content.add(backButton, BorderLayout.SOUTH);

        String textFieldValue = Button6Frame.driverName.getText();
        String col[] = {"Team Name", "Location","Date", "Position"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);

        for (int i = 0; i < Formula1ChampionshipManager.newRaces.size(); i++) {
            if (Formula1ChampionshipManager.newRaces.get(i).getDriverName().equalsIgnoreCase(textFieldValue)) {
                String teamName = Formula1ChampionshipManager.newRaces.get(i).getDriverTeamName();
                String location = Formula1ChampionshipManager.newRaces.get(i).getLocation();
                String strDate = Formula1ChampionshipManager.newRaces.get(i).getDate();
                int position = Formula1ChampionshipManager.newRaces.get(i).getPosition();

                Object[] data = {teamName, location, strDate, position};

                tableModel.addRow(data);
            }
            JTable table = new JTable(tableModel);
            JFrame window = new JFrame("Filtered Details of the Driver");
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setVisible(true);
            window.setSize(1000, 400);

            Container contentPane = window.getContentPane();
            contentPane.setLayout(new BorderLayout());
            contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
            contentPane.add(backButton, BorderLayout.SOUTH);

            backButton.addActionListener(e -> {
                window.dispose();
                new Formula1ChampionshipGUI();
            });
        }
    }
}
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formula1ChampionshipGUI{

    public Formula1ChampionshipGUI() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(2, 3, 2, 3));

        JPanel layout = new JPanel(new GridBagLayout());
        layout.setBorder(new EmptyBorder(5, 5, 5, 5));

        JPanel btnPanel = new JPanel(new GridLayout(9, 1, 20, 20));

        Border border = BorderFactory.createLineBorder(Color.green,3);

        JLabel label = new JLabel();
        label.setText("        ~WELCOME TO FORMULA 1 RACING GUI~"); //heading of the main menu
        label.setForeground(Color.black);
        label.setFont(new Font("Calibre",Font.PLAIN,20));

        //buttons with different functionalities
        JButton button = new JButton("Display all the drivers and their statistics (driver table) in descending order of points.");
        JButton button1 = new JButton("Display the driver table in ascending order of points.");
        JButton button2 = new JButton("Display the driver table in descending order of first positions.");
        JButton button3 = new JButton("Generate random race.");
        JButton button4 = new JButton("Generation of probabilistic race.");
        JButton button5 = new JButton("Display all completed races in ascending order of dates played.");
        JButton button6 = new JButton("Display details of races participated by a driver.");

        //adding the buttons to the panel
        btnPanel.add(label);
        btnPanel.add(button);
        btnPanel.add(button1);
        btnPanel.add(button2);
        btnPanel.add(button3);
        btnPanel.add(button4);
        btnPanel.add(button5);
        btnPanel.add(button6);

        layout.add(btnPanel);

        panel.setBorder(border);
        panel.add(layout, BorderLayout.CENTER);

        JFrame frame = new JFrame("Home Page");
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setSize(600, 400);
        frame.setVisible(true);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new ButtonFrame();
            }
        });

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Button1Frame();
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Button2Frame();
            }
        });

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Button3Frame();
            }
        });

        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Button5Frame();
            }
        });

        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Button6Frame();
            }
        });
    }
}


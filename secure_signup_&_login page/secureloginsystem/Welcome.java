package secureloginsystem;

import javax.swing.*;
import java.awt.*;

public class Welcome extends JFrame {
    public Welcome(String name, String regNumber) {
        setTitle("HELLO STUDENT");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Set layout and create components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.setBackground(Color.PINK);

        JLabel welcomeLabel = new JLabel("Welcome, " + name + "!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 20));
        panel.add(welcomeLabel);

        JLabel regNumberLabel = new JLabel("Registration Number: " + regNumber, SwingConstants.CENTER);
        regNumberLabel.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 16));
        panel.add(regNumberLabel);

        JButton btnLogout = new JButton("Logout");
        btnLogout.addActionListener(e -> {
            dispose(); // Close the welcome page
        });
        panel.add(btnLogout);

        add(panel);
        setVisible(true); // Show the welcome page
    }
}

package secureloginsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Signup extends JDialog {
    private JTextField txtName;
    private JTextField txtUsername;
    private JTextField txtRegNumber;
    private JPasswordField txtPassword;
    private JButton btnSignUp;
    private JButton btnGeneratePassword;
    private JPanel panel;
    private List<User> users;
    private JButton btnLogin;
    private JToggleButton btnShowPassword; // Toggle button for showing password

    public Signup(JFrame parent) {
        super(parent);
        setTitle("Sign Up Page");
        setSize(700, 500); // Increased form size
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        users = new ArrayList<>();

        // Panel with pink background
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.PINK); // Pink background
        setContentPane(panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("ALGERIAN", Font.BOLD, 18); // Larger label font
        Font textFieldFont = new Font("ALGERIAN", Font.BOLD, 18); // Larger text field font
        Dimension textFieldSize = new Dimension(300, 40); // Increased text field size

        // Name field
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel lblName = new JLabel("Name:");
        lblName.setFont(labelFont);
        panel.add(lblName, gbc);

        gbc.gridx = 1;
        txtName = new JTextField(15);
        txtName.setPreferredSize(textFieldSize); // Set preferred size for larger text field
        txtName.setFont(textFieldFont);
        panel.add(txtName, gbc);

        // Username field
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(labelFont);
        panel.add(lblUsername, gbc);

        gbc.gridx = 1;
        txtUsername = new JTextField(15);
        txtUsername.setPreferredSize(textFieldSize);
        txtUsername.setFont(textFieldFont);
        panel.add(txtUsername, gbc);

        // Registration Number field
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel lblRegNumber = new JLabel("Registration Number:");
        lblRegNumber.setFont(labelFont);
        panel.add(lblRegNumber, gbc);

        gbc.gridx = 1;
        txtRegNumber = new JTextField(15);
        txtRegNumber.setPreferredSize(textFieldSize);
        txtRegNumber.setFont(textFieldFont);
        panel.add(txtRegNumber, gbc);

        // Password field
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(labelFont);
        panel.add(lblPassword, gbc);

        gbc.gridx = 1;
        txtPassword = new JPasswordField(15);
        txtPassword.setPreferredSize(textFieldSize);
        txtPassword.setFont(textFieldFont);
        panel.add(txtPassword, gbc);

        // Show Password toggle button
        btnShowPassword = new JToggleButton(new ImageIcon("eye.png")); // Path to closed eye icon
        btnShowPassword.setPreferredSize(new Dimension(40, 40));
        btnShowPassword.setBorderPainted(false);
        btnShowPassword.setContentAreaFilled(false);
        btnShowPassword.setFocusable(false);
        gbc.gridx = 2; // Adjust the grid position to align with the password field
        panel.add(btnShowPassword, gbc);

        // Add action listener for show password button
        btnShowPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnShowPassword.isSelected()) {
                    txtPassword.setEchoChar((char) 0); // Show password
                    btnShowPassword.setIcon(new ImageIcon("path/to/eye_open.png")); // Path to open eye icon
                } else {
                    txtPassword.setEchoChar('*'); // Hide password
                    btnShowPassword.setIcon(new ImageIcon("path/to/eye_closed.png")); // Path to closed eye icon
                }
            }
        });

        // Generate Password button (centered below password label)
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        btnGeneratePassword = new JButton("Generate Password (optional)");
        btnGeneratePassword.setFont(new Font("ALGERIAN", Font.BOLD, 18));
        panel.add(btnGeneratePassword, gbc);

        // Sign Up and Login buttons (side by side at the bottom)
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        btnSignUp = new JButton("Sign Up");
        btnSignUp.setFont(new Font("ALGERIAN", Font.BOLD, 18));
        panel.add(btnSignUp, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("ALGERIAN", Font.BOLD, 18));
        panel.add(btnLogin, gbc);

        // Event Listener for Generate Password button
        btnGeneratePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String generatedPassword = generateStrongPassword();
                txtPassword.setText(generatedPassword);
                JOptionPane.showMessageDialog(Signup.this, "Generated Password: " + generatedPassword, "Password Generator", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText().trim();
                String regNumber = txtRegNumber.getText().trim();
                String username = txtUsername.getText().trim();
                String password = new String(txtPassword.getPassword()).trim();

                // Validation checks
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(Signup.this, "Name is required!", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (username.isEmpty()) {
                    JOptionPane.showMessageDialog(Signup.this, "Username is required!", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (regNumber.isEmpty()) {
                    JOptionPane.showMessageDialog(Signup.this, "Registration Number is required!", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (password.isEmpty()) {
                    JOptionPane.showMessageDialog(Signup.this, "Password is required!", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!isStrongPassword(password)) {
                    JOptionPane.showMessageDialog(Signup.this, "Password must be at least 8 characters long, include uppercase, lowercase, a digit, and a special character.", "Weak Password", JOptionPane.WARNING_MESSAGE);
                } else {
                    addUser(name, username, regNumber, password);
                    new Login(Signup.this, users);
                }
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login(Signup.this, users);
            }
        });

        setVisible(true);
    }

    private void addUser(String name, String username, String regNumber, String password) {
        User newUser = new User(name, username, regNumber, password);
        users.add(newUser);

        JOptionPane.showMessageDialog(null, "User registered successfully!");
        clearInputFields();
    }

    private void clearInputFields() {
        txtName.setText("");
        txtUsername.setText("");
        txtRegNumber.setText("");
        txtPassword.setText("");
    }

    // Generate Strong Password Method
    private String generateStrongPassword() {
        final String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String lowercase = "abcdefghijklmnopqrstuvwxyz";
        final String digits = "0123456789";
        final String specialChars = "!@#$%^&*()-_=+[]{};:<>/?";

        String allChars = uppercase + lowercase + digits + specialChars;
        SecureRandom random = new SecureRandom();

        StringBuilder password = new StringBuilder(8);

        // Ensure at least one of each required character type
        password.append(uppercase.charAt(random.nextInt(uppercase.length())));
        password.append(lowercase.charAt(random.nextInt(lowercase.length())));
        password.append(digits.charAt(random.nextInt(digits.length())));
        password.append(specialChars.charAt(random.nextInt(specialChars.length())));

        // Fill the remaining characters randomly
        for (int i = 4; i < 8; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        return password.toString();
    }

    private boolean isStrongPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }

        return hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Signup(null));
    }
}

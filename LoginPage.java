import javax.swing.*;
import java.awt.event.*;
import java.awt.GridLayout;

public class LoginPage extends JFrame {
    JLabel usernameLabel, passwordLabel;
    JTextField usernameField, passwordField;
    JButton loginButton;

    public LoginPage() {
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(20);
        passwordField = new JTextField(20);
        loginButton = new JButton("Login");

        setLayout(new GridLayout(3, 2));
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();

                if (username.equals("admin") && password.equals("admin123")) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    dispose();
                    BugTracker bugTracker = new BugTracker();
                    bugTracker.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password!");
                }
            }
        });

        setTitle("Login Page");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}

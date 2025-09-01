import javax.swing.*;
import java.awt.*;


public class LoginFrame extends JFrame {
    private final AdminService service = new AdminService();


    public LoginFrame() {
        setTitle("SmartStudent Login");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        JButton loginBtn = new JButton("Login");


        panel.add(userLabel); panel.add(userField);
        panel.add(passLabel); panel.add(passField);
        panel.add(new JLabel()); panel.add(loginBtn);
        add(panel);


        loginBtn.addActionListener(e -> {
            String username = userField.getText().trim();
            String password = new String(passField.getPassword());
            if (service.login(username, password)) {
                SwingUtilities.invokeLater(() -> new DashboardFrame(service).setVisible(true));
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}

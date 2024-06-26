import java.awt.*;
import javax.swing.*;

public class Dashboard extends JFrame {

    public Dashboard() {
        initialize();
    }

    private void initialize() {
        // Setting up the frame
        setTitle("Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.LIGHT_GRAY);
        headerPanel.setPreferredSize(new Dimension(getWidth(), 50));

        JButton homeButton = createTextButton("Home");
        JButton aboutButton = createTextButton("About");
        JButton servicesButton = createTextButton("Services");

        headerPanel.add(homeButton);
        headerPanel.add(aboutButton);
        headerPanel.add(servicesButton);

        add(headerPanel, BorderLayout.NORTH);

        // Body panel
        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));
        bodyPanel.setBackground(Color.GREEN); // Set background color to green

        JLabel titleLabel = new JLabel("Outsourced Contact Center Services");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bodyPanel.add(Box.createVerticalStrut(20));
        bodyPanel.add(titleLabel);

        String[] services = {
                "Customer Service",
                "Sales",
                "Outreach",
                "Technical Support",
                "Non-Profit",
                "Enrollment Services"
        };

        for (String service : services) {
            JLabel serviceLabel = new JLabel(service);
            serviceLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            serviceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            bodyPanel.add(Box.createVerticalStrut(10));
            bodyPanel.add(serviceLabel);

            JButton readMoreButton = new JButton("Read More");
            readMoreButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            bodyPanel.add(readMoreButton);
            bodyPanel.add(Box.createVerticalStrut(20));
        }

        // Wrap bodyPanel in a scroll pane
        JScrollPane scrollPane = new JScrollPane(bodyPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane, BorderLayout.CENTER);

        // Footer panel
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(Color.LIGHT_GRAY);
        footerPanel.setPreferredSize(new Dimension(getWidth(), 50));

        JLabel footerLabel = new JLabel("Synergy Solutions");
        footerPanel.add(footerLabel);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setFont(new Font("Arial", Font.PLAIN, 14));
        logoutButton.setForeground(Color.BLACK);
        logoutButton.setFocusPainted(false);
        logoutButton.addActionListener(e -> {
            // Handle logout functionality here
            JOptionPane.showMessageDialog(Dashboard.this, "Logout Button Clicked!");
            // Example: Redirect to login screen or perform logout actions
        });
        footerPanel.add(logoutButton);

        add(footerPanel, BorderLayout.SOUTH);

        // Center the frame on the screen
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JButton createTextButton(String text) {
        JButton button = new JButton(text);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Dashboard());
    }
}

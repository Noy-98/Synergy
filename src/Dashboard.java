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

        headerPanel.add(homeButton);

        add(headerPanel, BorderLayout.NORTH);

        // Body panel
        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));
        bodyPanel.setBackground(Color.GREEN); // Set background color to green

        JLabel titleLabel = new JLabel("12 Sub-Programs");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bodyPanel.add(Box.createVerticalStrut(20));
        bodyPanel.add(titleLabel);

        String[] services = {
                "Leadership Development Initiative",
                "Employee Wellness Program",
                "Diversity and Inclusion Framework",
                "Performance Management System",
                "Continuous Learning Platform",
                "Innovation Hub",
                "Customer Experience Enhancement Initiative",
                "Supply Chain Optimization Strategy",
                "Environmental Sustainability Program",
                "Community Engagement and Corporate Social Responsibility (CSR) Activities",
                "Technology Integration Plan",
                "Risk Management Framework"
        };

        // Messages corresponding to each service
        String[] serviceMessages = {
                "Implement training and mentorship programs to cultivate effective leadership skills across all levels of the organization.",
                "Establish initiatives to promote physical and mental well-being among employees, fostering a healthy and productive work environment.",
                "Develop strategies and policies to ensure diversity and inclusion are embedded in the organizational culture, promoting equity and respect.",
                "Implement a structured process for setting goals, providing feedback, and evaluating performance to drive employee growth and productivity.",
                "Offer access to learning resources and opportunities for skill development to empower employees to stay relevant in a rapidly changing landscape.",
                "Create a dedicated space or platform for employees to collaborate, brainstorm, and implement innovative ideas to drive organizational growth.",
                "Focus on understanding customer needs and preferences to deliver exceptional experiences that foster loyalty and satisfaction.",
                "Streamline supply chain processes to improve efficiency, reduce costs, and enhance overall operational effectiveness.",
                "Implement initiatives to reduce the organization's environmental footprint through energy conservation, waste reduction, and sustainable practices.",
                "Develop partnerships and initiatives to give back to the community and address social and environmental issues.",
                "Leverage technology to automate processes, improve decision-making, and enhance organizational agility in response to market dynamics.",
                "Establish procedures to identify, assess, and mitigate risks across all areas of operation, safeguarding the organization's interests and reputation."
        };

        for (int i = 0; i < services.length; i++) {
            JLabel serviceLabel = new JLabel(services[i]);
            serviceLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            serviceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            bodyPanel.add(Box.createVerticalStrut(10));
            bodyPanel.add(serviceLabel);

            int finalI = i; // Final variable for lambda expression
            JButton readMoreButton = new JButton("Read More");
            readMoreButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            readMoreButton.addActionListener(e -> {
                JOptionPane.showMessageDialog(Dashboard.this, serviceMessages[finalI]);
            });
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
            int choice = JOptionPane.showConfirmDialog(Dashboard.this,
                    "Are you sure you want to logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                // Close current dashboard window
                dispose();
                // Open login window
                new Login();
            }
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

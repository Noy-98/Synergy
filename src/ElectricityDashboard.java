import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ElectricityDashboard extends JFrame {

    private JTextField billAmountField, wattageField;
    private JComboBox<String> applianceDropdown, hoursDropdown, daysDropdown, weeksDropdown;
    private JLabel billAmountLabel, wattageLabel, applianceLabel, hoursLabel, daysLabel, weeksLabel;
    private JLabel costPerHourLabel, costPerDayLabel, costPerWeekLabel, costPerMonthLabel;

    public ElectricityDashboard() {
        initialize();
    }

    private void initialize() {
        setTitle("Electricity Bill Calculator");
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Main panel to hold all components
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridBagLayout());
        contentPane.setBackground(Color.GREEN);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Header Panel with Logout Button
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        headerPanel.setBackground(Color.LIGHT_GRAY);
        headerPanel.setPreferredSize(new Dimension(getWidth(), 50));

        JButton logoutButton = new JButton("Logout");
        logoutButton.setFont(new Font("Arial", Font.PLAIN, 14));
        logoutButton.setFocusPainted(false);
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(ElectricityDashboard.this,
                        "Are you sure you want to logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    dispose(); // Close current window
                    new Login(); // Open login window
                }
            }
        });
        headerPanel.add(logoutButton);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTH;
        contentPane.add(headerPanel, gbc);

        JLabel titleLabel = new JLabel("Electricity Bill Calculator");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        contentPane.add(titleLabel, gbc);

        // Bill Amount Components
        billAmountLabel = new JLabel("Monthly Bill Amount (PHP):");
        billAmountLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        contentPane.add(billAmountLabel, gbc);

        billAmountField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(billAmountField, gbc);

        // Appliance Components
        applianceLabel = new JLabel("Select Appliance:");
        applianceLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        contentPane.add(applianceLabel, gbc);

        String[] appliances = { "TV - 2HP", "Electricfan - 1HP", "Light - 1HP", "Aircon - 3HP", "Washing Machine - 5HP", "Flat Iron - 4HP" };
        applianceDropdown = new JComboBox<>(appliances);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        contentPane.add(applianceDropdown, gbc);

        // Wattage Components
        wattageLabel = new JLabel("Wattage (Watts):");
        wattageLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        contentPane.add(wattageLabel, gbc);

        wattageField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(wattageField, gbc);

        // Hours Used Components
        hoursLabel = new JLabel("Hours Used:");
        hoursLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        contentPane.add(hoursLabel, gbc);

        String[] hours = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" };
        hoursDropdown = new JComboBox<>(hours);
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        contentPane.add(hoursDropdown, gbc);

        // Days Used Components
        daysLabel = new JLabel("Days Used:");
        daysLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.EAST;
        contentPane.add(daysLabel, gbc);

        String[] days = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
        daysDropdown = new JComboBox<>(days);
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        contentPane.add(daysDropdown, gbc);

        // Weeks Used Components
        weeksLabel = new JLabel("Weeks Used:");
        weeksLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.EAST;
        contentPane.add(weeksLabel, gbc);

        String[] weeks = { "1", "2", "3", "4" };
        weeksDropdown = new JComboBox<>(weeks);
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        contentPane.add(weeksDropdown, gbc);

        // Calculate Button
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        contentPane.add(calculateButton, gbc);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateBill();
            }
        });

        // Result Labels
        costPerHourLabel = new JLabel("");
        costPerHourLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        contentPane.add(costPerHourLabel, gbc);

        costPerDayLabel = new JLabel("");
        costPerDayLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        contentPane.add(costPerDayLabel, gbc);

        costPerWeekLabel = new JLabel("");
        costPerWeekLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        contentPane.add(costPerWeekLabel, gbc);

        costPerMonthLabel = new JLabel("");
        costPerMonthLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        contentPane.add(costPerMonthLabel, gbc);

        // Add the main panel to a scroll pane
        JScrollPane scrollPane = new JScrollPane(contentPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        getContentPane().add(scrollPane);

        // Center the frame on the screen
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void calculateBill() {
        try {
            double billAmount = Double.parseDouble(billAmountField.getText());
            double wattage = Double.parseDouble(wattageField.getText());
            int hoursUsed = Integer.parseInt((String) hoursDropdown.getSelectedItem());
            int daysUsed = Integer.parseInt((String) daysDropdown.getSelectedItem());
            int weeksUsed = Integer.parseInt((String) weeksDropdown.getSelectedItem());

            // Calculate the cost per hour
            double costPerHour = (billAmount / (wattage * hoursUsed * daysUsed * weeksUsed));
            double costPerDay = costPerHour * hoursUsed;
            double costPerWeek = costPerDay * daysUsed;
            double costPerMonth = costPerWeek * weeksUsed;

            costPerHourLabel.setText(String.format("Cost per Hour: PHP %.2f", costPerHour));
            costPerDayLabel.setText(String.format("Cost per Day: PHP %.2f", costPerDay));
            costPerWeekLabel.setText(String.format("Cost per Week: PHP %.2f", costPerWeek));
            costPerMonthLabel.setText(String.format("Cost per Month: PHP %.2f", costPerMonth));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ElectricityDashboard());
    }
}

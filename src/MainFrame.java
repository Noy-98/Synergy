import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        initialize();
    }

    public void initialize() {
        // Setting up the frame
        setTitle("Landing Page");
        setSize(500, 600);
        setMinimumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.GREEN);
        
        // Creating the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(Color.GREEN);

        // Creating constraints for layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        // Creating the label
        JLabel welcomeLabel = new JLabel("Welcome to Synergy Solutions");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 22));
        welcomeLabel.setForeground(Color.BLACK);
        mainPanel.add(welcomeLabel, gbc);

        // Creating the rounded corner button
        gbc.gridy = 1;
        JButton getStartedButton = new RoundedButton("Get Started");
        getStartedButton.setFont(new Font("Arial", Font.PLAIN, 15));
        getStartedButton.setForeground(Color.BLACK);
        getStartedButton.setBackground(Color.YELLOW);
        getStartedButton.setOpaque(false);
        getStartedButton.setContentAreaFilled(false);
        getStartedButton.setBorderPainted(false);

        // Adding an action listener to the button
        getStartedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the Login window
                new Login();
                // Close the current MainFrame
                MainFrame.this.dispose();
            }
        });

        mainPanel.add(getStartedButton, gbc);

        // Adding main panel to frame
        add(mainPanel);
        
        // Making the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame());
    }

    // Custom button class with rounded corners
    class RoundedButton extends JButton {
        private static final long serialVersionUID = 1L;
        private int radius;

        public RoundedButton(String text) {
            super(text);
            this.radius = 20;
            setFont(new Font("Arial", Font.PLAIN, 15));
            setForeground(Color.BLACK);
            setBackground(Color.YELLOW);
            setOpaque(false);
            setContentAreaFilled(false);
            setBorderPainted(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
            g2.setColor(getForeground());
            FontMetrics fm = g2.getFontMetrics();
            Rectangle r = getBounds();
            int x = (r.width - fm.stringWidth(getText())) / 2;
            int y = (r.height - fm.getHeight()) / 2 + fm.getAscent();
            g2.drawString(getText(), x, y);
            g2.dispose();
        }

        @Override
        public void updateUI() {
            super.updateUI();
            setOpaque(false);
        }
    }
}

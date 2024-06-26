import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.*;
import javax.swing.border.AbstractBorder;

public class Signup extends JFrame {
    public Signup() {
        initialize();
    }

    public void initialize() {
        // Setting up the frame
        setTitle("Signup Page");
        setSize(500, 600);
        setMinimumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.GREEN); // Set background color to green
        
        // Creating the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(Color.GREEN); // Set background color to green

        // Creating constraints for layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        // Creating the label
        JLabel signupLabel = new JLabel("Signup");
        signupLabel.setFont(new Font("Arial", Font.BOLD, 22));
        signupLabel.setForeground(Color.BLACK);
        mainPanel.add(signupLabel, gbc);

        // Creating the form fields
        gbc.gridy++;
        JTextField firstNameField = createRoundedTextField("First Name");
        mainPanel.add(firstNameField, gbc);

        gbc.gridy++;
        JTextField lastNameField = createRoundedTextField("Last Name");
        mainPanel.add(lastNameField, gbc);

        gbc.gridy++;
        JTextField emailField = createRoundedTextField("Email");
        mainPanel.add(emailField, gbc);

        gbc.gridy++;
        JPasswordField passwordField = createHintPasswordField("Password");
        mainPanel.add(passwordField, gbc);

        gbc.gridy++;
        JPasswordField confirmPasswordField = createHintPasswordField("Confirm Password");
        mainPanel.add(confirmPasswordField, gbc);

        // Creating the signup button
        gbc.gridy++;
        JButton signupButton = new RoundedButton("Signup");
        signupButton.setFont(new Font("Arial", Font.PLAIN, 15));
        signupButton.setForeground(Color.BLACK);
        signupButton.setBackground(Color.YELLOW);
        signupButton.setOpaque(false);
        signupButton.setContentAreaFilled(false);
        signupButton.setBorderPainted(false);

        // Adding an action listener to the button
        signupButton.addActionListener(e -> JOptionPane.showMessageDialog(Signup.this, "Signup Button Clicked!"));

        mainPanel.add(signupButton, gbc);

        // Adding main panel to frame
        add(mainPanel);
        
        // Making the frame visible
        setVisible(true);
    }

    private JTextField createRoundedTextField(String hint) {
        JTextField textField = new JTextField(hint, 20) {
            @Override
            protected void paintComponent(Graphics g) {
                if (!isOpaque() && getBorder() instanceof RoundedBorder) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(getBackground());
                    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                    g2.dispose();
                }
                super.paintComponent(g);
            }
        };
        textField.setOpaque(false);
        textField.setBorder(new RoundedBorder(20));

        // Add focus listener to show/hide hint text
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(hint)) {
                    textField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(hint);
                }
            }
        });

        return textField;
    }

    private JPasswordField createHintPasswordField(String hint) {
        JPasswordField passwordField = new JPasswordField(hint, 20) {
            @Override
            protected void paintComponent(Graphics g) {
                if (!isOpaque() && getBorder() instanceof RoundedBorder) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(getBackground());
                    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                    g2.dispose();
                }
                super.paintComponent(g);
            }
        };
        passwordField.setEchoChar((char) 0);
        passwordField.setOpaque(false);
        passwordField.setBorder(new RoundedBorder(20));

        // Add focus listener to show/hide hint text
        passwordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (new String(passwordField.getPassword()).equals(hint)) {
                    passwordField.setText("");
                    passwordField.setEchoChar('•');
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (passwordField.getPassword().length == 0) {
                    passwordField.setText(hint);
                    passwordField.setEchoChar((char) 0);
                }
            }
        });

        return passwordField;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Signup());
    }

    // Custom border class for rounded corners
    class RoundedBorder extends AbstractBorder {
        private int radius;

        public RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.GRAY);
            g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
            g2.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(4, 8, 4, 8);
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.left = insets.right = insets.top = insets.bottom = 4;
            return insets;
        }
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

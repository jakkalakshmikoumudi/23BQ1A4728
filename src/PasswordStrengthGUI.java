import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PasswordStrengthGUI extends JFrame implements ActionListener {

    JLabel titleLabel;
    JLabel passwordLabel;
    JLabel resultLabel;

    JPasswordField passwordField;

    JButton checkButton;

    JTextArea suggestionArea;

    JProgressBar progressBar;

    public PasswordStrengthGUI() {

        setTitle("Password Strength Analyzer");
        setSize(500, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Background Color
        getContentPane().setBackground(new Color(30, 30, 30));

        // Title
        titleLabel = new JLabel("Password Strength Analyzer");
        titleLabel.setBounds(90, 20, 350, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(Color.CYAN);
        add(titleLabel);

        // Password Label
        passwordLabel = new JLabel("Enter Password:");
        passwordLabel.setBounds(50, 80, 150, 30);
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(passwordLabel);

        // Password Field
        passwordField = new JPasswordField();
        passwordField.setBounds(180, 80, 200, 30);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        add(passwordField);

        // Analyze Button
        checkButton = new JButton("Analyze");
        checkButton.setBounds(180, 130, 120, 35);
        checkButton.setBackground(Color.CYAN);
        checkButton.setForeground(Color.BLACK);
        checkButton.setFont(new Font("Arial", Font.BOLD, 14));
        checkButton.addActionListener(this);
        add(checkButton);

        // Progress Bar
        progressBar = new JProgressBar(0, 10);
        progressBar.setBounds(50, 190, 330, 30);
        progressBar.setStringPainted(true);
        progressBar.setForeground(Color.GREEN);
        progressBar.setBackground(Color.LIGHT_GRAY);
        add(progressBar);

        // Result Label
        resultLabel = new JLabel("Strength: ");
        resultLabel.setBounds(50, 240, 300, 30);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        resultLabel.setForeground(Color.WHITE);
        add(resultLabel);

        // Suggestions Area
        suggestionArea = new JTextArea();
        suggestionArea.setBounds(50, 280, 350, 60);
        suggestionArea.setEditable(false);
        suggestionArea.setBackground(new Color(50, 50, 50));
        suggestionArea.setForeground(Color.WHITE);
        suggestionArea.setFont(new Font("Arial", Font.PLAIN, 13));
        add(suggestionArea);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String password = new String(passwordField.getPassword());

        int score = PasswordChecker.calculateScore(password);

        String strength = PasswordChecker.getStrength(score);

        String suggestions = PasswordChecker.getSuggestions(password);

        // Set Progress Value
        progressBar.setValue(score);

        // Set Strength Text
        resultLabel.setText("Strength: " + strength);

        // Change Strength Color
        if(strength.equals("Weak")) {
            resultLabel.setForeground(Color.RED);
            progressBar.setForeground(Color.RED);
        }
        else if(strength.equals("Medium")) {
            resultLabel.setForeground(Color.ORANGE);
            progressBar.setForeground(Color.ORANGE);
        }
        else {
            resultLabel.setForeground(Color.GREEN);
            progressBar.setForeground(Color.GREEN);
        }

        // Suggestions
        suggestionArea.setText(suggestions);
    }
}
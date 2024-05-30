import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class labTask1 extends KeyAdapter {
    // Instances Of The Tasks
    private JFrame frame;
    private JPanel panel;
    private JLabel celDisplay, fahDisplay;
    private JTextField celInput, fahInput;

    // Constructor
    public labTask1() {
        // Objects
        frame = new JFrame("Celsius To Fahrenheit Converter");
        panel = new JPanel();
        celDisplay = new JLabel("Celsius: ");
        fahDisplay = new JLabel("Fahrenheit: ");
        celInput = new JTextField();
        fahInput = new JTextField();

        // Frame Methods
        panel.setLayout(new GridLayout(2, 2));
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(500, 500); // Adjusted size for better fit
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // Add KeyListeners
        celInput.addKeyListener(this);
        fahInput.addKeyListener(this);

        // Add Components To The Panel
        panel.add(celDisplay);
        panel.add(celInput);
        panel.add(fahDisplay);
        panel.add(fahInput);

        // Add Panel To The Frame
        frame.setVisible(true);
    }

    public void keyReleased(KeyEvent e) {
        if (e.getSource() == celInput) {
            convertCelsiusToFahrenheit();

        } else if (e.getSource() == fahInput) {
            convertFahrenheitToCelsius();
        }
    }

    public void convertCelsiusToFahrenheit() {
        double cel = Double.parseDouble(celInput.getText());
        double fah = (9.0 / 5.0 * cel) + 32;
        fahInput.setText(String.valueOf(fah));
        clearAfterDelay();
    }

    public void convertFahrenheitToCelsius() {
        double fah = Double.parseDouble(fahInput.getText());
        double cel = (fah - 32) * 5.0 / 9.0;
        celInput.setText(String.valueOf(cel));
        clearAfterDelay();
    }

    private void clearAfterDelay() {
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                celInput.setText("");
                fahInput.setText("");
            }
        });
        timer.setRepeats(false); // Execute only once
        timer.start();
    }

    public static void main(String[] args) {
        labTask1 obj = new labTask1();
    }
}


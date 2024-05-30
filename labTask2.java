import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class labTask2 extends MouseAdapter{
    //Instances Of The Tasks
    JFrame frame;
    JPanel panel;
    JLabel num1Display, num2Display;
    JTextField num1Input, num2Input, num3Output;
    JButton press;

    //Constructor
    labTask2(){
        //Objects
        frame = new JFrame("Addition And Subtraction");
        panel = new JPanel();
        num1Display = new JLabel("Input 1: ");
        num2Display = new JLabel("Input 2: ");
        num1Input = new JTextField();
        num2Input = new JTextField();
        num3Output = new JTextField();
        num3Output.setEditable(false);
        press = new JButton("Find!");

        //Frame Methods
        panel.setLayout(new GridLayout(3,2));
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        //Add MouseListeners
        press.addMouseListener(this);

        //Add Components To The Panel
        panel.add(num1Display);
        panel.add(num1Input);
        panel.add(num2Display);
        panel.add(num2Input);
        panel.add(press);
        panel.add(num3Output);

        //Add Panel To The Frame
        frame.setVisible(true);

    }
    public void mousePressed(MouseEvent e){
        double num1, num2, solution;
        String value;
        num1 = Double.parseDouble(num1Input.getText());
        num2 = Double.parseDouble(num2Input.getText());
        solution = num1 + num2;
        value = String.format("%.2f", solution);
        num3Output.setText(value);
        clearAfterDelay();
    }
    public void mouseReleased(MouseEvent e){
        double num1, num2, solution;
        String value;
        num1 = Double.parseDouble(num1Input.getText());
        num2 = Double.parseDouble(num2Input.getText());
        solution = num1 - num2;
        value = String.format("%.2f", solution);
        num3Output.setText(value);
        clearAfterDelay();
    }

    private void clearAfterDelay() {
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1Input.setText("");
                num2Input.setText("");
                num3Output.setText("");
            }
        });
        timer.setRepeats(false); // Execute only once
        timer.start();
    }

    public static void main(String[] args) {
        labTask2 obj = new labTask2();
    }
}
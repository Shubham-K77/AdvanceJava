import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TabbedQuestion {
    JFrame frame;
    JPanel home, profile, setting;
    JTabbedPane tab;
    JLabel welcome, name, email, random;
    JButton display;
    JTextField emailText, nameText;
    TabbedQuestion(){
        frame = new JFrame("Tabbed Pane");
        home = new JPanel();
        profile = new JPanel();
        setting = new JPanel();
        tab = new JTabbedPane();
        welcome = new JLabel("Welcome to the Home Tab!");
        name = new JLabel("Name: ");
        email = new JLabel("Email: ");
        random = new JLabel("Random: ");
        display = new JButton("Display!");
        emailText = new JTextField();
        nameText = new JTextField();

        //Frame Methods
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(3);

        //Tabbed Pane Methods
        tab.addTab("Home", home);
        tab.addTab("Profile", profile);
        tab.addTab("Setting", setting);

        //Panel Methods
        home.setLayout(new BorderLayout());
        home.add(welcome, BorderLayout.CENTER);
        welcome.setHorizontalAlignment(JLabel.CENTER);
        profile.setLayout(new GridLayout(10, 10, 10,10));
        profile.setSize(500, 300);
        profile.add(name);
        profile.add(nameText);
        profile.add(email);
        profile.add(emailText);
        setting.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        setting.add(random);
        setting.add(display);

        //Add To Frame
        frame.add(tab);
        frame.setVisible(true);
    }
    public static void main(String[] args){
        TabbedQuestion soln = new TabbedQuestion();
    }
}

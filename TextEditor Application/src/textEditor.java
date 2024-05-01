import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class textEditor extends JFrame implements ActionListener, KeyListener{
    ImageIcon image;
    //Constructor
    textEditor(){
        image = new ImageIcon("C:\\Users\\shubh\\IdeaProjects\\textEditor\\Images\\3959355.png");
        this.setIconImage(image.getImage());
        this.setTitle("TextEditor");
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
    }
    //Override The Methods For Action Listener
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    //Override The Methods For Key Listener
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }


}

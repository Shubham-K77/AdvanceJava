import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class textEditor extends JFrame implements ActionListener, ChangeListener{
    ImageIcon image;
    JTextArea textArea;
    JScrollPane scroll;
    JSpinner fontSizeSpinner;
    JLabel fontSize;
    JButton fontColorButton;
    JComboBox fontFamily;
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem openItem, saveItem, exitItem;
    //Constructor
    textEditor(){
        //Instances
        textArea = new JTextArea();
        fontColorButton = new JButton("Color");
        image = new ImageIcon("C:\\Users\\shubh\\IdeaProjects\\textEditor\\Images\\3959355.png");
        scroll = new JScrollPane(textArea); //Add Scroll Pane
        fontSizeSpinner = new JSpinner(); //Spinner Value => Change Listener
        fontSize = new JLabel("Font:");
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(); //Put All The Fonts Available In The Array
        fontFamily = new JComboBox(fonts); //Create The ComboBox
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        //MenuBar Operations
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        //JComboBox Operations
        fontFamily.addActionListener(this);
        fontFamily.setSelectedItem("Arial");

        //JButtons Operations
        fontColorButton.addActionListener(this);

        //FontSize Spinner Operations
        fontSizeSpinner.setPreferredSize(new Dimension(50, 30));
        fontSizeSpinner.setValue(20); //Default Font Size
        fontSizeSpinner.addChangeListener(this);

        //ScrollPane Operations
        scroll.setPreferredSize(new Dimension(450, 450)); //Set Size Of The Scroll Pane That Will Be Size Of The Text Area
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); //Set Vertical Scroll Bar

        //TextArea Operations
        textArea.setLineWrap(true); //Line Wrapping
        textArea.setWrapStyleWord(true); //Line Wrapping
        textArea.setFont(new Font("Arial", Font.PLAIN, 20));

        //Frame Operations
        this.setIconImage(image.getImage()); //Icon Of The Frame
        this.setTitle("TextEditor"); //Title Of The Frame
        this.setDefaultCloseOperation(3); //Closing Operation Of Frame
        this.setSize(500, 580); //Size OF Frame
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 8)); //Flow Layout
        this.setLocationRelativeTo(null); //This Will Make The Frame Appear From The Middle
        this.setResizable(false); //Can't Resize

        //Add Components
        this.setJMenuBar(menuBar);
        this.add(fontSize);
        this.add(fontSizeSpinner);
        this.add(fontColorButton);
        this.add(fontFamily);
        this.add(scroll);
        this.setVisible(true); //Make Visible
    }
    //Override The Methods For Action Listener/ JButton
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == fontColorButton){
            JColorChooser colorChooser = new JColorChooser(); //Color Chooser Box
            Color color = colorChooser.showDialog(null, "Choose A Color", Color.BLACK); //Show Dialog Helps To Get The Selected Color
            textArea.setForeground(color); //Change Color Of The Text
        }
        if(e.getSource() == fontFamily){
            textArea.setFont(new Font((String) fontFamily.getSelectedItem(),Font.PLAIN, textArea.getFont().getSize()));
        }
        if(e.getSource() == openItem){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("C:\\Users\\shubh\\IdeaProjects\\textEditor\\Files")); //Current Directory => .
            //Filter For File Name And Extensions
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
            fileChooser.setFileFilter(filter);
            //Record The Response
            int response = fileChooser.showOpenDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                Scanner fileIn = null;
                try {
                    fileIn = new Scanner(file);
                    if(file.isFile()){
                        while (fileIn.hasNextLine()){
                            String line = fileIn.nextLine() + "\n";
                            textArea.append(line);
                        }
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } finally{
                    fileIn.close();
                }
            }

        }
        if(e.getSource() == saveItem){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("C:\\Users\\shubh\\IdeaProjects\\textEditor\\Files")); //Current Directory => .
            //Record The Response
            int response = fileChooser.showSaveDialog(null); //Yes Or No (1 Or 0)
            if(response == JFileChooser.APPROVE_OPTION){
                File file;
                PrintWriter fileOut = null;
                file = new File(fileChooser.getSelectedFile().getAbsolutePath()); //Path For The New File To Be Written

                try{
                    fileOut = new PrintWriter(file);
                    fileOut.println(textArea.getText());

                }
                catch(FileNotFoundException e1){
                    e1.printStackTrace();
                }
                finally{
                    fileOut.close();
                }
            }
        }
        if(e.getSource() == exitItem){
            System.exit(0);
        }
    }

    //Override The Methods For Change Listener/ JSpinner
    @Override
    public void stateChanged(ChangeEvent e) {
        textArea.setFont(new Font(textArea.getFont().getFamily(), Font.PLAIN, (int) fontSizeSpinner.getValue()));
    }
}

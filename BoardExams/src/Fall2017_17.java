import java.awt.*;
import java.awt.event.*;
public class Fall2017_17 implements ActionListener{
    Frame frame1, frame2;
    Label userLabel, passLabel, actionLabel;
    TextField userText, passText;
    Button submit;
    Font myfont;
    Fall2017_17(){
        //Constructor To Create
        frame1 = new Frame("User Login!");
        userLabel = new Label("Username: ");
        passLabel = new Label("Password: ");
        actionLabel = new Label("Actions: ");
        userText = new TextField();
        passText = new TextField();
        myfont = new Font("Poppins", Font.PLAIN, 22);
        submit = new Button("Submit!");

        //Labels Methods
        userLabel.setFont(myfont);
        passLabel.setFont(myfont);
        actionLabel.setFont(myfont);

        //TextField Methods
        userText.setPreferredSize(new Dimension(300, 20));
        passText.setPreferredSize(new Dimension(300, 20));
        userText.setFont(myfont);
        passText.setFont(myfont);

        //Button Methods
        submit.addActionListener(this);
        submit.setFont(myfont);

        //Frame Closing Methods
        frame1.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame1.dispose();
            }
        });

        //Frame Methods
        frame1.setSize(600,500);
        frame1.setResizable(false);
        frame1.setLayout(new GridLayout(3, 2, 5, 5));
        frame1.add(userLabel);
        frame1.add(userText);
        frame1.add(passLabel);
        frame1.add(passText);
        frame1.add(actionLabel);
        frame1.add(submit);
        frame1.setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == submit){
            if(!userText.getText().equals("") && !passText.getText().equals("")){
                frame2 = new Frame("Special Message");
                Label message = new Label("Message: ");
                TextField output = new TextField();

                //Label Method
                message.setFont(myfont);

                //Textfield Method
                output.setFont(myfont);
                output.setText("Welcome " + userText.getText());
                output.setEditable(false);

                //Frame Closing Method
                frame2.addWindowListener(new WindowAdapter(){
                   public void windowClosing(WindowEvent e){
                       frame2.dispose();
                   }
                });

                //Frame Methods
                frame2.setSize(500, 500);
                frame2.setLocationRelativeTo(null);
                frame2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
                frame2.setResizable(false);
                frame2.add(message);
                frame2.add(output);
                frame2.setVisible(true);
            }
        }
    };
    public static void main(String[] args){
        //Main Method Inside The Class
        Fall2017_17 app = new Fall2017_17();
    };
};


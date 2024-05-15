import javax.swing.*; //For Swing Elements
import java.awt.*; //For AWT Components
import java.awt.event.*; //For Event Handling
public class Calculator implements ActionListener{
    JFrame frame;
    JTextField textField;
    JButton[] numberedButtons = new JButton[10]; //For (0-9) Buttons
    JButton[] functionButtons = new JButton[9]; //For (Operation) Buttons
    JButton addButton, subButton, divButton, mulButton; //Arithmetic Buttons
    JButton decButton, delButton, equalsButton, clrButton, negButton; //Operational Buttons
    JButton sinButton, cosButton, tanButton, roundButton, ceilButton, floorButton, absButton, powButton, srtButton, cubRtButton, logButton, lnButton;
    JButton[] scientificButtons = new JButton[12];
    JPanel panel;
    ImageIcon image;
    Font myFont = new Font("Poppins", Font.PLAIN, 30);
    Font scientificFont = new Font("Ink Free", Font.BOLD, 24);
    double num1=0,num2=0,result=0; //For Decimal Operations
    char operator; //Hold The Character Of The Operation : +, *, -, /, ^, S, C, T, L, l
    Calculator(){ //Constructor To Execute The Program

        //Frame Operations
        frame = new JFrame("Calculator Application");
        image = new ImageIcon("C:\\Users\\shubh\\IdeaProjects\\Calculator\\Images\\icon.png");
        frame.setIconImage(image.getImage());
        frame.setSize(590, 740);
        frame.setDefaultCloseOperation(3);
        frame.setResizable(false);
        frame.setLayout(null);


        //TextFields
        textField = new JTextField();
        textField.setBounds(90, 40, 400, 85);
        textField.setFont(myFont);
        textField.setBackground(new Color(209,231,217,255)); //Background Color
        textField.setForeground(new Color(47,45,48)); //Font Color
        textField.setEditable(false); //Disable The Editing

        //Function Buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("/");
        decButton = new JButton(".");
        delButton = new JButton("Del");
        clrButton = new JButton("Ac");
        negButton = new JButton("(-)");
        equalsButton = new JButton("=");

        //Add Buttons To Array
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = clrButton;
        functionButtons[6] = delButton;
        functionButtons[7] = equalsButton;
        functionButtons[8] = negButton;

        //Scientific Buttons Instances
        sinButton = new JButton("SIN");
        cosButton = new JButton("COS");
        tanButton = new JButton("TAN");
        roundButton = new JButton("RND");
        ceilButton = new JButton("CIL");
        floorButton = new JButton("FLR");
        absButton = new JButton("ABS");
        powButton = new JButton("POW");
        srtButton = new JButton("SRT");
        cubRtButton = new JButton("CRT");
        logButton = new JButton("LOG");
        lnButton = new JButton("LN");


        //Scientific Buttons To Array
        scientificButtons[0] = sinButton;
        scientificButtons[1] = cosButton;
        scientificButtons[2] = tanButton;
        scientificButtons[3] = roundButton;
        scientificButtons[4] = ceilButton;
        scientificButtons[5] = floorButton;
        scientificButtons[6] = absButton;
        scientificButtons[7] = powButton;
        scientificButtons[8] = srtButton;
        scientificButtons[9] = cubRtButton;
        scientificButtons[10] = logButton;
        scientificButtons[11] = lnButton;


        //Add Action Events To Each Button Using For Loop:
        for(int i = 0; i < functionButtons.length; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false); //Avoid The Outline When Button Is Clicked
            functionButtons[i].setForeground(new Color(4,5,4,255));
            functionButtons[i].setBackground(new Color(244,244,242,255));
        }
        negButton.setBackground(new Color(238,109,53,255));
        delButton.setBackground(new Color(238,109,53,255));
        clrButton.setBackground(new Color(238,109,53,255));


        //Numbered Buttons Using Loop
        for(int i = 0; i < 10; i++){
            numberedButtons[i] = new JButton(String.valueOf(i));
            numberedButtons[i].addActionListener(this);
            numberedButtons[i].setFont(myFont);
            numberedButtons[i].setFocusable(false); //Avoid The Outline When Button Is Clicked
            numberedButtons[i].setForeground(new Color(4,5,4,255));
            numberedButtons[i].setBackground(new Color(244,244,242,255));
        }

        //Scientific Buttons Using Loop
        for(int i = 0; i < 12; i++){
            scientificButtons[i].addActionListener(this);
            scientificButtons[i].setFont(scientificFont);
            scientificButtons[i].setFocusable(false);
            scientificButtons[i].setForeground(Color.BLUE);
            scientificButtons[i].setBackground(new Color(244,244,242,255));
        }


        //Delete And Clear Buttons Auto Placement
        delButton.setBounds(90, 580, 120, 50);
        clrButton.setBounds(230, 580, 120, 50);
        negButton.setBounds(365, 580, 120, 50);

        //Panels Add And Layout For The Buttons
        panel = new JPanel();
        panel.setBounds(90, 150, 400, 400);
        panel.setLayout(new GridLayout(7, 4, 10, 10));
        panel.add(numberedButtons[1]);
        panel.add(numberedButtons[2]);
        panel.add(numberedButtons[3]);
        panel.add(addButton);

        panel.add(numberedButtons[4]);
        panel.add(numberedButtons[5]);
        panel.add(numberedButtons[6]);
        panel.add(subButton);

        panel.add(numberedButtons[7]);
        panel.add(numberedButtons[8]);
        panel.add(numberedButtons[9]);
        panel.add(mulButton);

        panel.add(decButton);
        panel.add(numberedButtons[0]);
        panel.add(equalsButton);
        panel.add(divButton);

        panel.add(sinButton);
        panel.add(cosButton);
        panel.add(tanButton);
        panel.add(roundButton);

        panel.add(ceilButton);
        panel.add(floorButton);
        panel.add(absButton);
        panel.add(powButton);

        panel.add(srtButton);
        panel.add(cubRtButton);
        panel.add(logButton);
        panel.add(lnButton);

        //Frame Add And Visibility
        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(negButton);
        frame.add(textField);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) { //Action Handling
        //For Loop To Check Whether The Buttons Are Pressed And If Pressed Will Be Displayed!
        for(int i = 0; i < 10; i++){
            if(e.getSource() == numberedButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        //Add Decimal Functionalities
        if(e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }
        //Add Button Functionalities
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");

        }
        //Sub Button Functionalities
        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");

        }
        //Mul Button Functionalities
        if(e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");

        }
        //Div Button Functionalities
        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");

        }

        //Scientific Buttons Functionalities
        //Sin Function
        if(e.getSource() == sinButton){
            if (!textField.getText().isEmpty()) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.sin(Math.toDegrees(num1));
                textField.setText(String.valueOf(result));
            }
        }
        //Cos Function
        if(e.getSource() == cosButton){
            if (!textField.getText().isEmpty()) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.cos(Math.toDegrees(num1));
                textField.setText(String.valueOf(result));
            }
        }
        //Tan Function
        if(e.getSource() == tanButton){
            if (!textField.getText().isEmpty()) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.tan(Math.toDegrees(num1));
                textField.setText(String.valueOf(result));
            }
        }
        //Round Function
        if(e.getSource() == roundButton){
            if (!textField.getText().isEmpty()) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.round(num1);
                textField.setText(String.valueOf(result));
            }
        }
        //Ceil Function
        if(e.getSource() == ceilButton){
            if (!textField.getText().isEmpty()) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.ceil(num1);
                textField.setText(String.valueOf(result));
            }
        }
        //Abs Function
        if(e.getSource() == absButton){
            if (!textField.getText().isEmpty()) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.abs(num1);
                textField.setText(String.valueOf(result));
            }
        }
        //FLR Function
        if(e.getSource() == floorButton){
            if (!textField.getText().isEmpty()) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.floor(num1);
                textField.setText(String.valueOf(result));
            }
        }
        //SRT Function
        if(e.getSource() == srtButton){
            if (!textField.getText().isEmpty()) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.sqrt(num1);
                textField.setText(String.valueOf(result));
            }
        }
        //CRT Function
        if(e.getSource() == cubRtButton){
            if (!textField.getText().isEmpty()) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.round(Math.pow(num1, 0.3333));
                textField.setText(String.valueOf(result));
            }
        }
        //LOG Function
        if(e.getSource() == logButton){
            if (!textField.getText().isEmpty()) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.log10(num1);
                textField.setText(String.valueOf(result));
            }
        }
        //LN Function
        if(e.getSource() == lnButton){
            if (!textField.getText().isEmpty()) {
                num1 = Double.parseDouble(textField.getText());
                result = Math.log(num1);
                textField.setText(String.valueOf(result));
            }
        }
        //Pow Function
        if(e.getSource() == powButton){
            num1 = Double.parseDouble(textField.getText());
            operator = 'p';
            textField.setText("");
        }

        //Equals Button Functionalities (Main)
        if(e.getSource() == equalsButton){
            num2 = Double.parseDouble(textField.getText());
            switch(operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                case 'p':
                    result = Math.pow(num1, num2);
                    break;
            }
            //Update The Text Field
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        //Clear Button Functionalities
        if(e.getSource() == clrButton){
            num1 = 0;
            textField.setText("");
        }
        //Delete Button Functionalities (Main)
        if(e.getSource() == delButton){
            String str = textField.getText();
            textField.setText("");
            for(int i = 0; i < str.length()-1; i++){
                textField.setText(textField.getText()+str.charAt(i));
            }
        }
        //Negative Button Functionalities
        if(e.getSource() == negButton){
            double temp = Double.parseDouble(textField.getText());
            temp = temp * -1.0;
            num1 = temp;
            textField.setText(String.valueOf(num1));
        }
    }

    public static void main(String[] args){
        Calculator c = new Calculator();
    }

}

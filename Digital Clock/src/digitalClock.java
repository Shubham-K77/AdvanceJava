import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class digitalClock extends JFrame{
    //Instances To Be Used
    SimpleDateFormat timeFormat; //This Will Format The Calendar Object Concrete Class For Formatting And Parsing Dates
    SimpleDateFormat dayFormat; //This Will Format The Day Of The Calendar Object
    SimpleDateFormat dateFormat; //This Will Format The Date Of The Calendar Object
    Font myFontTime, myFontDay, myFontDate; //This Will Be Used To Add Our Font To The Text
    JLabel timeLabel; //This Will Be Used To Display The Time
    JLabel dayLabel; //This Will Be Used To Display The Day
    JLabel dateLabel; //This Will Be Used To Display The Date
    String time; //To Get The Current Time
    String day; //To Get The Current Day
    String date; //To Get The Current Date

    //Constructor To Create The Frame
    digitalClock(){
        //Frame Methods
        this.setTitle("My Digital Clock");
        this.setSize(350, 200);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(3);
        this.getContentPane().setBackground(Color.BLACK); //Background Color Of Frame
        this.setResizable(false);

        //Date Time Format Methods
        timeFormat = new SimpleDateFormat("hh:mm:ss a"); //hh: hour mm: minutes ss: seconds a: am/pm Also hh means hour in 12 hr format HH means hour in 24 hr format.
        dayFormat = new SimpleDateFormat("EEEE"); //Pattern For The Day Of The Week
        dateFormat = new SimpleDateFormat("MMMMM-dd, yyyy"); //Pattern For The Date Of The Today

        //Font Methods
        myFontTime = new Font("Verdana", Font.BOLD, 36);
        myFontDay = new Font("Ink Free", Font.BOLD, 55);
        myFontDate = new Font("Ink Free", Font.BOLD, 36);

        //Label Methods
        timeLabel = new JLabel();
        dayLabel = new JLabel();
        dateLabel = new JLabel();
        timeLabel.setFont(myFontTime);
        dayLabel.setFont(myFontDay);
        dateLabel.setFont(myFontDate);
        dateLabel.setForeground(new Color(0xFF3131)); //Change Color Of Font/Text
        dayLabel.setForeground(new Color(0x04d9ff)); //Change Color Of Font/Text
        timeLabel.setForeground(new Color(0x00FF00)); //Change Color Of Font/Text
        timeLabel.setBackground(Color.BLACK); //Change The Background Color
        dayLabel.setBackground(Color.BLACK); //Change The Background Color
        dateLabel.setBackground(Color.BLACK); //Change The Background Color
        timeLabel.setOpaque(true); //Display The Background Color
        dayLabel.setOpaque(true); //Display The Background Color
        dateLabel.setOpaque(true); //Display The Background Color

        //Utility Methods
        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);

        //Call The Method To Get The Time For Each Second
        setTime();
    }

    //Time Method To Update Time For Each Second
    public void setTime(){
        while(true){
        //String Methods
            time = timeFormat.format(Calendar.getInstance().getTime()); //Used To Convert The Current Date Into String
            day = dayFormat.format(Calendar.getInstance().getTime());   //Used To Convert The Current Date Into String
            date = dateFormat.format(Calendar.getInstance().getTime()); //Used To Convert The Current Date Into String
        //Label Methods
            timeLabel.setText(time);
            dayLabel.setText(day);
            dateLabel.setText(date);
        try{
            Thread.sleep(1000); //Sleep The Method For 1 sec And Again Run //1000 Milliseconds
        }catch(Exception e){
            e.printStackTrace();
        }
        }
    }
    public static void main(String[] args){
        digitalClock clock = new digitalClock(); //Calling The Constructor
    }
}

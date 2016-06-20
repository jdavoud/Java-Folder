import java.awt.*;
import javax.swing.*;

public class calendar {
	public static JFrame frame;
	public static Container content;
	public static JLabel text;
	public static String weekday = "Monday", month = "hi", label;
	public static Integer day = 1, year = 2013;
	public static void main(String[] args) {
		buildFrame();
		setText();
		frame.setVisible(true);
	}
	public static void buildFrame(){
		frame = new JFrame("Calendar");
		frame.setSize(400,400);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		content = frame.getContentPane();
	}
	public static void setText(){
		text = new JLabel();
		label = " " + weekday + ", " + month + " " + day + ", " + year;
		text.setText(label);
		text.setBounds(50,30,100,100);
		content.add(text);
	}
}

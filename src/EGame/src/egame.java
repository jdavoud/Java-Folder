import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Jacob
 */
public class egame {
    
    public static JFrame frame;
    public static Container content;
    public static int Es;
    public static int time;
    public static String le = "";
    public static int length;
    public static JLabel text;
    public static int actionNum;
    public static JLabel actiontext;
    public static String action;
    public static JButton eButton;
    public static JButton copyButton;
    public static JButton pasteButton;
    public static String lt = "";
    public static int actionnum = 0;
    public static String ca = "";
    
    public static void main(String[] args) {
        buildFrame();
        Buttons();
        Etext();
        frame.setVisible(true);
    }
    private static void buildFrame() {
        
        frame = new JFrame("Simple GUI");
        frame.setSize (800,800);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setBackground(new Color(238,238,238));
        content = frame.getContentPane();
        }
    public static void Etext() {
        text = new JLabel();
        text.setSize(800,800);
        text.setText("E's: " + Es + " time " + time + " Length of E " + length);
        text.setBounds(100,50,600,50);
        actiontext = new JLabel();
        actiontext.setSize(800,800);
        actiontext.setText(actiontext.getText());
        actiontext.setBounds(100,100,600,50);
        content.add(text);
        content.add(actiontext);
    }
    public static void Buttons(){
        eButton = new JButton("e");
        eButton.setBounds(100,600,100,100);
        copyButton = new JButton("c");
        copyButton.setBounds(300,600,100,100);
        pasteButton = new JButton("p");
        pasteButton.setBounds(500,600,100,100);
        content.add(eButton);
        content.add(copyButton);
        content.add(pasteButton);
        eButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
                                        time = time + 1;
                                        Es = Es + 1;
                                        action = "Add E";
                                        text.setText("E's: " + Es + " time " + time + " Length of E " + length);
                                        if (le != action){
                                        actiontext.setText(actiontext.getText() + (" ") + action + (","));
                                        le = "Add E";
                                        }
                                        else{
                                        actiontext.setText(lt + " " + actionnum + " " + action + ",");
                                        lt = actiontext.getText();
                                        }
			}
		});
        copyButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
                                        length = Es;
                                        time = time + 12;
                                        action = "Copy";
                                        text.setText("E's: " + Es + " time " + time + " Length of E " + length);
                                        if (le != action){
                                        actiontext.setText(actiontext.getText() + (" ") + action + (","));
                                        le = "Copy";
                                        }
                                        else{
                                        actiontext.setText(lt + " " + action + ",");
                                        lt = actiontext.getText();
                                        }
			}
		});
        pasteButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
                                        time = time + 1;
                                        Es = Es + length;
                                        action = "Paste";
                                        text.setText("E's: " + Es + " time " + time + " Length of E " + length);
										if (le != action){
	                                    actiontext.setText(actiontext.getText() + (" ") + action + (","));
	                                    le = "Paste";
	                                    }
	                                    else{
	                                    actiontext.setText(lt + " " + action + ",");
	                                    lt = actiontext.getText();
	                                    }
			}
				
		});
    }
}

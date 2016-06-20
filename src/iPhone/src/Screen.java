import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class Screen extends JPanel{
	
	//public static JPanel panel = new JPanel();
	public Screen() {
		setLayout(null);
		setBounds(25,25,300,534);
		setBorder(new LineBorder(Color.black,2,true));
	}
	public JPanel JPanel(){
		return this;
	}
	public void setJPanel(JPanel newPanel){
		removeAll();
		add(newPanel);
	}
}

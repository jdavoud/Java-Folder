import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class App extends JPanel {
	public static JButton appButton = new JButton();
	public static JLabel appName = new JLabel(""); 
	public App(JButton button,String nameOfApp){
		new JPanel();
		appButton = button;
		appButton.setSize(65, 65);
		add(appButton);
		appName.setText(nameOfApp);
		add(appName);
	}
	public JButton button(){
		return appButton;
	}
	public JLabel name(){
		return appName;
	}
}

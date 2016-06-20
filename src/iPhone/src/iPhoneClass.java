import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


public class iPhoneClass extends JFrame implements ActionListener  {

	/**
	 * @param args
	 */
	public static JPanel phone;
	
	public static Screen lockScreen = new Screen();
	public static Screen homeScreen = new Screen();
	public static Screen currentScreen = homeScreen;
	public static JFrame frame;
	public static JButton homeButton;
	public static App[] apps = new App[16];
	public static final JButton open = new JButton("Unlock");
	public static Container content;
	//public static String currentScreen = "lockScreen";
	
	
	public static void main(String[] args) {
		new iPhoneClass();
	}
	public iPhoneClass() {
		buildFrame();
		buildScreens();
		buildPhone();
		frame.setVisible(true);
	}
	public void buildFrame(){
		frame = new JFrame();
		frame.setSize(400,700);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		content = frame.getContentPane();
	}
	public void buildPhone(){
		
		homeButton = new JButton("[]");
		homeButton.setBounds(125, 569, 100, 55);
		homeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				currentScreen.remove(homeScreen);
				currentScreen.revalidate();
				currentScreen.repaint();
				currentScreen.add(lockScreen);
				currentScreen.revalidate();
				currentScreen.repaint();
				homeButton.setText("[]");
			}
		});
		
		phone = new JPanel();
		phone.setLayout(null);
		phone.setBounds(25,33,350,634);
		phone.setBorder(new LineBorder(Color.black,2,true));
		phone.add(currentScreen);
		phone.add(homeButton);
		content.add(phone);
		
		
	}
	public void buildScreens(){
		
		open.setBounds(50,25,200,100);
		lockScreen.add(open);
		//open.addActionListener(this);
		open.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				currentScreen.setJPanel(homeScreen);
				currentScreen.revalidate();
				currentScreen.repaint();
				homeButton.setText("JEW");
			}
		});
		
		/*apps[0] = new App(new JButton(),"Clock");
		homeScreen.add(apps[0]);
		apps[1] = new App(new JButton(),"Jew");
		for (int i = 0; i < apps.length; i++){
			if(apps[i] != null){
				apps[i].button().addActionListener(this);
				homeScreen.add(apps[i]);
			}
		}*/
		JLabel jl = new JLabel("jew");
		jl.setBounds(100,100,100,100);
		homeScreen.add(jl);
		
	}
	public void setScreen(Screen s){
		currentScreen = s;
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		//((JButton)event.getSource()).setVisible(false);
		if(((JButton)event.getSource()).equals(open)){
			//setScreen(lockScreen);
			setScreen(homeScreen);
		}
	}
}

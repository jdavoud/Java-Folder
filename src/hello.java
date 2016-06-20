import java.awt.Container;
import javax.swing.JFrame;

public class hello {
	public static JFrame frame;
	public static Container content;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}
	
	public static void BuildFrame() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(800,400);
		frame.setTitle("Jacob D.");
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		content = frame.getContentPane();
	}
}

import javax.swing.JFrame;

public class javaGraphics {

	public static JFrame frame;
	
	public static void main(String[] args) {
		buildFrame();
		makeDrawings();
		frame.setVisible(true);
	}
	public static void makeDrawings(){
		drawings d = new drawings();
		frame.add(d);
	}
	public static void buildFrame(){
		frame = new JFrame();
		frame.setSize(400,480);
		frame.setTitle("A Window");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

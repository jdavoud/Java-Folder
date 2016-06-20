	package JavaApplication1;

	import java.*;
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;
	public class Game {

	/**
	 * @param args
	 */
	
	private static JFrame frame;
	private static Container content;
	private static JMenuBar menubar;
	private static JButton sb;
	public static int min = 0;
	public static int max = 400;
	public static int g = (int)((max+min)/2);;
	public static boolean started = false;
	public static int guesses = 1;
	public static JLabel text;
	public static JLabel text1;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		buildFrame();
		buildMenu();
		buildText();
		b();
		frame.setVisible(true);
	}
		public static void buildFrame() {
			frame = new JFrame();
			frame.setSize(800,400);
			frame.setTitle("Jacob D.");
			frame.setResizable(false);
			frame.setLayout(null);
			frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			content = frame.getContentPane();
	}
		public static void er(){
			final JButton rstart;
			final JButton exit;
			
			exit = new JButton ("Exit");
			exit.setBounds(400,150,100,40);
			rstart = new JButton ("Restart");
			rstart.setBounds(300,150,100,40);
			exit.setVisible(true);
			rstart.setVisible(true);
			content.add(exit);
			content.add(rstart);
			rstart.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					started = false;
					buildMenu();
					text.setBounds(320,150,400,40);
					exit.setVisible(false);
					rstart.setVisible(false);
					
					min = 0;
					max = 400;
                    g = (int)((max+min)/2);;
					text.setText("Pick a number between "+min+ " and " +max+" and I'll guess it");
					buildMenu();
					b();
				}
			});
				exit.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
				}
			});
		}
                
		public static void b(){
			final JButton fb;
			final JButton fb1;
			final JButton fb2;
			text.setBounds(230,100,400,40);
			sb = new JButton ("Start Game");
			sb.setBounds(320,150,100,40);
			content.add(sb);
			fb = new JButton("Too Low");
			fb.setBounds(300,150,100,40);
			fb.setForeground(new Color(0,0,0));
			fb1 = new JButton("Too High");
			fb1.setBounds(400,150,100,40);
			fb.setForeground(new Color(0,0,0));
			fb2 = new JButton("Guessed It");
			fb2.setBounds(350,215,100,40);
			fb2.setForeground(new Color(0,0,0));
			content.add(fb);
			content.add(fb1);
			content.add(fb2);	
			fb.setVisible(false);
			fb1.setVisible(false);
			fb2.setVisible(false);
			if(started==false){
				fb.setVisible(false);
				fb1.setVisible(false);
				fb2.setVisible(false);
				sb.setVisible(true);
				guesses = 1;
			}
			sb.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					text.setBounds(375,100,100,40);
					text.setText("Is it "+ g);
					started = true;
					buildMenu();
					sb.setVisible(false);
					fb.setVisible(true);
					fb1.setVisible(true);
					fb2.setVisible(true);
					guesses();
			}
		});
			fb.addActionListener(new ActionListener(){	
				public void actionPerformed(ActionEvent e) {
					text.setBounds(375,100,100,40);
					min = g + 1;
					g = (int)((min+max)/2);
					text.setText("Is it "+ g);
					fb.setVisible(true);
					fb1.setVisible(true);
					fb2.setVisible(true);
					guesses = guesses+1;
					text1.setText("Number of guesses: "+guesses);
			}
		});
			fb1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					text.setBounds(375,100,100,40);
					max = g - 1;
					g = (int)((min+max)/2);
					text.setText("Is it "+ g);
					fb.setVisible(true);
					fb1.setVisible(true);
					fb2.setVisible(true);
					guesses = guesses+1;
					text1.setText("Number of guesses: "+guesses);
			}
		});
			fb2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					text.setBounds(350,100,150,40);
					if (guesses!=1){
						text.setText("I got it in "+guesses+" guesses.");
					}
					else {
						text.setText("I got it in "+guesses+" guess.");
					}
					fb.setVisible(false);
					fb1.setVisible(false);
					fb2.setVisible(false);
					er();
			}
		});
	}
		public static void buildMenu() {
			
			JMenuItem min1;
			JMenuItem min2;
			JMenuItem min3;
			JMenuItem max1;
			JMenuItem max2;
			JMenuItem max3;
			JMenu me2;
			JMenu me4;
			JMenuItem mi;
			JMenuItem mi4;
			JMenuItem mi2;
			JMenu me3;
			JMenuItem mi3;
			JMenu me;
			JMenu exit;
			JMenuItem e;
			e = new JMenuItem("Exit");
			exit = new JMenu("Exit");
			max1 = new JMenuItem("100");
			max2 = new JMenuItem("200");
			max3 = new JMenuItem("400");
			min1 = new JMenuItem("0");
			min2 = new JMenuItem("10");
			min3 = new JMenuItem("50");
			me2 = new JMenu("Set Min");
			me4 = new JMenu("Set Max");
			me = new JMenu("Background Colors");
			menubar = new JMenuBar();
			mi = new JMenuItem("White");
			mi4 = new JMenuItem("Blue");
			mi2 = new JMenuItem("Green");
			me3 = new JMenu("Game Settings"); 
			mi3 = new JMenuItem("Red");
			menubar.setForeground(new Color(0,255,0));
			menubar.setBackground(new Color(255,0,0));
			content.add(menubar);
			me.add(mi);
			menubar.add(me);
			me.add(mi4);
			me.add(mi2);
			me.add(mi3);
			menubar.add(exit);
			exit.add(e);
			if (started==false){
				menubar.add(me3);
				me3.add(me2);
				me3.add(me4);
				me2.add(min1);
				me2.add(min2);
				me2.add(min3);
				me4.add(max1);
				me4.add(max2);
				me4.add(max3);
			}

			frame.setJMenuBar(menubar);
			if(started==false){
				min1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						min = 0;
						text.setText("Pick a number between "+min+ " and " +max+" and I'll guess it");
						g = (int)((min+max)/2);
					}
				});
				min2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						min = 10;
						text.setText("Pick a number between "+min+ " and " +max+" and I'll guess it");
						g = (int)((min+max)/2);
					}
				});
				min3.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						min = 50;
						text.setText("Pick a number between "+min+ " and " +max+" and I'll guess it");
						g = (int)((min+max)/2);
					}
				});
				max1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						max = 100;
						text.setText("Pick a number between "+min+ " and " +max+" and I'll guess it");
						g = (int)((min+max)/2);
					}
				});
				max2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						max = 200;
						text.setText("Pick a number between "+min+ " and " +max+" and I'll guess it");
						g = (int)((min+max)/2);
					}
				});
				max3.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						max = 400;
						text.setText("Pick a number between "+min+ " and " +max+" and I'll guess it");
						g = (int)((min+max)/2);
					}
				});
			}	
			mi.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					content.setBackground(new Color(255,255,255));
				}
			});
			mi4.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					content.setBackground(new Color(0,0,255));
				}
			});
			mi2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					content.setBackground(new Color(0,255,0));
				}
			});
			mi3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					content.setBackground(new Color(255,0,0));
				}
			});
			e.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
				}
			});
			
		}
		public static void buildText(){
			text = new JLabel("Pick a number between "+min+ " and " +max+" and I'll guess it");
			text.setBounds(350,100,300,50);
			content.add(text);		
		}
		public static void guesses(){
			guesses = 1;
			text1 = new JLabel("Number of guesses: "+guesses);
			text1.setVisible(false);
			text1.setBounds(100,50,200,40);
			content.add(text1);
		}
}

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
public class StockChecker implements DocumentListener, ActionListener {
	/**
	 * @param args
	 */
	public static JFrame frame;
	public static Container content;
	public static JLabel searchLabel;
	public static JTextField searchBar;
	public static JTextArea textArea;
	public static JPanel panel;
	public static JScrollPane scroll;
	public static JMenuBar menuBar;
	public static String sortByString = "";
	
	public static void main(String[] args) {
		//new StockChecker();
		//frame.setVisible(true);
		 System.out.println(searchForStock("AAPL"));
	}
	public StockChecker(){
		
		frame = new JFrame("Subreddit Reader");
		frame.setSize(500,740);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setLayout(null);
		//content = frame.getContentPane();
		
		panel = new JPanel();
		
		searchLabel = new JLabel("Subreddit:");
		panel.add(searchLabel);
		
		searchBar = new JTextField("Search For A Sub",30);
		searchBar.addActionListener(this);
		panel.add(searchBar);
		
		textArea = new JTextArea(40,37);
		textArea.setEditable(false);
        scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scroll);
		
		
		frame.add(panel);
		
		/*menuBar = new JMenuBar();
		JMenu sortBy = new JMenu("Sort By");
		menuBar.add(sortBy);
		JMenuItem hot = new JMenuItem("Hot");
		JMenuItem new1 = new JMenuItem("New");
		JMenuItem rising = new JMenuItem("Rising");
		
		sortBy.add(hot);
		sortBy.add(new1);
		sortBy.add(rising);
		
		hot.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				sortByString = "";
				textArea.setText(searchForSub(searchBar.getText()));
			}
		});
		new1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				sortByString = "/new/";
				textArea.setText(searchForSub(searchBar.getText()));
			}
		});
		rising.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				sortByString = "/rising/";
				textArea.setText(searchForSub(searchBar.getText()));
			}
		});
		frame.setJMenuBar(menuBar);*/
		
	}
	public static String fixLine(String inputLine){
		String fixedLine = inputLine;
		fixedLine.replaceAll("&quot;", "'");
		fixedLine.replaceAll("&lt;", "<");
		fixedLine.replaceAll("&gt;", ">");
		return fixedLine;
	}
	public static String searchForStock(String company) {
		try {
			String StockURL = "http://feeds.finance.yahoo.com/rss/2.0/headline?s=" + company + "&region=US&lang=en-US";
			URL rssURL = new URL(StockURL);
			BufferedReader ln = new BufferedReader(new InputStreamReader(rssURL.openStream()));
			String headLine = "";
			String sourceCode = "JEW";
			String line;
			while((line = ln.readLine()) != null){
				if(line.contains("yfs_l84_" + company)){
					int firstPos = line.indexOf("yfs_l84_" + company) + new String("yfs_l84_" + company).length() + 2;
					int lastPos = line.indexOf("</span>",firstPos);
					headLine = line.substring(firstPos,lastPos);
					sourceCode += headLine + "\n";
				}
			}
			
			ln.close();
			//return company + " " + sourceCode;
			return String.valueOf(ln);
			
		} catch (MalformedURLException e) {
			return "Malformed URL";
		} catch (IOException e) {
			return "Error Loading";
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		textArea.setText(searchForStock(searchBar.getText()));
	}
	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void insertUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}


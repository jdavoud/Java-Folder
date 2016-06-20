import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
public class SubredditReaderGUI implements DocumentListener, ActionListener {
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
		new SubredditReaderGUI();
		frame.setVisible(true);
	}
	public SubredditReaderGUI(){
		
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
		
		menuBar = new JMenuBar();
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
		frame.setJMenuBar(menuBar);
		
	}
	public static String fixLine(String inputLine){
		String fixedLine = inputLine;
		fixedLine.replaceAll("&quot;", "'");
		fixedLine.replaceAll("&lt;", "<");
		fixedLine.replaceAll("&gt;", ">");
		return fixedLine;
	}
	public static String searchForSub(String sub) {
		try {
			String redditRSS = "http://www.reddit.com/r/"+ sub.toLowerCase() + sortByString + ".rss";
			URL rssUrl = new URL(redditRSS);
			BufferedReader ln = new BufferedReader(new InputStreamReader(rssUrl.openStream()));
			String headLine = "";
			String sourceCode = "";
			String line;
			while((line = ln.readLine()) != null){
				line = fixLine(line);
				line = line.substring(line.indexOf("<title>" ,line.indexOf("<title>")) + "<title>".length(), line.length());
				int hnum = 0;
				for(int i = 0; i < line.length(); i++){
					String tag = "title";
					String tagWithBrackets = "<" + tag + ">";
					String closingTagWithBrackets = "</"+ tag + ">";
					if(i + tagWithBrackets.length() < line.length() - 1){
						if(line.substring(i, i + tagWithBrackets.length()).equals(tagWithBrackets)){
							
							int firstPosition = (i + tagWithBrackets.length());
							String user = "Submitted by " + line.substring(line.indexOf("user/",firstPosition) + 5, line.indexOf("&#34",line.indexOf("user/",firstPosition) + 5));
							if(hnum < 1){user="";}
							int length = (line.indexOf(closingTagWithBrackets, firstPosition) - firstPosition);
							int lastPosition = firstPosition + length;
							if(length > 65){
								while(length > 65){
									int distanceFromLastSpaceToEnd = 0;
									headLine = line.substring(firstPosition,firstPosition+65);
									
									if(headLine.startsWith(" ")){
										headLine = headLine.substring(1, headLine.length());
									}
									distanceFromLastSpaceToEnd = headLine.length() - headLine.lastIndexOf(" ");
									headLine = headLine.substring(0,headLine.lastIndexOf(" "));
									sourceCode += headLine + "\n";
									firstPosition += 65 - distanceFromLastSpaceToEnd;
									length -= 65 - distanceFromLastSpaceToEnd;
								}
							}
							headLine = line.substring(firstPosition,lastPosition);
							if(headLine.startsWith(" ")){
								headLine = headLine.substring(1, headLine.length());
							}
							hnum++;
							if(hnum > 0){
								sourceCode += headLine + "\n" + user + " " + "\n" + "\n";
							}
						}	
					}
				}
			}
			
			ln.close();
			//sourceCode = sourceCode.substring(sourceCode.indexOf("\n",sourceCode.indexOf("\n")),sourceCode.length());
			return sourceCode;
			
		} catch (MalformedURLException e) {
			return "Malformed URL";
		} catch (IOException e) {
			return "Error Loading";
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		textArea.setText(searchForSub(searchBar.getText()));
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


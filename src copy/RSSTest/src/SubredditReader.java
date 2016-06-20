import java.io.*;
import java.net.*;
public class SubredditReader {

	/**
	 * @param args
	 */
	//public static String[] linesWithTitle = new String[numberOfTimesContains(line,"<title>")];
	public static void main(String[] args) {
		System.out.println(SubredditRss("worldnews"));
	}

	public static String SubredditRss(String sub) {
		try {
			String redditRSS = "http://www.reddit.com/r/news/.rss";
			redditRSS = redditRSS.replaceAll("news", sub.toLowerCase());
			URL rssUrl = new URL(redditRSS);
			BufferedReader ln = new BufferedReader(new InputStreamReader(rssUrl.openStream()));
			String headLine = "";
			String sourceCode = "";
			String line;
			boolean prevLineContainsTitle = true;
			while((line = ln.readLine()) != null){
//				sourceCode += linesInTag(line,"title").length + "\n";
//				for(int i = 0; i < linesInTag(line,"title").length;i++){
//					headLine = linesInTag(line,"title")[i];
//					sourceCode += i + " " + headLine + "\n";
//				}
//				
				for(int i = 0; i < line.length(); i++){
					String tag = "title";
					String tagWithBrackets = "<" + tag + ">";
					String closingTagWithBrackets = "</"+ tag + ">";
					if(i + tagWithBrackets.length() < line.length() - 1){
						if(line.substring(i, i + tagWithBrackets.length()).equals(tagWithBrackets)){
							
							int firstPosition = (i + tagWithBrackets.length());
							int length = (line.indexOf(closingTagWithBrackets, firstPosition) - firstPosition);
							int lastPosition = firstPosition + length;
							headLine = line.substring(firstPosition,lastPosition);
							sourceCode += headLine + "\n";
						}	
					}
				}
			}
			
			ln.close();
			return sourceCode;
			
		} catch (MalformedURLException e) {
			return "Malformed URL";
		} catch (IOException e) {
			return "Error reading line";
		}
		
	}
	public static int numberOfTimesContains(String container, String item){
		int num = 0;
		for (int i = 0; i < container.length(); i++){
			if(i + item.length() < container.length() - 1){
				if(container.substring(i, i + item.length()).equals(item)){
					num++;
				}
			}
		}
		return num;
	}
}


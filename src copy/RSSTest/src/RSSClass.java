import java.io.*;
import java.net.*;
public class RSSClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(readRss(""));
	}

	public static String readRss(String urlAddress) {
		try {
			URL rssUrl = new URL(urlAddress);
			BufferedReader ln = new BufferedReader(new InputStreamReader(rssUrl.openStream()));
			String headLine = "";
			String sourceCode = "";
			String line;
			while((line = ln.readLine()) != null){
				if(line.contains("<title>")){
					int firstPos = line.indexOf("<title>") + "<title>".length();
					int lastPos = line.indexOf("</title>");
					headLine = line.substring(firstPos,lastPos);
					sourceCode += headLine + "\n";
				}
			}
			
			ln.close();
			return sourceCode;
		} catch (MalformedURLException e) {
			return ("Malformed URL");
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return ("Error reading line");
		}
	}

}

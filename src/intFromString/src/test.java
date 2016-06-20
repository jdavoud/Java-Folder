import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class test {
public static int num,num1,num2;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	String str = "no";
	String regex ="(\\d+)";
	Matcher matcher = Pattern.compile( regex ).matcher( str);
	while (matcher.find()) { // for each match
	    num = (Integer.parseInt(matcher.group())); // convert to int
	}
	System.out.println(num);
	}
	
}

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class onetwothreegame {

	/**
	 * @param args
	 */
	public static int b = 21;
	public static boolean r = false;
	public static int c;
	public static boolean yourTurn;
	
	public static void main(String[] args) {
		System.out.println("Whoever makes the opponent get to 1 first wins");
		while(true){
			
			if(b!=1){
				r = false;
				Scanner keyboard = new Scanner(System.in);
				System.out.println("1, 2, or 3?");
				String a = keyboard.nextLine();
				
				String regex ="(\\d+)";
				Matcher matcher = Pattern.compile( regex ).matcher( a);
				while (matcher.find()) { // for each match
				    c = (Integer.parseInt(matcher.group())); // convert to int
				}
				if(a.equals("restart")){
					b = 21;
					System.out.println("Restart");
				}
				if(c == 1||c==2||c==3&&c!=0){
					System.out.println("You chose " + c);
					System.out.println(b + " - " + c + " = " + new Integer(b-c));
					b -= c;
					System.out.println("CPU chose " + new Integer(4-c));
					System.out.println(b + " - " + new Integer(4-c) + " = " + new Integer(b - new Integer(4-c)));
					b = b + c - 4;
					c = 0;
				}
				
				else{
					if(!a.equals("restart")){
						System.out.println("Try Again");
					}
				}
			}
			if(b==1){
				
				if(!r){
					System.out.println(b);
					System.out.println("CPU wins");
				}
				
				while(!r){
					
					Scanner keyboard1 = new Scanner(System.in);
					System.out.println("Restart? (yes/no)");
					String s = keyboard1.nextLine();
					
					if(s.equals("yes")){
						b = 21;
						r = true;
					}
					if(s.equals("no")){
						r = true;
					}
				}
				while(r){
					Scanner keyboard1 = new Scanner(System.in);
					String s = keyboard1.nextLine();
					if(s.equals("restart")){
						b = 21;
						r = false;
					}
				}
			}
		}	
	}
}

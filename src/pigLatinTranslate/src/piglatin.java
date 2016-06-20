import java.util.Scanner;


public class piglatin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input;
		System.out.println("Translate to pig latin");
		Scanner scan = new Scanner(System.in);
		input = scan.nextLine();
		
		input = input.substring(1,input.length()) + input.substring(0, 1) + "ay";
		System.out.println(input);
	}

}

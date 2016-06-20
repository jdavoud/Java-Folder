import java.util.Scanner;


public class pigLatinAdvanced {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input;
		while(true){
			System.out.println("Translate to pig latin");
			Scanner scan = new Scanner(System.in);
			input = scan.nextLine();
			if(input.startsWith("a") || input.startsWith("e") || input.startsWith("i")
				|| input.startsWith("o") || input.startsWith("u")){
			
				input = input.substring(1,input.length()) + "ay";
			} else {
				input = input.substring(1,input.length()) + input.substring(0,1) + "ay";
			}
			System.out.println(input);
		}
	}

}

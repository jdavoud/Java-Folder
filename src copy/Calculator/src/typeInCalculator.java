import java.util.Scanner;


public class typeInCalculator {

	/**
	 * @param args
	 */
	public static String error = "Errors: ";
	public static String originalLine;
	public static String line;
	public static void main(String[] args) {
		while(true){
			askForLine();
			answer();
		}
	}
	public static void askForLine(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Calculator: ");
	    line = scan.nextLine();
	}
	/*public static void scanLine(){
		line.replaceAll(" ", "");
		if(numberOf("(") == numberOf(")")){
			if(numberOf("(") != 0){
				for(int i = 0; i < line.length(); i++){
					if(line.substring(i, i + 1).equals("(")){
						if(line.indexOf(")",i) < line.indexOf("(",i)){
							
						}
					}
				}
			}
		} else {
			System.out.println("Parentheses don't match!");
		}
	}
	public static int doTheMath(String s){
		int answer;
		if(s.contains("/") || s.contains("*") || s.contains("+") || s.contains("-") || s.contains("^")){
			
		} else {
			Boolean allAreNumbers = true;
			for(int i = 0; i < s.length(); i++){
				if(s.substring(i).equals("0") || s.substring(i).equals("1") || s.substring(i).equals("2") || 
						s.substring(i).equals("3") || s.substring(i).equals("4") || s.substring(i).equals("5") || 
						s.substring(i).equals("6") || s.substring(i).equals("7") || s.substring(i).equals("8") || 
						s.substring(i).equals("9")){
					
					
				} else { //if one of the letters in not 0-9
					allAreNumbers = false;
				}
			}
			if(allAreNumbers){
				//answer = 
			}
		}
		
		return answer;
	}*/
	
	public static String answer(String s){
		s = String.valueOf(getFromString(s));
		
		return s;
	}
	public static void answer(){
		originalLine = line;
		line = line.replace("÷", "/");
		line = line.replace("X", "*");
		int t = 0;
		while(numberOf("/") > 0 || numberOf("*") > 0 || numberOf("+") > 0 || numberOf("-") > 0){
			t = 1;
			if(numberOf("(") != numberOf(")")){
				error += "\n parantheses dont match";
			}
			while(numberOf("(") == numberOf(")") && numberOf("(") > 0){	
				t = 2;
				for(int i = 0; i < line.length(); i++){
					t = 3;
					//s = s + line.substring(i,i+1) + " ";
					
					if(line.substring(i,i+1).equals(")")){
						t = 4;
						if(line.indexOf(")",i) < line.indexOf("(",i)){
							//s = s.substring(0, s.indexOf(")",i)) + answer(s.substring(i,s.indexOf(")",i))) + s.substring(0, s.indexOf(")",i));
							t = 5;
							line = line.substring(0,i) + getFromString(line.substring(i+1,line.indexOf(")",i+1))) + line.substring(line.indexOf(")",i+1) + 1,line.length());
						}
					}
				}
			}
			while(numberOf("*") > 0 || numberOf("/") > 0){
				t = 2;
				for(int i = 0; i < line.length(); i++){
					/*if(line.substring(i,i+1).equals("(")){
						t = 3;
						if(line.indexOf(")") < line.indexOf("(")){
							//s = s.substring(0, s.indexOf(")",i)) + answer(s.substring(i,s.indexOf(")",i))) + s.substring(0, s.indexOf(")",i));
							t = 4;
						}
					}*/
					if(line.substring(i,i+1).equals("*") || line.substring(i,i+1).equals("/")){
						
					}
				}
			}
			while(numberOf("+") > 0 || numberOf("-") > 0){
				t = 2;
				for(int i = 0; i < line.length(); i++){
					if(line.substring(i,i+1).equals("(")){
						t = 3;
						if(line.indexOf(")") < line.indexOf("(")){
							//s = s.substring(0, s.indexOf(")",i)) + answer(s.substring(i,s.indexOf(")",i))) + s.substring(0, s.indexOf(")",i));
							t = 4;
						}
					}
				}
			}
		}
		
		
		
		if(numberOf(")") > 0 || numberOf("(") > 0){
			line = line.replace(")","");
			line = line.replace("(","");
			//error  += "\nAre paren left \n num of ) = " + numberOf(")") + "\n num of ( = " + numberOf("(");
		}
		if(numberOf(")") != numberOf("(")){
			error += "\nParen dont match";
		}
		String allAreNum = "All the letters are numbers";
		for(int i = 0; i < line.length(); i++){
			if(line.substring(i,i+1).equals("0") || line.substring(i,i+1).equals("1") || line.substring(i,i+1).equals("2") || 
					line.substring(i,i+1).equals("3") || line.substring(i,i+1).equals("4") || line.substring(i,i+1).equals("5") || 
					line.substring(i,i+1).equals("6") || line.substring(i,i+1).equals("7") || line.substring(i,i+1).equals("8") || 
					line.substring(i,i+1).equals("9") || line.substring(i,i+1).equals(".")){
				
			} else {
				if(allAreNum.startsWith("All")){
					allAreNum = "Not all the letters are numbers";
				}
				allAreNum += "\n line of " + i + " is not a num, it is " + line.substring(i,i+1);
			}
		}
		if(!allAreNum.startsWith("All")){
			error += "\n" + allAreNum;
		}
		if(error != "Errors: "){
			line += "\n" + error;
		}
		//return String.valueOf(t);
		error = "Errors: ";
		System.out.println("Answer:\n" + originalLine + " = " + line);
	}
	public static int prevIndexOfOp(int end){
		int n = 0;
		if(line.substring(0,end).contains("-")){
			if(line.lastIndexOf("-",end) < n){
				n = line.lastIndexOf("-",end);
			}
		}
		if(line.substring(0,end).contains("+")){
			if(line.lastIndexOf("+",end) < n){
				n = line.lastIndexOf("+",end);
			}
		}
		if(line.substring(0,end).contains("*")){
			if(line.lastIndexOf("*",end) < n){
				n = line.lastIndexOf("*",end);
			}
		}
		if(line.substring(0,end).contains("/")){
			if(line.lastIndexOf("/",end) < n){
				n = line.lastIndexOf("/",end);
			}
		}
		return n;
		
	}
	public static int nextIndexOfOp(int start){
		int n = line.length();
		if(line.substring(start).contains("-")){
			if(line.indexOf("-",start) < n){
				n = line.indexOf("-",start);
			}
		}
		if(line.substring(start).contains("+")){
			if(line.indexOf("+",start) < n){
				n = line.indexOf("+",start);
			}
		}
		if(line.substring(start).contains("*")){
			if(line.indexOf("*",start) < n){
				n = line.indexOf("*",start);
			}
		}
		if(line.substring(start).contains("/")){
			if(line.indexOf("/",start) < n){
				n = line.indexOf("/",start);
			}
		}
		
		return n;
		
	}
	public static int numberOf(String s){
		int n = 0;
		for (int i = 0; i < line.length(); i++){
			if(line.substring(i,i+1).equals(s)){
				n++;
			}
		}
		return n;
	}
	public static double getFromString(String s){
		double num1 = 0, num2 = 0;
		String op = "";
		String[] whatLettersAre = new String[s.length()];
		for(int i = 0; i < s.length(); i++){
			if(s.substring(i,i+1).equals("0") || s.substring(i,i+1).equals("1") || s.substring(i,i+1).equals("2") || 
					s.substring(i,i+1).equals("3") || s.substring(i,i+1).equals("4") || s.substring(i,i+1).equals("5") || 
					s.substring(i,i+1).equals("6") || s.substring(i,i+1).equals("7") || s.substring(i,i+1).equals("8") || 
					s.substring(i,i+1).equals("9")){
				whatLettersAre[i] = "Number " + s.substring(i,i+1);
			} else if (s.substring(i,i+1).equals("*") || s.substring(i,i+1).equals("+") || s.substring(i,i+1).equals("-") ||
					s.substring(i,i+1).equals("/")){
				whatLettersAre[i] = "String " + s.substring(i,i+1);
				
			} else {
				error += "\n" + String.valueOf(i) + " letter of getFromString of " + s + " error";
				
			}
		}
		int howManyAreString = 0;
		for(int i = 0; i < whatLettersAre.length; i++){
			if(whatLettersAre[i].startsWith("String")){
				howManyAreString++;
			}
		}
		if(howManyAreString == 0){
			return Double.parseDouble(s);
		}
		else if(howManyAreString == 1){
			for(int i = 0; i < whatLettersAre.length; i++){
				if(whatLettersAre[i].startsWith("String")){
					op = s.substring(i,i+1);
				}
				num1 = Double.parseDouble(s.substring(0,i));
				num2 = Double.parseDouble(s.substring(i+1,s.length()));
			}
			return doTheMath(num1,op,num2);
		} else {
			error += "\n + getFromString of " + s + " has more than one operation";
			return 0;
		}
	}
	public static double doTheMath(double num1, String op, double num2){
		double answer = 0;
		if(op.equals("*")){
	    	answer = (num1*num2);
		} 
		else if(op.equals("/")) {
			answer = (num1/num2);
		}
		else if(op.equals("+")) {
			answer = (num1+num2);
		}
		else if(op.equals("-")) {
			answer = (num1-num2);
		}
		return answer;
	}
}

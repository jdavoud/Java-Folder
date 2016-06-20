
public class Function{
	public static String answer = "";
	public static int logNum = 0;
	public static String[] ops = new String[] {"^","+","-","*","/"};
	
	
	public Function(String s){
		//answer = s;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//answer = "y = x";
		log("Answer: " + String.valueOf(textFunc(5.0,"(x*-1)*2")));
		
	}
	//public static String getFunc(){
		//return textFunc(answer);
		
	//}
	
	
	public static Double textFunc(Double input, String answer){
		Boolean isError = false;
		
		String originalAnswer = answer;
		
		answer = answer.replaceAll(" ", "");
		if(String.valueOf(input).contains("E")){
			input = Double.parseDouble(String.valueOf(input).substring(0,String.valueOf(input).indexOf("E")));
		}
		answer = answer.replaceAll("x", String.valueOf(input));
		if(answer.startsWith("y=")){
			answer = answer.replace("y=", "");
		}
		if(containsAnOp(answer)){
			//log(answer);
			if(numberOf("(",answer) != numberOf(")",answer)){
				isError = true;
				//break;
			}
			while(numberOf("(",answer) == numberOf(")",answer) && numberOf("(",answer) > 0){	
				//log(answer);
				for(int i = 0; i < answer.length(); i++){
					if(answer.substring(i,i+1).equals("(")){
						
						if(answer.indexOf(")",i+1) < answer.indexOf("(",i+1) || answer.indexOf("(",i+1) == -1){
							answer = answer.substring(0,i) + getFromString(answer.substring(i+1,answer.indexOf(")",i+1))) + answer.substring(answer.indexOf(")",i+1) + 1,answer.length());
							//isError = true;
							
						}
					}
				}
			}
			while(numberOf("^",answer) > 0){
				answer = stringWithoutParentheses(answer,"^");
			}
			while(numberOf("*",answer) > 0 || numberOf("/",answer) > 0){
				answer = stringWithoutParentheses(answer,"*/");
			}
			while(numberOf("+",answer) > 0 || (numberOf("-",answer) > 0 && !(numberOf("-",answer) == 1 && answer.indexOf("-") == 0))){
				answer = stringWithoutParentheses(answer,"+-");
			}
		}
//		
//		
//		
//		if(numberOf(")") > 0 || numberOf("(") > 0){
//			answer = answer.replace(")","");
//			answer = answer.replace("(","");
//			//error  += "\nAre paren left \n num of ) = " + numberOf(")") + "\n num of ( = " + numberOf("(");
//		}
//		/*if(numberOf(")") != numberOf("(")){
//			error += "\nParen dont match";
//		}*/
		return Double.valueOf(answer);
	}
	public static int numberOf(String s, String fullText){
		int n = 0;
		for (int i = 0; i < fullText.length(); i++){
			if(fullText.substring(i,i+1).equals(s)){
				n++;
			}
		}
		return n;
	}
	public static double getFromString(String s){
		//log("Input: " + s);
		
		double num1 = 0, num2 = 0;
		String op = "";
		String[] whatLettersAre = new String[s.length()];
		
		
		for(int i = 0; i < s.length(); i++){
			if(s.substring(i,i+1).equals("0") || s.substring(i,i+1).equals("1") || s.substring(i,i+1).equals("2") || 
					s.substring(i,i+1).equals("3") || s.substring(i,i+1).equals("4") || s.substring(i,i+1).equals("5") || 
					s.substring(i,i+1).equals("6") || s.substring(i,i+1).equals("7") || s.substring(i,i+1).equals("8") || 
					s.substring(i,i+1).equals("9")){
				whatLettersAre[i] = "Number " + s.substring(i,i+1);
			} else if (containsAnOp(s.substring(i,i+1))){
				whatLettersAre[i] = "String " + s.substring(i,i+1);
			} else {
				//error += "\n" + String.valueOf(i) + " letter of getFromString of " + s + " error";
				whatLettersAre[i] = s.substring(i,i+1);
				
			}
		}
		int howManyAreString = 0;
		for(int i = 0; i < whatLettersAre.length; i++){
			if(whatLettersAre[i].startsWith("String")){
				if(i > 0){
					if(!whatLettersAre[i-1].startsWith("String")){
						howManyAreString++;
						
					} else {
						whatLettersAre[i] = "Negative -";
					}
				}
			}
		}
		if(howManyAreString == 0){
			//log("Output: " + String.valueOf(Double.parseDouble(s)));
			return Double.parseDouble(s);
			
		}
		
		else if(howManyAreString == 1){
			for(int i = 0; i < whatLettersAre.length; i++){
				if(whatLettersAre[i].startsWith("String")){
					op = s.substring(i,i+1);
					num1 = Double.parseDouble(s.substring(0,i));
					num2 = Double.parseDouble(s.substring(i+1,s.length()));
				}
			}
			//log ("Output: " + String.valueOf(doTheMath(num1,op,num2)));
			return doTheMath(num1,op,num2);
		} else {
			//error += "\n + getFromString of " + s + " has more than one operation";
			return 0;
		}
	}
	public static void log(String s){
		logNum++;
		System.out.println(logNum + ": " + s);
	}
	public static Boolean containsOneOf(String longText, String substrings){
		Boolean doesContain = false;
		for(int i = 0; i < substrings.length(); i++){
			if(numberOf(substrings.substring(i,i+1),longText) > 0){
				doesContain = true;
			}
		}
		return doesContain;
	}
	public static String stringWithoutParentheses(String answer, String operations){
		String finalAnswer = answer;
		Boolean foundOne = false;
		log("Input: " + answer);
		for(int i = 0; i < answer.length(); i++){
			//if(answer.substring(i,i+1).equals("*") || answer.substring(i,i+1).equals("/")){
			if(containsOneOf(answer.substring(i,i+1), operations) && !foundOne){
				foundOne = true;
				int start; //Int for where the beginning of the equation is
				int end; //Int for where the end of the equation is
				
				//Finds if there is another string before the equation
				String s = answer.substring(0,i);
				int howManyAreString = 0;
				int lastString = 0; // Variable to record where the last string before the equation occurs
				for(int j = 0; j < s.length(); j++){
					if (containsAnOp(s.substring(j,j+1))){
						//log("ContainsAnOp at " + j + " : " s.substring(j,j+1))
						howManyAreString++;
						lastString = j;
					}
				}
				if(howManyAreString == 0){
					start = 0;
				} else {
					start = lastString + 1;
				}
				log("Start of op: " + start + " i: " + i + " s: " + s);
				
				
				//Same for end
				
				s = answer.substring(i+1,answer.length());
				howManyAreString = 0;
				lastString = 0; // Variable to record where the first string after the equation occurs
				
				for(int j = i+1; j < answer.length(); j++){
					//log(" s: " + s + " j: " + j);
					if (containsAnOp(answer.substring(j,j+1))){
						if( !(j == i + 1 && answer.substring(j,j+1).equals("-"))   ){
							
							howManyAreString++;
							if(lastString == 0){
								lastString = j;
							}
						}
					}
				}
				if(howManyAreString == 0){
					end = answer.length();
					log("End from Answer");
				} else {
					end = lastString;
					log("End from String");
				}
				log("End of op: " + end + " i: " + i + " s: " + s);
				log("Equation: " + answer.substring(start, end));
				finalAnswer = answer.substring(0,start) + getFromString(answer.substring(start,end)) + answer.substring(end,answer.length());
				
				
			}
		}
		log("Output: " + finalAnswer);
		return finalAnswer;
	}
	public static Boolean containsAnOp(String s){
		Boolean doesContain = false;
		for(int i = 0; i < ops.length; i++){
			if(s.contains(ops[i])){
				doesContain = true;
			}
		}
		return doesContain;
	}
	public static double doTheMath(double num1, String op, double num2){
		double answer = 0;
		log("num1: " + num1 + " Op: " + op + " num2: " + num2);
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
		else if(op.equals("^")) {
			answer = (Math.pow(num1, num2));
		}
		return answer;
	}
}

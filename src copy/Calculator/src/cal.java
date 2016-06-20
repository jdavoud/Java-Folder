import java.util.Scanner;


public class cal {

	public static int num1, num2, num3;
	public static float num4;
	public static String o;
	public static Scanner in;
	public static float x, y;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		calculate();
	}
	public static void calculate(){
		in = new Scanner(System.in);
		num1 = 0;
		num2 = 0;
		o = " ";
		
		System.out.println("Enter the first number");
	    num1 = in.nextInt();
		
	    System.out.println("Enter the operation");
	    o = in.next();
	    
	    if(o.equals("new")){
	    	calculate();
	    }
	    
	    System.out.println("Enter the second number");
		num2 = in.nextInt();
		
		if(o.equals("*")){
	    	System.out.println(num1 + " * " + num2 + " = " + new Integer(num1*num2).toString());
		} 
		else if(o.equals("/")) {
			System.out.println(num1 + " / " + num2 + " = " + new Float(new Float(num1)/new Float(num2)).toString());
		}
		else if(o.equals("+")) {
			System.out.println(num1 + " + " + num2 + " = " + new Integer(num1+num2).toString());
		}
		else if(o.equals("-")) {
			System.out.println(num1 + " - " + num2 + " = " + new Integer(num1-num2).toString());
		}
		else if(o.equals("^")) {
			num3 = num1;
			for(int i = 1; i < num2; i++){
				num3 *= num1;
			}
			System.out.println(num1 + "^" + num2 + " = " + num3);
			
		}
		else if(o.equals("root")){
			num4 = num1;
			num4 = (float) Math.sqrt(num4);
			System.out.println("The " + num2 + " root of " + num1 + " = " + num4);
		}
		else if(o.equals("r")){
			num4 = num1;
			y = num4*num4;
			x = num4/y;
			
		}
		else {
			System.out.println("Error");
		}
		calculate();
	}
}

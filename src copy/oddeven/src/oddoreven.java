import java.util.Scanner;


public class oddoreven{

	public static int num1;
	public static Scanner in;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		calculate();
	}
	public static void calculate(){
		in = new Scanner(System.in);
		num1 = 0;
		
		
		System.out.println("Enter the number");
	    num1 = in.nextInt();
		
	    if(new Float(num1)/2 == new Integer(num1)/2){
	    	System.out.println("Even");
	    }
	    else{
	    	System.out.println("Odd");
	    }
		calculate();
	}
}

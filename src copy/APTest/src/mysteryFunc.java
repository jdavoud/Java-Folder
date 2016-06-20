
public class mysteryFunc {
	public static int num = 12304;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new mysteryFunc();
		
	}
	public mysteryFunc(){
		mystery(num);
	}
	public void mystery(int x){
		System.out.println((x % 10) + " " + x); 
		if((x / 10) != 0){
			mystery(x / 10);
		}
		System.out.println((x % 10) + " " +  x); 
		
	}
}

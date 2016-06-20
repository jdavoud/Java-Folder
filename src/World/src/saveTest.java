import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class save implements Serializable { 
	int score;
	String name;
	Image image;
	public save(int score, String name, String imagePath){
		this.score = score;
		this.name = name;
		this.image = Toolkit.getDefaultToolkit().getImage(imagePath);
	}
	public void setName(String name){
		this.name = name;
	}
	//public void 
	@Override
	public String toString() {
		return "save [score=" + score + ", name=" + name + "]";
	}


}
//public saveTest save;
public class saveTest implements Serializable {
	public static save testSave;// 
	//public static saveTest save;
	//public int num;
	
	public static void main(String[] args){
		testSave = new save(15,"Jacob", "images/balls/ball.png");
	}
	public void writeToFile(save fileSave) throws IOException{
		ObjectOutputStream obj_out = new ObjectOutputStream (new FileOutputStream("testsave.txt"));
		//Write object out to disk
		obj_out.writeObject (fileSave);
		System.out.println(fileSave.toString());
	}
	public void loadSave() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream obj_in = new ObjectInputStream (new FileInputStream("testsave.txt"));
		testSave = (save) obj_in.readObject();
		System.out.println(this.toString());
	}
	
}

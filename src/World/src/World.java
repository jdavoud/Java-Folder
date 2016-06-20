import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
class Main {
	static World world;
	public static void main(String[] args){
		try {
			loadSave();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void writeToFile(World world) throws IOException{
		ObjectOutputStream obj_out = new ObjectOutputStream (new FileOutputStream("testsave.txt"));
		//Write object out to disk
		obj_out.writeObject (world);
		System.out.println(world.toString());
	}
	static void loadSave() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream obj_in = new ObjectInputStream (new FileInputStream("testsave.txt"));
		world = (World) obj_in.readObject();
		System.out.println(world.toString());
	}
	
}
public class World extends Applet implements KeyListener, MouseListener, Serializable{
	World world;
	String mode = "Beginning"; //Will be used for bag, battle, and normal also 
	Trainer player;
	Trainer rival;
	int optionNum = 1; //Used for when there are options,
	int repaintNum = 1; //to make an arrow show and not show
	int step = 1; //Used for when there is a process that has steps, like the beginning with asking questions
	Boolean wPressed = false, aPressed = false, sPressed = false, dPressed = false, enterPressed = false, mousePressed = false;
	Boolean keyPressed = false; //Only used for typing names - using every key
	Boolean keysPressed[] = new Boolean[222]; //For if the key is pressed http://www.cambiaresearch.com/articles/15/javascript-key-codes
	Boolean canPress = false;
	Image Oak;
	Monster currentMonster = new Monster(null,null); //Used for the monster currently fighting with
	Room currentRoom = new Room(14,12);
	Room screenRoom = new Room(14,12);
	static Room playerHouse;
	Point2D mouseCoords;
	Room homeTown;
	static Room rivalHouse;
	Boolean battleNextRepaint = false; //A variable that becomes true when a player encounters a wild monster, then the next time the screen refreshes, it starts the battle
	public static Battle battle;
	public static Textbox textBox, defaultTextBox;
	public static Ball ball, masterball;
	public static Monster pikachu, charmander;
	public static Type fire, water, grass, electric, ground, rock, dark, fight, normal, flying, psychic, ghost, dragon, ice, bug, poison, steel;
	public static Move Shock, Tackle, ThunderWave, Spark;
	@Override
	public String toString() {
		return "World [world=" + world + ", mode=" + mode + ", player=" + player + ", rival=" + rival + ", optionNum="
				+ optionNum + ", repaintNum=" + repaintNum + ", step=" + step + ", wPressed=" + wPressed + ", aPressed="
				+ aPressed + ", sPressed=" + sPressed + ", dPressed=" + dPressed + ", enterPressed=" + enterPressed
				+ ", mousePressed=" + mousePressed + ", keyPressed=" + keyPressed + ", keysPressed="
				+ Arrays.toString(keysPressed) + ", canPress=" + canPress + ", Oak=" + Oak + ", currentMonster="
				+ currentMonster + ", currentRoom=" + currentRoom + ", screenRoom=" + screenRoom + ", mouseCoords="
				+ mouseCoords + ", homeTown=" + homeTown + ", battleNextRepaint=" + battleNextRepaint + "]";
	}
	public World() throws ClassNotFoundException{
		Oak = Toolkit.getDefaultToolkit().getImage("images/oak.png");
		player = new Trainer("Name");
		rival = new Trainer("Player");
		for(int i = 0; i < keysPressed.length; i++){
			keysPressed[i] = false;
		}

		//Just for testing right now
		mode = "Normal";
		player.setGender("Boy");
		player.setName("Jacob");
		player.setCoordinates(0,0);
		player.setImage("images/trainer/boy/down.png");
		player.setBag(new Bag()); //Nothing in the bag

		rival.setGender("Boy");
		rival.setName("Rival");


		ball = new Ball("Ball");
		//ball.setImage("images/balls/ball.png");
		masterball = new Ball("Masterball");
		//masterball.setImage("images/balls/masterball.png");
		textBox = new Textbox("", 10, 490, 540, 100, 4);
		defaultTextBox = textBox;
		pikachu = new Monster("Pikachu",electric);
		Shock = new Move("Shock", electric);
		Tackle = new Move("Tackle", normal);
		ThunderWave = new Move("Thunder Wave", electric);
		Spark = new Move("Spark", electric);
		pikachu.setMoves(new Move[]{Shock,Tackle,ThunderWave,Spark});
		charmander = new Monster("Charmander", fire);


		player.setMonsters(new Monster[] {pikachu});
		//Ends testing right now

		//need to write setBalls();
		//need to write setMonsters();
		//need to write setMoves();
		setTypes();
		setRooms();
		try {
			loadSave();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		currentRoom = playerHouse;

		//setSize(520,600);
		addKeyListener(this);
		addMouseListener(this);

		log(this.toString());
	}
	public void init(){
		try {
			world = new World();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		//drawButton(g2, new Button("Step: " + step,10,200,80,25));
		setSize(560,600);
		setBackground(new Color(255,255,255));
		if(mode == "Beginning"){
			beginning(g2);
		} else if (mode == "Normal"){
			normal(g2);
		} else if (mode == "Battle"){
			battle(g2);
		}
		if(keysPressed[80]){
			try {
				writeToFile(world);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		repaint();
	}

	//	public static void main(String[] args) throws IOException{
	//		//saveGame();
	//		//loadSave();
	//	}
	public void writeToFile(World world) throws IOException{
		ObjectOutputStream obj_out = new ObjectOutputStream (new FileOutputStream("testsave.txt"));
		//Write object out to disk
		obj_out.writeObject (world);
	}
	public void loadSave() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream obj_in = new ObjectInputStream (new FileInputStream("testsave.txt"));
		world = (World) obj_in.readObject();
	}
	public void beginning(Graphics2D g2){
		Color startColor = g2.getColor();
		//So that you can't click enter to skip through everything
		if(step == 1){
			Button newGame = new Button("New Game", 40, 20, 540, 80);
			//newGame.setTextCoordinates(new Point2D.Double(newGame.getTextCoordinates().getX(),newGame.getTextCoordinates().getY()+25));
			Polygon arrow;
			if(optionNum == 1){
				arrow = new Polygon(new int[] {15,25,15}, new int[] {50,55,60}, 3);
				if(enterPressed || buttonPressed(newGame)){	
					step++;
					optionNum = 1;
				} 
			} else {
				arrow = new Polygon(new int[] {15,25,15}, new int[] {50,55,60}, 3);
			}
			drawButton(g2, newGame);
			g2.fill(arrow);
		} else if((step >= 2 && step <= 5) || (step >= 7 && step <= 8)){
			Button newGame = new Button("On step " + step, 20, 500, 560, 80);
			if(step == 2){
				newGame.setText("Hi! My Name Is Professor Oak!");
			} else if(step == 3){
				newGame.setText("This is the World!");
			} else if(step == 4){
				if(aPressed){
					optionNum = 1;
				}
				if(dPressed){
					optionNum = 2;
				}
				if(optionNum == 1){
					newGame.setText("Are you a boy or a girl?   < boy >   girl");
				} else {
					newGame.setText("Are you a boy or a girl?      boy   < girl >");
				}
			} else if(step == 5){
				if(aPressed){
					optionNum = 1;
				}
				if(dPressed){
					optionNum = 2;
				}
				if(optionNum == 1){
					newGame.setText("You're a " + player.getGender() + "? < Yes >   No");
				} else {
					newGame.setText("You're a " + player.getGender() + "?    Yes   < No >");
				}
			} else if(step == 7){
				if(aPressed){
					optionNum = 1;
				}
				if(dPressed){
					optionNum = 2;
				}
				if(optionNum == 1){
					newGame.setText("Is your rival a boy or a girl?   < boy >   girl");
				} else if(optionNum == 2) {
					newGame.setText("Is your rival a boy or a girl?      boy   < girl >");
				}
			} else if(step == 8){
				if(aPressed){
					optionNum = 1;
				}
				if(dPressed){
					optionNum = 2;
				}
				if(optionNum == 1){
					newGame.setText("Your rival is a " + rival.getGender() + "? < Yes >   No");
				} else if (optionNum == 2){
					newGame.setText("Your rival is a " + rival.getGender() + "?    Yes   < No >");
				}
			}
			drawButton(g2, newGame);
			g2.drawImage (Oak, this.getWidth()/2-((Oak.getWidth(this)/2)), 50, (int) Oak.getWidth(this), (int) Oak.getHeight(this), this);
			if(repaintNum % 500 < 250 && step < 4){ //Displays the arrow half the time, but the higher the numbers are, the longer the arrow stays on and disappears for
				Polygon arrow = new Polygon(new int[] {560,570,565}, new int[] {535,535,545}, 3);
				g2.fill(arrow);
			}
			repaintNum++;
			if(canPress && (enterPressed || buttonPressed(newGame))){
				if(step == 4){
					if(optionNum == 1){
						player.setGender("Boy");
					} else {
						player.setGender("Girl");
					}
				} else if(step == 5){
					if(optionNum == 2){
						step = 3; //so that step++ will make it 4 and then you can rechoose boy or girl
					} else {
						player.setName("");
					}
				} else if(step == 7){
					if(optionNum == 1){
						rival.setGender("Boy");
					} else {
						rival.setGender("Girl");
					}
				} else if(step == 8){
					if(optionNum == 2){
						step = 6;
						//so that step++ down low will make it 7 and then rechoose
					} else {
						mode = "Normal";
						rival.setName("");
					}
				}
				step++;
				log("" + step);
				optionNum = 1;
				repaintNum = 1;
				canPress = false;
			}
			if(repaintNum > 200){
				canPress = true;
			}
		} else if(step == 6){
			Button name = new Button(player.getName(), 40, 120, 540, 80);
			Button newGame = new Button("What is your name?", 40, 20, 540, 80);
			this.addKeyListener(new KeyListener() {
				@Override
				public void keyTyped(KeyEvent e) {

				}
				@Override
				public void keyReleased(KeyEvent e) {
					keysPressed[e.getKeyCode()] = false;
				}
				@Override
				public void keyPressed(KeyEvent e) {

					//if(!keyPressed){
					if(!keysPressed[e.getKeyCode()]){
						keysPressed[e.getKeyCode()] = true;
						//System.out.println("Pressed " + e.getKeyCode());
						if(e.getKeyCode() == 10){ //Enter is Pressed
							if(player.getName().length() > 1 && optionNum != 2){ //The optionNum != 2 is to prevent error from step 8
								step++;
								System.out.println("Name Ended");
							}
						} else if(e.getKeyCode() == 8){ //Delete Backspace is pressed
							if(player.getName().length() > 1){
								player.setName(player.getName().substring(0, player.getName().length()-1));
							}
						} else if(e.getKeyCode() == 16){
							keysPressed[e.getKeyCode()] = false;
						}
						else if(player.getName().length() < 10){
							player.setName(player.getName() + e.getKeyChar());
						}
					}
				}
			});
			drawButton(g2,newGame);
			drawButton(g2,name);

		}
		g2.setBackground(startColor);
	}
	public void normal(Graphics2D g2){

		if(battleNextRepaint){ //Battles 
			drawRoom(g2,screenRoom); //Draws room + textbox first so the screen is still there
			drawTextBox(g2, textBox);
			try {
				Thread.sleep(1000); //Waits one second so the screen shows up
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaintNum = 0;
			battle.setOptionNum(0);
			textBox = new Textbox("",10,405,540,185,5); //Sets the text to what it needs to be
			if(battle.getBattleType() == "wild"){
				textBox.setText("You encountered a wild " + battle.getMonster().getName() + "!");
			} else {
				textBox.setText("Fighting against " + battle.getOpponent().getName() + "!");
			}
			currentMonster = player.getMonsters()[0];
			battleNextRepaint = false;
			mode = "Battle"; //Starts the battle
		}


		player.setCanWalkNum(player.getCanWalkNum() + 1); //Adds to the canWalkNum each time it refreshes, once it reaches a number, the player can walk again, but not indefinitely

		if(player.getCanWalkNum() > 50){
			player.setCanMove(true);
		} else {
			player.setCanMove(false);
		}
		if(keysPressed[10]){//If enter is pressed, then check to pick up an item, talk to a trainer, etc...
			int facingX = 0; //coordinates of the tile the player is facing
			int facingY = 0;
			if(player.getDirection() == "down"){
				facingX = (int) player.getCoordinates().getX();
				facingY = (int) player.getCoordinates().getY() + 1;
			} else if (player.getDirection() == "up"){
				facingX = (int) player.getCoordinates().getX();
				facingY = (int) player.getCoordinates().getY() - 1;
			} else if (player.getDirection() == "left"){
				facingX = (int) player.getCoordinates().getX() - 1;
				facingY = (int) player.getCoordinates().getY();
			} else if (player.getDirection() == "right"){
				facingX = (int) player.getCoordinates().getX() + 1;
				facingY = (int) player.getCoordinates().getY();
			} else { //In case of error and direction is wrong
				facingX = (int) player.getCoordinates().getX();
				facingY = (int) player.getCoordinates().getY();
			}
			if(facingX >= 0 && facingX <= currentRoom.getHeight() - 1 && facingY >= 0 && facingY <= currentRoom.getHeight() - 1){
				if(currentRoom.getTiles()[facingX][facingY].containsItem()){
					currentRoom.getTiles()[facingX][facingY].getItem().pressedOn(player,currentRoom.getTiles()[facingX][facingY]);
				} else if(currentRoom.getTiles()[facingX][facingY].containsTrainer()){
					currentRoom.getTiles()[facingX][facingY].getTrainer().talkedTo();
				}
			}
		}
		if(keysPressed[16]){ //Shift, need to write for reading the bag in the textbox
			log(player.getBag().toString());
			//int textBoxLines = textBox.getLines();
			//String bagOptions
			//textBox.setLines(5);

		}
		if(player.getCanMove() && (keysPressed[87] || keysPressed[83] || keysPressed[65] || keysPressed[68])){//WASD is pressed
			//For moving
			int moveX = 0; //for moving in X direction
			int moveY = 0; //for moving in Y direction
			if(keysPressed[87]){ //W is pressed
				if(player.getDirection() == "up"){ //So that you can face a direction without walking there
					moveY = -1;
				}
				player.setDirection("up");
			} /*else*/ if(keysPressed[83]){ //S is pressed
				if(player.getDirection() == "down"){ //So that you can face a direction without walking there
					moveY = 1;
				}
				player.setDirection("down");
			} /*else*/ if(keysPressed[65]){ //A is pressed
				if(player.getDirection() == "left"){ //So that you can face a direction without walking there
					moveX = -1;
				}
				player.setDirection("left");
			} /*else*/ if(keysPressed[68]){ //D is pressed
				if(player.getDirection() == "right"){ //So that you can face a direction without walking there
					moveX = 1;
				}
				player.setDirection("right");
			}
			if(player.getCoordinates().getX() + moveX >= 0 && player.getCoordinates().getX() + moveX <= currentRoom.getWidth() - 1 && player.getCoordinates().getY() + moveY >= 0 && player.getCoordinates().getY() + moveY <= currentRoom.getHeight() - 1){
				//If moved, the player is still in the room boundaries
				Tile newTile = currentRoom.getTiles()[(int) (player.getCoordinates().getX() + moveX)][(int) (player.getCoordinates().getY() + moveY)];
				if(newTile.getWalkable()){
					currentRoom.getTiles()[player.getCoordinates().x][player.getCoordinates().y].setTrainer(null);
					player.setCoordinates((int) (player.getCoordinates().getX() + moveX),(int) (player.getCoordinates().getY() + moveY));
					player.setCanWalkNum(0);
					if(newTile.containsPortal() && newTile.getPortal() != null){
						Portal tilePortal = newTile.getPortal();
						currentRoom = tilePortal.getEndRoom();
						//log(currentRoom.toString());
						player.setCoordinates(tilePortal.getX(), tilePortal.getY());
					}

					if(newTile.containsGrass() && newTile.getGrass().getMonsters() != null){
						Double random = Math.random();
						if(random < 0.1) { //Should be 10% chance of encountering a wild monster
							random = Math.random()*100;
							double chanceAdder = 0; //Adds up all the percentage chances of running into a monster and if the random num is less than that, then it encounters that monster
							for(int i = 0; i < newTile.getGrass().getMonsters().length; i++){
								chanceAdder += newTile.getGrass().getPercentages()[i];
								if(random < chanceAdder){
									//Battle that monster
									battle = new Battle(player, newTile.getGrass().getMonsters()[i]); //sets the global variable battle to this new instance of battle and changes textbox text
									battleNextRepaint = true; //makes the next repaint become a battle 
									textBox.setText("Battle!");
									break;
								}
							}
						}
					}

				}
			}
		}
		setImageBasedOnDirection(player);
		//log("Player Can Move Num: " + player.getCanWalkNum() + " Player Can Move: " + player.getCanMove().toString());
		currentRoom.getTiles()[player.getCoordinates().x][player.getCoordinates().y].setTrainer(player);
		Tile blackSpace = new Tile("images/tiles/black.png");
		for(int i = 0; i < screenRoom.getWidth(); i++){
			for(int j = 0; j < screenRoom.getHeight(); j++){
				//if(i >= 0 && i < currentRoom.getWidth() && j >= 0 && j < currentRoom.getHeight()){
				if(i - ((screenRoom.getWidth() - currentRoom.getWidth())/2) >= 0 && i - ((screenRoom.getWidth() - currentRoom.getWidth())/2) < currentRoom.getWidth() && j - ((screenRoom.getHeight() - currentRoom.getHeight())/2) >= 0 && j - ((screenRoom.getHeight() - currentRoom.getHeight())/2) < currentRoom.getHeight()){
					//currentRoom.getTiles()[i - ((screenRoom.getWidth() - currentRoom.getWidth())/2)][j - ((screenRoom.getHeight() - currentRoom.getHeight())/2)].setImage("images/tiles/housefloor.png");//needs to be fixed
					//need to fix line above 

					//log(String.valueOf(currentRoom.getTiles()[player.getCoordinates().x][player.getCoordinates().y].containsTrainer()));
					//screenRoom.setTile(i, j, currentRoom.getTiles()[i][j]);
					screenRoom.setTile(i, j, currentRoom.getTiles()[i - ((screenRoom.getWidth() - currentRoom.getWidth())/2)][ j - ((screenRoom.getHeight() - currentRoom.getHeight())/2)]);
				} else {
					//log("Current Room " + currentRoom.toString() + " x " + i + " y " + j);
					screenRoom.setTile(i, j, blackSpace.getImage());
				}
			}

		}

		drawRoom(g2,screenRoom);
		drawTextBox(g2, textBox);
		//Draw currentRoom
	}
	public void battle(Graphics2D g2){ //Work a lot on battle
		//Progression of events in a battle
		drawTextBox(g2, textBox); //Draws textbox first so that the arrow is drawn over it
		if(battle.getSceneNum() <= 1000){ //Intro, min 0 and max 100
			player.setImage("images/trainer/" + player.getGender() + "/battle/throwing0.png");
			if(battle.getBattleType() == "wild"){
				Monster monster = battle.getMonster();
				if(battle.getSceneNum() <= 400){
					g2.drawImage(monster.getImage(), 0 - monster.getImage().getWidth(this) + battle.getSceneNum(), 100, monster.getImage().getWidth(this), monster.getImage().getHeight(this), this);
				} else {
					g2.drawImage(monster.getImage(), 400 - monster.getImage().getWidth(this) , 100, monster.getImage().getWidth(this), monster.getImage().getHeight(this), this);
				}
			}

			if(battle.getSceneNum() <= 400){ //For moving the players across the screen
				if(repaintNum % 500 < 250){ //Displays the arrow half the time, but the higher the numbers are, the longer the arrow stays on and disappears for
					Polygon arrow = new Polygon(new int[] {535,545,540}, new int[] {575,575,585}, 3);
					Color oldColor = g2.getColor();
					g2.setColor(Color.BLACK);
					g2.fill(arrow);
					g2.setColor(oldColor);
				}
				repaintNum++;
			} else {
				if(battle.getSceneNum() < 460){
					player.setImage("images/trainer/" + player.getGender() + "/battle/throwing1.png");
				} else if (battle.getSceneNum() < 650) {
					player.setImage("images/trainer/" + player.getGender() + "/battle/throwing2.png");
				} else {
					player.setImage("images/trainer/" + player.getGender() + "/battle/throwing3.png");
				}
				if(battle.getSceneNum() >= 600 && battle.getSceneNum() <= 700){ //Ball curve should be a parametrization of y = -((x)/10)^2 + 25 //something like that
					g2.drawImage(ball.getImage(), (battle.getSceneNum() - 600)*2, (int) (316 + (Math.pow((((battle.getSceneNum()-600)- 50)/8),2) - 39.063) ), ball.getImage().getWidth(this), ball.getImage().getHeight(this), this);
				} else if(battle.getSceneNum() >= 700 && battle.getSceneNum() <= 900){
					Image ballImage = ball.getImage();
					Image playerMonsterImage = currentMonster.getImage();
					g2.drawImage(playerMonsterImage, 200 - (playerMonsterImage.getWidth(this)/2) + (ballImage.getWidth(this)/2), 314 - (playerMonsterImage.getHeight(this)/2) + (ballImage.getHeight(this)/2),playerMonsterImage.getWidth(this),playerMonsterImage.getHeight(this),this);
					//log("X: " + (int) (ballImage.getWidth(this)/2) +  " Y: " + (int) (playerMonsterImage.getHeight(this)/2));
				}
			}
			if(battle.getSceneNum() != 400){ //For every scene not 400 move on, and when 400, press enter to move on
				battle.setSceneNum(battle.getSceneNum() + 1); 
				if(battle.getSceneNum() == 1000){
					repaintNum = 0; //Set repaintNum to 0 for the battling section
				}
			} else { //IF scene num == Max, then you can move on
				if(keysPressed[10]){
					battle.setSceneNum(battle.getSceneNum() + 1);
					textBox.setText("Go " + player.getMonsters()[0].getName() + "!");
				}
			}
			g2.drawImage(player.getImage(), this.getWidth() - battle.getSceneNum(), 300, player.getImage().getWidth(this)*2, player.getImage().getHeight(this)*2, this);
		} else if(battle.getSceneNum() == 1000000){//Placeholder number
			//Write the outro for the battle
		} else { //Battling section
			//optionNum < 4 -> choosing what to do
			Image playerMonsterImage = currentMonster.getImage();
			g2.drawImage(playerMonsterImage, 210 - (playerMonsterImage.getWidth(this)/2), 336 - (playerMonsterImage.getHeight(this)/2),playerMonsterImage.getWidth(this),playerMonsterImage.getHeight(this),this);
			if(battle.getBattleType() == "wild"){
				Monster monster = battle.getMonster();
				g2.drawImage(monster.getImage(), 400 - monster.getImage().getWidth(this) , 100, monster.getImage().getWidth(this), monster.getImage().getHeight(this), this);
			}
			if(battle.getOptionNum() < 4){ //This means that it is choosing the option, optionNum above 5 does something else
				textBox.setTextLine(0,"What will " + currentMonster.getName() + " do?");
				textBox.setTextLine(1, " Fight");
				textBox.setTextLine(2, " Bag");
				textBox.setTextLine(3, " Monsters");
				textBox.setTextLine(4, " Run");
				int addNum = (int) (37.5 * battle.getOptionNum()); //Where to put the arrow y coord based on optionNum

				Polygon arrow = new Polygon(new int[] {15,15,25}, new int[] {450 + addNum,460 + addNum,455 + addNum}, 3);
				Color oldColor = g2.getColor();
				g2.setColor(Color.BLACK);
				g2.fill(arrow);
				g2.setColor(oldColor);

				if((keysPressed[40] || keysPressed[83] /*Down or S pressed*/) && battle.getOptionNum() <= 2 && battle.getCanChangeOptionNum()){ //Can only go up to 3
					battle.setOptionNum(battle.getOptionNum() + 1);
					battle.setCanChangeOptionNum(false);
					repaintNum = 0;
				} else if ((keysPressed[38] || keysPressed[87]/*Up or W pressed*/) && battle.getOptionNum() >= 1 && battle.getCanChangeOptionNum()){//Can only go down to 4
					battle.setOptionNum(battle.getOptionNum() - 1);
					battle.setCanChangeOptionNum(false);
					repaintNum = 0;
				} else if(!battle.getCanChangeOptionNum()){
					repaintNum++;
					if(repaintNum > 100){
						battle.setCanChangeOptionNum(true);
					}
				} else if (keysPressed[10]){//Enter is pressed, move on
					switch (battle.getOptionNum()){
					case 0:
						battle.setOptionNum(4); //Go to fighting
						break;
					case 1:
						//Use bag, prob set OptionNum 10 or something idk
						break;
					case 2:
						//Set current monster
						break;
					case 3:
						run(battle); //Run from the battle
						break;
					}
				}

			} else if (battle.getOptionNum() >= 4 && battle.getOptionNum() <= 7){ //optionNum == 5 through 8 -> choosing which move to use
				textBox.setTextLine(0, "Which move?  (Del Back)");
				textBox.setTextLine(1, " " + currentMonster.getMoves()[0].getName());
				textBox.setTextLine(2, " " + currentMonster.getMoves()[1].getName());
				textBox.setTextLine(3, " " + currentMonster.getMoves()[2].getName());
				textBox.setTextLine(4, " " + currentMonster.getMoves()[3].getName());
				int addNum = (int) (37.5 * (battle.getOptionNum()-4)); //Where to put the arrow y coord based on optionNum

				Polygon arrow = new Polygon(new int[] {15,15,25}, new int[] {450 + addNum,460 + addNum,455 + addNum}, 3);
				Color oldColor = g2.getColor();
				g2.setColor(Color.BLACK);
				g2.fill(arrow);
				g2.setColor(oldColor);
				if((keysPressed[40] || keysPressed[83] /*Down or S pressed*/) && battle.getOptionNum() <= 6 && battle.getCanChangeOptionNum()){ //Can only go up to 3
					battle.setOptionNum(battle.getOptionNum() + 1);
					battle.setCanChangeOptionNum(false);
					repaintNum = 0;
				} else if ((keysPressed[38] || keysPressed[87]/*Up or W pressed*/) && battle.getOptionNum() >= 5 && battle.getCanChangeOptionNum()){//Can only go down to 4
					battle.setOptionNum(battle.getOptionNum() - 1);
					battle.setCanChangeOptionNum(false);
					repaintNum = 0;
				} else if(!battle.getCanChangeOptionNum()){
					repaintNum++;
					if(repaintNum > 100){
						battle.setCanChangeOptionNum(true);
					}
				} else if (keysPressed[10]){//Enter is pressed, move on

				} else if (keysPressed[8]){//Backspace is pressed, go back
					battle.setOptionNum(0);
				}
			}
			//textBox.setTextLine(0, " " + currentMonster.getMoves()[0].getName() + "     " + currentMonster.getMoves()[1].getName());
			//textBox.setTextLine(1, " " + currentMonster.getMoves()[2].getName() + "     " + currentMonster.getMoves()[3].getName());
		}
	}
	public void setImageBasedOnDirection(Trainer trainer) {
		if(trainer.getDirection() != null){
			trainer.setImage("images/trainer/" + trainer.getGender() + "/" + trainer.getDirection() + ".png");
		} else {
			trainer.setDirection("down");
			setImageBasedOnDirection(trainer); //Recursion to set the image to down
		}
	}
	public void run(Battle battle){
		if(battle.getBattleType() == "wild"){
			mode = "Normal";
			textBox = defaultTextBox;
			textBox.setText("");
		} else {
			textBox.setText("Can't run from trainer battle");
		}

	}
	public void drawRoom(Graphics2D g2, Room room){
		for(int i = 0; i < room.getWidth(); i++){
			for(int j = 0; j < room.getHeight(); j++){
				drawTile(g2, room.getTiles()[i][j], i*40, j*40, 40, 40);
			}
		}
	}
	public void drawTile(Graphics2D g2, Tile tile, int x, int y, int width, int height){
		g2.drawImage(tile.getImage(), x, y, width, height, this);
		if(tile.containsGrass()){
			g2.drawImage(tile.getGrass().getImage(), x + (width/2) - (tile.getGrass().getImage().getWidth(this)/2), y + (height/2) - (tile.getGrass().getImage().getHeight(this)/2), tile.getGrass().getImage().getWidth(this), tile.getGrass().getImage().getHeight(this), this);
		}
		if(tile.containsTrainer()){ //Draws the trainer on it
			g2.drawImage(tile.getTrainer().getImage(), x + (width/2) - (tile.getTrainer().getImage().getWidth(this)/2), y + (height/2) - (tile.getTrainer().getImage().getHeight(this)/2) /* -5 maybe, so its not right at the bottom*/, tile.getTrainer().getImage().getWidth(this), tile.getTrainer().getImage().getHeight(this), this);
			//log("drawing Trainer");
		} else if(tile.containsItem()){
			g2.drawImage(tile.getItem().getImage(), x + (width/2) - (tile.getItem().getImage().getWidth(this)/2), y + (height/2) - (tile.getItem().getImage().getHeight(this)/2), tile.getItem().getImage().getWidth(this), tile.getItem().getImage().getHeight(this), this);

		}
	}
	public void drawButton(Graphics2D g2, Button b){
		Color startColor = g2.getColor();
		Font startFont = g2.getFont();
		g2.setColor(b.getButtonColor());
		g2.fill(new Rectangle2D.Double(b.getX(), b.getY(), b.getWidth(), b.getHeight()));
		g2.setFont(b.getFont());
		g2.setColor(b.getTextColor());
		g2.drawString(b.getText(), (float) b.getTextCoordinates().getX(), (float) b.getTextCoordinates().getY());
		g2.setFont(startFont);
		g2.setColor(startColor);
	}
	public void drawTextBox(Graphics2D g2, Textbox textBox){
		Color startColor = g2.getColor();
		Font startFont = g2.getFont();
		g2.setColor(textBox.getButtonColor());
		g2.fill(new Rectangle2D.Double(textBox.getX(), textBox.getY(), textBox.getWidth(), textBox.getHeight()));
		g2.setFont(textBox.getFont());
		g2.setColor(textBox.getTextColor());
		for(int i = 0; i < textBox.getLines(); i++){
			g2.drawString(textBox.getTextLine(i), (float) textBox.getTextCoordinates(i).getX(), (float) textBox.getTextCoordinates(i).getY());
			//log("i: " + i + " line: " + textBox.getTextLine(i) + " X: " + textBox.getTextCoordinates(i).getX() + " Y: " + textBox.getTextCoordinates(i).getY());

		}
		g2.setFont(startFont);
		g2.setColor(startColor);
	}
	public Boolean buttonPressed(Button b){
		Boolean isPressed = false;
		if(mousePressed){
			if(new Rectangle2D.Double(mouseCoords.getX(),mouseCoords.getY(),1,1).intersects(b.getButton())){
				isPressed = true;
			}
		}
		return isPressed;
	}
	public static void setRooms(){
		rivalHouse = new Room(5,5);
		playerHouse = new Room(10,10);
		rivalHouse.setDefaultTile(new Tile("images/tiles/rivalhousefloor.png").getImage());
		playerHouse.setDefaultTile(new Tile("images/tiles/housefloor.png").getImage());
		Grass playerHouseGrass = new Grass(new Monster[]{charmander,pikachu}, new Double[] {50.0,50.0});
		for(int i = 3; i < 7; i++){
			for(int j = 3; j < 7; j++){
				playerHouse.getTiles()[i][j].setGrass(playerHouseGrass);
				//rivalHouse.getTiles()[i][1].setGrass(playerHouseGrass);
			}
		}
		playerHouse.getTiles()[7][0].setPortal(new Portal(rivalHouse,0,0));
		rivalHouse.getTiles()[4][4].setPortal(new Portal(playerHouse,0,0));
		//playerHouse.getTiles()[7][0].getPortal().setX(2);
		playerHouse.getTiles()[4][4].setItem(ball);
		playerHouse.getTiles()[2][2].setItem(masterball);

	}
	public static void tryToCatch(Graphics2D g2, Trainer trainer, Ball ball, Monster wildMonster){
		Color oldColor = g2.getColor();
		Double catchRate = (3 * wildMonster.getHealthMax() - 2 * wildMonster.getHealth()) * wildMonster.getCatchRate() * ball.getCatchRate() * wildMonster.monsterStatusNumber() / (3 * wildMonster.getHealthMax()); 
		Double shakeRate;
		if(catchRate < 255){
			shakeRate = 1048560 / Math.sqrt(Math.sqrt(16711680/catchRate));
		} else { //255 or over means it will always be caught
			shakeRate = 65535.0;
		}
		//catch rate and shake rate taken from http://bulbapedia.bulbagarden.net/wiki/Catch_rate
		for(int i = 0; i < 4; i++){
			int randomNum = (int) (Math.random()*(65535)); //65535 means automatic catch
			if(randomNum < shakeRate){
				//Shake the ball
				if(i == 3){
					//Caught the monster
				}
			} else {
				textBox.setText("Player did not catch the wild " + wildMonster.getName() + "!");
				break;
			}
		}

		g2.setColor(oldColor);
	}
	public static void setTypes(){
		fire = new Type("Fire");
		water = new Type("Water");
		grass = new Type("Grass");
		electric = new Type("Electric");
		ground = new Type("Ground");
		rock = new Type("Rock");
		dark = new Type("Dark");
		fight = new Type("Fight");
		normal = new Type("Normal");
		flying = new Type("Flying");
		psychic = new Type("Psychic");
		ghost = new Type("Ghost");
		dragon = new Type("Dragon");
		ice = new Type("Ice");
		bug = new Type("Bug");
		poison = new Type("Poison");
		steel = new Type("Steel");

		addStrong(fire, new Type[] {bug, grass, ice, steel});
		addWeak(fire, new Type[] {fire, water, rock, dragon});

		addStrong(water, new Type[] {fire, ground, rock});
		addWeak(water, new Type[] {water, grass, dragon});

		addWeak(normal, new Type[] {rock, steel});
		addCantAttack(normal, new Type[]{ghost});

		addStrong(electric, new Type[] {water, flying});
		addWeak(electric, new Type[] {electric, grass, dragon});
		addCantAttack(electric, new Type[]{ground});

		addStrong(grass, new Type[] {water, ground, rock});
		addWeak(grass, new Type[] {fire, grass, poison, bug, flying, dragon, steel});

		addStrong(ice, new Type[] {grass, ground, flying, dragon});
		addWeak(ice, new Type[] {fire, water, ice, steel});

		addStrong(fight, new Type[]{normal, ice, rock, dark, steel});
		addWeak(fight, new Type[] {poison, flying, psychic, bug});
		addCantAttack(fight, new Type[] {ghost});

		addStrong(poison, new Type[] {grass});
		addWeak(poison, new Type[] {poison, rock, ground, ghost});

		addStrong(ground, new Type[] {fire, electric, poison, rock, steel});
		addWeak(ground, new Type[] {grass, bug});
		addCantAttack(ground, ghost);

		addStrong(flying, new Type[] {grass, fight, bug});
		addWeak(flying, new Type[] {electric, rock, steel});

		addStrong(psychic, new Type[] {fight, poison});
		addWeak(psychic, new Type[] {psychic, steel});
		addCantAttack(psychic, dark);

		addStrong(bug, new Type[] {grass, psychic, dark});
		addWeak(bug, new Type[] {fire, fight, poison, flying, dark, steel});

		addStrong(rock, new Type[] {fire, ice, flying, bug});
		addWeak(rock, new Type[] {fight, ground, steel});

		addStrong(ghost, new Type[] {psychic, ghost});
		addWeak(ghost, new Type[] {dark, steel});
		addCantAttack(ghost, new Type[] {normal});

		addStrong(dragon, new Type[] {dragon});
		addWeak(dragon, new Type[] {steel});


		addStrong(dark, new Type[] {psychic, ghost});
		addWeak(dark, new Type[] {fight, dark, steel});

		addStrong(steel, new Type[] {ice, rock});
		addWeak(steel, new Type[] {fire, water, electric, steel});


	}
	public static void addStrong(Type type1, Type type2){
		type1.setStrongAttacking(type2);
		type2.setWeakDefending(type1);
	}
	public static void addStrong(Type type1, Type[] types){
		if(types != null){
			for (int i = 0; i < types.length; i++){
				addStrong(type1, types[i]);
			}
		}
	}
	public static void addWeak(Type type1, Type type2){
		type1.setWeakAttacking(type2);
		type2.setStrongDefending(type1);
	}
	public static void addWeak(Type type1, Type[] types){
		if(types != null){
			for (int i = 0; i < types.length; i++){
				addWeak(type1, types[i]);
			}
		}
	}
	public static void addCantAttack(Type type1, Type type2){
		type1.cantAttack(type2);
		type2.cantBeAttackedBy(type1);
	}
	public static void addCantAttack(Type type1, Type[] types){
		if(types != null){
			for (int i = 0; i < types.length; i++){
				addCantAttack(type1, types[i]);
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		mousePressed = true;
		mouseCoords = new Point2D.Double(e.getX(), e.getY());
		log(mouseCoords.toString());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		mousePressed = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		log (e.toString());
		keysPressed[e.getKeyCode()] = true;
		switch (e.getKeyCode()){
		case KeyEvent.VK_W:
			wPressed = true;
			break;
		case KeyEvent.VK_A:
			aPressed = true;
			break;
		case KeyEvent.VK_S:
			sPressed = true;
			break;
		case KeyEvent.VK_D:
			dPressed = true;
			break;
		case KeyEvent.VK_UP:
			wPressed = true;
			break;
		case KeyEvent.VK_LEFT:
			aPressed = true;
			break;
		case KeyEvent.VK_DOWN:
			sPressed = true;
			break;
		case KeyEvent.VK_RIGHT:
			dPressed = true;
			break;
		case KeyEvent.VK_ENTER:
			enterPressed = true;
			break;

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		keysPressed[e.getKeyCode()] = false;
		switch (e.getKeyCode()){
		case KeyEvent.VK_W:
			wPressed = false;
			break;
		case KeyEvent.VK_A:
			aPressed = false;
			break;
		case KeyEvent.VK_S:
			sPressed = false;
			break;
		case KeyEvent.VK_D:
			dPressed = false;
			break;
		case KeyEvent.VK_UP:
			wPressed = false;
			break;
		case KeyEvent.VK_LEFT:
			aPressed = false;
			break;
		case KeyEvent.VK_DOWN:
			sPressed = false;
			break;
		case KeyEvent.VK_RIGHT:
			dPressed = false;
			break;
		case KeyEvent.VK_ENTER:
			enterPressed = false;
			break;

		}
	}
	public static void log(String s){
		System.out.println(s);
	}
}

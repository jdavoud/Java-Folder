import java.awt.Image;

public class Room {
	private int width;
	private int height;
	private Tile[][] tiles;
	private Image defaultTile;
	public Room(int width, int height){
		this.width = width;
		this.height = height;
		tiles = new Tile[width][height];
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				if(tiles[i][j] == null){
					tiles[i][j] = new Tile();
				}
			}
		}
	}
	public void setDefaultTile(Image image){
		this.defaultTile = image;
		for(int i = 0; i < tiles.length; i++){
			for(int j = 0; j < tiles[i].length; j++){
				if(tiles[i][j].getImage() == null){
					tiles[i][j] = new Tile(this.defaultTile);
				}
			}
		}
	}
	public Image getDefaultTile(){
		return this.defaultTile;
	}
	public void setWidth(int width){
		this.width = width;
	}
	public int getWidth(){
		return this.width;
	}
	public void setHeight(int height){
		this.height = height;
	}
	public int getHeight(){
		return this.height;
	}
	public Tile[][] getTiles(){
		return tiles;
	}
	public void setTile(int width, int height, Image image){
		this.tiles[width][height].setImage(image);
	}
	public void setTile(int width, int height, String imagePath){
		this.tiles[width][height].setImage(imagePath);
	}
	public void setTile(int width, int height, Tile tile){
		this.tiles[width][height] = tile;
	}
}
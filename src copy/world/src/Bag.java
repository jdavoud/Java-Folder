
public class Bag {
	private Item[] items = new Item[20];
	private int[] amount = new int[items.length];
	public static void main(String[] args){
		Bag b = new Bag();
		Item jew = new Item("Jew");
		Item goy = new Item("goy");

		b.addItem(goy);
		for(int i = 0; i < b.items.length; i++){
			if(b.items[i] == null){
				//System.out.println("Items[" + i + "]" + b.items[i].getName());
				log("Items[" + i + "] is null");
			} else {
				log("Items[" + i + "] " + b.items[i].getName());
			}
		}
		log("" + b.numberOfItems());
	}
	public Bag(){
		for(int i = 0; i < this.items.length; i++){
			this.items[i] = null;
		}
	}
	public Bag(Item[] items){
		for(int i = 0; i < items.length; i++){
			if(i < this.items.length){
				this.items[i] = items[i];
			}
		}
		if(items.length < this.items.length){
			for(int i = 0; i < this.items.length; i++){
				this.items[i] = null;
			}
		}
	}
	public void emptyBag(){
		for(int i = 0; i < this.items.length; i++){
			this.items[i] = null;
			this.amount[i] = 0;
		}
	}
	public Item getItem(int itemNumber){
		return this.items[itemNumber];
	}
	public void setItem(int itemNumber, Item newItem){
		this.items[itemNumber] = newItem;
		for(int i = 0; i < this.items.length; i++){//If there is a filled slot after a null slot, it slides them over so the filled slots are first
			if(this.amount[i] == 0){
				this.items[i] = null;
				this.amount[i] = 0;
			}
			if(this.items[i] == null){
				for(int j = i; j < this.items.length; j++){
					if(this.items[j] != null){
						while(this.items[i] == null){
							for(int h = i; h < this.items.length - 1; h++){
								this.items[h] = this.items[h+1];
								this.amount[h] = this.amount[h+1];
							}
							this.items[this.items.length - 1] = null;
							this.amount[this.items.length - 1] = 0;
						}
					}
				}
			}
		}
	}
	public void addItem(Item newItem){
		Boolean doesContain = false;
		int containsNum = 0;

		for(int i = 0; i < this.items.length; i++){
			if(this.items[i] != null && newItem != null){ //Sometimes an item is set to null, so the name is null
				if(this.items[i].getName() == newItem.getName()){
					doesContain = true;
					containsNum = i;
				}
			}
		}
		if(doesContain){ //Adds to the amount in the bag already instead of using a new slot for the item
			this.amount[containsNum]++;
		} else {
			this.amount[numberOfItems()]++;
			setItem(numberOfItems(), newItem);
		}
	}
	public void removeAllOfItem(int itemNumber){
		setItem(itemNumber, null);
	}
	public void removeOneOfItem(int itemNumber){
		if(this.amount[itemNumber] <= 1){
			removeAllOfItem(itemNumber);
		} else{
			this.amount[itemNumber]--;
		}
		
	}
	public int numberOfItems(){
		int num = 0;
		for(int i = 0; i < this.items.length; i++){
			if(this.items[i] != null){
				num++;
			}
		}
		return num;
	}
	public int slotContaining(Item item){
		int containsNum = (Integer) null;
		for(int i = 0; i < this.items.length; i++){
			if(this.items[i] == item){
				containsNum = i;
			}
		}
		return containsNum;
	}
	public Boolean containsItem(Item item){
		Boolean doesContain = false;
		for(int i = 0; i < this.items.length; i++){
			if(this.items[i] == item){
				doesContain = true;
			}
		}
		return doesContain;
	}
	public String toString(){ //returns the contents of the bag in string form
		String contents = "";
		for(int i = 0; i < numberOfItems(); i++){
			contents += this.items[i].getName() + " " + this.amount[i] + "X, ";
		}
		if(contents == ""){
			contents = "No Items";
		}
		return contents;
	}
	public static void log(String s){
		System.out.println(s);
	}
}

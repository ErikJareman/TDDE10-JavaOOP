import java.util.ArrayList;
import java.util.Arrays;

public class Location {
    private String name;
    private String descriptionLong = "";
    private String descriptionShort = "";
    private ArrayList<Location> paths;
    private ArrayList<Item> items;
    public Location(String name) {
	this.name = name;
	this.paths = new ArrayList<>();
	this.paths.add(0, null);
	this.paths.add(1, null);
	this.paths.add(2, null);
	this.paths.add(3, null);
	this.items = new ArrayList<>();
    }

    public void describeYourself() {
	System.out.println(this.descriptionLong);
	this.descriptionLong = this.descriptionShort;
    }
    
    public static void doCommand(String command, Player player) throws MoveException{
	int i=0;
	if (command.compareToIgnoreCase("north") == 0) {
	    i= 0;
	} else if (command.compareToIgnoreCase("east") == 0) {
	    i=1;
	} else if (command.compareToIgnoreCase("south") == 0) {
	    i= 2;
	} else if (command.compareToIgnoreCase("west") == 0) {
	    i=3;		
	}
	if (player.getLocation().paths.get(i) != null) {				
	    player.moveTo(player.getLocation().paths.get(i));
	} else { 
	    throw new MoveException("Invalid move, try again!");
	}
    }


    public void setDescriptionLong(String DL) {
	this.descriptionLong = DL;
    }

    public String getDescriptionLong() {
	return this.descriptionLong;
    }

    public void setDescriptionShort(String DS) {
	this.descriptionShort = DS;
    }

    public String getDescriptionShort() {
	return this.descriptionShort;
    }

    public void setPossibleMove(int direction, Location newLocation) {    //int direction => north=0, east=1, south=2, west=3
	this.paths.set(direction, newLocation);
    }

    public void setItem(Item item) {
	this.items.add(item);
    }

    public void removeItem(Item item) {
	this.items.remove(item);
    }

    public ArrayList<Item> getItemList() {
	return this.items;
    }

    //TODO: Komplettering: Inte okej att ha en tom funktion, gör denna
    //abstrakt istället
    public void changeWeather() {

    }

    public void showLocationItems() {
	if (this.items.isEmpty()) {
	    System.out.println("Den h�r platsen har inga items...");
	} else {
	    for (int i = 0; i < this.items.size(); i++) {
		System.out.println(this.items.get(i).getName());
	    }
	}

    }
}

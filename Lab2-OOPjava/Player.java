import java.util.ArrayList;

public class Player {
    private String name;
    private Location position;
    private int gold;
    private int health;
    private ArrayList<Item> items;
	
    public Player(String name, Location position) {
	this.name = name; this.position = position;
	this.gold = 900; this.health = 100;
	this.items = new ArrayList<>();
    }
	
    public void moveTo(Location newLocation) {
	//Kommentar: Onödigt att använda 'this'
	this.position.changeWeather();
	this.position = newLocation;
	this.getLocation().describeYourself();
	this.position.showLocationItems();
    }

    public Location getLocation() { 
	return this.position;
    }
	
    public void showItems() {
	if (this.items.isEmpty()) {
	    System.out.println("Du har inga items...");
	} else {
	    for (int i = 0; i < this.items.size(); i++) {
		System.out.println(this.items.get(i).getName());
	    }
	}
    }
	
    public ArrayList<Item> getPlayerItems() {
	return this.items;
    }

    public void doCommand(String command, Player player) throws CommandException, MoveException, ItemException{   //int direction => north=0, east=1, south=2, west=3
	command = command.toLowerCase();
	String arr[] = command.split(" ", 2);
		
	if (Game.getLocationCommands().contains(command)) {
	    Location.doCommand(command, player);	
	}
	else if (Game.getItemCommands().contains(arr[0]) && command.contains(" ")) {
	    for (int i = 0; i < player.position.getItemList().size(); i++) {
		if (arr[1].equals(player.position.getItemList().get(i).getName()))  {
		    player.position.getItemList().get(i).doCommand(command, player);
		    return;
		}
	    }
	    for (int i = 0; i < this.getPlayerItems().size(); i++) {
		if (arr[1].equals(this.items.get(i).getName())) {
		    this.items.get(i).doCommand(command, player);
		    return;
		}
	    }
		
	    throw new ItemException("Can not do that, please try again!");
	} else if (Game.getPlayerCommands().contains(command)) {
	    if (command.compareToIgnoreCase("look") == 0) {
		player.position.describeYourself();
		System.out.println("Du �ppnar ryggs�cken och tar en titt p� dina f�rem�l... Du identifierar f�ljande:");
		player.showItems();
		System.out.println("Dessa items finns p� platsen: ");
		player.position.showLocationItems();
	    } else if (command.compareToIgnoreCase("items") == 0) {
		System.out.println("Du �ppnar ryggs�cken och tar en titt p� dina f�rem�l... Du identifierar f�ljande:");
		player.showItems();
		System.out.println("Dessa items finns p� platsen: ");
		player.position.showLocationItems();
	    } else if (command.compareToIgnoreCase("help") == 0){
		System.out.println("----------------------------HELP----------------------------");
		System.out.println("Hello there summoner, you seem lost! Walk around in Runeterra \nand explore the world by using the following commands:");
		System.out.println(" - Travel commands: \'north\', \'east\', \'south\', \'west\'");
		System.out.println(" - Item commands: \'take \'item\'\', \'wear \'item\'\'");
		System.out.println(" - Info commands: \'items\', \'look\', \'help\'");
	    } 
	} else {
	    throw new CommandException("Invalid command, try again!");
	}
    }
}

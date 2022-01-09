
import java.util.*;

public class Game {
    private Scanner keyboard; 
    private ArrayList<Location> locations;

    //TODO: Komplettering: Dessa variabler ska ligga där dem används,
    //inte i Game och sedan hämtas med getters
    private static ArrayList<String> locationCommands;
    private static ArrayList<String> itemCommands;
    private static ArrayList<String> playerCommands;
    private static ArrayList<String> weatherConditions;
    private Player player;

    public Game() {
	keyboard = new Scanner(System.in);

	locationCommands = new ArrayList<>(Arrays.asList("north", "east", "south", "west"));
	itemCommands = new ArrayList<>(Arrays.asList("take", "wear", "use"));
	playerCommands = new ArrayList<>(Arrays.asList("items", "look", "help"));
	weatherConditions = OutdoorsArea.createWeather();

	Location midlane = new OutdoorsArea("Midlane", "rainy");
	Location toplane = new OutdoorsArea("Toplane", "sunny");
	Location botlane = new OutdoorsArea("Botlane", "foggy");    	
	Location baronPit = new OutdoorsArea("Baron Pit", "hot");
	Location itemShop = new Room("Item Shop", 40);

	locations = new ArrayList<>();
	locations.add(midlane); //locations.get(0)
	locations.add(toplane); //locations.get(1)
	locations.add(botlane); //locations.get(2)
	locations.add(baronPit); //locations.get(3)
	locations.add(itemShop); //locations.get(4)

	midlane.setDescriptionLong("Welcome to Midlane, you can go to Toplane by the north road, Botlane by the south road and Baron Pit the by west road.");
	midlane.setDescriptionShort("You are now in Midlane. Travelpaths: north, south, west.");
	midlane.setPossibleMove(0, toplane); //int direction => north=0, east=1, south=2, west=3
	midlane.setPossibleMove(2, botlane);
	midlane.setPossibleMove(3, baronPit);

	toplane.setDescriptionLong("Welcome to Toplane, go to Midlane by the south road.");
	toplane.setDescriptionShort("You are now in Toplane. Travelpaths: south.");
	toplane.setPossibleMove(2, midlane); //int direction => north=0, east=1, south=2, west=3

	botlane.setDescriptionLong("Welcome to Botlane, go to Midlane by the north road and Item Shop by the west road.");
	botlane.setDescriptionShort("You are now in Botlane. Travelpaths: north, west.");
	botlane.setPossibleMove(0, midlane); //int direction => north=0, east=1, south=2, west=3
	botlane.setPossibleMove(3, itemShop);

	baronPit.setDescriptionLong("Welcome to Baron Pit, go to Midlane by the east road and Item Shop by the south road.");
	baronPit.setDescriptionShort("You are now in Baron Pit. Travelpaths: east, south.");
	baronPit.setPossibleMove(1, midlane); //int direction => north=0, east=1, south=2, west=3
	baronPit.setPossibleMove(2, itemShop);

	itemShop.setDescriptionLong("Welcome to Item Shop, go to Baron Pit by the north gate and Botlane by the east gate");
	itemShop.setDescriptionShort("You are now in the Item Shop. Doors: north, east.");
	itemShop.setPossibleMove(0, baronPit); //int direction => north=0, east=1, south=2, west=3
	itemShop.setPossibleMove(1, botlane);

	toplane.setItem(new InfinityEdge());
	botlane.setItem(new Shovel());
	baronPit.setItem(new ElvenRobe());
	itemShop.setItem(new Torch());
	itemShop.setItem(new HealingStick());
    }

    public static ArrayList<String> getLocationCommands() {
	return Game.locationCommands;
    }

    public static ArrayList<String> getItemCommands() {
	return Game.itemCommands;
    }

    public static ArrayList<String> getPlayerCommands() {
	return Game.playerCommands;
    }

    public static ArrayList<String> getWeatherConditions() {
	return Game.weatherConditions;
    }

    public void run() {
	String name;
	String command;
	System.out.println("Welcome to the League of Legends adventure game!\nWhat is your summoner name?");
	name = keyboard.nextLine();
	player = new Player(name, locations.get(0));
	System.out.println("Hello " + name + ", welcome to this magical world of Runeterra! You can move around by typing north/south/west/east. You will have to learn more commands as you play the game! (Hint: there is a command \"help\").");
	player.getLocation().describeYourself();

	while (true) {
	    System.out.println("What do you want to do?");
	    while (true) {

		//TODO: Komplettering: Trevligt att ni
		//försöker er på användandet av
		//try-catch. Det ska dock inte användas på
		//det här viset då det blir otroligt dyrt
		//(tidskrävande för datorn). Om man kan
		//göra kontrollen med vanliga if-satser
		//bör man nästan alltid göra det istället
		//då det tar mellan 10 och 100 gånger
		//längre tid att köra en try-catch.
		try {
		    command = keyboard.nextLine();
		    player.doCommand(command, player);
		    break;
		}
		catch (CommandException e) {
		    System.out.println(e.getMessage());
		}
		catch (MoveException e) {
		    System.out.println(e.getMessage());
		}	
		catch (ItemException e) {
		    System.out.println(e.getMessage());
		}

	    }    
	}   
    }
}

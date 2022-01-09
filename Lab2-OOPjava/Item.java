
public class Item {
	private String name;
	private double weight;
	private int price;

	public Item(String name, double weight, int price) {
		this.name = name;
		this.weight = weight;
		this.price = price;
	}


	public String getName() {
		return this.name;
	}

    //TODO: Komplettering: Inte okej att ha tomma funktioner, gör
    //denna abstrakt istället
	public void useItem() {
		
	}

	public void printYourself() {
		System.out.println("Name: " + this.name + "\nWeight: " + this.weight + "\nPrice: " + this.price);
	}


    
	public void doCommand(String command, Player player) throws ItemException {
		String arr[] = command.split(" ", 2);
		if (arr[0].compareToIgnoreCase("take") == 0) {
			this.takeItem(command.substring(5, command.length()), player);
		} else {
			throw new ItemException("You can only 'take' " + arr[1] + ", try again!");
		}
	}


	public static void giveItem(Item item, Player player) throws ItemException {
		if (player.getLocation().getItemList().contains(item)) {
			player.getPlayerItems().add(item);
			player.getLocation().removeItem(item);
			//introduce item
		}
		else {
			throw new ItemException("Can not do that, try again!");
		}
	}


	public void takeItem(String string, Player player) throws ItemException {
		System.out.println("Du plockade upp " + this.getName() + "!");
		giveItem(this, player);
	}
}


public class WearableItem extends Item{

    public WearableItem(String name, double weight, int price) {
	super(name, weight, price);
    }

    public void doCommand(String command, Player player) throws ItemException {
	String arr[] = command.split(" ", 2);
	if (arr[0].compareToIgnoreCase("wear") == 0) {
	    this.putOn(command.substring(5, command.length()), player);
	}
	else throw new ItemException("You can only 'wear' " + arr[1] + ", try again!");
    }

    public void putOn(String string, Player player) throws ItemException {
	System.out.println("Du tog pa dig " + this.getName() + "!");
	giveItem(this, player);
    }
}

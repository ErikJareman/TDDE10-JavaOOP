
public class InfinityEdge extends Weapon{

    public InfinityEdge() {
	super("infinity_edge", 13.37, 360, 99);
    }

    public void doCommand(String command, Player player) throws ItemException {
	String arr[] = command.split(" ", 2);
	if (arr[0].compareToIgnoreCase("take") == 0 && player.getLocation().getItemList().contains(this)) {
	    this.takeItem(command.substring(5, command.length()), player);			
	} else if (arr[0].compareToIgnoreCase("use") == 0 && player.getPlayerItems().contains(this)) {
	    this.useItem(command.substring(5, command.length()), player);
	}
	else throw new ItemException("You can not do that...");
    }

    public void useItem(String string, Player player) {
	System.out.println("Bra jobbat! Du stabade nån!");
    }

}

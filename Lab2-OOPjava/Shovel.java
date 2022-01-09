
public class Shovel extends Tool{

    public Shovel() {
	super("shovel", 4.8, 180);
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
	System.out.println("Du grävde ett hål, bra jobbat.");
    }
	
	
}


public class Torch extends Tool{

    public Torch() {
	super("torch", 0.5, 25);
    }

    //TODO: Komplettering: En del av denna kod genomförs redan i
    //basklassens (Item) doCommand() metod vilket innebär att ni
    //kodduplicerar här. Anropa basklassens doCommand istället

    //TODO Komplettering: Mycket av Shovel:s doCommand() är identisk
    //med denna vilket inte är okej då det anses vara
    //kodduplicering. Flytta koden till lämpligt ställe där båda
    //klasserna kan anropa den.
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
	System.out.println("Jävlar va de lyser!");
    }
	
	
}

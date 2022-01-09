
public class HealingStick extends Tool{

	public HealingStick() {
		super("healing_stick", 1.11, 220);
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
		System.out.println("Saaaatan va bra du mår! koks på det?");
	}
}

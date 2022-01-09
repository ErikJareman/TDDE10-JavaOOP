
public class Room extends Location{
	private int size;

	public Room(String name, int size) {
		super(name);
		this.size = size;
	}

	public void describeYourself() {
	    //TODO: Komplettering: De två första raderna här är exakt
	    //samma som dem i basklassens describeYourself(). Anropa
	    //basklassens metod istället för att kodduplicera. Samma
	    //sak gäller OutdoorsArea
		System.out.println(this.getDescriptionLong());
		this.setDescriptionLong(this.getDescriptionShort());
		System.out.println("This room is: " + this.size + " square (dwarf) feet!");
	}
}

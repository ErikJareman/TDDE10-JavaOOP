//TODO: Komplettering: Denna klass tillför ingenting till spelet då
//den entast initierar basklassen. Lägg till unik funktionalitet till
//klassen så att det går att motivera att detta är en separat klass
public class Weapon extends Item {
	private int damage;
	
	public Weapon(String name, double weight, int price, int damage) {
		super(name, weight, price);
		this.damage = damage;
	}

}

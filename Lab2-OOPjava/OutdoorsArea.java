import java.util.ArrayList;
import java.util.Arrays;

public class OutdoorsArea extends Location{
	private String weather;

	public OutdoorsArea(String name, String weather) {
		super(name);
		this.weather = weather;
	}

	public static ArrayList<String> createWeather() {
		return new ArrayList<>(Arrays.asList("sunny", "cloudy", "rainy", "foggy"));
	}

	public void changeWeather() {
		int i = (int) (Math.random() * 4);
		this.weather = Game.getWeatherConditions().get(i);
	}

	public void describeYourself() {
		System.out.println(this.getDescriptionLong());
		this.setDescriptionLong(this.getDescriptionShort());
		System.out.println("Weather report: " + this.weather);
	}
}
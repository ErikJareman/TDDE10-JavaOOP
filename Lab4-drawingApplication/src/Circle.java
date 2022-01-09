import java.awt.*;

public class Circle extends Shapes{

	public void draw(Model model, Color color, int x, int y) {
		model.getGraphics().fillOval(x-5, y-5, 10, 10);
		
	}
}

import java.awt.*;

import javax.swing.*;

public class Model extends Canvas{
	Circle currentShape;
	
	public Model() {
		super();
	}
	
	public void paint(Graphics g) {
	    g.setColor(Color.blue);
	    g.fillOval(75, 10, 150, 75);
	}
}

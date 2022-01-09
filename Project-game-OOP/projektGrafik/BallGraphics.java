package projektGrafik;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BallGraphics {
	
	private static BufferedImage ballImage1;
	private static BufferedImage ballImage2;
	
	
	public BallGraphics() {
		try {
			ballImage1 = ImageIO.read(new File("C:\\Users\\Erik\\Desktop\\JAVA - eclipse\\Projekt\\src\\resources\\Ball(1).png"));
			ballImage2 = ImageIO.read(new File("C:\\Users\\Erik\\Desktop\\JAVA - eclipse\\Projekt\\src\\resources\\Ball(2).png"));
		} catch (IOException e) {
			//doNothing
		}
	}
	
	public static void drawBall(ball ball, Graphics g) {
		if (ball.getDirection() == 0 || ball.getDirection() == 2) {
			g.drawImage(ballImage1, ball.getX() - 11, ball.getY() - 11, graphicsPanel.graphicsPanelGet());
		} else {
			g.drawImage(ballImage2, ball.getX() - 11, ball.getY() - 11, graphicsPanel.graphicsPanelGet());
		}
	}
}

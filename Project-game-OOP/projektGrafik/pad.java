package projektGrafik;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class pad { //Kanske ska ha en logik-klass?
	private static int x;
	private static int padY;
	private static int width;
	private static int padDirection;
	private static int preferredPosition;
	private static int imageCallCount;
	private static ArrayList<BufferedImage> padImageList;

	public pad(int width) {
		x = (1280 - width) / 2;
		pad.width = width;
		padDirection = 1;
		padY = 600;
		imageCallCount = 0;
		
		BufferedImage padImage1 = null;
		BufferedImage padImage2 = null;
		BufferedImage padImage3 = null;
		BufferedImage padImage4 = null;
		try {
			padImage1 = ImageIO.read(new File("C:\\Users\\Erik\\Desktop\\JAVA - eclipse\\Projekt\\src\\resources\\Pad(1).jpg"));
			padImage2 = ImageIO.read(new File("C:\\Users\\Erik\\Desktop\\JAVA - eclipse\\Projekt\\src\\resources\\Pad(2).jpg"));
			padImage3 = ImageIO.read(new File("C:\\Users\\Erik\\Desktop\\JAVA - eclipse\\Projekt\\src\\resources\\Pad(3).jpg"));
			padImage4 = ImageIO.read(new File("C:\\Users\\Erik\\Desktop\\JAVA - eclipse\\Projekt\\src\\resources\\Pad(4).jpg"));
		} catch (IOException e) {
			//doNothing
		}
		padImageList = new ArrayList<>();
		padImageList.addAll(Arrays.asList(padImage1, padImage2, padImage3, padImage4));
	}

	public void drawPad(Graphics g) {
		int imageCall = 0;
		if (imageCallCount > 4 && imageCallCount < 10) {
			imageCall = 1;
		} else if (imageCallCount >= 10 && imageCallCount < 15) {
			imageCall = 2;
		} else if (imageCallCount >= 15 && imageCallCount < 20) {
			imageCall = 3;
		} else if (imageCallCount >= 20) {
			imageCallCount = 0;
		}
		g.drawImage(padImageList.get(imageCall), x, padY, graphicsPanel.graphicsPanelGet());
		imageCallCount += 1;
	}

	public void movePad() {
		int tmp = Math.abs(pad.x - preferredPosition);
		pad.x += padDirection * (tmp);

		if (pad.x < preferredPosition) {
			padDirection = 1;
		} else if (pad.x > preferredPosition) {
			padDirection = -1;
		} else {
			padDirection = 0;
		}
	}

	public static void changePadDirection(int mouseX) {
		preferredPosition = mouseX - getWidth()/2;
	}

	public static void tryPadBounce(ball ball) {
			if (pad.x - 15 < ball.getX() && ball.getX() < pad.x + width + 15) { //-15,+15 ger förlåtande pga studs i bollens mittpunkt
				ball.setDirection((ball.getDirection() -3 ) * -1);
			}
	}

	public static int getX() {
		return x;
	}

	public static int getWidth() {
		return width;
	}

	public static void setWidth(int width) {
		pad.width = width;
	}	

	public static int getPadY() {
		return padY;
	}
}
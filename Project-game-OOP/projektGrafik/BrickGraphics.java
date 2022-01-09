package projektGrafik;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

import projektLogik.Brick;
import projektLogik.GreenBrick;
import projektLogik.RedBrick;
import projektLogik.TerrainBrick;

public class BrickGraphics { //Jag skapar logixObjekt BRICK som borde vara grafikobjektBrick, sen borde logic för brick endast vara beräkningar som nt har så mycket med själva objektet att göra...
	
	private static ArrayList<BufferedImage> redBrickSource;
	private static ArrayList<BufferedImage> terrainBrickSource;
	private static ArrayList<BufferedImage> greenBrickSource;
	
	public BrickGraphics() {
		BufferedImage greenBrickImage1 = null;
		BufferedImage greenBrickImage2 = null;
		BufferedImage terrainBrickImage1 = null;
		BufferedImage terrainBrickImage2 = null;
		BufferedImage terrainBrickImage3 = null;
		BufferedImage redBrickImage1 = null;
		
		try {
			greenBrickImage1 = ImageIO.read(new File("C:\\Users\\Erik\\Desktop\\JAVA - eclipse\\Projekt\\src\\resources\\GreenBrick(1).png"));
			greenBrickImage2 = ImageIO.read(new File("C:\\Users\\Erik\\Desktop\\JAVA - eclipse\\Projekt\\src\\resources\\GreenBrick(2).png"));
			
			terrainBrickImage1 = ImageIO.read(new File("C:\\Users\\Erik\\Desktop\\JAVA - eclipse\\Projekt\\src\\resources\\TerrainBrick(1).png"));
			terrainBrickImage2 = ImageIO.read(new File("C:\\Users\\Erik\\Desktop\\JAVA - eclipse\\Projekt\\src\\resources\\TerrainBrick(2).png"));
			terrainBrickImage3 = ImageIO.read(new File("C:\\Users\\Erik\\Desktop\\JAVA - eclipse\\Projekt\\src\\resources\\TerrainBrick(3).png"));
			
			redBrickImage1 = ImageIO.read(new File("C:\\Users\\Erik\\Desktop\\JAVA - eclipse\\Projekt\\src\\resources\\RedBrick(1).png"));
		} catch (IOException e) {
		}
		
		redBrickSource = new ArrayList<>();
		terrainBrickSource = new ArrayList<>();
		greenBrickSource = new ArrayList<>();
		
		redBrickSource.add(redBrickImage1);
		greenBrickSource.add(greenBrickImage1);
		greenBrickSource.add(greenBrickImage2);
		terrainBrickSource.add(terrainBrickImage1);
		terrainBrickSource.add(terrainBrickImage2);
		terrainBrickSource.add(terrainBrickImage3);
	}
	
	
	public static void drawBrick(Brick brick, Graphics g) { //ÄNDRA DETTA!!! Ville bara få det att funka snabbt (dvs instanceof...)

		if (brick instanceof TerrainBrick) {
			drawTerrainBrick(brick, g);
			
		} else if (brick instanceof RedBrick) {
			drawRedBrick(brick, g);
			
		} else if (brick instanceof GreenBrick) {
			drawGreenBrick(brick, g);
			
		} else {
			g.setColor(brick.getColor());
			g.fillRect(112 + brick.getX()*81, 80 + brick.getY()*41, 80, 40);
			g.setColor(Color.BLACK);
		}
	}

	public static void drawGreenBrick(Brick brick, Graphics g) { //kass kod med ville bara få det att funka
				g.drawImage(greenBrickSource.get(brick.getDurability()), 112 + brick.getX()*81, 80 + brick.getY()*41, graphicsPanel.graphicsPanelGet());

	}
	
	public static void drawRedBrick(Brick brick, Graphics g) {
		g.drawImage(redBrickSource.get(brick.getDurability()), 112 + brick.getX()*81, 80 + brick.getY()*41, graphicsPanel.graphicsPanelGet());
	}
	
	public static void drawTerrainBrick(Brick brick, Graphics g) {
		g.drawImage(terrainBrickSource.get(brick.getDurability()), 112 + brick.getX()*81, 80 + brick.getY()*41, graphicsPanel.graphicsPanelGet());
	}
}

//resourcesloader.class.getClassLoader().getResource("package1/resources/repository/SSL-Key/cert.jks").toString();
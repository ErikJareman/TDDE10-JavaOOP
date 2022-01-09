package projektLogik;

import java.awt.Color;

import java.awt.Graphics;
import java.util.ArrayList;

import projektGrafik.BrickGraphics;
import projektGrafik.ball;
import projektGrafik.graphicsPanel;

public abstract class Brick {
	private int x;
	private int y;
	private Color color;
	private int points;
	private int durability;
	
	public Brick(int x, int y, Color color, int points, int durability) {
		this.x = x;
		this.y = y;
		this.setColor(color);
		this.points = points;
		this.setDurability(durability);
	}
	
	public static void createLevel(ArrayList<Brick> brickList, int level) {
		if (level == 1) { 
			for (int i = 0; i < 13; i++) {
				for (int j = 0; j < 6; j++) {
					if (i == 0 || i == 4 || i == 8 || i == 12 ) {
						brickList.add(new TerrainBrick(i, j));
					} else if (i == 1 || i == 3 || i == 5 || i == 7 || i == 9 || i == 11 ) {
						brickList.add(new GreenBrick(i, j));
					} else {
						brickList.add(new RedBrick(i, j));
					}
				}
			}
		} else if (level == 2) { 
			for (int i = 0; i < 13; i++) {
				for (int j = 0; j < 6; j++) {
					if (i == 0 || i == 4 || i == 8 || i == 12 ) {
						brickList.add(new RedBrick(i, j));
					} else if (i == 1 || i == 3 || i == 5 || i == 7 || i == 9 || i == 11 ) {
						brickList.add(new RedBrick(i, j));
					} else {
						brickList.add(new RedBrick(i, j));
					}
				}
			}
		}
	}
	
	public void printBricks(Graphics g) {
		BrickGraphics.drawBrick(this, g);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public static void brickBounce(ball ball) { //"objektorienterad programmering" i Java
		
		for (int i = 0; i < graphicsPanel.getBrickList().size(); i++) {
			
			int firstX = graphicsPanel.getBrickList().get(i).getX()*80 + 112;
			int secondX = graphicsPanel.getBrickList().get(i).getX()*80 + 192;
			int firstY = graphicsPanel.getBrickList().get(i).getY()*40 + 80;
			int secondY = graphicsPanel.getBrickList().get(i).getY()*40 + 120;
			
			if ((firstY <= ball.getY()) && (ball.getY() <= secondY)) {
				if ((firstX <= ball.getX()) && (ball.getX() <= secondX)) {
					
					int tmp = ball.getDirection();
					

					if (tmp == 0) { //borde egentligen kolla n�rliggande bricka viod h�rntr�ff f�r att veta hur det ska studsa (fixa om tid / ork)
						if (ball.getY() == secondY) {
							ball.setDirection(3);
						} else {
							ball.setDirection(1);
						}
					} else if (tmp == 1) {
						if (ball.getY() == secondY) {
							ball.setDirection(2);
						} else {
							ball.setDirection(0);
						}
					} else if (tmp == 2) {
						if (ball.getY() == firstY) {
							ball.setDirection(1);
						} else {
							ball.setDirection(3);
						}
					} else if (tmp == 3) {
						if (ball.getY() == firstY) {
							ball.setDirection(0);
						} else {
							ball.setDirection(2);
						}
					}
					
					graphicsPanel.removeBrick(i);

				}
			}
		}
	}
	

	public boolean confirmRemovable(int index) {
		return true;
	}
	
	public void addPoints() {
		graphicsPanel.addPoints(this.points);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}

}


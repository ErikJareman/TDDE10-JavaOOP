package projektGrafik;

import java.awt.Graphics;

public class ball {
	private int x;
	private int y;
	private int direction; //four directions(?)	 -->  0:(x,-y)  1:(-x,-y)  2:(-x,y)  3:(x,y)

	public ball(int x, int y, int direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
	public void drawBall(Graphics g) {
		BallGraphics.drawBall(this, g);
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return this.y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public int getDirection() {
		return this.direction;
	}
	
	public void setDirection(int dir) {
		this.direction = dir;
	}
}
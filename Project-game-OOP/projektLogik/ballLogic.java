package projektLogik;

import java.util.ArrayList;

import projektGrafik.ball;
import projektGrafik.graphicsPanel;
import projektGrafik.pad;

public class ballLogic extends RuntimeException{

	private static ArrayList<ball> balls;

	public ballLogic() {
		balls = new ArrayList<>();
	}

	public static void moveBall(ball ball) {
		if (ball.getY() > pad.getPadY() + 10) { 								//hanterar under pad
			if (ball.getY() > 718) {
				droppedBall(ball);
			} else {
				if (ball.getX() < 2) {
					ball.setDirection(3);
				} else if (ball.getX() > 1278) {
					ball.setDirection(2);
				}
			}
		} else if (ball.getX() < 2 && ball.getY() < 2) { 						//hanterar h�rnstuds (1)
			ball.setDirection(3);
		} else if (ball.getX() > 1278  && ball.getY() < 2) { //x2y1 corner		//hanterar h�rnstuds (2)
			ball.setDirection(2);
			
		} else if (ball.getX() < 2 && ball.getY() == pad.getPadY() -8 && pad.getX() - 15 <= ball.getX()) { 						//hanterar h�rnstuds (3)
			ball.setDirection(0);
		} else if (ball.getX() > 1278 && ball.getY() == pad.getPadY() -8 && pad.getX() + pad.getWidth() + 15 >=  ball.getX()) { //x2y1 corner		//hanterar h�rnstuds (4)
			ball.setDirection(1);
			
		} else {
			if (ball.getX() < 2) { 												//v�nster v�ggstuds
				if (ball.getDirection() == 1) {
					ball.setDirection(0);
				} else {
					ball.setDirection(3);
				}
			} else if (ball.getX() > 1278) { 									//h�ger v�ggstuds
				if (ball.getDirection() == 0) {
					ball.setDirection(1);
				} else {
					ball.setDirection(2);
				}
			} else if (ball.getY() < 2) { 										//�vre v�ggstuds
				if (ball.getDirection() == 1) {
					ball.setDirection(2);
				} else {
					ball.setDirection(3);
				}
			} else if (ball.getY() == pad.getPadY() - 8) {
				pad.tryPadBounce(ball);
			} else {
				Brick.brickBounce(ball);
			}
		}
		doMove(ball);
	}

	public static void doMove(ball ball) {
		if (ball.getDirection() == 0) {
			ball.setX(ball.getX() +2);
			ball.setY(ball.getY() -2);
		} else if (ball.getDirection() == 1) {
			ball.setX(ball.getX() -2);
			ball.setY(ball.getY() -2);
		} else if (ball.getDirection() == 2) {
			ball.setX(ball.getX() -2);
			ball.setY(ball.getY() +2);
		} else {
			ball.setX(ball.getX() +2);
			ball.setY(ball.getY() +2);
		}
	}

	public static void increaseDirection(ball ball) {
		if (ball.getDirection() == 3) {
			ball.setDirection(0);
		} else {
			ball.setDirection(ball.getDirection() +1);
		}
	}

	public static void decreaseDirection(ball ball) {
		if (ball.getDirection() == 0) {
			ball.setDirection(3);
		} else {
			ball.setDirection(ball.getDirection() -1);
		}
	}

	public static void droppedBall(ball ball) {
		balls.remove(ball);
		if (balls.size() < 1) {
			graphicsPanel.youLost();
		}
	}

	public void addBall(int x, int y, int direction) {
		balls.add(new ball(x, y, direction));
	}

	public static ArrayList<ball> getBalls() {
		return balls;
	}

	public static void setBalls(ArrayList<ball> balls) {
		ballLogic.balls = balls;
	}
}

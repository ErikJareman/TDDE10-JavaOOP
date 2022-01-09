package projektGrafik;

import projektLogik.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class graphicsPanel extends JPanel {

	private static graphicsPanel graphicsPanel;
	private static Timer timer;
	private pad playerPad;
	private static ballLogic ballGroup;
	private static int totalPoints;
	private static int expPoints;
	private static BrickGraphics brickGraphics = new BrickGraphics();
	private static BallGraphics ballGraphics = new BallGraphics();
	private BufferedImage BG = null;
	
	private static ArrayList<Brick> brickList; //borde ligga i brick
	
	public graphicsPanel(int level) {
		super();
		graphicsPanel = this;
		gameRun(level);
	}

	private void gameRun(int level) {
		try {
			BG = ImageIO.read(new File("C:\\Users\\Erik\\Desktop\\JAVA - eclipse\\Projekt\\src\\resources\\BG.jpeg"));
		} catch (IOException e) {
			//doNothing
		}
		totalPoints = 0;
		expPoints = 0;
		playerPad = new pad(180);
		ballGroup = new ballLogic();
		addBall(pad.getX() + pad.getWidth()/2, pad.getPadY() - 10, (int) (Math.random() * 2));
		brickList = new ArrayList<>();
		Brick.createLevel(brickList, level); 
		this.addMouseMotionListener(new MyMotionListener());
        timer = new Timer((int) 6, new GameCycle());
        timer.start();
	}

    private class GameCycle implements ActionListener {
		
    	private boolean firstCycle = true;
    	
    	@Override
		public void actionPerformed(ActionEvent arg0) {
    		if (firstCycle) {
    			try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
    			firstCycle = false;
    		}
    		gameCycle();
    	}
    }
	
	private void gameCycle() {
		for (int i = 0; i < ballLogic.getBalls().size(); i++) {
			ballLogic.moveBall(ballLogic.getBalls().get(i));
		}
		playerPad.movePad();
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(BG, 0, 0, graphicsPanel);
		for(int i = 0; i < brickList.size(); i++) {
			brickList.get(i).printBricks(g);
		}
		
		playerPad.drawPad(g);
		
		for(int i = 0; i < ballLogic.getBalls().size(); i++) {
			ballLogic.getBalls().get(i).drawBall(g);
		}
		
        Font pointFont = g.getFont().deriveFont( 78.0f );
        g.setFont(pointFont);
        g.setColor(new Color(255, 0, 255, 160));
        g.drawString(Integer.toString(totalPoints), 15, 680);
        printScore(g);
	}
	
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(1280, 720);
    }
	
	public void printScore(Graphics g) {
        int ballsDivide = ballLogic.getBalls().size();
        expPoints = 0;
        while (ballsDivide > 3 && expPoints < 2) {
        	ballsDivide -= 3;
            expPoints += 1;
            g.drawString("x" + Integer.toString(3), 1180 - this.rJust()*45 - (expPoints) * 90, 680); 
        }
        g.drawString("x" + Integer.toString(ballLogic.getBalls().size() - (expPoints) * 3), 1180 - this.rJust()*45, 680);
        g.setColor(Color.BLACK);
	}
	
	public static ArrayList<Brick> getBrickList() {
		return brickList;
	}

	public static void removeBrick(int index) {
		if (brickList.get(index).confirmRemovable(index)) {
			brickList.get(index).addPoints();
			brickList.remove(index);
		}
	}
	
	public static void addBall(int x, int y, int direction) {
		ballGroup.addBall(x, y, direction);
	}
	
	public static void addPoints(int points) {
		if (ballLogic.getBalls().size() - 3*expPoints == 0) {
			totalPoints += points *  Math.pow(3, expPoints) ;
		} else {
		totalPoints += points * (ballLogic.getBalls().size() - 3*expPoints) * Math.pow(3, expPoints);
		}
	}
	
	public int rJust() {
		if (ballLogic.getBalls().size() >= 16) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static void youLost() {
		timer.stop();
		gameBoard.addHighScore(totalPoints);
		gameMain.lostGame();
	}
	
	public static graphicsPanel graphicsPanelGet() {
		return graphicsPanel;
	}
}

package projektGrafik;

import javax.swing.JFrame;

import java.util.ArrayList;

public class gameBoard extends JFrame {
	
	private static ArrayList<Integer> highScoreList = new ArrayList<>();
	
	public gameBoard() {
		super("Breakout Arcade Extreme Edition 6_000_000_000_000");
		setSize(1280, 720);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(false);
	}
	
	public static void addHighScore(int score) {
		highScoreList.add(score);
	}
}

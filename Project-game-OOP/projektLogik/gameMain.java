package projektLogik;
import java.awt.EventQueue;

import projektGrafik.LostGamePanel;
import projektGrafik.MainMenuPanel;
import projektGrafik.gameBoard;
import projektGrafik.graphicsPanel;


public class gameMain {
	
	private static gameBoard gameBoard;
	
	public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
    		gameBoard = new gameBoard();
    		gameBoard.getContentPane().add(new MainMenuPanel());
    		gameBoard.setVisible(true);
        });
	}
	
	
	public static void startGame() {
		gameBoard.getContentPane().removeAll();
		gameBoard.getContentPane().add(new graphicsPanel(1));
		gameBoard.setVisible(true);
	}
	
	public static void lostGame() {
		gameBoard.getContentPane().removeAll();
		gameBoard.getContentPane().add(new LostGamePanel());
		gameBoard.setVisible(true);
	}
	
	public static void resetGame() {
		gameBoard.getContentPane().removeAll();
		gameBoard.getContentPane().add(new MainMenuPanel());
		gameBoard.setVisible(true);
	}
}
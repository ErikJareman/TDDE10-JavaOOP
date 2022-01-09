package projektGrafik;

import projektLogik.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class MainMenuPanel extends JPanel {

	public MainMenuPanel() {
		
	    JButton startButton = new JButton("START GAME");
	    startButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ae) {
	    		gameMain.startGame();
	    	}
	    });
		
	    JButton quitButton = new JButton("QUIT GAME");
	    quitButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ae) {
	    		System.exit(0);
	    	}
	    });
		
	    add(startButton);
	    add(quitButton);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
        Font pointFont = g.getFont().deriveFont( 120.0f );
        g.setFont(pointFont);
        g.setColor(new Color(30, 200, 30, 255));
        g.drawString("MAIN MENU", 300, 380);
	}
	
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(1280, 720);
    }
}
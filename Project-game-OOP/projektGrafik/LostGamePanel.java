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


public class LostGamePanel extends JPanel {

	public LostGamePanel() {
		
	    JButton toStartMenuButton = new JButton("RESET GAME");
	    toStartMenuButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ae) {
	    		gameMain.resetGame();
	    	}
	    });
	    JButton quitButton = new JButton("QUIT GAME");
	    quitButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ae) {
	    		System.exit(0);
	    	}
	    });
		
	    add(toStartMenuButton);
	    toStartMenuButton.setLocation(100, 100);
	    quitButton.setLocation(400, 100);
	    add(quitButton);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
        Font pointFont = g.getFont().deriveFont( 120.0f );
        g.setFont(pointFont);
        g.setColor(new Color(255, 0, 0, 255));
        g.drawString("YOU LOST", 335, 350);

	}
	
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(1280, 720);
    }
}
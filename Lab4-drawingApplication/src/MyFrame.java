import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class MyFrame extends JFrame{
	
	public MyFrame() { 
		super("Välkommen till Ritprogrammet!"); 
		setLayout(new BorderLayout());
	    Model myModel = new Model();
	    myModel.setSize(1200, 730);
	    
	    add(myModel, BorderLayout.CENTER);
	    JPanel centerPanel = new JPanel();
	    centerPanel.addMouseListener(new MyListener());
	    
	    
	    //Skapar Söderspalten
	    JPanel southPanel = new JPanel();
	    southPanel.setLayout(new FlowLayout(FlowLayout.LEFT));;
	    southPanel.setBackground(Color.LIGHT_GRAY);
	    southPanel.add(new JButton("Rensa"));
	    
	    //Skapar Högerspalten
	    JPanel eastPanel = new JPanel();
	    eastPanel.setBackground(Color.LIGHT_GRAY);
	    eastPanel.setLayout(new GridLayout(20, 1, 0, 0));
	    
	    eastPanel.add(new JLabel("Färg"));
	   
	    JButton blueButton = new JButton();
	    blueButton.setBackground(Color.BLUE);
	    blueButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
	    eastPanel.add(blueButton);
	    
	    JButton redButton = new JButton();
	    redButton.setBackground(Color.RED);
	    eastPanel.add(redButton);
	    
	    eastPanel.add(new JLabel("Form"));
	    
	    
	    //Lägger till allt o visar hela rutan
	    add(southPanel, BorderLayout.SOUTH);
	    add(eastPanel, BorderLayout.EAST);
	    
		setSize(1000, 700);	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//	    add(myModel);
		pack();
		setVisible(true);
	}
	
//	public Model getModel() {
//		return this.myModel;
//	}
//	
//	public void setModel(Model model) {
//		this.myModel = model;
//	}
	
}

	
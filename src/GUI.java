
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class GUI extends JFrame implements ActionListener{
	
	public JButton[][] oceanGrid = new JButton [10][10];
	public boolean placingBoats = true;
	public int curBoat = 0;

	
	public GUI(){
		
		super();
		//getContentPane().setBackground(new Color(51,255,255) );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   
		setSize(500,740);
		setResizable(false);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
		JPanel topPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		JPanel radarPanel = new JPanel();
		JPanel oceanPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		bottomPanel.setLayout(new BorderLayout());
		
		
		JButton bottomNorth = new JButton("Placing: Horizontal");
		JLabel topEast = new JLabel ("");
		
		
		topPanel.add(new JButton(" "), BorderLayout.NORTH);
		topPanel.add(new JButton(" "), BorderLayout.SOUTH);
		topPanel.add(topEast, BorderLayout.EAST);
		topPanel.add(new JButton("    "), BorderLayout.WEST);
		topPanel.add(radarPanel, BorderLayout.CENTER);
		
		radarPanel.setLayout(new GridLayout(10,10));
		
		int x = 0;
		int y = 0;
		JButton b;
		
		while( x < 10){
			while(y < 10){
				System.out.println(x + " , " + y);
				b = new JButton("");
				
				b.setBorder(BorderFactory.createRaisedBevelBorder());
				
				radarPanel.add(b, BorderLayout.CENTER);
				b.addActionListener(this);
				b.setActionCommand("r" + x + "" + y);
				y++;
			}
			x++;
			y=0;
		}
		
		
		
		bottomPanel.add(bottomNorth, BorderLayout.NORTH);
		bottomPanel.add(new JButton(""), BorderLayout.SOUTH);
		bottomPanel.add(new JButton("    "), BorderLayout.EAST);
		bottomPanel.add(new JButton("    "), BorderLayout.WEST);
		bottomPanel.add(oceanPanel, BorderLayout.CENTER);
		
		oceanPanel.setLayout(new GridLayout(10,10));
		
		x = 0;
		y = 0;
		
		while( x < 10){
			while(y < 10){
				System.out.println(x + " , " + y);
				b = new JButton("");
				oceanGrid[x][y] = b;
				
				b.setBorder(BorderFactory.createRaisedBevelBorder());
				
				oceanPanel.add(b, BorderLayout.CENTER);
				b.addActionListener(this);
				b.setActionCommand(x+ "" + y);
				y++;

			}
			x++;
			y=0;
		}
		
		
		
		
		add(topPanel);
		//add(radarPanel);
		add(bottomPanel);

		
		setVisible(true);
		

	}
	
	
	public static void main(String[] args){
		GUI gui = new GUI();
		
	}


	
	public void actionPerformed(ActionEvent e) {

		System.out.println(e.getActionCommand());
		
		if(placingBoats == true){
			
			int xCoord = Integer.parseInt(e.getActionCommand().toString().charAt(0) + "");
			int yCoord = Integer.parseInt(e.getActionCommand().toString().charAt(1) + "");
			
			
			if(curBoat == 0){
				System.out.println(xCoord);
					oceanGrid[xCoord][yCoord].setBackground(Color.BLUE);
			}
			
			
		}

	}

	
	
	
	
	

}

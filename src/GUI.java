
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
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class GUI extends JFrame implements ActionListener{
	
	public JButton[][] oceanGrid = new JButton [10][10];
	
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
		
		topPanel.add(new JButton("North"), BorderLayout.NORTH);
		topPanel.add(new JButton("South"), BorderLayout.SOUTH);
		topPanel.add(new JButton("East"), BorderLayout.EAST);
		topPanel.add(new JButton("West"), BorderLayout.WEST);
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
		
		bottomPanel.add(new JButton("North"), BorderLayout.NORTH);
		bottomPanel.add(new JButton("South"), BorderLayout.SOUTH);
		bottomPanel.add(new JButton("East"), BorderLayout.EAST);
		bottomPanel.add(new JButton("West"), BorderLayout.WEST);
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
		
		if(e.getActionCommand().equals("00")){
			System.out.println("ASD");
			oceanGrid[0][0].setForeground(new Color(255,255,255));
			oceanGrid[0][0].setBackground(new Color(122,245,0));
			oceanGrid[0][0].setOpaque(true);
		}
		
	}

	
	
	
	
	

}


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUI extends JFrame implements ActionListener{
	
	public int[][] radarGrid = new int [10][10];
	
	public GUI(){
		super();
		

		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   
		setSize(500,740);
		setResizable(false);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
		JPanel topPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		JPanel radarPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		bottomPanel.setLayout(new BorderLayout());
		
		topPanel.add(new JButton("North"), BorderLayout.NORTH);
		topPanel.add(new JButton("South"), BorderLayout.SOUTH);
		topPanel.add(new JButton("East"), BorderLayout.EAST);
		topPanel.add(new JButton("West"), BorderLayout.WEST);
		topPanel.add(radarPanel, BorderLayout.CENTER);
		
		int x = 0;
		int y = 0;
		
		while( x < 10){
			while(y < 10){
				System.out.println(x + " , " + y);
				radarPanel.add(new JButton(""), BorderLayout.CENTER);
				y++;
			}
			x++;
			y=0;
		}
		
		bottomPanel.add(new JButton("North"), BorderLayout.NORTH);
		bottomPanel.add(new JButton("South"), BorderLayout.SOUTH);
		bottomPanel.add(new JButton("East"), BorderLayout.EAST);
		bottomPanel.add(new JButton("West"), BorderLayout.WEST);
		bottomPanel.add(new JButton("Center"), BorderLayout.CENTER);
		
		
		add(radarPanel);
		add(bottomPanel);

		
		setVisible(true);

	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static void main(String[] args){
		GUI gui = new GUI();
		//setLayout(new BoxLayout(gui, BoxLayout.PAGE_AXIS));
		//gui.setLayout(new BoxLayout(gui, BoxLayout.PAGE_AXIS));
	}

}

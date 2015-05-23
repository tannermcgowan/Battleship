
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GUI extends JFrame implements ActionListener{
	
	public JButton[][] oceanGrid = new JButton [10][10];
	public JButton[][] radarGrid = new JButton [10][10];
	public boolean isHorizontal = true;
	public int curBoat = 0;
	public Data G;

	
	JLabel topEast = new JLabel("                 ");
	JLabel topWest = new JLabel("                 ");
	JLabel topNorth = new JLabel("<html><p> <br> &nbsp;&nbsp;&nbsp; Accuracy: [Stat] &nbsp;&nbsp;&nbsp; Shots Fired: [Stat] <br> <br> </p></html>");
	JLabel topSouth = new JLabel(" ");
	JPanel bottomNorth = new JPanel();
	JButton FlipButton = new JButton("Placing: Horizontal");
	JLabel bottomEast = new JLabel("                 ");
	JLabel bottomWest = new JLabel("                 ");
	JLabel bottomSouth = new JLabel("<html><p> <br><br> </p></html>");

	
	public GUI(){
		
		super();
		G = new Data();
		topNorth.setFont(new Font("Times New Roman", Font.BOLD, 15));
		topNorth.setText("<html><p> <br> &nbsp;&nbsp;&nbsp; Accuracy: " + G.getAccuracy() +"%" + "&nbsp;&nbsp;&nbsp; Enemy Ships Remaining: " + G.getEnemyShips() + "&nbsp;&nbsp;&nbsp; Player Ships Remaining: " + G.getPlayerShips() + "<br> <br> </p></html>");
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
		bottomNorth.setLayout(new BoxLayout(bottomNorth, BoxLayout.LINE_AXIS));
		
	
		
		FlipButton.addActionListener(this);
		FlipButton.setActionCommand("flipHorizontal");
		
		bottomNorth.add(Box.createHorizontalGlue());
		bottomNorth.add(FlipButton);
		bottomNorth.add(Box.createHorizontalGlue());
		
		topPanel.add(topNorth, BorderLayout.NORTH);
		topPanel.add(topSouth, BorderLayout.SOUTH);
		topPanel.add(topEast, BorderLayout.EAST);
		topPanel.add(topWest, BorderLayout.WEST);
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
				radarGrid[x][y] = b;
				y++;
			}
			x++;
			y=0;
		}
		
		
		
		bottomPanel.add(bottomNorth, BorderLayout.NORTH);
		bottomPanel.add(bottomSouth, BorderLayout.SOUTH);
		bottomPanel.add(bottomEast, BorderLayout.EAST);
		bottomPanel.add(bottomWest, BorderLayout.WEST);
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

		G.debugBoard();


	}
	
	
	public static void main(String[] args){
		GUI gui = new GUI();
	}
	
	
	public void CPUFireMissile(){
		if( G.curGameState == 1 && G.getTurn() == false){
			
			int CPUx = (int)(Math.random() * 10);
			if(CPUx == 10) CPUx = 9;
			
			int CPUy = (int)(Math.random() * 10);
			if(CPUy == 10) CPUx = 9;
			
			if(G.curGameState == 1 && G.getTurn() == false){
				if(G.getPlayerSpace(CPUx, CPUy) < 2){

					System.out.println("CPU shooting at " + CPUx + " , "+ CPUy);					
					G.recieveCPUShot(CPUx, CPUy);
					
					if(G.getPlayerSpace(CPUx, CPUy) == 2){ // Shot and missed
						oceanGrid[CPUx][CPUy].setBackground(Color.CYAN);
						oceanGrid[CPUx][CPUy].setForeground(Color.CYAN);
						oceanGrid[CPUx][CPUy].setOpaque(true);
					}
					if(G.getSpace(CPUx, CPUy) == 3){ // Shot and hit
						oceanGrid[CPUx][CPUy].setBackground(Color.RED);
						oceanGrid[CPUx][CPUy].setForeground(Color.RED);
						oceanGrid[CPUx][CPUy].setOpaque(true);
					}
					
					G.flipPlayer();
					G.debugBoard();
					
					
				}
				
				
			}
			
			
		}
		
	}
	

	public void playerFireMissile(int x, int y){
		if( G.curGameState == 1 && G.getTurn() == true){//this is the method where the player fires a missile. Should show up
			if(G.getSpace(x, y) < 2){
				G.addPlayerShot();
				G.updateStats();
				System.out.println("Shooting at " + x + " , "+ y);
				G.recievePlayerShot(x, y);
				
				if(G.getSpace(x, y) == 2){ // Shot and missed
					radarGrid[x][y].setBackground(Color.CYAN);
					radarGrid[x][y].setForeground(Color.CYAN);
					radarGrid[x][y].setOpaque(true);
				}
				if(G.getSpace(x, y) == 3){ // Shot and hit
					radarGrid[x][y].setBackground(Color.RED);
					radarGrid[x][y].setForeground(Color.RED);
					radarGrid[x][y].setOpaque(true);
				}
				
				G.flipPlayer();
				G.debugBoard();
				CPUFireMissile();
			}
		}
	}

	
	public void actionPerformed(ActionEvent e) {

		topNorth.setText("<html><p> <br> &nbsp;&nbsp;&nbsp; Accuracy: " + G.getAccuracy() +"%" + "&nbsp;&nbsp;&nbsp; Enemy Ships Remaining: " + G.getEnemyShips() + "&nbsp;&nbsp;&nbsp; Player Ships Remaining: " + G.getPlayerShips() + "<br> <br> </p></html>");
		
		System.out.println(e.getActionCommand());
		
		if(G.getGameState() == 1){
			if(G.getTurn()){
				FlipButton.setText("Your Turn!");
			}
			else{
				FlipButton.setText("Enemy Turn!");
			}
			
			
			if(e.getActionCommand().charAt(0) == 'r' && e.getActionCommand().length() == 3){
				System.out.println("Tried to do something on radar");
				playerFireMissile(	Character.getNumericValue((e.getActionCommand().charAt(1)))	,	Character.getNumericValue((e.getActionCommand().charAt(2)))		);
			}
			
			
			
			
			
		}
		

		
		
		
		
		
		if(G.getGameState() == 0){
		if(e.getActionCommand() == "flipHorizontal"){
			if(G.getGameState() == 0){
				if(isHorizontal){
					isHorizontal = false;
					FlipButton.setText("Placing: Vertical");
				}
				else{
					isHorizontal = true;
					FlipButton.setText("Placing: Horizontal");
				}
			}
			
			
			
		}
		else{ 
			if(G.getGameState() == 0 && e.getActionCommand().toString().charAt(0) != 'r'){
		
				
				int xCoord = Integer.parseInt(e.getActionCommand().toString().charAt(0) + "");
				int yCoord = Integer.parseInt(e.getActionCommand().toString().charAt(1) + "");
				
				
				/* -------------------- 5-Boat --------------------*/
				if(curBoat == 4){ // 5-Boat
					System.out.println(xCoord);
					if(	(isHorizontal && (yCoord < 6))	|| (!isHorizontal && (xCoord < 6))	){
						if(		(!(isHorizontal) && oceanGrid[xCoord][yCoord].getBackground() != Color.BLUE && oceanGrid[xCoord + 1][yCoord].getBackground() != Color.BLUE && oceanGrid[xCoord + 2][yCoord].getBackground() != Color.BLUE && oceanGrid[xCoord + 3][yCoord].getBackground() != Color.BLUE && oceanGrid[xCoord + 4][yCoord].getBackground() != Color.BLUE)	||	((isHorizontal) && oceanGrid[xCoord][yCoord].getBackground() != Color.BLUE && oceanGrid[xCoord][yCoord + 1].getBackground() != Color.BLUE && oceanGrid[xCoord][yCoord + 2].getBackground() != Color.BLUE && oceanGrid[xCoord][yCoord + 3].getBackground() != Color.BLUE && oceanGrid[xCoord][yCoord + 4].getBackground() != Color.BLUE)){
							oceanGrid[xCoord][yCoord].setBackground(Color.BLUE);
							oceanGrid[xCoord][yCoord].setForeground(Color.BLUE);
							oceanGrid[xCoord][yCoord].setOpaque(true);
								if(isHorizontal){
									oceanGrid[xCoord][yCoord + 1].setBackground(Color.BLUE);
									oceanGrid[xCoord][yCoord + 1].setForeground(Color.BLUE);
									oceanGrid[xCoord][yCoord + 1].setOpaque(true);
									oceanGrid[xCoord][yCoord + 2].setBackground(Color.BLUE);
									oceanGrid[xCoord][yCoord + 2].setForeground(Color.BLUE);
									oceanGrid[xCoord][yCoord + 2].setOpaque(true);
									oceanGrid[xCoord][yCoord + 3].setBackground(Color.BLUE);
									oceanGrid[xCoord][yCoord + 3].setForeground(Color.BLUE);
									oceanGrid[xCoord][yCoord + 3].setOpaque(true);
									oceanGrid[xCoord][yCoord + 4].setBackground(Color.BLUE);
									oceanGrid[xCoord][yCoord + 4].setForeground(Color.BLUE);
									oceanGrid[xCoord][yCoord + 4].setOpaque(true);
									G.SetPlayerGridSpot(xCoord, yCoord);
									G.SetPlayerGridSpot(xCoord, yCoord + 1);
									G.SetPlayerGridSpot(xCoord, yCoord + 2);
									G.SetPlayerGridSpot(xCoord, yCoord + 3);
									G.SetPlayerGridSpot(xCoord, yCoord + 4);
								}
								if(!isHorizontal){
									oceanGrid[xCoord + 1][yCoord].setBackground(Color.BLUE);
									oceanGrid[xCoord + 1][yCoord].setForeground(Color.BLUE);
									oceanGrid[xCoord + 1][yCoord].setOpaque(true);
									oceanGrid[xCoord + 2][yCoord].setBackground(Color.BLUE);
									oceanGrid[xCoord + 2][yCoord].setForeground(Color.BLUE);
									oceanGrid[xCoord + 2][yCoord].setOpaque(true);
									oceanGrid[xCoord + 3][yCoord].setBackground(Color.BLUE);
									oceanGrid[xCoord + 3][yCoord].setForeground(Color.BLUE);
									oceanGrid[xCoord + 3][yCoord].setOpaque(true);
									oceanGrid[xCoord + 4][yCoord].setBackground(Color.BLUE);
									oceanGrid[xCoord + 4][yCoord].setForeground(Color.BLUE);
									oceanGrid[xCoord + 4][yCoord].setOpaque(true);
									G.SetPlayerGridSpot(xCoord, yCoord);
									G.SetPlayerGridSpot(xCoord + 1, yCoord);
									G.SetPlayerGridSpot(xCoord + 2, yCoord);
									G.SetPlayerGridSpot(xCoord + 3, yCoord);
									G.SetPlayerGridSpot(xCoord + 4, yCoord);
								}
							curBoat ++;
							G.addPlayerShip();
							FlipButton.setText("Your Turn!");
							G.setGameState(1);
						}
					}	
				}
				/* -------------------- ------ --------------------*/
				//
				//
				//
				/* -------------------- 4-Boat --------------------*/
				if(curBoat == 3){ // 4-Boat
					System.out.println(xCoord);
					if(	(isHorizontal && (yCoord < 7))	|| (!isHorizontal && (xCoord < 7))	){
						if(		(!(isHorizontal) && oceanGrid[xCoord][yCoord].getBackground() != Color.BLUE && oceanGrid[xCoord + 1][yCoord].getBackground() != Color.BLUE && oceanGrid[xCoord + 
						   		  2][yCoord].getBackground() != Color.BLUE && oceanGrid[xCoord + 3][yCoord].getBackground() != Color.BLUE)	||	((isHorizontal) && oceanGrid[xCoord][yCoord].getBackground() != Color.BLUE &&
						   		  oceanGrid[xCoord][yCoord + 1].getBackground() != Color.BLUE 
						   		  
						   		  && oceanGrid[xCoord][yCoord + 2].getBackground() != Color.BLUE && oceanGrid[xCoord][yCoord + 3].getBackground() != Color.BLUE)){
							oceanGrid[xCoord][yCoord].setBackground(Color.BLUE);
							oceanGrid[xCoord][yCoord].setForeground(Color.BLUE);
							oceanGrid[xCoord][yCoord].setOpaque(true);
								if(isHorizontal){
									oceanGrid[xCoord][yCoord + 1].setBackground(Color.BLUE);
									oceanGrid[xCoord][yCoord + 1].setForeground(Color.BLUE);
									oceanGrid[xCoord][yCoord + 1].setOpaque(true);
									oceanGrid[xCoord][yCoord + 2].setBackground(Color.BLUE);
									oceanGrid[xCoord][yCoord + 2].setForeground(Color.BLUE);
									oceanGrid[xCoord][yCoord + 2].setOpaque(true);
									oceanGrid[xCoord][yCoord + 3].setBackground(Color.BLUE);
									oceanGrid[xCoord][yCoord + 3].setForeground(Color.BLUE);
									oceanGrid[xCoord][yCoord + 3].setOpaque(true);
									G.SetPlayerGridSpot(xCoord, yCoord);
									G.SetPlayerGridSpot(xCoord, yCoord + 1);
									G.SetPlayerGridSpot(xCoord, yCoord + 2);
									G.SetPlayerGridSpot(xCoord, yCoord + 3);
								}
								if(!isHorizontal){
									oceanGrid[xCoord + 1][yCoord].setBackground(Color.BLUE);
									oceanGrid[xCoord + 1][yCoord].setForeground(Color.BLUE);
									oceanGrid[xCoord + 1][yCoord].setOpaque(true);
									oceanGrid[xCoord + 2][yCoord].setBackground(Color.BLUE);
									oceanGrid[xCoord + 2][yCoord].setForeground(Color.BLUE);
									oceanGrid[xCoord + 2][yCoord].setOpaque(true);
									oceanGrid[xCoord + 3][yCoord].setBackground(Color.BLUE);
									oceanGrid[xCoord + 3][yCoord].setForeground(Color.BLUE);
									oceanGrid[xCoord + 3][yCoord].setOpaque(true);
									G.SetPlayerGridSpot(xCoord, yCoord);
									G.SetPlayerGridSpot(xCoord + 1, yCoord);
									G.SetPlayerGridSpot(xCoord + 2, yCoord);
									G.SetPlayerGridSpot(xCoord + 3, yCoord);
								}
							curBoat ++;
							G.addPlayerShip();
						}
					}	
				}
				/* -------------------- ------ --------------------*/
				//
				//
				//
				/* -------------------- 3-Boat(s) --------------------*/
				if(curBoat == 1 || curBoat == 2){ // 3-Boat
					System.out.println(xCoord);
					if(	(isHorizontal && (yCoord < 8))	|| (!isHorizontal && (xCoord < 8))	){
						if(		(!(isHorizontal) && oceanGrid[xCoord][yCoord].getBackground() != Color.BLUE && oceanGrid[xCoord + 1][yCoord].getBackground() != Color.BLUE && oceanGrid[xCoord + 2][yCoord].getBackground() != Color.BLUE)	||	((isHorizontal) && oceanGrid[xCoord][yCoord].getBackground() != Color.BLUE && oceanGrid[xCoord][yCoord + 1].getBackground() != Color.BLUE && oceanGrid[xCoord][yCoord + 2].getBackground() != Color.BLUE)){	
							oceanGrid[xCoord][yCoord].setBackground(Color.BLUE);
							oceanGrid[xCoord][yCoord].setForeground(Color.BLUE);
							oceanGrid[xCoord][yCoord].setOpaque(true);
								if(isHorizontal){
									oceanGrid[xCoord][yCoord + 1].setBackground(Color.BLUE);
									oceanGrid[xCoord][yCoord + 1].setForeground(Color.BLUE);
									oceanGrid[xCoord][yCoord + 1].setOpaque(true);
									oceanGrid[xCoord][yCoord + 2].setBackground(Color.BLUE);
									oceanGrid[xCoord][yCoord + 2].setForeground(Color.BLUE);
									oceanGrid[xCoord][yCoord + 2].setOpaque(true);
									G.SetPlayerGridSpot(xCoord, yCoord);
									G.SetPlayerGridSpot(xCoord, yCoord + 1);
									G.SetPlayerGridSpot(xCoord, yCoord + 2);
								}
								if(!isHorizontal){
									oceanGrid[xCoord + 1][yCoord].setBackground(Color.BLUE);
									oceanGrid[xCoord + 1][yCoord].setForeground(Color.BLUE);
									oceanGrid[xCoord + 1][yCoord].setOpaque(true);
									oceanGrid[xCoord + 2][yCoord].setBackground(Color.BLUE);
									oceanGrid[xCoord + 2][yCoord].setForeground(Color.BLUE);
									oceanGrid[xCoord + 2][yCoord].setOpaque(true);
									G.SetPlayerGridSpot(xCoord, yCoord);
									G.SetPlayerGridSpot(xCoord + 1, yCoord);
									G.SetPlayerGridSpot(xCoord + 2, yCoord);
								}
							curBoat ++;
							G.addPlayerShip();
						}
					}	
				}
				/* -------------------- --------- --------------------*/
				//
				//
				//
				/* -------------------- 2-Boat --------------------*/
				if(curBoat == 0){ // 2-Boat
					System.out.println(xCoord);
					if(	(isHorizontal && (yCoord < 9))	|| (!isHorizontal && (xCoord < 9))	){
						if(		(!(isHorizontal) && oceanGrid[xCoord][yCoord].getBackground() != Color.BLUE && oceanGrid[xCoord + 1][yCoord].getBackground() != Color.BLUE)	||	((isHorizontal) && oceanGrid[xCoord][yCoord].getBackground() != Color.BLUE && oceanGrid[xCoord][yCoord + 1].getBackground() != Color.BLUE)){	
							oceanGrid[xCoord][yCoord].setBackground(Color.BLUE);
							oceanGrid[xCoord][yCoord].setForeground(Color.BLUE);
							oceanGrid[xCoord][yCoord].setOpaque(true);
								if(isHorizontal){
									oceanGrid[xCoord][yCoord + 1].setBackground(Color.BLUE);
									oceanGrid[xCoord][yCoord + 1].setForeground(Color.BLUE);
									oceanGrid[xCoord][yCoord + 1].setOpaque(true);
									G.SetPlayerGridSpot(xCoord, yCoord);
									G.SetPlayerGridSpot(xCoord, yCoord + 1);

								}
								if(!isHorizontal){
									oceanGrid[xCoord + 1][yCoord].setBackground(Color.BLUE);
									oceanGrid[xCoord + 1][yCoord].setForeground(Color.BLUE);
									oceanGrid[xCoord + 1][yCoord].setOpaque(true);
									G.SetPlayerGridSpot(xCoord, yCoord);
									G.SetPlayerGridSpot(xCoord + 1, yCoord);
								}
							curBoat ++;
							G.addPlayerShip();
						}
					}	
				}
				/* -------------------- ------ --------------------*/
				
				
				
				
				
				
			
			}
			
		}

		
		
		//Update top scoreboard thing
		topNorth.setText("<html><p> <br> &nbsp;&nbsp;&nbsp; Accuracy: " + G.getAccuracy() +"%" + "&nbsp;&nbsp;&nbsp; Enemy Ships Remaining: " + G.getEnemyShips() + "&nbsp;&nbsp;&nbsp; Player Ships Remaining: " + G.getPlayerShips() + "<br> <br> </p></html>");
		
	}

	
	}
	
	
	

}




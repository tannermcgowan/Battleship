import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Data {
	

	boolean playerTurn = true; //If true, then it is the players turn, if false it is the CPU
	int numberOfShotsFired = 0;
	int numberOfShotsThatHit = 0;
	int accuracy = 0;
	int numberOfCPUShipsLeft = 5;
	int numberOfPlayerShipsLeft = 5;
	int[][] CPUGrid = new int [10][10];
	int [][] playerGrid = new int [10][10];
	
	
	public Data(){
		
		playerTurn = true;
		CPUPlaceShip();
		CPUPlaceShip();
		CPUPlaceShip();
		CPUPlaceShip();
		CPUPlaceShip();

		
	}
	
	
	public static void main(String[] args){
		
		//debugBoard();
		
	}
	
	public void debugBoard(){
	
		int x = 0;
		int y = 0;
		String curRow  = "";
		
		while( x < 10){
			while(y < 10){
				
				curRow += (CPUGrid[x][y] + " | ");
				
				y++;

			}
			x++;
			System.out.println(curRow);
			curRow = "";
			y=0;
		}
		
	}
	

	public int getAccuracy(){
		return accuracy;
	}
	
	public int getEnemyShips(){
		return numberOfCPUShipsLeft;
	}
	
	public int getPlayerShips(){
		return numberOfPlayerShipsLeft;
	}
	
	public void updateStats(){
		if(checkForWin()==false){
		//this will update the stats

		accuracy = numberOfShotsFired / numberOfShotsThatHit;
		 
	
		}
	}
	
	
	
	public boolean checkForWin(){
		if(numberOfCPUShipsLeft == 0 || numberOfPlayerShipsLeft == 0){
			return true;
		}
		updateStats();
		return false;
	}
	
	
	public String playerFireMissile(){
		if(checkForWin()==false){//this is the method where the player fires a missile. Should show up
		numberOfShotsFired++;
		updateStats();
		//we decided we would return a string of 2 numbers, which we can then split and use as coordinates
		return "00";
		}
		return"a";
	}
	
	
	public String CPUFireMissile(){
		if(checkForWin()==false){//This will be the method where the CPU fires a missile.. If it hits it should fire at the surrounding 8 spaces
		updateStats();
		//we decided we would return a string of 2 numbers, which we can then split and use as coordinates
		return "00";
		}
		return"a";
	}
	
	public void CPUTakeHit(){
		if(checkForWin()==false){//this will be the method that scores the data when the CPU bopat takes a hit
		numberOfShotsThatHit++;
		updateStats();
		}
	}
	
	public void CPUGetSunk(){
		if(checkForWin()==false){//this is the method where the CPU gets a boat sunken
		numberOfCPUShipsLeft--;
		updateStats();
		}
	}
	
	public void playerGetSunk(){
		if(checkForWin()==false){
		//this is the method where the player loses a ship, and the buttons all turn red
		numberOfPlayerShipsLeft--;
		updateStats();
		}
	}
	
	public void playerTakeHit(){
		if(checkForWin()==false){//this method is where the JButton that was hit turns red, and stores the data that it was hit
		updateStats();
		}
	}
	
	
	
	
	public void CPUPlaceShip() {
		
		int xCoord = (int)Math.random()*10;
		int yCoord = (int)Math.random()*10;
		int curBoat = 0;
		boolean isHorizontal = true;
		if(Math.random() > .5f) isHorizontal = false;
		
		/* -------------------- 5-Boat --------------------*/
		if(curBoat == 4){ // 5-Boat
			System.out.println(xCoord);
			if(	(isHorizontal && (yCoord < 6))	|| (!isHorizontal && (xCoord < 6))	){
				if(		(!(isHorizontal) && CPUGrid[xCoord][yCoord] != 15 && CPUGrid[xCoord + 1][yCoord] != 15 && CPUGrid[xCoord + 2][yCoord] != 15 && CPUGrid[xCoord + 3][yCoord] != 15 && CPUGrid[xCoord + 4][yCoord] != 15)	||	((isHorizontal) && CPUGrid[xCoord][yCoord] != 15 && CPUGrid[xCoord][yCoord + 1] != 15 && CPUGrid[xCoord][yCoord + 2] != 15 && CPUGrid[xCoord][yCoord + 3] != 15 && CPUGrid[xCoord][yCoord + 4] != 15)){
					CPUGrid[xCoord][yCoord] = 15;
						if(isHorizontal){
							CPUGrid[xCoord][yCoord + 1] = 15;
							CPUGrid[xCoord][yCoord + 2] = 15;
							CPUGrid[xCoord][yCoord + 3] = 15;
							CPUGrid[xCoord][yCoord + 4] = 15;
						}
						if(!isHorizontal){
							CPUGrid[xCoord + 1][yCoord] = 15;
							CPUGrid[xCoord + 2][yCoord] = 15;
							CPUGrid[xCoord + 3][yCoord] = 15;
							CPUGrid[xCoord + 4][yCoord] = 15;
						}
					curBoat ++;
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
				if(		(!(isHorizontal) && CPUGrid[xCoord][yCoord] != 15 && CPUGrid[xCoord + 1][yCoord] != 15 && CPUGrid[xCoord + 
				   		  2][yCoord] != 15 && CPUGrid[xCoord + 3][yCoord] != 15)	||	((isHorizontal) && CPUGrid[xCoord][yCoord] != 15 &&
				   		  CPUGrid[xCoord][yCoord + 1] != 15 
				   		  
				   		  && CPUGrid[xCoord][yCoord + 2] != 15 && CPUGrid[xCoord][yCoord + 3] != 15)){
					CPUGrid[xCoord][yCoord] = 15;
						if(isHorizontal){
							CPUGrid[xCoord][yCoord + 1] = 15;
							CPUGrid[xCoord][yCoord + 2] = 15;
							CPUGrid[xCoord][yCoord + 3] = 15;
						}
						if(!isHorizontal){
							CPUGrid[xCoord + 1][yCoord] = 15;
							CPUGrid[xCoord + 2][yCoord] = 15;
							CPUGrid[xCoord + 3][yCoord] = 15;
						}
					curBoat ++;
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
				if(		(!(isHorizontal) && CPUGrid[xCoord][yCoord] != 15 && CPUGrid[xCoord + 1][yCoord] != 15 && CPUGrid[xCoord + 2][yCoord] != 15)	||	((isHorizontal) && CPUGrid[xCoord][yCoord] != 15 && CPUGrid[xCoord][yCoord + 1] != 15 && CPUGrid[xCoord][yCoord + 2] != 15)){	
					CPUGrid[xCoord][yCoord] = 15;
						if(isHorizontal){
							CPUGrid[xCoord][yCoord + 1] = 15;
							CPUGrid[xCoord][yCoord + 2] = 15;
						}
						if(!isHorizontal){
							CPUGrid[xCoord + 1][yCoord] = 15;
							CPUGrid[xCoord + 2][yCoord] = 15;
						}
					curBoat ++;
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
				if(		(!(isHorizontal) && CPUGrid[xCoord][yCoord] != 15 && CPUGrid[xCoord + 1][yCoord] != 15)	||	((isHorizontal) && CPUGrid[xCoord][yCoord] != 15 && CPUGrid[xCoord][yCoord + 1] != 15)){	
					CPUGrid[xCoord][yCoord] = 15;
						if(isHorizontal){
							CPUGrid[xCoord][yCoord + 1] = 15;
						}
						if(!isHorizontal){
							CPUGrid[xCoord + 1][yCoord] = 15;
						}
					curBoat ++;
				}
			}	
		}
		/* -------------------- ------ --------------------*/
		
	}

	
	
	
}
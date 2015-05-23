import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Data {
	

	boolean playerTurn = true; //If true, then it is the players turn, if false it is the CPU
	int numberOfShotsFired = 0;
	int numberOfShotsThatHit = 0;
	int accuracy = 0;
	int numberOfCPUShipsLeft = 0;
	int numberOfPlayerShipsLeft = 0;
	int[][] CPUGrid = new int [10][10];
	int [][] playerGrid = new int [10][10];
	int curBoat = 0;
	int curGameState = 0; //0 is placing boats, 1 is running, 2 is game over
	
	
	public Data(){
		
		while(numberOfCPUShipsLeft < 5){
			CPUPlaceShip();
		}
		
		
		playerTurn = true;
		

		
	}
	
	
	public static void main(String[] args){
		
		
	}
	
	public void SetPlayerGridSpot(int x, int y){
		playerGrid[x][y] = 1;
	}
	
	public void flipPlayer(){
		
		if(playerTurn == true){
			playerTurn = false;
		}
		else{
			playerTurn = true;
		}
	}
	
	public int getSpace(int x, int y){
		return CPUGrid[x][y];
	}
	
	public int getPlayerSpace(int x, int y){
		return playerGrid[x][y];
	}
	
	public void recieveCPUShot(int x, int y){
		
		if(playerGrid[x][y] == 0){ //Shot and miss
			playerGrid[x][y] += 2;
		}	
		if(playerGrid[x][y] == 1){ //Shot and hit
			playerGrid[x][y] += 2;
		}
			
	}
	
	public void recievePlayerShot(int x, int y){
		
		if(CPUGrid[x][y] == 0){ //Shot and miss
			CPUGrid[x][y] += 2;
		}	
		if(CPUGrid[x][y] == 1){ //Shot and hit
			CPUGrid[x][y] += 2;
		}
			
	}
	
	
	public boolean getTurn(){
		return playerTurn;
	}
	
	public void setGameState(int i){
		curGameState = i;
	}
	
	public int getGameState(){
		return curGameState;
	}
	
	public void addPlayerShip (){
		numberOfPlayerShipsLeft ++;
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
		if(curGameState == 1){
		//this will update the stats
			
		if(numberOfShotsFired > 0){
			accuracy = numberOfShotsThatHit / numberOfShotsFired;
		}
	
		}
	}
	
	
	
	
	
	public void addPlayerShot(){
		numberOfShotsFired ++;
	}
	
	
	
	public void CPUTakeHit(){
		if(curGameState == 1){//this will be the method that scores the data when the CPU bopat takes a hit
		numberOfShotsThatHit++;
		updateStats();
		}
	}
	
	public void CPUGetSunk(){
		if(curGameState == 1){//this is the method where the CPU gets a boat sunken
		numberOfCPUShipsLeft--;
		updateStats();
		}
	}
	
	public void playerGetSunk(){
		if(curGameState == 1){
		//this is the method where the player loses a ship, and the buttons all turn red
		numberOfPlayerShipsLeft--;
		updateStats();
		}
	}
	
	public void playerTakeHit(){
		if(curGameState == 1){//this method is where the JButton that was hit turns red, and stores the data that it was hit
		updateStats();
		}
	}
	
	
	
	
	public void CPUPlaceShip() {
		
		int xCoord = (int)(Math.random()*10);
		int yCoord = (int)(Math.random()*10);
		boolean isHorizontal = true;
		if(Math.random() > .5f) isHorizontal = false;
		
		/* -------------------- 5-Boat --------------------*/
		if(curBoat == 4){ // 5-Boat
			System.out.println(xCoord);
			if(	(isHorizontal && (yCoord < 6))	|| (!isHorizontal && (xCoord < 6))	){
				if(		(!(isHorizontal) && CPUGrid[xCoord][yCoord] != 1 && CPUGrid[xCoord + 1][yCoord] != 1 && CPUGrid[xCoord + 2][yCoord] != 1 && CPUGrid[xCoord + 3][yCoord] != 1 && CPUGrid[xCoord + 4][yCoord] != 1)	||	((isHorizontal) && CPUGrid[xCoord][yCoord] != 1 && CPUGrid[xCoord][yCoord + 1] != 1 && CPUGrid[xCoord][yCoord + 2] != 1 && CPUGrid[xCoord][yCoord + 3] != 1 && CPUGrid[xCoord][yCoord + 4] != 1)){
					CPUGrid[xCoord][yCoord] = 1;
						if(isHorizontal){
							CPUGrid[xCoord][yCoord + 1] = 1;
							CPUGrid[xCoord][yCoord + 2] = 1;
							CPUGrid[xCoord][yCoord + 3] = 1;
							CPUGrid[xCoord][yCoord + 4] = 1;
						}
						if(!isHorizontal){
							CPUGrid[xCoord + 1][yCoord] = 1;
							CPUGrid[xCoord + 2][yCoord] = 1;
							CPUGrid[xCoord + 3][yCoord] = 1;
							CPUGrid[xCoord + 4][yCoord] = 1;
						}
					curBoat ++;
					numberOfCPUShipsLeft ++;
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
				if(		(!(isHorizontal) && CPUGrid[xCoord][yCoord] != 1 && CPUGrid[xCoord + 1][yCoord] != 1 && CPUGrid[xCoord + 
				   		  2][yCoord] != 1 && CPUGrid[xCoord + 3][yCoord] != 1)	||	((isHorizontal) && CPUGrid[xCoord][yCoord] != 1 &&
				   		  CPUGrid[xCoord][yCoord + 1] != 1 
				   		  
				   		  && CPUGrid[xCoord][yCoord + 2] != 1 && CPUGrid[xCoord][yCoord + 3] != 1)){
					CPUGrid[xCoord][yCoord] = 1;
						if(isHorizontal){
							CPUGrid[xCoord][yCoord + 1] = 1;
							CPUGrid[xCoord][yCoord + 2] = 1;
							CPUGrid[xCoord][yCoord + 3] = 1;
						}
						if(!isHorizontal){
							CPUGrid[xCoord + 1][yCoord] = 1;
							CPUGrid[xCoord + 2][yCoord] = 1;
							CPUGrid[xCoord + 3][yCoord] = 1;
						}
					curBoat ++;
					numberOfCPUShipsLeft ++;
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
				if(		(!(isHorizontal) && CPUGrid[xCoord][yCoord] != 1 && CPUGrid[xCoord + 1][yCoord] != 1 && CPUGrid[xCoord + 2][yCoord] != 1)	||	((isHorizontal) && CPUGrid[xCoord][yCoord] != 1 && CPUGrid[xCoord][yCoord + 1] != 1 && CPUGrid[xCoord][yCoord + 2] != 1)){	
					CPUGrid[xCoord][yCoord] = 1;
						if(isHorizontal){
							CPUGrid[xCoord][yCoord + 1] = 1;
							CPUGrid[xCoord][yCoord + 2] = 1;
						}
						if(!isHorizontal){
							CPUGrid[xCoord + 1][yCoord] = 1;
							CPUGrid[xCoord + 2][yCoord] = 1;
						}
					curBoat ++;
					numberOfCPUShipsLeft ++;
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
				if(		(!(isHorizontal) && CPUGrid[xCoord][yCoord] != 1 && CPUGrid[xCoord + 1][yCoord] != 1)	||	((isHorizontal) && CPUGrid[xCoord][yCoord] != 1 && CPUGrid[xCoord][yCoord + 1] != 1)){	
					CPUGrid[xCoord][yCoord] = 1;
						if(isHorizontal){
							CPUGrid[xCoord][yCoord + 1] = 1;
						}
						if(!isHorizontal){
							CPUGrid[xCoord + 1][yCoord] = 1;
						}
					curBoat ++;
					numberOfCPUShipsLeft ++;
				}
			}	
		}
		/* -------------------- ------ --------------------*/
		
	}

	
	
	
}


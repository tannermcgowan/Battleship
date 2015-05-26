import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Data {
	

	boolean playerTurn = true; //If true, then it is the players turn, if false it is the CPU
	int numberOfShotsFired = 0;
	int numberOfShotsThatHit = 0;
	int accuracy = 0;
	public int numberOfCPUShipsLeft = 0;
	public int numberOfPlayerShipsLeft = 0;
	int[][] CPUGrid = new int [10][10];
	int [][] playerGrid = new int [10][10];
	int curBoat = 0;
	int curGameState = 0; //0 is placing boats, 1 is running, 2 is game over
	String PlayerBoat2 = "";
	String PlayerBoat3a = "";
	String PlayerBoat3b = "";
	String PlayerBoat4 = "";
	String PlayerBoat5 = "";
	String CPUBoat2 = "";
	String CPUBoat3a = "";
	String CPUBoat3b = "";
	String CPUBoat4 = "";
	String CPUBoat5 = "";
	
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
		System.out.println("Called GetAcurracy");
		System.out.println("Hit = " + numberOfShotsThatHit);
		System.out.println("Fired = " + numberOfShotsFired);
		if(numberOfShotsFired > 0){
			accuracy = 100 * (numberOfShotsThatHit / numberOfShotsFired);
		}
		
		return accuracy;
	}
	
	public int getEnemyShips(){
		int i = 0;
		boolean isSunk;
		
		
		isSunk = true;
		for(int x = 0; x < 4; x += 2){
			if(CPUGrid[Character.getNumericValue(CPUBoat2.charAt(x))][Character.getNumericValue(CPUBoat2.charAt(x + 1))] == 1){
				isSunk = false;
			}

		}
		if(isSunk == false)	i++;
		
		
		isSunk = true;
		for(int x = 0; x < 6; x += 2){
			if(CPUGrid[Character.getNumericValue(CPUBoat3a.charAt(x))][Character.getNumericValue(CPUBoat3a.charAt(x + 1))] == 1){
				isSunk = false;
			}
		}
		if(isSunk == false)	i++;
		
		
		isSunk = true;
		for(int x = 0; x < 6; x += 2){
			if(CPUGrid[Character.getNumericValue(CPUBoat3b.charAt(x))][Character.getNumericValue(CPUBoat3b.charAt(x + 1))] == 1){
				isSunk = false;
			}
		}
		if(isSunk == false)	i++;
		
		
		isSunk = true;
		for(int x = 0; x < 8; x += 2){
			if(CPUGrid[Character.getNumericValue(CPUBoat4.charAt(x))][Character.getNumericValue(CPUBoat4.charAt(x + 1))] == 1){
				isSunk = false;
			}
		}
		if(isSunk == false)	i++;
		
		
		System.out.println("starting cpu boat 5: " + CPUBoat5);
		
		isSunk = true;
		for(int x = 0; x < 10; x += 2){
			if(CPUGrid[Character.getNumericValue(CPUBoat5.charAt(x))][Character.getNumericValue(CPUBoat5.charAt(x + 1))] == 1){
				isSunk = false;
			}
			System.out.println(	"CPU Boat 5 " +	Character.getNumericValue(CPUBoat5.charAt(x)) + Character.getNumericValue(CPUBoat5.charAt(x + 1))	);
		}
		if(isSunk == false)	i++;
		
		numberOfCPUShipsLeft = i;
		return i;
	}
	
	

	public int getPlayerShips(){
		if(curGameState == 1){
			int i = 0;
			boolean isSunk;
			
			
			isSunk = true;
			for(int x = 0; x < 4; x += 2){
				if(playerGrid[Character.getNumericValue(PlayerBoat2.charAt(x))][Character.getNumericValue(PlayerBoat2.charAt(x + 1))] == 1){
					isSunk = false;
				}
			}
			if(isSunk == false)	i++;
			
			
			isSunk = true;
			for(int x = 0; x < 6; x += 2){
				if(playerGrid[Character.getNumericValue(PlayerBoat3a.charAt(x))][Character.getNumericValue(PlayerBoat3a.charAt(x + 1))] == 1){
					isSunk = false;
				}
			}
			if(isSunk == false)	i++;
			
			
			isSunk = true;
			for(int x = 0; x < 6; x += 2){
				if(playerGrid[Character.getNumericValue(PlayerBoat3b.charAt(x))][Character.getNumericValue(PlayerBoat3b.charAt(x + 1))] == 1){
					isSunk = false;
				}
			}
			if(isSunk == false)	i++;
			
			
			isSunk = true;
			for(int x = 0; x < 8; x += 2){
				if(playerGrid[Character.getNumericValue(PlayerBoat4.charAt(x))][Character.getNumericValue(PlayerBoat4.charAt(x + 1))] == 1){
					isSunk = false;
				}
			}
			if(isSunk == false)	i++;
			
			
			isSunk = true;
			for(int x = 0; x < 10; x += 2){
				if(playerGrid[Character.getNumericValue(PlayerBoat5.charAt(x))][Character.getNumericValue(PlayerBoat5.charAt(x + 1))] == 1){
					isSunk = false;
				}
			}
			if(isSunk == false)	i++;
			
			numberOfPlayerShipsLeft = i;
			return i;
		}
		return numberOfPlayerShipsLeft;
	}
	
	
	
	
	
	public void updateStats(){
		getPlayerShips();
		getEnemyShips();
		
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
							CPUBoat5 = "" + xCoord + yCoord + xCoord + (yCoord + 1) + xCoord + (yCoord + 2) + xCoord + (yCoord + 3) + xCoord + (yCoord + 4);
						}
						if(!isHorizontal){
							CPUGrid[xCoord + 1][yCoord] = 1;
							CPUGrid[xCoord + 2][yCoord] = 1;
							CPUGrid[xCoord + 3][yCoord] = 1;
							CPUGrid[xCoord + 4][yCoord] = 1;
							CPUBoat5 = "" + xCoord + yCoord + (xCoord + 1) + yCoord + (xCoord + 2) + yCoord + (xCoord + 3) + yCoord + (xCoord + 4) + yCoord;
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
							CPUBoat4 = "" + xCoord + yCoord + xCoord + (yCoord + 1) + xCoord + (yCoord + 2) + xCoord + (yCoord + 3);
						}
						if(!isHorizontal){
							CPUGrid[xCoord + 1][yCoord] = 1;
							CPUGrid[xCoord + 2][yCoord] = 1;
							CPUGrid[xCoord + 3][yCoord] = 1;
							CPUBoat4 = "" + xCoord + yCoord + (xCoord + 1) + yCoord + (xCoord + 2) + yCoord + (xCoord + 3) + yCoord;
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
							if(curBoat == 1){	CPUBoat3a = "" + xCoord + yCoord + xCoord + (yCoord + 1) + xCoord + (yCoord + 2);	}
							if(curBoat == 2){	CPUBoat3b = "" + xCoord + yCoord + xCoord + (yCoord + 1) + xCoord + (yCoord + 2);	}
						}
						if(!isHorizontal){
							CPUGrid[xCoord + 1][yCoord] = 1;
							CPUGrid[xCoord + 2][yCoord] = 1;
							if(curBoat == 1){	CPUBoat3a = "" + xCoord + yCoord + (xCoord + 1) + yCoord + (xCoord + 2) + yCoord;	}
							if(curBoat == 2){	CPUBoat3b = "" + xCoord + yCoord + (xCoord + 1) + yCoord + (xCoord + 2) + yCoord;	}
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
							CPUBoat2 = "" + xCoord + yCoord + xCoord + (yCoord + 1);
						}
						if(!isHorizontal){
							CPUGrid[xCoord + 1][yCoord] = 1;
							CPUBoat2 = "" + xCoord + yCoord + (xCoord + 1) + yCoord;
						}
					curBoat ++;
					numberOfCPUShipsLeft ++;
				}
			}	
		}
		/* -------------------- ------ --------------------*/
		
	}

	
	
	
}


import javax.swing.JButton;

public class Data {
	

	boolean playerTurn = true; //If true, then it is the players turn, if false it is the CPU
	int numberOfShotsFired = 0;
	int numberOfShotsThatHit = 0;
	int accuracy = 0;
	int numberOfCPUSHipsLeft = 5;
	int numberOfPlayerShipsLeft = 5;
	String accuracyForTheScoreboard;
	String numberOfShotsFiredForTheScoreboard;
	String numberOfShotsThatHitForTheScoreboard;
	String numberOfCPUSHipsLeftForTheScoreboard;
	String numberOfPlayerShipsLeftForTheScoreboard;
	int[][] CPUGrid = new int [10][10];
	int [][] playerGrid = new int [10][10];
	
	
	public Data(){
			
	}
	
	
	
	
	
	public void updateStats(){
		if(checkForWin()==false){
		//this will update the stats

		accuracy = numberOfShotsFired / numberOfShotsThatHit;
		 
		accuracyForTheScoreboard = "Your Accuracy Is " + accuracy*100 + "%";
		
		numberOfShotsFiredForTheScoreboard = "You have fired " + numberOfShotsFired + " shots";
		
		numberOfShotsThatHitForTheScoreboard = "You have hit an enemy boat " + numberOfShotsThatHit + " times";
		
		numberOfCPUSHipsLeftForTheScoreboard = "The enemy has " + numberOfCPUSHipsLeft +  " ships left";
		
		numberOfPlayerShipsLeftForTheScoreboard = "The enemy has sunken " + (5 - numberOfPlayerShipsLeft) + " of your ships";
		}
	}
	
	
	
	public boolean checkForWin(){
		if(numberOfCPUSHipsLeft == 0 || numberOfPlayerShipsLeft == 0){
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
		numberOfCPUSHipsLeft--;
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
	
	
	public static void main(String[] args){
		
	}
	
}
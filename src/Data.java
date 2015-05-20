public class Data {
	

	private boolean playerTurn = true; //If true, then it is the players turn, if false it is the CPU
	private int numberOfShotsFired = 0;
	private int numberOfShotsThatHit = 0;
	private int accuracy = 0;
	private int numberOfCPUSHipsLeft = 5;
	private int numberOfPlayerShipsLeft = 5;
	private String accuracyForTheScoreboard;
	private String numberOfShotsFiredForTheScoreboard;
	private String numberOfShotsThatHitForTheScoreboard;
	private String numberOfCPUSHipsLeftForTheScoreboard;
	private String numberOfPlayerShipsLeftForTheScoreboard;
	
	
	
	public boolean checkForWin(){
		return false;
	}
	
	public void fireMissile(){
		//this is the method to fire onto the radar
	}
	
	public void updateStats(){
		//this will update the stats
		
		accuracy = numberOfShotsFired / numberOfShotsThatHit;
		 
		accuracyForTheScoreboard = "Your Accuracy Is " + accuracy*100 + "%";
		
		numberOfShotsFiredForTheScoreboard = "You have fired " + numberOfShotsFired + " shots";
		
		numberOfShotsThatHitForTheScoreboard = "You have hit an enemy boat " + numberOfShotsThatHit + " times";
		
		numberOfCPUSHipsLeftForTheScoreboard = "The enemy has " + numberOfCPUSHipsLeft +  " ships left";
		
		numberOfPlayerShipsLeftForTheScoreboard = "The enemy has sunken " + (5 - numberOfPlayerShipsLeft) + " of your ships";
		
	}
	
	
	
	
	public static void main(String[] args){
		
	}
	
}
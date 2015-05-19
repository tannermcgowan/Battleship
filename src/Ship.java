
public class Ship {
	
	/* This class should be the place where ships are created. The ships should have a size, name, position on the 
	 * grid(Array), and direction that they are facing. This class should have some operations such as getDeleted, 
	 * and some others
	 * 
	 */
	private boolean isSunk;
	private int length;
	//Some attribute to show which way they are facing. I.E. North, West, etc.
	
	
	
	public Ship(int l){
		//this needs to be done as buttons once we have the layout figured out, but these are some attributes needed
		
		isSunk = false;
		length = l;
		//something about direction, maybe something to do with user interput?
	}
	
	public void getSunk(){
		//this maybe can have something to do with the JButtons becoming all red, if we end up using buttons
	}
	
	public void takeHit(){
		//this method should turn the JButton, or whatever area depending on how we do it, turns red
	}
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
																								//
																								//
																								//
					//The ship placing set of methods could possibly go here																			//
																								//
																								//
																								//
																								//
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}

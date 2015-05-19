
public class Ship {
	
	/* This class should be the place where ships are created. The ships should have a size, name, position on the 
	 * grid(Array), and direction that they are facing. This class should have some operations such as getDeleted, 
	 * and some others
	 * 
	 */
	private boolean isSunk;
	private int length;
	private boolean isVertical;
	
	
	
	public Ship(int l){
		
		isSunk = false;
		length = l;
		isVertical = true;
	}
	
	public void getSunk(){
		//this maybe can have something to do with the JButtons becoming all red, if we end up using buttons
	}
	
	public void takeHit(){
		//this method should turn the JButton, or whatever area depending on how we do it, turns red
	}
	
}

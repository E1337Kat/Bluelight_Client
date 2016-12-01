package Backend;

public class Location {

	private Coord xCoord;
	private Coord yCoord;
	
	/**
	 * 
	 */
	public Location() {
		xCoord = new Coord();
		yCoord = new Coord();
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public Location(Coord x, Coord y) {
		xCoord = x;
		yCoord = y;
	}
	
	@Override
	public String toString() {
		return "(" + xCoord.toString() + "," + yCoord.toString() + ")";
	}
}

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
	
	public Coord getXCoordinate() {
		return xCoord;
	}
	
	public void setXCoordinate(Coord x) {
		xCoord = x;
	}
	
	public Coord getYCoordinate() {
		return yCoord;
	}
	
	public void setYCoordinate(Coord y) {
		yCoord = y;
	}
	
	public Coord[] getCoordinates() {
		Coord[] c = {xCoord, yCoord};
		return c;
	}
	
	public void setCoordinates(Coord x, Coord y) {
		xCoord = x;
		yCoord = y;
	}
	
	@Override
	public String toString() {
		return "(" + xCoord.toString() + "," + yCoord.toString() + ")";
	}
}

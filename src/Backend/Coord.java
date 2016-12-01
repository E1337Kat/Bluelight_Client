package Backend;

import java.util.Random;

public class Coord {

	private int degrees;
	private int minutes;
	private double seconds;
	private String relativeLocation;
	
	/*
	 * 
	 */
	public Coord() {
		Random rand = new Random();
		
		degrees = rand.nextInt(361);
		minutes = rand.nextInt(61);
		seconds = rand.nextInt(61) + rand.nextDouble();
		relativeLocation = "Earth";
	}
	
	/**
	 * 
	 * @param d
	 * @param m
	 * @param s
	 */
	public Coord(int d, int m, double s) {
		degrees = d;
		minutes = m;
		seconds = s;
		relativeLocation = "Earth";
	}
	
	/**
	 * 
	 * @param d
	 * @param m
	 * @param s
	 * @param loc
	 */
	public Coord(int d, int m, double s, String loc) {
		degrees = d;
		minutes = m;
		seconds = s;
		relativeLocation = loc;
	}
	
	/**
	 * Constructor for Coord object utilizing only relative location.
	 * @param loc	relative location of coordinates
	 */
	public Coord(String loc){
		relativeLocation = loc;
		//TODO: infer Coords from relative location
	}
	
	/**
	 * Returns the text of the coodinates in form DDD:MM:SS.S
	 * @return		The coordinates of the current location object
	 */
	@Override
	public String toString() {
		return degrees + ":" + minutes + ":" + String.format("%1$.3f", seconds) + " Near the: " + relativeLocation; 
	}
	
}

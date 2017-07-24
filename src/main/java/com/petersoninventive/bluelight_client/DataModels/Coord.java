/*
 * Copyright 2017 Elliekat.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.petersoninventive.bluelight_client.DataModels;

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
	
	public void setCoordinates(int d, int m, double s) {
		degrees = d;
		minutes = m;
		seconds = s;
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

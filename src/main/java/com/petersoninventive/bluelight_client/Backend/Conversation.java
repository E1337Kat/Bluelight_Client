package com.petersoninventive.bluelight_client.Backend;

import java.util.ArrayList;

public class Conversation<T> extends ArrayList<T> {

	public Conversation(){
		super();
	}
	
	public Conversation(T[] s) {
		super();
		for (T i : s) {
			this.add(i);
		}
	}
}

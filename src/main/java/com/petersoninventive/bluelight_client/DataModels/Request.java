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

import com.petersoninventive.bluelight_client.Backend.Conversation;
import com.petersoninventive.bluelight_client.GUIPackage.ConvoListModel;
import java.util.ArrayList;
import java.util.UUID;


public class Request {

	private ConvoListModel<String> list;
	private UUID convoID;
	private String stuID;
	private Location loc;
	
	public Request(String sID, Conversation<String> msg, Location coords) {
		stuID = sID;
		convoID = createConvoID();
		list = new ConvoListModel<String>(msg);
		loc = coords;
	}
	
	public ConvoListModel<String> getConvoListModel(){
		return list;
	}
	
	private UUID createConvoID() {
		UUID u = UUID.randomUUID();
		System.out.println("UUID for " + stuID + " is " + u.toString());
		return u;
	}
	
	public UUID getConvoID(){
		return convoID;
	}
	
	public String getStudentID() {
		return stuID;
	}
	
	public ArrayList<String> getConversation() {
		return list.getConvoList();
	}
	
	public Location getLocation() {
		return loc;
	}
	
	public void addMessage(String s) {
		list.addElement(s);
	}
	
	@Override
	public String toString() {
		return "UTCID: " + stuID + ", Location: " + loc.toString();
	}
}

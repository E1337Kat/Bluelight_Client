package Backend;

import java.util.ArrayList;
import java.util.UUID;

import GUIPackage.*;

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

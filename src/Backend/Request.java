package Backend;

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
		return UUID.randomUUID();
	}
	
	public UUID getConvoID(){
		return convoID;
	}
	
	public void addMessage(String s) {
		list.addElement(s);
	}
	
	@Override
	public String toString() {
		return "UTCID: " + stuID + ", Location: " + loc.toString();
	}
}

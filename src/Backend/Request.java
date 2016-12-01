package Backend;


import GUIPackage.*;

public class Request {

	private ConvoListModel<String> list;
	private long convoID;
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
	
	private long createConvoID() {
		return 0;
	}
	
	public long getConvoID(){
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

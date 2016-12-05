package Backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Pattern;

import GUIPackage.*;

public class NetCode extends Socket {
	
	public static final String CLOSED_CONNECTION = "THE CONNECTION TO THE SERVER HAS CLOSED";
	public static final String serverAddress = "localhost";
	
	private static final String reqRegex = "^%[a-z][a-z][a-z][0-9][0-9][0-9]%[ a-zA-Z0-9]++%[1-3]?[0-9][0-9]:[1-6]?[0-9]:[1-6]?[0-9]\\.[0-9]++%[1-3]?[0-9][0-9]:[1-6]?[0-9]:[1-6]?[0-9]\\.[0-9]++%$";
	private static final String msgRegex = "^%[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}%[ a-zA-Z0-9]++%$";
	
	private boolean openSocket;
	private boolean readyToReceive;
	private boolean readyToWrite;
	private String returnAnswer;
	private String answer;
	private static BufferedReader input;
	private static BufferedWriter output;
	
	/**
	 * single netcode instance
	 */
	private static NetCode netcode;
	
	/**
	 * Private NetCode constructor for lazy singleton invocation
	 */
	private NetCode () throws IOException {
		super(serverAddress, 9090);
		
		if (netcode.isConnected()) {
			this.openSocket = true;
			readyToReceive = true;
			readyToWrite = true;
			input =
					new BufferedReader(new InputStreamReader(this.getInputStream()));
			output = 
					new BufferedWriter(new OutputStreamWriter(this.getOutputStream()));
		} else {
			this.openSocket = false;
			readyToReceive = false;
			readyToWrite = true;
			System.err.println("Error connecting to socket at address: " + 
								serverAddress + 
								"; pease check server Address");
		}
	}
	
	/**
	 * Lazy singleton invocation of NetCode
	 * @return a single NetCode object
	 */
	public static NetCode getNetCodeInstance() {
		if (netcode != null)
			return netcode;
		else {
			try {
				netcode = new NetCode();
			}
			catch (IOException e){
				System.out.println("IO Error:" + e + " at " + NetCode.class.toGenericString() + ": line 60");
			}
			return netcode;
		}
	}
	
	private String queryServer() {
		if (!netcode.equals(null) && readyToReceive) {
			try{
				readyToWrite = true;
				this.answer = input.readLine();
				readyToReceive = false;
			} catch (IOException e) {
				System.err.println("Error: " + e + " at line 72 in " + this.getClass());
			}
		} else if (netcode.equals(null) && readyToReceive){
			getNetCodeInstance();
			try{
				readyToWrite = true;
				this.answer = input.readLine();
				readyToReceive = false;
			} catch (IOException e) {
				System.err.println("Error: " + e + " at line 80 in " + this.getClass());
			}
		}
		if (this.answer != null) {
			return this.answer;
		} else {
			return null;
		}
	}
	
	private void writeToServer() {
		if (!netcode.equals(null) && readyToWrite) {
			try{
				readyToWrite = false;
				output.write(returnAnswer);
				readyToReceive = true;
				readyToWrite = true;
			} catch (IOException e) {
				System.err.println("Error: " + e + " at line 72 in " + this.getClass());
			}
		} else if (netcode.equals(null) && readyToReceive){
			getNetCodeInstance();
			try{
				readyToWrite = false;
				output.write(returnAnswer);
				readyToReceive = true;
				readyToWrite = true;
			} catch (IOException e) {
				System.err.println("Error: " + e + " at line 80 in " + this.getClass());
			}
		}
		
	}
	
	public void sendTelemetry(long time, Location loc) {
		
		Date date = new Date();
		date.setTime(time);
		String o = date.toString().concat(" ").concat(loc.toString());
		this.returnAnswer = o;
		this.readyToWrite = true;
		this.readyToReceive = false;
		writeToServer();
	}
	
	public Request getNewRequest() {
		String temp;
		String stuID = "";
		Conversation<String> convo = new Conversation<String>();
		Coord x = new Coord();
		Coord y = new Coord();
		Location loc = new Location();
		if (this.isOpenSocket() ){
			queryServer();
			
			if (answer != null && isRequest()) {
				temp = answer;
				readyToReceive = true;
				readyToWrite = true;
				System.out.println("New req: " + answer);
				
				Scanner parts = new Scanner(temp);
				parts.useDelimiter("%");
				
				stuID = parts.next();
				
				convo.add(parts.next());
				
				parts.useDelimiter(":");
				parts.skip("%");
				
				int d = parts.nextInt();
				int m = parts.nextInt();
				
				parts.useDelimiter("%");
				parts.skip(":");
				
				double s = parts.nextDouble();
				x.setCoordinates(d, m, s);
				
				parts.useDelimiter(":");
				parts.skip("%");
				
				d = parts.nextInt();
				m = parts.nextInt();
				
				parts.useDelimiter("%");
				parts.skip(":");
				
				s = parts.nextDouble();
				y.setCoordinates(d, m, s);
				
				loc.setCoordinates(x, y);
				
				parts.close();
				return new Request(stuID, convo, loc);
			} 
		}
		return null;
	}
	
	public String getNewMessage() {
		String temp;
		UUID convo;
		String msg;
		
		if (this.isOpenSocket() ) {
			queryServer();
			
			if (answer != null && isMessage() ) {
				temp = answer;
				readyToReceive = true;
				readyToWrite = true;
				Scanner parts = new Scanner(temp);
				parts.useDelimiter("%");
				
				convo = UUID.fromString(parts.next());
				System.out.println("convoID: " + convo.toString());
				msg = parts.next();
				System.out.println("Message to add: " + msg);
				System.out.println("Request to add msg to: " + ReqListModel.getModel().getRequestByConvoID(convo));
				
				(ReqListModel.getModel().getRequestByConvoID(convo)).addMessage(msg);
				
				parts.close();
				return msg;
			} 
		}
		return CLOSED_CONNECTION;
	}
	
	public void closeSocket(){
		try{
			super.close();
		} catch (IOException e) {
			System.err.println("Error: " + e + " in " + this.getClass() + " while closing socket.");
		}
	}
	
	/**
	 * 
	 * @return true is socket is open, false otherwise
	 */
	public boolean isOpenSocket() {
		return this.openSocket;
	}
	
	/**
	 * 
	 * @return true if new request, false if not
	 */
	public boolean isRequest() {
		if (answer != null && answer.matches(reqRegex) ) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 * @return true if message, false if not
	 */
	public boolean isMessage() {
		if (answer != null && answer.matches(msgRegex) ) {
			return true;
		} else {
			return false;
		}
	}
}

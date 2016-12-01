package Backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class NetCode {
	
	public static final String NO_INPUT = "STOP";
	public static final String serverAddress = "localhost";
	
	private boolean openSocket;
	private String answer;
	private static BufferedReader input;
	
	/**
	 * single netcode instance
	 */
	private NetCode netcode;
	
	/**
	 * Private NetCode constructor for lazy singleton invocation
	 */
	private NetCode () throws IOException {
		Socket s = new Socket(serverAddress, 9090);
		if (s.isConnected()) {
			this.openSocket = true;
			this.input =
					new BufferedReader(new InputStreamReader(s.getInputStream()));
		} else {
			System.err.println("Error connecting to socket at address: " + 
								this.serverAddress + 
								"; pease check server Address");
		}
	}
	
	/**
	 * Lazy singleton invocation of NetCode
	 * @return a single NetCode object
	 */
	public NetCode getNetCodeInstance() {
		if (this.netcode != null)
			return this.netcode;
		else {
			try {
				this.netcode = new NetCode();
			}
			catch (IOException e){
				System.out.println("IO Error:" + e + " at " + NetCode.class.toGenericString() + ": line 46");
			}
			return this.netcode;
		}
	}
	
	public String getNewAnswer() {
		if (netcode != null) {
			try{
				this.answer = input.readLine();
			} catch (IOException e) {
				System.err.println("Error: " + e + " at line 52 in " + this.getClass());
			}
		} else {
			getNetCodeInstance();
			try{
				this.answer = input.readLine();
			} catch (IOException e) {
				System.err.println("Error: " + e + " at line 52 in " + this.getClass());
			}
		}
		if (this.answer != null) {
			return this.answer;
		} else {
			return this.NO_INPUT;
		}
	}
	
	public boolean isOpenSocket() {
		return this.openSocket;
	}
}

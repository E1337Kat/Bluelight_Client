package Backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class NetCode {
	
	
	
	/**
	 * single netcode instance
	 */
	private NetCode netcode;
	
	/**
	 * Private NetCode constructor for lazy singleton invocation
	 */
	private NetCode () throws IOException {
		String serverAddress = "";
		Socket s = new Socket(serverAddress, 9090);
		BufferedReader input =
			new BufferedReader(new InputStreamReader(s.getInputStream()));
		String answer = input.readLine();
	}
	
	/**
	 * Lazy singleton invocation of NetCode
	 * @return a single NetCode object
	 */
	public NetCode getNewNetCodeInstance() {
		if (netcode != null)
			return netcode;
		else {
			try {
			netcode = new NetCode();
			}
			catch (IOException e){
				System.out.println("IO Error:" + e + " at " + NetCode.class.toGenericString() + ": line 46");
			}
			return netcode;
		}
	}
}

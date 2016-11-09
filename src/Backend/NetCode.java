package Backend;

import java.net.*;

public class NetCode {
	/**
	 * single netcode instance
	 */
	private static final NetCode netcode = new NetCode();
	
	/**
	 * Private NetCode constructor for lazy singleton invocation
	 */
	private NetCode () {}
	
	/**
	 * Lazy singleton invocation of NetCode
	 * @return a single NetCode object
	 */
	public static NetCode getNewNetCodeInstance() {
		return netcode;
	}
}

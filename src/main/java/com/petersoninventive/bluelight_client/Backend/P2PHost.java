/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petersoninventive.bluelight_client.Backend;

import java.util.Scanner;
import javax.websocket.DeploymentException;

/**
 * Uses a websocket server as a P2P host.
 * @author ellie
 */
public class P2PHost {
    private P2PHost host;
    
    /*
    * Lazy singleton method to retrieve one instance of P2PHost
    * 
    * @return P2PHost instance
    */
    public P2PHost getP2PHostInstance() {
        if (this.host == null) {
            this.host = new P2PHost();
        }
        
        return this.host;
    }
    
    /*
    * Private constructor for a P2PHost
    * 
    */
    private P2PHost() {
        org.glassfish.tyrus.server.Server server =
            new org.glassfish.tyrus.server.Server("localhost", 8025, "/wss", P2PEndpoint.class);
        try {
            server.start();
            System.out.println("Press any key to stop the server..");
            new Scanner(System.in).nextLine();
        } catch (DeploymentException e) {
            throw new RuntimeException(e);
        } finally {
            server.stop();
        }
    }
}
